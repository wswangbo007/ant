package com.mq.operation;
/** 
 * ClassName:MqOperation <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月3日 下午6:38:00 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface MqOperation {

	/**
	  * connectMq(连接MQ)
	  * @Title: connectMq
	  * @param @throws Exception    设定文件
	  * @return void    返回类型
	  * @throws Exception
	 */
	void connectMq() throws Exception;
	
	/**
	  * connectMq(关闭MQ)
	  * @Title: connectMq
	  * @param @throws Exception    设定文件
	  * @return void    返回类型
	  * @throws Exception
	 */
	void colseMq() throws Exception;
}