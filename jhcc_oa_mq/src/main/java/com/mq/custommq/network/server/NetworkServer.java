package com.mq.custommq.network.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.constant.ConstantUtil;

/**
 * ClassName:NetworkServer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年1月18日 下午10:58:36 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public class NetworkServer implements Runnable {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	  * 创建一个新的实例 NetworkServer. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	 */
	public NetworkServer() {
	}

	/**
	 * <p>Title: run</p> <p>Description: </p>
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			NettyServer.getNettyServer().bing(ConstantUtil.NETTYWORK.PROT);
		} catch (InterruptedException e) {
			log.error("初始化netty server发生异常 :" , e);
		}
	}
}
