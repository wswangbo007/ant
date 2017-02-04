package com.mq.operation;

import com.mq.config.AbstractMqConfig;

/** 
 * ClassName:AbstractMqOperation <br/>
 * Date:     2017年2月3日 下午7:07:53 <br/>
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see      
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractMqOperation implements MqOperation {

	/**MQ参数配置*/
	protected AbstractMqConfig mqConfig;

	public AbstractMqOperation() {
		super();
	}

	public AbstractMqOperation(AbstractMqConfig mqConfig) {
		super();
		this.mqConfig = mqConfig;
	}

	public AbstractMqConfig getMqConfig() {
		return mqConfig;
	}

	public void setMqConfig(AbstractMqConfig mqConfig) {
		this.mqConfig = mqConfig;
	}
}