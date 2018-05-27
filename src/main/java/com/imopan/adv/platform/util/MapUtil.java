package com.imopan.adv.platform.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class MapUtil {
	/**
	 * 移除  值为""的 map属性
	 * @param hashmmap
	 */
	public static void removeBlankOfMap(HashMap<String, Object> hashmmap) {
		Set<Entry<String, Object>> entrySet = hashmmap.entrySet();
    	List<String> list =new ArrayList<String>();
		  for (Entry<String, Object> entry : entrySet) {
			 if("".equals(entry.getValue())){
				 list.add(entry.getKey());
			 } 
		  }
    	for (String object : list) {
    		hashmmap.remove(object);
		}
	}
}
