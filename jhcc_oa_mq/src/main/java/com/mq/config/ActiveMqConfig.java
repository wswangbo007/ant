package com.mq.config;
/** 
 * ClassName:ActiveMqConfig <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月3日 下午7:04:51 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class ActiveMqConfig extends AbstractMqConfig {
	
	/**模式*/
	protected int acknowledgeMode;

	public ActiveMqConfig() {
		super();
	}

	public ActiveMqConfig(String ip, String port) {
		super(ip, port);
	}
	
	public ActiveMqConfig(String ip, String port, String topicName, String queueName) {
		super(ip, port, topicName, queueName);
	}

	public ActiveMqConfig(int acknowledgeMode) {
		super();
		this.acknowledgeMode = acknowledgeMode;
	}

	public int getAcknowledgeMode() {
		return acknowledgeMode;
	}

	public void setAcknowledgeMode(int acknowledgeMode) {
		this.acknowledgeMode = acknowledgeMode;
	}
}