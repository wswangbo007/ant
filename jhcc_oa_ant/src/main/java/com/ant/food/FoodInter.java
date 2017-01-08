package com.ant.food;

import java.util.Collection;
import java.util.List;

/**
 * 食物
  * @ClassName: FoodInter
  * @author 神经刀
 */
public interface FoodInter<T> {

	/**是否吃食物*/
	boolean eatFood(Collection<T> food);
	
	/**是否发现食物*/
	boolean isFindFood();
	
	/**重新分配食物*/
	FoodInter<T> setFood(List<T> food);
	
	/**
	 * 获取食物
	  * @Title: getFood
	  * @param @return    设定文件
	  * @return Collection<T>    返回类型
	 */
	Collection<T> getFood();
}