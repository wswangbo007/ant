package com.mq.integration;

import javax.jms.MessageConsumer;

/** 
 * ClassName:MqReceive <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月3日 下午6:18:11 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface MqReceive<T> extends Mq {

	/**
	  * receiveMsg(接受消息 队列模式)
	  * @Title: receiveMsg
	  * @Description: 接受消息
	  * @param @throws Exception    设定文件
	  * @return T    返回类型
	  * @throws Exception
	 */
	T receiveQueueMsg() throws Exception;
	
	/**
	  * receiveMsg(接受消息 订阅模式)
	  * @Title: receiveMsg
	  * @Description: 接受消息
	  * @param @throws Exception    设定文件
	  * @return T    返回类型
	  * @throws Exception
	 */
	T receiveTopMsg() throws Exception;
	
	/**
	  * getMessageConsumer(将MessageConsumer暴漏给开发者,让开发者选择选择方式)
	  * @Title: getMessageConsumer
	  * @Description: 将MessageConsumer暴漏给开发者,让开发者选择选择方式
	  * @param @return    设定文件
	  * @return MessageConsumer    返回类型
	 */
	MessageConsumer getMessageConsumer();
}