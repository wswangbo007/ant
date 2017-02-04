package com.mq.kafka;

import com.mq.integration.MqSend;

/** 
 * ClassName:IKafkaMq <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月3日 下午11:57:35 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface IKafkaMq<K,V> extends MqSend<V> {

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
	boolean sendQueueMsg(V v) throws Exception;
	
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
	boolean sendQueueMsg(K k,V v) throws Exception;
	
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
	boolean sendTopMsg(V v) throws Exception;
	
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
	boolean sendTopMsg(K k,V v) throws Exception;
}
