package com.datasource.send;

/** 
 * ClassName:MQContainer <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午7:53:14 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class MQContainer extends Send {

	/**
	  * connectMQ(连接MQ)
	  * @Title: connectMQ
	  * @Description: TODO
	  * @param     设定文件
	  * @return void    返回类型
	 */
	protected abstract void connectMQ();
	
	/**
	  * closeMQ(关闭MQ)
	  * @Title: closeMQ
	  * @Description: TODO
	  * @param     设定文件
	  * @return void    返回类型
	  * @throws
	 */
	protected abstract void closeMQ();
}