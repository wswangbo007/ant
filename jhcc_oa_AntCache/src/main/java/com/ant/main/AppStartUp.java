package com.ant.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.network.NetworkServer;

/**
 * ClassName:AppStartUp <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年1月18日 下午10:56:15 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public class AppStartUp {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private Object obj = new Object();

	/**
	 * main(这里用一句话描述这个方法的作用)
	 *
	 * @Title: main
	 * @Description: TODO
	 * @param @param
	 *            args 设定文件
	 * @return void 返回类型
	 */
	public static void main(String[] args) {
		new AppStartUp().start();
	}

	public void start() {
		NetworkServer networkServer = new NetworkServer();
		synchronized (obj) {
			if (log.isDebugEnabled()) log.debug("main Thread start!");
			new Thread(networkServer,"main Thread").start();
		}
	}
}