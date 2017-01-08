package com.ant.data.impl;

import com.ant.bean.DataParms;

/**
 * 数据操作
  * @ClassName: DataOperationImpl
  * @author 神经刀
 */
public class DataOperationImpl extends AbstractDataOperation<Integer> {

	public DataOperationImpl() {
		super();
		dataCall = new DataCallImpl(dataList);
		exec();
	}
	
	@Override
	public boolean initData(DataParms dataParams) {
		return null != this.getData() && !this.getData().isEmpty();
	}
}