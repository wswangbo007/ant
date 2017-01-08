package com.ant.bean;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.ant.food.FoodInter;
import com.ant.work.IAntWrok;

/**
 * 蚂蚁
  * @ClassName: Ant
  * @author 神经刀
 */
public abstract class Ant implements IAntWrok {
	
	protected final int antCount = 5;
	
	protected ExecutorService executorService = Executors.newFixedThreadPool(antCount);

	protected FoodInter<?> food;
	
	protected Lock lock = new ReentrantLock();
	
	protected Condition condition = lock.newCondition(); 
	
	protected Cave cave;
	
	protected int size;
	
	public Ant() {
		super();
	}
	
	public Ant(FoodInter<?> food,Cave cave) {
		super();
		this.food = food;
		this.cave = cave;
	}
	
	/**
	 * 执行
	 */
	public abstract void exec();
	
	/**
	  * 吃食物
	  * @Title: eatFood
	  * @param     设定文件
	  * @return void    返回类型
	 */
	protected abstract Map<?,?> eatFood();
	
	public FoodInter<?> getFood() {
		return food;
	}

	public void setFood(FoodInter<?> food) {
		this.food = food;
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}
}