/**
 * Project Name:adv-business-service1.1.1
 * File Name:TimeInterval.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年8月17日上午11:13:10
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ClassName: TimeInterval <br/>
 * Desc:(..)
 * date: 2016年8月17日 上午11:13:10 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class TimeInterval implements Serializable{
	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = 6314330873117527019L;
	private String type; //"0" :全天投  "1" 自定义
	private String value;
	private HashMap<String,ArrayList<String>> valuemap;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public HashMap<String, ArrayList<String>> getValuemap() {
		return valuemap;
	}
	public void setValuemap(HashMap<String, ArrayList<String>> buildWeekHourMap) {
		this.valuemap = buildWeekHourMap;
	}
	
}
