package com.ant.bean;

import java.util.List;
import java.util.concurrent.ExecutorService;

import com.ant.food.Food;
import com.ant.food.FoodInter;

/**
 * 蚂蚁监工
  * @ClassName: AntTaskMaster
  * @author 神经刀
 */
public class AntTaskMaster extends AbstAntTaskMaster {

	public AntTaskMaster() {super();}

	public AntTaskMaster(FoodInter<?> food, Cave cave) {
		super(food, cave);
	}
	
	public AntTaskMaster(FoodInter<?> food, Cave cave,ExecutorService executorService) {
		super(food, cave);
		this.executorService = executorService;
	}
	
	public AntTaskMaster(FoodInter<?> food, Cave cave,List<Ant> antWorks) {
		super(food, cave, antWorks);
	}
	
	public AntTaskMaster(FoodInter<?> food, Cave cave,List<Ant> antWorks,ExecutorService executorService) {
		super(food, cave, antWorks);
		this.executorService = executorService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void planAntTask() {
		List<Integer> antFood = null;
		AntWork antWork = null;
		List<Integer> foodList = (List<Integer>) food.getFood();
		if (null != foodList && !foodList.isEmpty()) {
			this.size = foodList.size();
			if (this.size > dataLimit) {
				int limit = size / dataLimit;
				for (int i = 0,count = limit; i < count; i++) {
					try {
						antFood = foodList.subList(0, dataLimit);
						foodList.subList(0, dataLimit).clear();
						antWork = (AntWork) super.getAntWork(i);
						antWork.setFood(((Food)food).setFood(antFood));
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						antWork.exec();
					}
				}
			}
		}
	}
}
