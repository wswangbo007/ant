package com.datasource.data.production;
/** 
 * ClassName:IDataProduction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午8:37:21 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface IDataProduction extends Runnable {

	/**
	  * production(数据)
	  * @Title: production
	  * @param     设定文件
	  * @return void    返回类型
	 */
	void production();
	
}