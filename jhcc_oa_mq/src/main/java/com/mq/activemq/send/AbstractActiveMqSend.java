package com.mq.activemq.send;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.activemq.AbstractActiveMq;
import com.mq.config.AbstractMqConfig;
import com.mq.integration.MqSend;

/** 
 * ClassName:AbstractActiveMqSend <br/> 
 * Date:     2017年2月3日 下午9:07:20 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractActiveMqSend<T> extends AbstractActiveMq implements MqSend<T> {

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected MessageProducer producer;
	
	/**
	  * 创建一个新的实例 AbstractActiveMqReceive. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	 * @throws JMSException 
	  */
	public AbstractActiveMqSend() throws JMSException {
		if (StringUtils.isNotEmpty(mqConfig.getQueueName())) {
			this.sendQueue = session.createQueue(mqConfig.getQueueName());
		} else {
			this.sendQueue = session.createTopic(mqConfig.getTopicName());
		}
		this.producer = session.createProducer(this.sendQueue);
	}
	
	public AbstractActiveMqSend(ActiveMQConnectionFactory connectionFactory, Session session, Destination sendQueue,
			Connection connection) {
		super();
		this.connectionFactory = connectionFactory;
		this.session = session;
		this.sendQueue = sendQueue;
		this.connection = connection;
	}
	
	public AbstractActiveMqSend(AbstractMqConfig mqConfig,ActiveMQConnectionFactory connectionFactory, Session session, Destination sendQueue,
			Connection connection) {
		this(connectionFactory,session,sendQueue,connection);
		this.mqConfig = mqConfig;
	}
	
	public AbstractActiveMqSend(AbstractMqConfig mqConfig) throws JMSException {
		super(mqConfig);
		if (StringUtils.isNotEmpty(mqConfig.getQueueName())) {
			this.sendQueue = session.createQueue(mqConfig.getQueueName());
		} else {
			this.sendQueue = session.createTopic(mqConfig.getTopicName());
		}
		this.producer = session.createProducer(this.sendQueue);
	}

	public MessageProducer getProducer() {
		return producer;
	}

	public void setProducer(MessageProducer producer) {
		this.producer = producer;
	}
//	public abstract Message setMessage();
}
