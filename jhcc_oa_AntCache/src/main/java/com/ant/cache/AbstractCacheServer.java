package com.ant.cache;

import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * 缓存,用于存储符合规则的数据<br>
 * 此类只作用于缓存数据使用,不再提供任何关于业务的操作接口<br>
 * 此类将在后期中不断维护,保持版本迭代<br>
 * <p> 版本 0.1 : 提供缓存的增删改查 <p>
 * ClassName:CacheServer <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO 设计不合理. <br/> 
 * Date:     2017年1月19日 上午1:12:07 <br/> 
 * @author   神经刀
 * @version  0.1
 * @param <K>
 * @param <T>
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractCacheServer<K, T> implements ICacheServer<K,T> {
	
	protected Lock lock = new ReentrantLock();
	
	protected Condition condition = lock.newCondition(); 
	
	protected Map<K,T> chache = CacheObject.getCacheObject().cacheData;
}