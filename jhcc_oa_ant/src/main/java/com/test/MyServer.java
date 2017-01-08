package com.test;

import java.util.concurrent.Callable;

public class MyServer implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(1);
		return 1;
	}

//	@Override
//	public void run() {
//		System.out.println(2);
//	}

}
