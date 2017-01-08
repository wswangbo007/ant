package com.ant.work;

import java.util.List;

import com.ant.bean.Ant;
import com.ant.bean.AntQueen;
import com.ant.bean.AntTaskMaster;
import com.ant.bean.Cave;
import com.ant.data.impl.AbstractDataOperation;
import com.ant.data.impl.DataOperationImpl;
import com.ant.food.Food;

/**
  * @ClassName: WorkRun
  * @author 神经刀
 */
public class WorkRun implements Runnable {
	
	private AbstractDataOperation<Integer> dataOperation;
	
	// 蚂蚁皇后
	private AntQueen antQueen;
	
	// 蚂蚁监工 
	private AntTaskMaster antTaskMaster;
	
	// 蚂蚁工人
	private List<Ant> antWorks;
	
	public WorkRun() {
		this.dataOperation = new DataOperationImpl();
		this.antQueen = new AntQueen();
		Food food = new Food(dataOperation);
		this.antWorks = antQueen.getAnts(5);
		this.antTaskMaster = new AntTaskMaster(food, new Cave(antWorks));
		antTaskMaster.exec();
//		antQueen.setFood(food);
//		antWorks.add(antQueen);
	}

	@Override
	public void run() {
		// TODO 初始化蚂蚁工人
		// 生成食物.
		// 蚂蚁寻找食物
		// 根据食物大小来分配蚂蚁的个数
		// 拿走食物
		// 回到蚂蚁窝.
		// 找出最大的数字
		// 贡献给蚂蚁皇后,最大的数字
	}

	public List<Ant> getAntWorks() {
		return antWorks;
	}

	public void setAntWorks(List<Ant> antWorks) {
		this.antWorks = antWorks;
	}
}