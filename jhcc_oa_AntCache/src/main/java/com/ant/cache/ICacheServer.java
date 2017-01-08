package com.ant.cache;
/** 
 * 缓存操作接口
 * ClassName:ICacheServer <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月18日 下午11:42:13 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public interface ICacheServer<K,T> {

	/**
	 * 
	  * put(新增数据)
	  *
	  * @Title: put
	  * @Description: TODO
	  * @param @param T t
	  * @param @param K key
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean put(K key,T t);

	/**
	 * 
	  * delete(删除数据)
	  *
	  * @Title: delete
	  * @Description: TODO
	  * @param @param t
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean deleteByValue(T t);
	
	/**
	  * delete(删除数据)
	  * @Title: delete
	  * @Description: TODO
	  * @param @param t
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean deleteByKey(K key);

	/**
	 * 
	  * update(修改数据)
	  *
	  * @Title: update
	  * @Description: TODO
	  * @param @param t
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean update(T t);
	
	/**
	 * 
	  * update(修改数据)
	  *
	  * @Title: update
	  * @Description: TODO
	  * @param @param t
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean update(K key,T t);
	
	/**
	 * 
	  * get(拿取数据)
	  *
	  * @Title: get
	  * @Description: TODO
	  * @param @param K
	  * @param @return    设定文件
	  * @return T    返回类型
	 */
	T get(K t);
}
