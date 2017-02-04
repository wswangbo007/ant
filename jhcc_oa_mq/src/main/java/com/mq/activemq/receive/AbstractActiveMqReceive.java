package com.mq.activemq.receive;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.activemq.AbstractActiveMq;
import com.mq.config.AbstractMqConfig;
import com.mq.integration.MqReceive;

/** 
 * ClassName:AbstractActiveMqReceive <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月3日 下午6:30:50 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractActiveMqReceive<T> extends AbstractActiveMq implements MqReceive<T> {
	
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected MessageConsumer consumer;
	
	/**
	  * 创建一个新的实例 AbstractActiveMqReceive. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  */
	public AbstractActiveMqReceive() {}
	
	public AbstractActiveMqReceive(ActiveMQConnectionFactory connectionFactory, Session session, Destination sendQueue,
			Connection connection) {
		super();
		this.connectionFactory = connectionFactory;
		this.session = session;
		this.sendQueue = sendQueue;
		this.connection = connection;
	}
	
	public AbstractActiveMqReceive(AbstractMqConfig mqConfig,ActiveMQConnectionFactory connectionFactory, Session session, Destination sendQueue,
			Connection connection) {
		this(connectionFactory,session,sendQueue,connection);
		this.mqConfig = mqConfig;
	}
	
	public AbstractActiveMqReceive(AbstractMqConfig mqConfig) throws JMSException {
		super(mqConfig);
		if (StringUtils.isNotEmpty(mqConfig.getQueueName())) {
			this.sendQueue = session.createQueue(mqConfig.getQueueName());
		} else {
			this.sendQueue = session.createTopic(mqConfig.getTopicName());
		}
		this.consumer = session.createConsumer(this.sendQueue);
	}
	
	/**
	  * 将MessageConsumer暴漏给开发者,让开发者选择选择方式
	  * <p>Title: getMessageConsumer</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.mq.integration.MqReceive#getMessageConsumer()
	  */
	@Override
	public MessageConsumer getMessageConsumer() {
		return getConsumer();
	}
	
	public MessageConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(MessageConsumer consumer) {
		this.consumer = consumer;
	}
}