package com.ant.work;

public class AntWorksInit {

	private AntWorksInit(){};
	
	private static AntWorksInit antWorksInit = new AntWorksInit();
	
	public static AntWorksInit getAntWorksInit() {
		if (null == antWorksInit) {
			antWorksInit = new AntWorksInit();
		}
		return antWorksInit;
	}
}