package com.datasource.data.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datasource.data.production.IDataProduction;

/** 
 * ClassName:InitClass <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午5:15:48 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class InitData implements IInitData {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**数据操作类*/
	private IDataProduction dataProduction;

	/**
	  * <p>Title: afterPropertiesSet</p>
	  * <p>Description: </p>
	  * @throws Exception
	  * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	  */
	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}

	/**
	  * <p>Title: init</p>
	  * <p>Description: 初始化</p>
	  * @see com.datasource.data.init.IInitData#init()
	  */
	@Override
	public void init() {
		logger.debug("--------------------------初始化-----------------------------");
		Thread thread = new Thread(dataProduction,"data-production");
		thread.start();
	}

	public IDataProduction getDataProduction() {
		return dataProduction;
	}

	public void setDataProduction(IDataProduction dataProduction) {
		this.dataProduction = dataProduction;
	}

}