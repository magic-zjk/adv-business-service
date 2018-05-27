/**
 * Project Name:adv-business-service
 * File Name:MediaSettingChaping.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年3月24日上午10:29:09
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

import org.mongodb.morphia.annotations.Entity;

/**
 * ClassName: MediaSettingChaping <br/>
 * Desc:(媒体参数设置--插屏) date: 2016年3月24日 上午10:29:09 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
@Entity(noClassnameStored = true)
public class MediaSettingChaping extends BaseEntity {
	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -6322414471329494369L;

	private String mediaid;

	private Double chpPrice=0.3d;

	private Double chpRequestDiscount=0.8d;

	private Double chpClikDiscount=0.8d;

	private Double chpShowDiscount=0.8d;

	private String settlementType = "1";
    //1点击 2展示
	public String getMediaid() {
		return mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}

	public Double getChpPrice() {
		return chpPrice;
	}

	public void setChpPrice(Double chpPrice) {
		this.chpPrice = chpPrice;
	}

	public Double getChpRequestDiscount() {
		return chpRequestDiscount;
	}

	public void setChpRequestDiscount(Double chpRequestDiscount) {
		this.chpRequestDiscount = chpRequestDiscount;
	}

	public Double getChpClikDiscount() {
		return chpClikDiscount;
	}

	public void setChpClikDiscount(Double chpClikDiscount) {
		this.chpClikDiscount = chpClikDiscount;
	}

	public Double getChpShowDiscount() {
		return chpShowDiscount;
	}

	public void setChpShowDiscount(Double chpShowDiscount) {
		this.chpShowDiscount = chpShowDiscount;
	}

	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}



}
