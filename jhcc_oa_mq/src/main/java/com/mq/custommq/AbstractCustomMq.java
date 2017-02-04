package com.mq.custommq;

import java.io.Serializable;

import com.mq.config.AbstractMqConfig;
import com.mq.custommq.queue.CustomMqServer;

/**
 * ClassName:AbstractCustomMq <br/> 
 * Date:     2017年2月4日 下午7:12:42 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractCustomMq<E extends Serializable> {

	/**操作接口*/
	protected CustomMqServer<E> customMqServer;
	
	/**配置信息*/
	protected AbstractMqConfig abstractMqConfig;
	
}