package com.data.log;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.data.log.impl.Log4jLoadServiceImpl;

/** 
 * 日志配置
 * ClassName:AbstractLoggerInit <br/> 
 * Date:     2017年2月4日 下午10:32:18 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractLoggerInit {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected Resource logResource;
	
	protected Log4jLoadService log4jLoadService;
	
	public AbstractLoggerInit(){
		log4jLoadService = new Log4jLoadServiceImpl(this);
	}
	
	public AbstractLoggerInit(Resource logResource) {
		this.logResource = logResource;
		log4jLoadService = new Log4jLoadServiceImpl(this);
	}
	
	protected void init() {
		if (checkResource()) {
			log4jLoadService.polling();
		}
	}
	
	/**
	  * loadLog4jFile(读取文件)
	  * @Title: loadLog4jFile
	  * @param     设定文件
	  * @return void    返回类型
	 */
	public abstract boolean loadLog4jFile() throws IOException;

	/**
	  * checkResource(注入失败)
	  * @Title: checkResource
	  * @param @return    设定文件
	  * @return boolean    返回类型
	  * @throws
	 */
	protected boolean checkResource() {
		boolean result = true;
		if (null == logResource) {
			result = false;
			log.error("注入Log4j配置文件出现异常,未能找到log4j配置文件!!请检查...");
		}
		return result;
	}

	public Resource getLogResource() {
		return logResource;
	}

	public void setLogResource(Resource logResource) {
		this.logResource = logResource;
	}

	public Log4jLoadService getLog4jLoadService() {
		return log4jLoadService;
	}

	public void setLog4jLoadService(Log4jLoadService log4jLoadService) {
		this.log4jLoadService = log4jLoadService;
	}
}