package com.mq.config;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.apache.commons.lang3.StringUtils;

/** 
 * ClassName:CustomMqConfig <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年2月4日 下午6:56:14 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractCustomMqConfig extends AbstractMqConfig {

	/**socket*/
	protected SocketAddress socketAddress;
	/**读闲置秒数*/
	protected long readerIdleTimeSeconds;
	/**写闲置秒数*/
	protected long writerIdleTimeSeconds;
	/**读写闲置秒数*/
	protected long allIdleTimeSeconds;
	
	public AbstractCustomMqConfig() {
		super();
		complementedParams();
	}
	
	/**
	  * checkParams(补全默认值),
	  * @Title: checkParams : 一些条件
	  * @Description: 补全
	  * @param     设定文件
	  * @return void    返回类型
	 */
	protected abstract void complementedParams();
	
	/**
	  * checkParams(验证数据是否合法)
	  * @Title: checkParams
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	protected boolean checkParams(int inputParms) {
		return inputParms <= 0;
	}
	
	/**
	  * checkParams(验证数据是否合法)
	  * @Title: checkParams
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	protected boolean checkParams(long inputParms) {
		return inputParms <= 0;
	}
	
	public SocketAddress getSocketAddress() {
		if (StringUtils.isNotEmpty(this.ip) && StringUtils.isNotEmpty(this.port)) {
			this.socketAddress = new InetSocketAddress(this.ip, Integer.valueOf(this.port));
		}
		return socketAddress;
	}

	public long getReaderIdleTimeSeconds() {
		return readerIdleTimeSeconds;
	}

	public void setReaderIdleTimeSeconds(long readerIdleTimeSeconds) {
		this.readerIdleTimeSeconds = readerIdleTimeSeconds;
	}

	public long getWriterIdleTimeSeconds() {
		return writerIdleTimeSeconds;
	}

	public void setWriterIdleTimeSeconds(long writerIdleTimeSeconds) {
		this.writerIdleTimeSeconds = writerIdleTimeSeconds;
	}

	public long getAllIdleTimeSeconds() {
		return allIdleTimeSeconds;
	}

	public void setAllIdleTimeSeconds(long allIdleTimeSeconds) {
		this.allIdleTimeSeconds = allIdleTimeSeconds;
	}
}