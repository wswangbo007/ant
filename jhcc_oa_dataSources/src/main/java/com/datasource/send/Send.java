package com.datasource.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.bean.AbstractFood;

/** 
 * ClassName:Send <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午7:40:14 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class Send implements ISend {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ISend kafka;
	
	private ISend activeMq;
	
	private ISend dubboClient;
	
	/**
	  * <p>Title: sendMessage</p>
	  * <p>Description: 默认KAFKA发送消息</p>
	  * @param abstractFood
	  * @return Boolean
	  * @see com.datasource.send.ISend#sendMessage(com.common.bean.AbstractFood)
	  */
	@Override
	public boolean sendMessage(AbstractFood abstractFood) {
		boolean result = true;
		if (null != abstractFood) {
			logger.debug(abstractFood.toString());
		} else {
			result = false;
		}
		return result;
	}
	
	/**
	  * <p>Title: sendMessage</p>
	  * <p>Description: 根据FLAG选择发送的工具</p>
	  * @param abstractFood
	  * @param flag : 标识 1. KAFKA, 2. ACTIVEMQ, 3. DUBBO, 4, NETTY
	  * @return boolean
	  * @see com.datasource.send.ISend#sendMessage(com.common.bean.AbstractFood, java.lang.Integer)
	  */
	@Override
	public boolean sendMessage(AbstractFood abstractFood, Integer flag) {
		boolean result = true;
		try {
			if (1 == flag) {
				kafka.sendMessage(abstractFood);
			} else if (2 == flag) {
				activeMq.sendMessage(abstractFood);
			} else if (3 == flag) {
				dubboClient.sendMessage(abstractFood);
			}
		} catch (Exception e) {
			result = false;
			logger.error("" , e);
		}
		return result;
	}

	public ISend getKafka() {
		return kafka;
	}

	public void setKafka(ISend kafka) {
		this.kafka = kafka;
	}

	public ISend getActiveMq() {
		return activeMq;
	}

	public void setActiveMq(ISend activeMq) {
		this.activeMq = activeMq;
	}

	public ISend getDubboClient() {
		return dubboClient;
	}

	public void setDubboClient(ISend dubboClient) {
		this.dubboClient = dubboClient;
	}
}