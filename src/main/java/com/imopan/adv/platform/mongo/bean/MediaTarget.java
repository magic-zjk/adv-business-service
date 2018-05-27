/**
 * Project Name:adv-business-service
 * File Name:MediaTarget.java
 * Package Name:com.imopan.adv.platform.mongo.bean
 * Date:2016年5月6日下午3:42:08
 * Copyright (c) 2016 www.imopan.com, All Rights Reserved.
 *
 */
package com.imopan.adv.platform.mongo.bean;

import java.util.Arrays;

import org.mongodb.morphia.annotations.Embedded;

/**
 * ClassName: MediaTarget <br/>
 * Desc:(..)
 * date: 2016年5月6日 下午3:42:08 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
@Embedded
public class MediaTarget {
	
	private String flag;//开关 是否详细设置 1是 0否

	private String mediaflag;//开关 是否设置媒体1是 0否
	
	private String mediacatflag;//开关 是否设置媒体类别1是 0否
	
	private String mediablackflag;//开关 是否设置媒体黑名单1是 0否
	
	private Integer[] medialist;//媒体

	private Integer[] mediacatlist;//媒体列表

	private Integer[] mediablacklist;//媒体黑名单

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMediaflag() {
		return mediaflag;
	}

	public void setMediaflag(String mediaflag) {
		this.mediaflag = mediaflag;
	}

	public String getMediacatflag() {
		return mediacatflag;
	}

	public void setMediacatflag(String mediacatflag) {
		this.mediacatflag = mediacatflag;
	}

	public String getMediablackflag() {
		return mediablackflag;
	}

	public void setMediablackflag(String mediablackflag) {
		this.mediablackflag = mediablackflag;
	}


	public Integer[] getMedialist() {
		return medialist;
	}

	public void setMedialist(Integer[] medialist) {
		this.medialist = medialist;
	}

	public Integer[] getMediacatlist() {
		return mediacatlist;
	}

	public void setMediacatlist(Integer[] mediacatlist) {
		this.mediacatlist = mediacatlist;
	}

	public Integer[] getMediablacklist() {
		return mediablacklist;
	}

	public void setMediablacklist(Integer[] mediablacklist) {
		this.mediablacklist = mediablacklist;
	}

	@Override
	public String toString() {
		return "MediaTarget [flag=" + flag + ", mediaflag=" + mediaflag + ", mediacatflag=" + mediacatflag
				+ ", mediablackflag=" + mediablackflag + ", medialist=" + Arrays.toString(medialist) + ", mediacatlist="
				+ Arrays.toString(mediacatlist) + ", mediablacklist=" + Arrays.toString(mediablacklist) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((mediablackflag == null) ? 0 : mediablackflag.hashCode());
		result = prime * result + Arrays.hashCode(mediablacklist);
		result = prime * result + ((mediacatflag == null) ? 0 : mediacatflag.hashCode());
		result = prime * result + Arrays.hashCode(mediacatlist);
		result = prime * result + ((mediaflag == null) ? 0 : mediaflag.hashCode());
		result = prime * result + Arrays.hashCode(medialist);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MediaTarget other = (MediaTarget) obj;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (mediablackflag == null) {
			if (other.mediablackflag != null)
				return false;
		} else if (!mediablackflag.equals(other.mediablackflag))
			return false;
		if (!Arrays.equals(mediablacklist, other.mediablacklist))
			return false;
		if (mediacatflag == null) {
			if (other.mediacatflag != null)
				return false;
		} else if (!mediacatflag.equals(other.mediacatflag))
			return false;
		if (!Arrays.equals(mediacatlist, other.mediacatlist))
			return false;
		if (mediaflag == null) {
			if (other.mediaflag != null)
				return false;
		} else if (!mediaflag.equals(other.mediaflag))
			return false;
		if (!Arrays.equals(medialist, other.medialist))
			return false;
		return true;
	}
	
}
