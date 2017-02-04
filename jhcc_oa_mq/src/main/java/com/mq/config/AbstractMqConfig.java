package com.mq.config;
/** 
 * MQ配置
 * ClassName:AbstractMqConfig <br/> 
 * Date:     2017年2月3日 下午6:21:17 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractMqConfig {

	/**IP 地址*/
	protected String ip;
	
	/**port 端口*/
	protected String port;
	
	/**主题名称*/
	protected String topicName;
	
	/**队列名称*/
	protected String queueName;
	
	/**可以存放队列长度*/
	protected int queueSize;

	public AbstractMqConfig() {
		super();
	}

	public AbstractMqConfig(String ip, String port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public AbstractMqConfig(String ip, String port, String topicName, String queueName) {
		super();
		this.ip = ip;
		this.port = port;
		this.topicName = topicName;
		this.queueName = queueName;
	}

	public AbstractMqConfig(String ip, String port, String topicName, String queueName, int queueSize) {
		super();
		this.ip = ip;
		this.port = port;
		this.topicName = topicName;
		this.queueName = queueName;
		this.queueSize = queueSize;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public int getQueueSize() {
		return queueSize;
	}

	public void setQueueSize(int queueSize) {
		this.queueSize = queueSize;
	}
}