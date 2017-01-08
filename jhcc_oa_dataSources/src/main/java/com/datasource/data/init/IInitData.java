package com.datasource.data.init;

import org.springframework.beans.factory.InitializingBean;

/** 
 * 初始化数据
 * ClassName:InitData <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午5:13:50 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see      
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface IInitData extends InitializingBean {
	
	/**
	  * init(初始化一些参数)
	  * @Title: init
	  * @Description: TODO
	  * @param     设定文件
	  * @return void    返回类型
	 */
	void init();
}
