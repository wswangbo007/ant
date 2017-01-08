package com.ant.map;

import java.io.Serializable;
import java.util.Collection;

/**
 * IMapParams
  * @ClassName: IMapParams
  * @author 神经刀
  * @param <E>
 */
public class IMapParams<E> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Collection<E> collection;
	
	private int startIndex;
	
	private int endIndex;
	
	private int size;
	
	public IMapParams(Collection<E> collection) {
		super();
		this.collection = collection;
	}

	public IMapParams(Collection<E> collection, int startIndex, int endIndex) {
		super();
		this.collection = collection;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public IMapParams(Collection<E> collection, int startIndex, int endIndex, int size) {
		super();
		this.collection = collection;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.size = size;
	}
	
	public IMapParams(){super();};
	
	public IMapParams(int size) {
		super();
		this.size = size;
	}


	public Collection<E> getCollection() {
		return collection;
	}

	public void setCollection(Collection<E> collection) {
		this.collection = collection;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}