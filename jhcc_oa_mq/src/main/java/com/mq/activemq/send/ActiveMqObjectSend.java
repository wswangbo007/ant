package com.mq.activemq.send;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import com.mq.config.AbstractMqConfig;

/** 
 * 支持对象发送
 * ClassName:ActiveMqSend <br/>
 * Date:     2017年2月3日 下午9:59:28 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see      
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class ActiveMqObjectSend extends AbstractActiveMqSend<Serializable> {

	/**
	  * 创建一个新的实例 ActiveMqObjectSend. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @throws JMSException
	  */
	public ActiveMqObjectSend() throws JMSException {
		super();
	}
	
	/**
	  * 创建一个新的实例 ActiveMqObjectSend. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @throws JMSException
	  */
	public ActiveMqObjectSend(AbstractMqConfig mqConfig) throws JMSException {
		super(mqConfig);
	}

	/**
	  * <p>Title: sendQueueMsg</p>
	  * <p>Description: </p>
	  * @param t
	  * @return 如果为null,返回false
	  * @throws Exception
	  * @see com.mq.integration.MqSend#sendQueueMsg(java.lang.Object)
	  */
	@Override
	public boolean sendQueueMsg(Serializable message) throws Exception {
		boolean result = false;
		if (null != message) {
			ObjectMessage objectMessage = this.session.createObjectMessage();
			objectMessage.setObject(message);
			this.producer.send(objectMessage);
		}
		return result;
	}

	/**
	  * <p>Title: sendTopMsg</p>
	  * <p>Description: </p>
	  * @param t
	  * @return
	  * @throws Exception
	  * @see com.mq.integration.MqSend#sendTopMsg(java.lang.Object)
	  */
	@Override
	public boolean sendTopMsg(Serializable message) throws Exception {
		boolean result = false;
		if (null != message) {
			ObjectMessage objectMessage = this.session.createObjectMessage();
			objectMessage.setObject(message);
			this.producer.send(objectMessage);
		}
		return result;
	}

}
