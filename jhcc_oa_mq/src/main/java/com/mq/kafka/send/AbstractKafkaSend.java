package com.mq.kafka.send;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.mq.kafka.IKafkaMq;
import com.mq.kafka.KafkaMq;

/** 
 * ClassName:KafkaSend <br/> 
 * Reason:   此类提供给开发者继承使用. <br/> 
 * Date:     2017年2月3日 下午11:38:18 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractKafkaSend<K,V> extends KafkaMq implements IKafkaMq<K,V> {

	protected Producer<K,V> producer;
	
	/**
	  * 创建一个新的实例 AbstractKafkaSend. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  */
	public AbstractKafkaSend() {
		producer = new KafkaProducer<>(kafkaconfig.getKafkaConfigMap());
	}
	
	/**
	  * <p>Title: sendQueueMsg</p>
	  * <p>Description: </p>
	  * @param t
	  * @return
	  * @throws Exception
	  * @see com.mq.integration.MqSend#sendQueueMsg(java.lang.Object)
	  */
	@Override
	public boolean sendQueueMsg(V t) throws Exception {
		boolean result = false;
		if (null != t) {
			result = true;
			producer.send(new ProducerRecord<K, V>(kafkaconfig.getTopicName(), null, t));
		}
		return result;
	}
	
	/**
	  * sendQueueMsg(这里用一句话描述这个方法的作用)
	  * @Title: sendQueueMsg
	  * @Description: TODO
	  * @param @param k
	  * @param @param t
	  * @param @return
	  * @param @throws Exception    设定文件
	  * @return boolean    返回类型
	 */
	@Override
	public boolean sendQueueMsg(K k,V t) throws Exception {
		boolean result = false;
		if (null != t) {
			result = true;
			producer.send(new ProducerRecord<K, V>(kafkaconfig.getTopicName(), k, t));
		}
		return result;
	}
	
	/**
	  * <p>Title: sendTopMsg</p>
	  * <p>Description: </p>
	  * @param t
	  * @return
	  * @throws Exception
	  * @see com.mq.integration.MqSend#sendTopMsg(java.lang.Object)
	  */
	@Override
	public boolean sendTopMsg(V v) throws Exception {
		boolean result = false;
		if (null != v) {
			result = true;
			producer.send(new ProducerRecord<K, V>(kafkaconfig.getTopicName(), null, v));
		}
		return result;
	}
	
	/**
	  * <p>Title: sendTopMsg</p>
	  * <p>Description: </p>
	  * @param k
	  * @param v
	  * @return
	  * @throws Exception
	  * @see com.mq.kafka.IKafkaMq#sendTopMsg(java.lang.Object, java.lang.Object)
	  */
	@Override
	public boolean sendTopMsg(K k, V v) throws Exception {
		boolean result = false;
		if (null != v) {
			result = true;
			producer.send(new ProducerRecord<K, V>(kafkaconfig.getTopicName(), k, v));
		}
		return result;
	}
}