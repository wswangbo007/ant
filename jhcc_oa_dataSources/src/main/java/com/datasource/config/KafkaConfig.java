package com.datasource.config;

import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

/** 
 * KAFKA 配置
 * ClassName:KafkaConfig <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午9:45:31 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class KafkaConfig extends Properties {

	private static final long serialVersionUID = 1L;
	
	private Map<String,String> paramsMap;

	public Map<String, String> getParamsMap() {
		return paramsMap;
	}

	@Resource(name="kafkaParmsMap")
	public void setParamsMap(Map<String, String> paramsMap) {
		this.paramsMap = paramsMap;
	}
	
	/**
	  * getProperties(获得配置)
	  * @Title: getProperties
	  * @param @return    设定文件
	  * @return Properties    返回类型
	 */
	public Properties getProperties() {
		for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
			this.put(entry.getKey(), entry.getValue());
		}
		return this;
	}
}