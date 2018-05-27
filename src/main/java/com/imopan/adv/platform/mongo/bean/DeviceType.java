/**
 * Project Name:adv-business-service1.1.1
 * File Name:DeviceType.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年8月17日上午11:24:18
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ClassName: DeviceType <br/>
 * Desc:(设备类型 iphone itouch ipad)
 * date: 2016年8月17日 上午11:24:18 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class DeviceType implements Serializable{
	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -6193650729667549996L;
	private String type; //"0" :不限  "1" 自定义
	private ArrayList<String> valueArr;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getValueArr() {
		return valueArr;
	}
	public void setValueArr(ArrayList<String> valueArr) {
		this.valueArr = valueArr;
	}
	
}
