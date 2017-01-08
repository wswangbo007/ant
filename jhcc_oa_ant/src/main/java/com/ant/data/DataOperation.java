package com.ant.data;

import java.util.Collection;

import com.ant.bean.DataParms;

/**
 * 数据层
  * @ClassName: DataOperation
  * @author 神经刀
 */
public interface DataOperation<T> {

	/**
	  * initData(数据操作)
	  * @Title: initData
	  * @param @param dataParams
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean initData(DataParms dataParams);
	
	/**
	  * clearData(清空缓存)
	  * @Title: clearData
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	boolean clearData();
	
	/**
	 * 是否结束
	  * @Title: isOver
	  * @return boolean    返回类型
	 */
	boolean isOver();

	/**
	  * 获取数据
	  * @Title: getData
	  * @param @return    设定文件
	  * @return Collection<T>    返回类型
	 */
	Collection<T> getData();
}
