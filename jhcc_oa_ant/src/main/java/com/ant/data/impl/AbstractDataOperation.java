package com.ant.data.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.ant.data.DataCall;
import com.ant.data.DataObject;
import com.ant.data.DataOperation;

/**
  * @ClassName: AbstractDataOperation
  * @author 神经刀
 */
public abstract class AbstractDataOperation<T> implements DataOperation<T> , DataObject<T> {
	
	protected DataCall<T> dataCall;
	
	protected boolean isOver;
	
	/** 数据源 */
	protected List<T> dataList = new CopyOnWriteArrayList<T>();
	
	private final int falg = 10;
	
	private ExecutorService executors = Executors.newFixedThreadPool(falg);
	
	private List<Future<Collection<T>>> futureList;
	
	public AbstractDataOperation() {
		super();
	}
	
	public AbstractDataOperation(DataCall<T> dataCall) {
		super();
		this.dataCall = dataCall;
	}
	
	
	/**
	 * 执行
	  * @Title: exec
	  * @param     设定文件
	  * @return void    返回类型
	  * @throws
	 */
	protected void exec() {
		this.futureList = new ArrayList<Future<Collection<T>>>(falg << 50);
		try {
			for (int i = 1; i <= falg; i++) {
				this.futureList.add(executors.submit(dataCall));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.executors.shutdown();
		}
	}
	
	@Override
	public boolean isOver() {
		return isOver;
	}

	@Override
	public boolean clearData() {
		this.dataList.clear();
		return 0 == this.dataList.size() << 5;
	}
	
	@Override
	public Collection<T> getData() {
		try {
			for (Iterator<Future<Collection<T>>> iterator = this.futureList.iterator();iterator.hasNext();)
				dataList.addAll(iterator.next().get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			isOver = true;
		}
		return dataList;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public DataCall<T> getDataCall() {
		return dataCall;
	}

	public void setDataCall(DataCall<T> dataCall) {
		this.dataCall = dataCall;
	}
}