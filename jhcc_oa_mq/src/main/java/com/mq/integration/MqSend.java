package com.mq.integration;
/** 
 * MQ 发送
 * ClassName:MqSendClient <br/> 
 * Date:     2017年2月3日 下午6:06:55 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface MqSend<T> extends Mq {
	
	/**
	 * sendMsg(发送消息 队列模式)
	  * @Title: sendMsg
	  * @Description: 发送消息
	  * @param @param t 
	  * @param @return
	  * @param @throws Exception    设定文件
	  * @return boolean    返回类型
	  * @throws Exception
	 */
	boolean sendQueueMsg(T t) throws Exception;
	
	/**
	 * sendMsg(发送消息 订阅模式)
	  * @Title: sendMsg
	  * @Description: 发送消息
	  * @param @param t 
	  * @param @return
	  * @param @throws Exception    设定文件
	  * @return boolean    返回类型
	  * @throws Exception
	 */
	boolean sendTopMsg(T t) throws Exception;
	
}
