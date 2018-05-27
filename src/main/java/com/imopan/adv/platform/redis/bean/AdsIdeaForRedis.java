/**
 * Project Name:adv-business-service
 * File Name:AdsIdeaForRedis.java
 * Package Name:com.imopan.adv.platform.redis.bean
 * Date:2016年5月12日下午5:53:29
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.redis.bean;

/**
 * ClassName: AdsIdeaForRedis <br/>
 * Desc:(..)
 * date: 2016年5月12日 下午5:53:29 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class AdsIdeaForRedis {
	private Integer advid;//广告id
	private Integer adsid;//投放id
	private Integer ideaId;//创意id
	private String ideaName;//创意名称
	private String adsName;//投放名称/活动名称
	private Integer feeType;//计费类型cpm102 cpc 103
	private Integer adsType;//广告类型1banner 2插屏
	private float adsPrice; //价格
	private long ideaUpdateTime;//存入redis时间
	
	public Integer getAdvid() {
		return advid;
	}

	public void setAdvid(Integer advid) {
		this.advid = advid;
	}

	public Integer getAdsid() {
		return adsid;
	}

	public void setAdsid(Integer adsid) {
		this.adsid = adsid;
	}

	public Integer getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}

	public String getAdsName() {
		return adsName;
	}

	public void setAdsName(String adsName) {
		this.adsName = adsName;
	}

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}

	public Integer getAdsType() {
		return adsType;
	}

	public void setAdsType(Integer adsType) {
		this.adsType = adsType;
	}

	public float getAdsPrice() {
		return adsPrice;
	}

	public void setAdsPrice(float adsPrice) {
		this.adsPrice = adsPrice;
	}

	public long getIdeaUpdateTime() {
		return ideaUpdateTime;
	}

	public void setIdeaUpdateTime(long ideaUpdateTime) {
		this.ideaUpdateTime = ideaUpdateTime;
	}

	@Override
	public String toString() {
		return "AdsIdeaForRedis [advid=" + advid + ", adsid=" + adsid + ", ideaId=" + ideaId + ", ideaName=" + ideaName
				+ ", adsName=" + adsName + ", feeType=" + feeType + ", adsType=" + adsType + ", adsPrice=" + adsPrice
				+ ", ideaUpdateTime=" + ideaUpdateTime + "]";
	}
	
}
