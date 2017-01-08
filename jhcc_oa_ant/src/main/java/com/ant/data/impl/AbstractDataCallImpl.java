package com.ant.data.impl;

import java.util.Collection;
import java.util.LinkedList;

import com.ant.data.DataCall;

/**
 * 数据回调
  * @ClassName: AbstractDataCallImpl
  * @author 神经刀
  * @param <T>
 */
public abstract class AbstractDataCallImpl<T> implements DataCall<T> {
	
	protected Collection<T> collection;
	
	public AbstractDataCallImpl() {
		collection = new LinkedList<>();
	};
	
	public AbstractDataCallImpl(Collection<T> collection) {
		this.collection = collection;
	};
	
	protected Collection<T> getDataCollection() {
		return this.collection;
	}
	
	/**
	 * 合并结果集
	 */
	@Override
	public boolean mergeData(Collection<T> collection) {
		return this.collection.addAll(collection);
	}

	public Collection<T> getCollection() {
		return collection;
	}

	public void setCollection(Collection<T> collection) {
		this.collection = collection;
	}
}