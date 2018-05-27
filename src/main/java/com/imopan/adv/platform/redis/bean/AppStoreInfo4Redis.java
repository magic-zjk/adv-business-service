/** 
 * File Name:AppStoreInfo4Redis.java
 * Project Name:adv-business-service  
 * Package Name:com.imopan.adv.platform.redis.bean 
 * Create Date:2016年8月18日下午10:15:58 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */  
package com.imopan.adv.platform.redis.bean;

import java.io.Serializable;

/** 
 * Description: appstoreinfo<br>
 * Create Date: 2016年8月18日 下午10:15:58
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class AppStoreInfo4Redis implements Serializable{

	private static final long serialVersionUID = -301506024197130137L;
	
	private Integer id;
	private String appStoreId;
	private String name;
	private String landingPage;
	private String iconUrl;//appStore iconUrl
	private String bundleId;
	
	/**
	 * @return the appStoreId
	 */
	public String getAppStoreId() {
		return appStoreId;
	}
	/**
	 * @param appStoreId the appStoreId to set
	 */
	public void setAppStoreId(String appStoreId) {
		this.appStoreId = appStoreId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the landingPage
	 */
	public String getLandingPage() {
		return landingPage;
	}
	/**
	 * @param landingPage the landingPage to set
	 */
	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}
	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}
	/**
	 * @param iconUrl the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	/**
	 * @return the bundleId
	 */
	public String getBundleId() {
		return bundleId;
	}
	/**
	 * @param bundleId the bundleId to set
	 */
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
