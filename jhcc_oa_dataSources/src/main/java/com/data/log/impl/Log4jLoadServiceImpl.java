package com.data.log.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.data.log.AbstractLoggerInit;
import com.data.log.Log4jLoadService;

/** 
 * ClassName:Log4jLoadServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月4日 下午10:49:18 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class Log4jLoadServiceImpl implements Log4jLoadService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private AbstractLoggerInit abstractLoggerInit;
	
	public Log4jLoadServiceImpl(AbstractLoggerInit abstractLoggerInit) {
		this.abstractLoggerInit = abstractLoggerInit;
	}
	
	/**
	  * <p>Title: run</p>
	  * <p>Description: </p>
	  * @see java.lang.Runnable#run()
	  */
	@Override
	public void run() {
		try {
			Thread.sleep(60 * 1000L);
			abstractLoggerInit.loadLog4jFile();
		} catch (InterruptedException | IOException e) {
			log.error("" , e);
		}
	}

	/**
	  * <p>Title: polling</p>
	  * <p>Description: </p>
	  * @see com.data.log.Log4jLoadService#polling()
	  */
	@Override
	public void polling() {
		Thread pollTread = new Thread(this,"轮询线程" );
		pollTread.start();
	}
}
