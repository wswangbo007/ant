package com.datasource.data.production;

import com.common.bean.AbstractFood;
import com.common.bean.Food;
import com.datasource.send.ISend;
import com.datasource.util.UUIDUtil;

/** 
 * ClassName:DataProduction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午8:38:23 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class DataProduction implements IDataProduction {
	
	private ISend iSend;

	/**
	  * <p>Title: production</p>
	  * <p>Description: 生产数据</p>
	  * @see com.datasource.data.IDataProduction#production()
	  */
	@Override
	public void production() {
		AbstractFood food = null;
		while (true) {
			food = new Food();
			food.setId(UUIDUtil.getUUID());
			food.setFoodName("food");
			food.setSize(1.1D);
			iSend.sendMessage(food,1);
		}
	}

	/**
	  * <p>Title: run</p>
	  * <p>Description: run</p>
	  * @see java.lang.Runnable#run()
	  */
	@Override
	public void run() {
		production();
	}

	public ISend getiSend() {
		return iSend;
	}

	public void setiSend(ISend iSend) {
		this.iSend = iSend;
	}
}