package com.datasource.config;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

/** 
 * ClassName:Log4jInit <br/> 
 * Date:     2017年2月1日 下午2:36:03 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see      
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class Log4jInit {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Resource fileName;

	public Log4jInit() {
		super();
	}

	public Log4jInit(Resource fileName) {
		super();
		this.fileName = fileName;
		try {
			logger.info("------------------log4j-------------------------------" + this.fileName.getURL());
			PropertyConfigurator.configure(this.fileName.getURL());
		} catch (Exception e) {
			logger.error("" , e);
		}
	}
	
}
