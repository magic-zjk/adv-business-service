/**
 * Project Name:adv-business-service1.1.1
 * File Name:CpaCampaign.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年8月17日上午11:42:28
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

import org.mongodb.morphia.annotations.Entity;

/**
 * ClassName: CpaCampaign <br/>
 * Desc:(..)
 * date: 2016年8月17日 上午11:42:28 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
//@Entity(value = "ads_plan",noClassnameStored=true)
@Entity(noClassnameStored = true)

public class CpaCampaign extends BaseEntity {
	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = -4634714348430665543L;
	private String campaignid;//活动id
	private String efftime;//开始时间
	private String exptime;//结束时间
	public String getCampaignid() {
		return campaignid;
	}
	public void setCampaignid(String campaignid) {
		this.campaignid = campaignid;
	}
	public String getEfftime() {
		return efftime;
	}
	public void setEfftime(String efftime) {
		this.efftime = efftime;
	}
	public String getExptime() {
		return exptime;
	}
	public void setExptime(String exptime) {
		this.exptime = exptime;
	}
	
}
