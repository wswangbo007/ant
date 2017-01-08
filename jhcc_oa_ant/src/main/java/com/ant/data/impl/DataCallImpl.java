package com.ant.data.impl;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.concurrent.Semaphore;

public class DataCallImpl extends AbstractDataCallImpl<Integer> {
	
	// 双核心CPU,还有别的事情要用CPU资源(不知道这样理解对不对)
	// TODO google Semaphore
	protected Semaphore semaphore = new Semaphore(2);
	
	public DataCallImpl() {
		super();
	}
	
	public DataCallImpl(Collection<Integer> collection) {
		super(collection);
	}

	@Override
	public Collection<Integer> call() throws Exception {
		try {
			SecureRandom random = new SecureRandom();
			semaphore.acquire();
			int index = 0;
			while (index < 1000 << 1) {
				collection.add(random.nextInt(++index << 5));
			}
			semaphore.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collection;
	}
}