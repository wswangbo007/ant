package com.datasource.send;

import javax.annotation.Resource;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.bean.AbstractFood;
import com.datasource.config.KafkaConfig;

/** 
 * ClassName:KafkaContainer <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午7:50:46 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class KafkaContainer extends MQContainer {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private KafkaConfig props;
	
	private Producer<String, String> producer;
	
	/**
	  * <p>Title: connectMQ</p>
	  * <p>Description: 连接MQ</p>
	  * @see com.datasource.send.MQContainer#connectMQ()
	  */
	@Override
	protected void connectMQ() {
		producer = new KafkaProducer<String, String>(props.getProperties());
	}
	
	/**
	  * <p>Title: sendMessage</p>
	  * <p>Description: 发送消息</p>
	  * @param abstractFood
	  * @return
	  * @see com.datasource.send.AbstractSend#sendMessage(com.common.bean.AbstractFood)
	  */
	@Override
	public boolean sendMessage(AbstractFood abstractFood) {
		this.connectMQ();
		boolean result = false;
		if (null != abstractFood) {
			result = true;
			logger.info(abstractFood.toJSON());
			producer.send(new ProducerRecord<String, String>("shuaige", abstractFood.toJSON()));
		}
		this.closeMQ();
		return result;
	}
	
	/**
	  * <p>Title: closeMQ</p>
	  * <p>Description: 关闭</p>
	  * @see com.datasource.send.MQContainer#closeMQ()
	  */
	@Override
	protected void closeMQ() {
		producer.close();
	}
	
	public KafkaConfig getProps() {
		return props;
	}

	@Resource(name="kafkaConfig")
	public void setProps(KafkaConfig props) {
		this.props = props;
	}

	public Producer<String, String> getProducer() {
		return producer;
	}

	public void setProducer(Producer<String, String> producer) {
		this.producer = producer;
	}
}