package com.data.util;

import java.util.UUID;

/** 
 * ClassName:UUIDUtil <br/> 
 * Date:     2017年2月4日 下午11:45:57 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class UUIDUtil {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
//	@Test
//	public void test() {
//		System.out.println(UUIDUtil.getUUID());
//		System.out.println(RandomStr.getRandomString(5));
//		System.out.println(RandomStr.getRandomString(5));
//		System.out.println(RandomStr.getRandomString(5));
//	}
}
