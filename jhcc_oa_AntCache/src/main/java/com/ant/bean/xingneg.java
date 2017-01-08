package com.ant.bean;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

/** 
 * ClassName:xingneg <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月19日 上午12:56:32 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class xingneg {

	public static void main(String[] args) {
		MemoryMXBean memorymbean = ManagementFactory.getMemoryMXBean();   
	    MemoryUsage usage = memorymbean.getHeapMemoryUsage();   
	    System.out.println("INIT HEAP: " + usage.getInit());   
	    System.out.println("MAX HEAP: " + usage.getMax());   
	    System.out.println("USE HEAP: " + usage.getUsed());   
	    System.out.println("\nFull Information:");   
	    System.out.println("Heap Memory Usage: "   
	    + memorymbean.getHeapMemoryUsage());   
	    System.out.println("Non-Heap Memory Usage: "   
	    + memorymbean.getNonHeapMemoryUsage());   
	      
	    List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();   
	    System.out.println("===================java options=============== ");  
	    System.out.println(inputArguments);  
	  
	      
	      
	    System.out.println("=======================通过java来获取相关系统状态============================ ");  
	    int i = (int)Runtime.getRuntime().totalMemory()/1024;//Java 虚拟机中的内存总量,以字节为单位  
	    System.out.println("总的内存量 i is "+i);  
	    int j = (int)Runtime.getRuntime().freeMemory()/1024;//Java 虚拟机中的空闲内存量  
	    System.out.println("空闲内存量 j is "+j);  
	    System.out.println("最大内存量 is "+Runtime.getRuntime().maxMemory()/1024);  
	  
	    System.out.println("=======================OperatingSystemMXBean============================ ");  
	}
}
