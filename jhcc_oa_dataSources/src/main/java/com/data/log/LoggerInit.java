package com.data.log;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * ClassName:LoggerInit <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月4日 下午11:00:17 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class LoggerInit extends AbstractLoggerInit {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	  * <p>Title: loadLog4jFile</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.data.log.AbstractLoggerInit#loadLog4jFile()
	  */
	@Override
	public boolean loadLog4jFile() throws IOException {
		boolean result = false;
		String path = this.logResource.getURL().toString();
		if (path.endsWith(".xml")) {
			DOMConfigurator.configure(this.logResource.getURL());
		} else if (path.endsWith(".properties")) {
			PropertyConfigurator.configure(this.logResource.getURL());
		} else {
			log.error("注入的配置文件必须以xml或者properties!!!");
		}
		return result;
	}

}
