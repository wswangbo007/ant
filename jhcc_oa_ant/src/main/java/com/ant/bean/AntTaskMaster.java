package com.ant.bean;

import java.util.List;

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
	
	public AntTaskMaster(FoodInter<?> food, Cave cave,List<Ant> antWorks) {
		super(food, cave, antWorks);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void planAntTask() {
		List<Integer> andFood = null;
		AntWork antWork = null;
		List<Integer> foodList = (List<Integer>) food.getFood();
		if (null != foodList && !foodList.isEmpty()) {
			this.size = foodList.size();
			if (this.size > dataLimit) {
				int limit = size / dataLimit;
				for (int i = 0,count = limit; i < count; i++) {
					try {
						andFood = foodList.subList(0, dataLimit);
						antWork = (AntWork) super.getAntWork(i);
						antWork.setCave(cave);
						antWork.setFood(((Food)food).setFood(andFood));
						antWork.exec();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						foodList.subList(0, dataLimit).clear();
					}
				}
			}
		}
	}
}
