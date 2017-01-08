package com.datasource.send;

import com.common.bean.AbstractFood;

/** 
 * ClassName:ISend <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午7:38:13 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface ISend {
	
	/**
	  * sendMessage(发送消息)
	  * 默认KAFKA发送
	  * @Title: sendMessage
	  * @Description: 发送消息
	  * @param @param abstractFood
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean sendMessage(AbstractFood abstractFood);
	
	/**
	  * sendMessage(发送消息)
	  *
	  * @Title: sendMessage
	  * @Description: 发送消息
	  * @param abstractFood
	  * @param flag : 标识 1. KAFKA, 2. ACTIVEMQ, 3. DUBBO, 4, NETTY
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean sendMessage(AbstractFood abstractFood,Integer flag);
	
}