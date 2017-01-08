package com.ant.bean;

import java.io.Serializable;

import com.ant.data.impl.DataOperationImpl;

/**
 * 数据参数
  * @ClassName: DataParms
  * @author 神经刀
 */
public class DataParms implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**数据长度*/
	protected int dataSize;
	
	public void test11() {
		new DataOperationImpl().getDataList();
	}
	
}