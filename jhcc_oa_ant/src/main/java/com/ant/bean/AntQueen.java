package com.ant.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * 蚂蚁皇后
  * @ClassName: AntQueen
  * @author 神经刀
 */
public class AntQueen extends Ant implements Runnable {
	
	protected int antCount;
	
	public AntQueen() {};
	
	public AntQueen(int antCount) {
		this.antCount = antCount;
	}
	
	public AntQueen(int antCount,ExecutorService executorService) {
		super(executorService);
		this.antCount = antCount;
	}
	
	/**
	  * 生产蚂蚁
	  * @Title: getAnts
	  * @param @param count
	  * @param @return    设定文件
	  * @return List<Ant>    返回类型
	 */
	public List<Ant> getAnts() {
		return getAnts(antCount);
	}
	
	/**
	  * 生产蚂蚁
	  * @Title: getAnts
	  * @param @param count
	  * @param @return    设定文件
	  * @return List<Ant>    返回类型
	 */
	public List<Ant> getAnts(int count) {
		List<Ant> ants = new ArrayList<Ant>(count);
		if (count > 0) {
			for (int index = 1; index <= count; index++) {
				ants.add(new AntWork(executorService));
			}
		} else {
			throw new NullPointerException("干嘛?,神经病啊!");
		}
		return ants;
	}
	
	@Override
	protected Map<Integer,Integer> eatFood() {
		// TODO 吃蚂蚁军师提供的数据
		return null;
	}
	
	@Override
	public void exec() {
		this.executorService.execute(this);
	}

	@Override
	public void run() {
		this.lock.lock();
		try {
			for (;;) {
				if (this.food.isFindFood()) {
					this.condition.signal();
					System.out.println("蚂蚁皇后  eat food!");
					// TODO 蚂蚁皇后吃食物
				} else {
					System.out.println("休息一会");
					this.condition.await();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
};