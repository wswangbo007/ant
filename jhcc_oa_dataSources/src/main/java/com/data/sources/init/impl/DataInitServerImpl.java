package com.data.sources.init.impl;

import com.common.bean.AbstractFood;
import com.data.sources.ProduceDataService;
import com.data.sources.init.DataInitServer;

/** 
 * ClassName:DataInitServerImpl <br/> 
 * Date:     2017年2月4日 下午10:23:10 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class DataInitServerImpl implements DataInitServer {
	
	private ProduceDataService<AbstractFood> produceDataService;
	
	/**
	  * <p>Title: initData</p>
	  * <p>Description: </p>
	  * @throws Exception
	  * @see com.data.sources.init.DataInitServer#initData()
	  */
	@Override
	public void initData() throws Exception {
		Thread thread = new Thread(produceDataService,"测试产生数据");
		thread.start();
	}

}