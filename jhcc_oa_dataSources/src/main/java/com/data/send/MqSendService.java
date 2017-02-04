package com.data.send;

/** 
 * ClassName:MqSend <br/> 
 * Date:     2017年2月4日 下午11:24:05 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface MqSendService<E> {

	/**
	  * send(发送)
	  * @Title: send
	  * @param @param e
	  * @param @return    设定文件
	  * @return boolean    返回类型
	  * @throws
	 */
	boolean send(E e);
}
