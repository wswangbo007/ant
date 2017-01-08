package com.ant.bean;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import com.ant.food.FoodInter;
import com.ant.map.AntMap;
import com.ant.map.IMapParams;

/**
 * 蚂蚁(工薪)
 * 
 * @ClassName: AntWork
 * @author 神经刀
 */
public abstract class AbstractAntWork extends Ant implements Callable<Integer> {
	
	protected int startIndex;
	
	protected int endIndex;
	
	protected List<Future<Integer>> futureList;
	
	public AbstractAntWork() {super();};
	
	public AbstractAntWork(int startIndex, int endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public AbstractAntWork(FoodInter<?> food, Cave cave) {
		super(food, cave);
	}
	
	public AbstractAntWork(FoodInter<?> food, Cave cave, int startIndex, int endIndex) {
		super(food, cave);
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO 蚂蚁工人线程
		return null;
	}
	
	@Override
	public void exec() {
		futureList.add(this.executorService.submit(this));
	}
	
	@Override
	protected Map<Integer,Integer> eatFood() {
		// TODO MAP 排序,前3名
		Map<Integer,Integer> resultMap = null;
		try {
			@SuppressWarnings("unchecked")
			IMapParams<Integer> iMapParams = new IMapParams<Integer>((List<Integer>)this.getFood(),startIndex,endIndex,size);
			AntMap antMap = new AntMap();
			antMap.put(iMapParams);
			resultMap = antMap.getMapData(iMapParams);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return resultMap;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
}