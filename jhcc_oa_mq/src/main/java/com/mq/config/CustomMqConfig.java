package com.mq.config;
/** 
 * ClassName:CustomMqConfig <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月4日 下午7:33:45 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class CustomMqConfig extends AbstractCustomMqConfig {
	
	protected boolean isEnd;
	
	public CustomMqConfig() {
		super();
	}

	/**
	  * <p>Title: complementedParams</p>
	  * <p>Description: </p>
	  * @see com.mq.config.AbstractCustomMqConfig#complementedParams()
	  */
	@Override
	protected void complementedParams() {
		int temp = 10;
		if (checkParams(this.getReaderIdleTimeSeconds())) {
			this.setReaderIdleTimeSeconds(temp);
		}
		if (checkParams(this.getWriterIdleTimeSeconds())) {
			this.setWriterIdleTimeSeconds(temp);
		}
		if (checkParams(this.getAllIdleTimeSeconds())) {
			this.setAllIdleTimeSeconds(temp);
		}
		if (!this.isEnd) {
			this.isEnd = true;
		}
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
}