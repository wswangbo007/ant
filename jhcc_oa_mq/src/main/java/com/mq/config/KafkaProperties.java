package com.mq.config;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/** 
 * ClassName:KafkaProperties <br/> 
 * Date:     2017年2月3日 下午10:45:17 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class KafkaProperties extends Properties {
	
	private final Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 1L;

	public KafkaProperties(){}
	
	public KafkaProperties(Map<String,String> configMap) {
		if (null != configMap && !configMap.isEmpty()) {
			for (Map.Entry<String, String> entry : configMap.entrySet()) {
				if (configMap.containsKey(entry.getKey())) {
					logger.error("已经注入相同的参数,参数为:{"+ entry.getKey() +"},请认真检查配置文件!");
					return;
				}
				this.put(entry.getKey(), entry.getValue());
			}
		} else {
			logger.error("注入kafka配置参数报错.不能为NULL!");
		}
	}
	
}