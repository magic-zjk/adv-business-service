/**
 * Project Name:adv-business-service
 * File Name:JsonUtils.java
 * Package Name:com.imopan.adv.platform.util
 * Date:2016年12月28日下午4:12:47
 * Copyright (c) 2016, guochangqing@imopan.com All Rights Reserved.
 *
*/

package com.imopan.adv.platform.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * ClassName:JsonUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年12月28日 下午4:12:47 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class JsonUtils {
	public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
	    Map<String, Object> retMap = new HashMap<String, Object>();

	    if(json != JSONObject.NULL) {
	        retMap = toMap(json);
	    }
	    return retMap;
	}
	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);

	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}
	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
	public static void JsonObject2HashMap(JSONObject jo, List<Map<?, ?>> rstList) {
		for (Iterator<String> keys = jo.keys(); keys.hasNext();) {
			try {
				String key1 = keys.next();
				System.out.println("key1---" + key1 + "------" + jo.get(key1)
						+ (jo.get(key1) instanceof JSONObject) + jo.get(key1)
						+ (jo.get(key1) instanceof JSONArray));
				if (jo.get(key1) instanceof JSONObject) {

					JsonObject2HashMap((JSONObject) jo.get(key1), rstList);
					continue;
				}
				if (jo.get(key1) instanceof JSONArray) {
					JsonArray2HashMap((JSONArray) jo.get(key1), rstList);
					continue;
				}
				System.out.println("key1:" + key1 + "----------jo.get(key1):"
						+ jo.get(key1));
				json2HashMap(key1, jo.get(key1), rstList);

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

	}
	public static void JsonArray2HashMap(JSONArray joArr,
			List<Map<?, ?>> rstList) {
		for (int i = 0; i < joArr.length(); i++) {
			try {
				if (joArr.get(i) instanceof JSONObject) {

					JsonObject2HashMap((JSONObject) joArr.get(i), rstList);
					continue;
				}
				if (joArr.get(i) instanceof JSONArray) {

					JsonArray2HashMap((JSONArray) joArr.get(i), rstList);
					continue;
				}
				System.out.println("Excepton~~~~~");

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

	}

	public static void json2HashMap(String key, Object value,
			List<Map<?, ?>> rstList) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		rstList.add(map);
	}
}


