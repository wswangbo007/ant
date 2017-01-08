package com.datasource.send;

import com.common.bean.AbstractFood;

/** 
 * ClassName:ActiveMqContainer <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午10:51:11 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see      
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class ActiveMqContainer extends MQContainer {

	/**
	  * <p>Title: connectMQ</p>
	  * <p>Description: </p>
	  * @see com.datasource.send.MQContainer#connectMQ()
	  */
	@Override
	protected void connectMQ() {

	}

	/**
	  * <p>Title: closeMQ</p>
	  * <p>Description: </p>
	  * @see com.datasource.send.MQContainer#closeMQ()
	  */
	@Override
	protected void closeMQ() {

	}
	
	/**
	  * <p>Title: sendMessage</p>
	  * <p>Description: </p>
	  * @param abstractFood
	  * @return
	  * @see com.datasource.send.AbstractSend#sendMessage(com.common.bean.AbstractFood)
	  */
	@Override
	public boolean sendMessage(AbstractFood abstractFood) {
		return super.sendMessage(abstractFood);
	}

}