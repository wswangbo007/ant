package com.mq.kafka;

import com.mq.config.KafkaConfig;

/** 
 * ClassName:KafkaMq <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月3日 下午11:07:06 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class KafkaMq {

	/***
	 * 配置文件
	 */
	protected KafkaConfig kafkaconfig;

	public KafkaMq() {
		super();
	}

	public KafkaMq(KafkaConfig kafkaconfig) {
		super();
		this.kafkaconfig = kafkaconfig;
	}

	public KafkaConfig getKafkaconfig() {
		return kafkaconfig;
	}

	public void setKafkaconfig(KafkaConfig kafkaconfig) {
		this.kafkaconfig = kafkaconfig;
	}
}
