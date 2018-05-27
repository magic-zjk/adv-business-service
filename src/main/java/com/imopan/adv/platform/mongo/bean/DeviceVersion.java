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

/**
 * ClassName: DeviceVersion <br/>
 * Desc:(操作系统版本)
 * date: 2016年8月17日 上午11:13:10 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class DeviceVersion implements Serializable{

	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -3580054931821989986L;
	private String type; //"0" :不限  "1" 自定义
	private ArrayList<DeviceVersionUnit> valueArr;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<DeviceVersionUnit> getValueArr() {
		return valueArr;
	}
	public void setValueArr(ArrayList<DeviceVersionUnit> valueArr) {
		this.valueArr = valueArr;
	}

	
}
