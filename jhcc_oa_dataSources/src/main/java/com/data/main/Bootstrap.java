package com.data.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * ClassName:Bootstrap <br/> 
 * Date:     2017年2月4日 下午9:56:29 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class Bootstrap {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	  * main(这里用一句话描述这个方法的作用)
	  *
	  * @Title: main
	  * @Description: TODO
	  * @param @param args    设定文件
	  * @return void    返回类型
	  * @throws
	  */
	public static void main(String[] args) {
		new Bootstrap().start();
	}
	
	private void start() {
		log.info("启动spring容器!!!");
		try {
			@SuppressWarnings("resource")
			AbstractRefreshableApplicationContext app = new ClassPathXmlApplicationContext("spring-conf/app.xml");
			app.registerShutdownHook();
		} catch (BeansException e) {
			log.error("spring 容器 启动异常 : " , e);
		}
	}

}