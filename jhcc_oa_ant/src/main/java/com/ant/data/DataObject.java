package com.ant.data;

import java.util.Collection;

/**
 * 数据源
  * @ClassName: DataObject
  * @author 神经刀
 */
public interface DataObject<T> {

	/**
	  * getData(获取数据源)
	  * @Title: getData
	  * @param @return    设定文件
	  * @return Collection<T>    返回类型
	 */
	Collection<T> getData();
}
