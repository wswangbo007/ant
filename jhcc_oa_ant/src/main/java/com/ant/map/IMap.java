package com.ant.map;

import java.util.Map;

/**
  * @ClassName: IMap
  * @author 神经刀
 */
public interface IMap<V> {

	/**
	 * 新增data
	  * @Title: put
	  * @param @param iMapParams
	  * @param @return    设定文件
	  * @return boolean    返回类型
	  * @throws
	 */
	boolean put(IMapParams<V> iMapParams);
	
	/**
	 * 
	  * 获取MAP,可限定个数
	  * @Title: getMapData
	  * @param @param iMapParams
	  * @param @return    设定文件
	  * @return Map<V,V>    返回类型
	 */
	Map<V,V> getMapData(IMapParams<V> iMapParams);
}
