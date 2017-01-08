package com.ant.cache;

import java.util.HashMap;
import java.util.Map;

import com.ant.constant.ConstantUtil;

/** 
 * 缓存对象,设计不合理,后期记得重构.<br>
 * 后期优化,1.初始化大小<br>
 * 2.key|value与锁分离<br>
 * 3.添加读写锁机制.<br>
 * 4.添加数据缓存淘汰机制.<br>
 * 5.持久化数据到DB<br>
 * ClassName:CacheObject <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月18日 下午11:59:52 <br/> 
 * @author   神经刀
 * @version  0.1
 * @param <K> : Key
 * @param <T> : Object
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class CacheObject<K, T> {
	
	private static CacheObject cacheObject = new CacheObject();
	
	private CacheObject(){super();};
	
	/**
	 * 
	  * getCacheObject(获取对象)
	  *
	  * @Title: getCacheObject
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return CacheObject    返回类型
	  * @throws
	 */
	public static CacheObject getCacheObject() {
		if (null == cacheObject)
			cacheObject = new CacheObject();
		return cacheObject;
	}
	
	public Map<K,T> cacheData = new HashMap<K,T>(ConstantUtil.CACHEDATA.INITSIZE);

}