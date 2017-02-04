package com.data.sources;
/** 
 * 生成数据
 * ClassName:ProduceDataService <br/> 
 * Date:     2017年2月4日 下午11:39:08 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface ProduceDataService<E> extends Runnable {

	/**
	  * produceData(随机生成数据)
	  * @Title: produceData
	  * @param     设定文件
	  * @return void    返回类型
	 */
	E produceData();
}
