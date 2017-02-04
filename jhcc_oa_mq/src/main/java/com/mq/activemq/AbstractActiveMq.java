package com.mq.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.config.AbstractMqConfig;
import com.mq.config.ActiveMqConfig;
import com.mq.operation.MqOperation;

/**
 * ClassName:AbstractActiveMq <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年2月3日 下午9:51:43 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public class AbstractActiveMq {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** MQ配置 */
	protected AbstractMqConfig mqConfig;
	/** MQ操作 */
	protected MqOperation mqOperation;
	protected ActiveMQConnectionFactory connectionFactory;
	protected Session session;
	protected Destination sendQueue;
	protected Connection connection;

	public AbstractActiveMq(AbstractMqConfig mqConfig, MqOperation mqOperation) {
		super();
		this.mqConfig = mqConfig;
		this.mqOperation = mqOperation;
	}

	public AbstractActiveMq(AbstractMqConfig mqConfig) throws JMSException {
		super();
		ActiveMqConfig activeMqConfig = (ActiveMqConfig)mqConfig;
		this.mqConfig = mqConfig;
		this.connectionFactory = new ActiveMQConnectionFactory("tcp://" + activeMqConfig.getIp() + ":" + activeMqConfig.getPort());
		if (StringUtils.isNotEmpty(activeMqConfig.getTopicName())) 
			this.connection = connectionFactory.createTopicConnection();
		else
			this.connection = connectionFactory.createQueueConnection();
		try {
			connection.start();
		} catch (JMSException e) {
			logger.error("初始化失败" , e);
			this.colseMq();
		}
		this.session = connection.createSession(true, activeMqConfig.getAcknowledgeMode());
	}

	public AbstractActiveMq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MqOperation getMqOperation() {
		return mqOperation;
	}

	public void setMqOperation(MqOperation mqOperation) {
		this.mqOperation = mqOperation;
	}

	/**
	 * connectMq(关闭MQ)
	 * 
	 * @Title: connectMq
	 * @param @throws
	 *            Exception 设定文件
	 * @return void 返回类型
	 * @throws Exception
	 */
	protected void colseMq() {
		try {
			if (null != connection) {
				connection.close();
			}
		} catch (JMSException e) {
			logger.error("关闭Active Mq 失败", e);
		}
	}

	/**
	 * connectMq(连接MQ)
	 * 
	 * @Title: connectMq
	 * @param @throws
	 *            Exception 设定文件
	 * @return void 返回类型
	 * @throws Exception
	 */
	protected void connectMq() {
	}

	public ActiveMQConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ActiveMQConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Destination getSendQueue() {
		return sendQueue;
	}

	public void setSendQueue(Destination sendQueue) {
		this.sendQueue = sendQueue;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public AbstractMqConfig getMqConfig() {
		return mqConfig;
	}

	public void setMqConfig(AbstractMqConfig mqConfig) {
		this.mqConfig = mqConfig;
	}
}