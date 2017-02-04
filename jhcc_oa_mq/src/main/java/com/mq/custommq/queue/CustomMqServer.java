package com.mq.custommq.queue;

/** 
 * queue操作接口
 * ClassName:CustomMqServer <br/> 
 * Date:     2017年2月4日 下午7:03:59 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface CustomMqServer<E> {

	/**
	  * push(压入数据)
	  * @Title: push
	  * @param @param e
	  * @param @return    设定文件
	  * @return boolean    返回类型
	  * @throws Exception
	 */
	boolean push(E e) throws Exception;

	/**
	 * 
	  * take(拿取数据)
	  * @Title: take
	  * @param @return 为空返回null
	  * @param @throws Exception    设定文件
	  * @return E    返回类型
	  * @throws Exception
	 */
	E take() throws Exception;
}
