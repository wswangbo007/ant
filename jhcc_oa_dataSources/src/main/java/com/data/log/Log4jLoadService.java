package com.data.log;
/** 
 * ClassName:Log4jLoadThrad <br/> 
 * Date:     2017年2月4日 下午10:44:05 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface Log4jLoadService extends Runnable {

	/**
	  * polling(轮询)
	  * @Title: polling
	  * @param     设定文件
	 */
	void polling();
}
