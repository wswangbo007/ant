package com.ant.bean;

import java.util.List;

/**
 * 洞穴
  * @ClassName: Cave
  * @author 神经刀
 */
public class Cave {
	
	public Cave(){};
	
	public Cave(List<Ant> ants) {
		this.ants = ants;
	}
	
	/**洞穴中的蚂蚁*/
	protected List<Ant> ants;

	public List<Ant> getAnts() {
		return ants;
	}

	public void setAnts(List<Ant> ants) {
		this.ants = ants;
	}
}