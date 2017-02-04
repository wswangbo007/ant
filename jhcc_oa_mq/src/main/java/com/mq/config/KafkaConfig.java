package com.mq.config;

import java.util.Map;

/** 
 * ClassName:ActiveMqConfig <br/> 
 * Date:     2017年2月3日 下午7:04:51 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class KafkaConfig extends AbstractMqConfig {
	
	/**配置*/
	protected KafkaProperties kafkaProperties;
	
	/**配置*/
	protected Map<String,Object> kafkaConfigMap;
	
	public KafkaConfig(KafkaProperties kafkaProperties) {
		this.kafkaProperties = kafkaProperties;
	}
	
	public KafkaConfig(Map<String,Object> kafkaConfigMap) {
		this.kafkaConfigMap = kafkaConfigMap;
	}

	public Map<String, Object> getKafkaConfigMap() {
		return kafkaConfigMap;
	}

	public void setKafkaConfigMap(Map<String, Object> kafkaConfigMap) {
		this.kafkaConfigMap = kafkaConfigMap;
	}

	public KafkaProperties getKafkaProperties() {
		return kafkaProperties;
	}

	public void setKafkaProperties(KafkaProperties kafkaProperties) {
		this.kafkaProperties = kafkaProperties;
	}
}