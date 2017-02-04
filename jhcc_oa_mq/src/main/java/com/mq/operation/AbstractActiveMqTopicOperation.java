package com.mq.operation;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.mq.config.AbstractMqConfig;

/** 
 * ClassName:ActiveMqOperation <br/> 
 * Date:     2017年2月3日 下午6:47:01 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractActiveMqTopicOperation extends AbstractMqOperation {
	
	protected ActiveMQConnectionFactory connectionFactory;
	protected Session session;
	protected Destination sendQueue;
	protected Connection connection;
	
	public AbstractActiveMqTopicOperation(ActiveMQConnectionFactory connectionFactory, Session session,
			Destination sendQueue, Connection connection) {
		super();
		this.connectionFactory = connectionFactory;
		this.session = session;
		this.sendQueue = sendQueue;
		this.connection = connection;
	}
	
	public AbstractActiveMqTopicOperation(AbstractMqConfig mqConfig,ActiveMQConnectionFactory connectionFactory, Session session,
			Destination sendQueue, Connection connection) {
		super(mqConfig);
		this.connectionFactory = connectionFactory;
		this.session = session;
		this.sendQueue = sendQueue;
		this.connection = connection;
	}
	
	public AbstractActiveMqTopicOperation(AbstractMqConfig mqConfig) {
		super(mqConfig);
		this.connectionFactory = new ActiveMQConnectionFactory("tcp://" + mqConfig.getIp() + ":" + mqConfig.getPort());
		try {
			this.connection = connectionFactory.createTopicConnection();
			connection.start();
			this.session = connection.createSession(true, Session.SESSION_TRANSACTED);
			sendQueue = session.createTopic(mqConfig.getTopicName());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	  * <p>Title: connectMq</p>
	  * <p>Description: </p>
	  * @throws Exception
	  * @see com.mq.operation.MqOperation#connectMq()
	  */
	@Override
	public void connectMq() throws Exception {
		
	}

	/**
	  * <p>Title: colseMq</p>
	  * <p>Description: </p>
	  * @throws Exception
	  * @see com.mq.operation.MqOperation#colseMq()
	  */
	@Override
	public void colseMq() throws Exception {
		
	}

}
