package com.mq.kafka.receive;

import javax.jms.MessageConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.mq.integration.MqReceive;
import com.mq.kafka.KafkaMq;

/** 
 * KAFKA 接受<br>
 * ClassName:KafkaReceive <br/> 
 * Date:     2017年2月3日 下午11:04:53 <br/>
 * 此类对开发者开发.可继承使用
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see      
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class KafkaReceive<K,T> extends KafkaMq implements MqReceive<T> {
	
	protected KafkaConsumer<K, T> consumer;
	
	/**
	  * 创建一个新的实例 KafkaReceive. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  */
	public KafkaReceive() {
		consumer = new KafkaConsumer<K,T>(kafkaconfig.getKafkaConfigMap());
	}
	
	public KafkaReceive(KafkaConsumer<K, T> consumer) {
		this();
		this.consumer = consumer;
	}
	
	/**
	  * <p>Title: getMessageConsumer</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.mq.integration.MqReceive#getMessageConsumer()
	  * @deprecated KAFKA不提供该方法的使用
	  */
	@Override
	public MessageConsumer getMessageConsumer() {
		return null;
	}
	
	/**
	  * <p>Title: receiveQueueMsg</p>
	  * <p>Description: </p>
	  * @return
	  * @throws Exception
	  * @see com.mq.integration.MqReceive#receiveQueueMsg()
	  */
	@SuppressWarnings("unchecked")
	@Override
	public T receiveQueueMsg() throws Exception {
		ConsumerRecords<K, T> consumerRecords = consumer.poll(100);
		return (T) consumerRecords;
	}
	
	/**
	  * <p>Title: receiveTopMsg</p>
	  * <p>Description: </p>
	  * @return
	  * @throws Exception
	  * @see com.mq.integration.MqReceive#receiveTopMsg()
	  */
	@SuppressWarnings("unchecked")
	@Override
	public T receiveTopMsg() throws Exception {
		ConsumerRecords<K, T> consumerRecords = consumer.poll(100);
		return (T) consumerRecords;
	}
}
