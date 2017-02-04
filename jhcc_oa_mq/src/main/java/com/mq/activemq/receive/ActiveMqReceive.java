package com.mq.activemq.receive;

import javax.jms.Message;

/** 
 * ClassName:ActiveMqReceive <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月3日 下午8:55:24 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class ActiveMqReceive extends AbstractActiveMqReceive<Message> {

	/**
	  * 创建一个新的实例 ActiveMqReceive. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  */
	public ActiveMqReceive() {}
	
	/**
	  * <p>Title: receiveQueueMsg</p>
	  * <p>Description: </p>
	  * @return
	  * @throws Exception
	  * @see com.mq.integration.MqReceive#receiveQueueMsg()
	  */
	@Override
	public Message receiveQueueMsg() throws Exception {
		return null;
	}
	
	/**
	  * <p>Title: receiveTopMsg</p>
	  * <p>Description: </p>
	  * @return
	  * @throws Exception
	  * @see com.mq.integration.MqReceive#receiveTopMsg()
	  */
	@Override
	public Message receiveTopMsg() throws Exception {
		return null;
	}
}
