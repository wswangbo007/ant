package com.data.send.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.data.send.MqSendService;
import com.mq.integration.MqSend;

/** 
 * MQ send
 * ClassName:MqSendImpl <br/> 
 * Date:     2017年2月4日 下午11:25:45 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class MqSendServiceImpl<AbstractFood> implements MqSendService<AbstractFood> {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private MqSend<AbstractFood> mqSend;
	
	/**
	  * <p>Title: send</p>
	  * <p>Description: </p>
	  * @param e
	  * @return
	  * @see com.data.send.MqSendService#send(com.common.bean.AbstractFood)
	  */
	@Override
	public boolean send(AbstractFood e) {
		boolean result = true;
		try {
			result = mqSend.sendQueueMsg(e);
		} catch (Exception e1) {
			log.error("" , e);
		}
		return result;
	}

	public MqSend<AbstractFood> getMqSend() {
		return mqSend;
	}

	public void setMqSend(MqSend<AbstractFood> mqSend) {
		this.mqSend = mqSend;
	}
}