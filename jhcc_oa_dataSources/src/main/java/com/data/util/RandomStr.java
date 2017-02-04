package com.data.util;

import java.util.Random;

/** 
 * ClassName:RandomStr <br/> 
 * Date:     2017年2月4日 下午11:47:39 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class RandomStr {
	
	private RandomStr(){}
	
	private static RandomStr randomStr = new RandomStr();
	
	private static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	
	private static Random random = new Random();
	
	private static StringBuffer sb = new StringBuffer();
	
	public static RandomStr getRandomStr() {
		if (null == randomStr) {
			randomStr = new RandomStr();
		}
		return randomStr;
	}

	/**
	  * getRandomString(随机生成字符串)
	  * @Title: getRandomString
	  * @Description: 随机生成字符串
	  * @param @param length
	  * @param @return    设定文件
	  * @return String    返回类型
	 */
	public static String getRandomString(int length) {
		int number = 0;
		if (length > 0) {
			sb.setLength(number);
			try {
				for (int i = 0; i < length; i++) {
					number = random.nextInt(base.length());
					sb.append(base.charAt(number));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new NullPointerException("传入的参数必须大于0");
		}
		return sb.toString();
	}
}