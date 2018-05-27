/**
 * Project Name:adv-business-service1.1.1
 * File Name:DeviceVersionUnit.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年8月17日上午11:19:17
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

import java.io.Serializable;

/**
 * ClassName: DeviceVersionUnit <br/>
 * Desc:(操作系统版本基本单位)
 * date: 2016年8月17日 上午11:19:17 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class DeviceVersionUnit implements Serializable {
	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -1363779501031316226L;
	private String id;
	private String name;
	private String pid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
