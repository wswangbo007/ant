package com.ant.map;

import java.util.Comparator;
import java.util.Map;

/**
 * 工具
 * 
 * @ClassName: MyComparator
 * @Description: TODO
 * @author 神经刀
 */
public class MyComparator implements Comparator<Integer> {

	private Map<Integer, Integer> resourceMap;

	public MyComparator() {
		super();
	};

	public MyComparator(Map<Integer, Integer> resourceMap) {
		this.resourceMap = resourceMap;
	};

	@Override
	public int compare(Integer o1, Integer o2) {
		if (resourceMap.get(o1) >= resourceMap.get(o2)) {
			return -1;
		} else {
			return 1;
		}
	}

}