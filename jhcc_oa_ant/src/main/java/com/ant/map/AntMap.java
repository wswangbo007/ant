package com.ant.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map工具
  * @ClassName: AntMap
  * @author 神经刀
 */
public class AntMap extends TreeMap<Integer, Integer> implements IMap<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	public AntMap() {super();};
	
	public AntMap(Comparator<? super Integer> comparator) {
		super(comparator);
	}

	@Override
	public boolean put(IMapParams<Integer> iMapParams) {
		int index = 0;
		if (null != iMapParams && null != iMapParams.getCollection() && !iMapParams.getCollection().isEmpty()) {
			for (Iterator<Integer> it = iMapParams.getCollection().iterator(); it.hasNext();) {
				index = it.next();
				if (this.containsKey(index)) {
					this.put(index, 1 + this.get(index));
				} else {
					this.put(index, 0);
				}
			}
		}
		return this.size() > 0;
	}

	@Override
	public Map<Integer, Integer> getMapData() {
		int index = 0;
		Map<Integer,Integer> map = null;
		if (null != this && !this.isEmpty() && this.size() > 0) {
			map = new HashMap<Integer,Integer>();
			for (java.util.Map.Entry<Integer, Integer> entry : this.entrySet()) {
				if (index >= this.size()) break;
				index++;
				map.put(entry.getKey(), entry.getValue());
			}
		}
		return map;
	}
}