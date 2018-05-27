/**
 * Project Name:adv-business-service
 * File MediaSettingOfferWall.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年3月24日上午10:29:09
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
 * ClassName: MediaSettingChaping <br/>
 * Desc:(媒体参数设置--banner)
 * date: 2016年3月24日 上午10:29:09 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
@Entity(noClassnameStored = true)
public class MediaSettingOfferWall extends BaseEntity {
	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -6322414471329494369L;

	private String mediaid;

	public String getMediaid() {
		return mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}
	



}
