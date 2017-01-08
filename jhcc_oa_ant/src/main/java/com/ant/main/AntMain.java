package com.ant.main;

import com.ant.work.WorkRun;

/**
 * 启动类
  * @ClassName: AntMain
  * @author 神经刀
 */
public class AntMain {
	
	public static void main(String[] args) {
		try {
			Thread thread = new Thread(new WorkRun(),"start Thread");
			thread.setDaemon(true);
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
