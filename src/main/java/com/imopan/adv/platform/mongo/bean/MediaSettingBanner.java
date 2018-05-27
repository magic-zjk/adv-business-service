/**
 * Project Name:adv-business-service
 * File MediaSettingBanner.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年3月24日上午10:29:09
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

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
public class MediaSettingBanner extends BaseEntity {
	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -6322414471329494369L;

	private String mediaid;
	
    private Double bannerPrice=0.3d;

    private Double bannerRequestDiscount=0.8d;

    private Double bannerClikDiscount=0.8d;

	private Double bannerShowDiscount=0.8d;
    
    private String settlementType="1";
    //1点击 2展示


    public String getMediaid() {
		return mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}


	public Double getBannerPrice() {
		return bannerPrice;
	}

	public void setBannerPrice(Double bannerPrice) {
		this.bannerPrice = bannerPrice;
	}

	public Double getBannerRequestDiscount() {
		return bannerRequestDiscount;
	}

	public void setBannerRequestDiscount(Double bannerRequestDiscount) {
		this.bannerRequestDiscount = bannerRequestDiscount;
	}

	public Double getBannerClikDiscount() {
		return bannerClikDiscount;
	}

	public void setBannerClikDiscount(Double bannerClikDiscount) {
		this.bannerClikDiscount = bannerClikDiscount;
	}

	public Double getBannerShowDiscount() {
		return bannerShowDiscount;
	}

	public void setBannerShowDiscount(Double bannerShowDiscount) {
		this.bannerShowDiscount = bannerShowDiscount;
	}

	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}





}
