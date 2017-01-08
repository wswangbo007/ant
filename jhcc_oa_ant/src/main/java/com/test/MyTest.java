package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTest {

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) {
		MyServer myServer = new MyServer();
		executorService.submit(myServer);
	}
}
