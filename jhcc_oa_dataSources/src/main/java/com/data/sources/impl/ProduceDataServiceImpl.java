package com.data.sources.impl;

import com.common.bean.AbstractFood;
import com.common.bean.Food;
import com.data.send.MqSendService;
import com.data.sources.ProduceDataService;
import com.data.util.RandomStr;
import com.data.util.UUIDUtil;

/** 
 * ClassName:ProduceDataServiceImpl <br/> 
 * Date:     2017年2月4日 下午11:40:39 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class ProduceDataServiceImpl implements ProduceDataService<AbstractFood> {
	
	private MqSendService<AbstractFood> mqSendService;

	/**
	  *  随机生成测试使用
	  * <p>Title: produceData</p>
	  * <p>Description: </p>
	  * @see com.data.sources.ProduceDataService#produceData()
	  */
	@Override
	public AbstractFood produceData() {
		AbstractFood abstractFood = new Food();
		abstractFood.setId(UUIDUtil.getUUID());
		abstractFood.setFoodName(RandomStr.getRandomString(10));
		abstractFood.setSize(5.5);
		return abstractFood;
	}

	/**
	  * <p>Title: run</p>
	  * <p>Description: </p>
	  * @see java.lang.Runnable#run()
	  */
	@Override
	public void run() {
		for (;;) {
			mqSendService.send(produceData());
		}
	}

	public MqSendService<AbstractFood> getMqSendService() {
		return mqSendService;
	}

	public void setMqSendService(MqSendService<AbstractFood> mqSendService) {
		this.mqSendService = mqSendService;
	}
}