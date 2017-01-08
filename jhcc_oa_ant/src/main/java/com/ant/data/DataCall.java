package com.ant.data;

import java.util.Collection;
import java.util.concurrent.Callable;

/**
 * 数据回调
  * @ClassName: DataCall
  * @author 神经刀
  * @param <T>
 */
public interface DataCall<T> extends Callable<Collection<T>>{
	
	/**
	 * 合并数据集
	  * @Title: mergeData
	  * @param @return    设定文件
	  * @return boolean    返回类型
	  * @throws
	 */
	boolean mergeData(Collection<T> collection);
}
