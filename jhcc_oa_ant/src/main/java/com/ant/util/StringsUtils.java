package com.ant.util;

/**
 * 字符串
  * @ClassName: StringsUtils
  * @author 神经刀
  * @date 2017年1月1日 下午10:07:21
  *
 */
public class StringsUtils {
	
	/**
	  * isNull(是否null)
	  * @Title: isNull
	  * @param @param params
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	public static boolean isNull(String params) {
		return null == params;
	}
	
	/**
	  * isNull(是否不为null)
	  * @Title: isNull
	  * @param @param params
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	public static boolean isNotNull(String params) {
		return !isNull(params);
	}
	
	/**
	  * isEmpty(是否为空)
	  * @Title: isEmpty
	  * @param @param params
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	public static boolean isEmpty(String params) {
		return isNull(params) && params.isEmpty();
	}
	
	/**
	  * isEmpty(是否不为空)
	  * @Title: isEmpty
	  * @param @param params
	  * @param @return    设定文件
	  * @return boolean    返回类型
	 */
	public static boolean isNotEmpty(String params) {
		return isNotNull(params) && !params.isEmpty();
	}
}
