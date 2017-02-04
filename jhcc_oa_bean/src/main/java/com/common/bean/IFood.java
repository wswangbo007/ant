package com.common.bean;
/** 
 * ClassName:IFood <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月31日 下午3:38:49 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface IFood<T> {

	/**
	  * toJson(将Object转换为JSON)
	  * @Title: toJson
	  * @param @return    设定文件
	  * @return String    返回类型
	 */
	String toJSON();
	
	/**
	  * toThis(将JSON转对象)
	  * @Title: toThis
	  * @param jsonParams 
	  * @param 设定文件
	  * @return T    返回类型
	 */
	T toThis(String jsonParams);
	
}
