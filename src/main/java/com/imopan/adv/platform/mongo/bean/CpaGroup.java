package com.imopan.adv.platform.mongo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.mongodb.morphia.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity(value = "ads_plan",noClassnameStored=true)
@Entity(noClassnameStored = true)

public class CpaGroup extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String groupid;//组id

	private String campaignid;//活动id
	
	private String keyword;//关键字
	
	private Integer limit;//激活限量
	
	private Boolean isnolimit;//是否不限量 true 不限量

	private TimeInterval timeinterval;//投放时间

	private DeviceVersion deviceversion;//设备版本
	
	private DeviceType device; //设备类型
	
	private String landingpage;//推广链接
	
	private Boolean isuseitunesurl;//是否使用itunesurl 是 使用
	
	private Double price;//投放单价	
	
	private String secondstep;//第二步操作描述
	
	private String thirdstep;//第三步操作描述

	private String opuserid;//做到 添加 mongo 操作人 操作时间 TODO
	
	private String opusername;
	
	public String getOpuserid() {
		return opuserid;
	}

	public void setOpuserid(String opuserid) {
		this.opuserid = opuserid;
	}

	public String getOpusername() {
		return opusername;
	}

	public void setOpusername(String opusername) {
		this.opusername = opusername;
	}

	public String getSecondstep() {
		return secondstep;
	}

	public void setSecondstep(String secondstep) {
		this.secondstep = secondstep;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getCampaignid() {
		return campaignid;
	}

	public void setCampaignid(String campaignid) {
		this.campaignid = campaignid;
	}


	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}



	public Boolean getIsnolimit() {
		return isnolimit;
	}

	public void setIsnolimit(Boolean isnolimit) {
		this.isnolimit = isnolimit;
	}

	public TimeInterval getTimeinterval() {
		return timeinterval;
	}

	public void setTimeinterval(TimeInterval timeinterval) {
		this.timeinterval = timeinterval;
	}

	public DeviceVersion getDeviceversion() {
		return deviceversion;
	}

	public void setDeviceversion(DeviceVersion deviceversion) {
		this.deviceversion = deviceversion;
	}

	public DeviceType getDevice() {
		return device;
	}

	public void setDevice(DeviceType device) {
		this.device = device;
	}

	public String getLandingpage() {
		return landingpage;
	}

	public void setLandingpage(String landingpage) {
		this.landingpage = landingpage;
	}

	public Boolean getIsuseitunesurl() {
		return isuseitunesurl;
	}

	public void setIsuseitunesurl(Boolean isuseitunesurl) {
		this.isuseitunesurl = isuseitunesurl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getThirdstep() {
		return thirdstep;
	}

	public void setThirdstep(String thirdstep) {
		this.thirdstep = thirdstep;
	}




}
