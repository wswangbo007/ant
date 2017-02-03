package com.datasource.util;

import java.util.UUID;

/** 
 * ClassName:UUIDUtil <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午8:40:25 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class UUIDUtil {

	/**
	  * getUUID(获取UUID)
	  * @Title: getUUID
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
