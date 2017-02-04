package com.mq.custommq.queue;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/** 
 * 此版本只对序列化做MQ的支持.<br>
 * 因为业务只需要序列化<br>
 * 等需要其他的数据格式以及协议,在以后的版本中会扩展.<br>
 * ClassName:CustoomMqQueue <br/> 
 * Date:     2017年2月4日 下午4:14:09 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractCustoomMqQueue<E> implements CustomMqServer<E>{
	
	/**topic : queue*/
	protected Map<String,LinkedBlockingQueue<E>> vessel;
	
	
}