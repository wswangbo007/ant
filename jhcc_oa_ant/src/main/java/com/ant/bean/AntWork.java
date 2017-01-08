package com.ant.bean;

import java.util.concurrent.ExecutorService;

import com.ant.food.FoodInter;

/**
 * 蚂蚁工人
  * @ClassName: AntWork
  * @author 神经刀
 */
public class AntWork extends AbstractAntWork {
	
	public AntWork() {};
	
	public AntWork(FoodInter<?> food, Cave cave, int startIndex, int endIndex) {
		super(food, cave, startIndex, endIndex);
	}

	public AntWork(FoodInter<?> food, Cave cave) {
		super(food, cave);
	}

	public AntWork(int startIndex, int endIndex) {
		super(startIndex, endIndex);
	}
	
	public AntWork(ExecutorService executorService) {
		super(executorService);
	}
}