package com.ant.bean;

import java.util.List;
import java.util.Map;

import com.ant.food.FoodInter;

/**
 * 蚂蚁监工
 * 
 * @ClassName: AbstAntTaskMaster
 * @author 神经刀
 */
public abstract class AbstAntTaskMaster extends Ant implements Runnable {

	protected List<Ant> antWorks;

	protected int dataLimit = 50000;

	public AbstAntTaskMaster() {
		super();
	};

	public AbstAntTaskMaster(FoodInter<?> food, Cave cave) {
		super(food, cave);
	}

	public AbstAntTaskMaster(FoodInter<?> food, Cave cave, List<Ant> antWorks) {
		super(food, cave);
		this.antWorks = antWorks;
	}

	/**
	 * 分配任务
	 * 
	 * @Title: planAntTask
	 * @param 设定文件
	 * @return void 返回类型
	 */
	protected abstract void planAntTask();

	/**
	 * 处理数据
	 * @Title: disposeList
	 * @param @return
	 *            设定文件
	 * @return List<List<Integer>> 返回类型
	 */
	protected List<List<Integer>> disposeList() {
		return null;
	}

	/**
	 * 获取蚂蚁
	 * @Title: getAntWork
	 * @param @return
	 *            设定文件
	 * @return AntWork 返回类型
	 */
	protected Ant getAntWork(int index) {
		List<Ant> ants = cave.getAnts();
		AntWork antWork = null;
		if (index > -1 || (null != ants && !ants.isEmpty())) {
			if (index > ants.size()) {
				antWork = new AntWork(executorService);
				antWork.setCave(this.cave);
			} else {
				antWork = (AntWork) this.cave.getAnts().get(index);
			}
		} else {
			throw new NullPointerException("洞穴中没有蚂蚁或者不知道你要找哪一只蚂蚁工人!");
		}
		return antWork;
	}

	@Override
	public void exec() {
		this.executorService.execute(this);
	}

	@Override
	public void run() {
		planAntTask();
	}

	@Override
	protected Map<Integer, Integer> eatFood() {
		return null;
	}

}
