package com.datasource.main;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:StartUp <br/>
 * Date: 2017年1月31日 下午2:51:30 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public class StartUp {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Object lock = new Object();

	public static void main(String[] args) {
		new StartUp().start();
	}

	/**
	 * start(这里用一句话描述这个方法的作用)
	 * 
	 * @Title: start
	 * @Description: TODO
	 * @param 设定文件
	 * @return void 返回类型
	 */
	@SuppressWarnings("resource")
	private void start() {
		System.out.println("---启动了--");
		logger.debug("---启动了--");
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring-config/applicationContext.xml");
		applicationContext.registerShutdownHook();
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				logger.error("error", e);
			}
		}
	}
}