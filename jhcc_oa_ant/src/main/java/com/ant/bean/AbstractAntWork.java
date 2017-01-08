package com.ant.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.ant.food.FoodInter;
import com.ant.map.AntMap;
import com.ant.map.IMapParams;
import com.ant.map.MyComparator;

/**
 * 蚂蚁(工薪)
 * 
 * @ClassName: AntWork
 * @author 神经刀
 */
public abstract class AbstractAntWork extends Ant implements Callable<Map<Integer,Integer>> {
	
	protected int startIndex;
	
	protected int endIndex;
	
	protected List<Future<Map<Integer,Integer>>> futureList = new ArrayList<>();
	
	public AbstractAntWork() {super();};
	
	public AbstractAntWork(int startIndex, int endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public AbstractAntWork(FoodInter<?> food, Cave cave) {
		super(food, cave);
	}
	
	public AbstractAntWork(ExecutorService executorService) {
		super(executorService);
	}
	
	public AbstractAntWork(FoodInter<?> food, Cave cave, int startIndex, int endIndex) {
		super(food, cave);
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	@Override
	public Map<Integer,Integer> call() throws Exception {
		System.err.println(Thread.currentThread().getName());
		// TODO 蚂蚁工人线程
		Map<Integer,Integer> resultMap = eatFood();
		return resultMap;
	}
	
	@Override
	public void exec() {
		futureList.add(this.executorService.submit(this));
	}
	
	/**
	 * 优质食物
	  * @Title: highFood
	  * @param @return    设定文件
	  * @return Map<Integer,Integer>    返回类型
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	protected Map<Integer,Integer> highFood() throws InterruptedException, ExecutionException {
		Map<Integer,Integer> highFood = null;
		if (null != futureList && !futureList.isEmpty()) {
			highFood = new HashMap<Integer,Integer>(futureList.size());
			for (Future<Map<Integer,Integer>> future : futureList) {
				highFood.putAll(future.get());
			}
		}
		return highFood;
	}
	
	@Override
	protected Map<Integer,Integer> eatFood() {
		// TODO MAP 排序,前3名
		Map<Integer,Integer> resultMap = null;
		try {
			@SuppressWarnings("unchecked")
			IMapParams<Integer> iMapParams = new IMapParams<Integer>((List<Integer>)this.getFood().getFood(),startIndex,endIndex,size);
			AntMap antMap = new AntMap(new MyComparator());
			antMap.put(iMapParams);
			resultMap = antMap.getMapData();
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