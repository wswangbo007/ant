package com.ant.food;

import java.util.Collection;
import java.util.List;

import com.ant.data.DataOperation;

/**
 * 食物
 * @ClassName: Food
 * @author 神经刀
 */
public class Food implements FoodInter<Integer> {

	/** 是否发现食物 */
	protected boolean isFindFood;

	protected Collection<Integer> foods;
	
	protected DataOperation<Integer> dataOperation;
	
	public Food() {
		super();
	};
	
	public Food(DataOperation<Integer> dataOperation) {
		this.dataOperation = dataOperation;
	}
	
	@Override
	public FoodInter<Integer> setFood(List<Integer> food) {
		this.foods = food;
		return this;
	}

	@Override
	public boolean eatFood(Collection<Integer> food) {
		if (null != food && !food.isEmpty()) {
			this.foods = food;
			return true;
		}
		return false;
	}

	@Override
	public boolean isFindFood() {
		return isFindFood = dataOperation.isOver();
	}

	@Override
	public Collection<Integer> getFood() {
		this.foods = dataOperation.getData();
		return foods;
	}

	public Collection<Integer> getFoods() {
		return foods;
	}

	public void setFoods(Collection<Integer> foods) {
		this.foods = foods;
	}

	public void setFindFood(boolean isFindFood) {
		this.isFindFood = isFindFood;
	}

	public DataOperation<Integer>  getDataOperation() {
		return dataOperation;
	}

	public void setDataOperation(DataOperation<Integer>  dataOperation) {
		this.dataOperation = dataOperation;
	}
}
