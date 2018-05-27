package com.imopan.adv.platform.mongo.bean;

import java.util.ArrayList;
import java.util.Arrays;

import org.mongodb.morphia.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity(value = "ads_plan",noClassnameStored=true)
@Entity(noClassnameStored = true)
@JsonIgnoreProperties({ "starttemp","endtemp"})
public class AdsPlan extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String adsid;
	
	private String advstatus;//活动状态广告状态(1: 上线,2: 下线,--3: 删除4: 草稿5:待审核6:审核拒绝

	private String starttime;

	private String endtime;

	private Integer showrate;

	private Integer clickrate;

	private String clicktype;

	private String clickeffect;

	private String[] nettype;

	private String[] isptype;
	
	private String[] areawhite;
	
	private String[] areablack;
	
	private String[] tagwhite;
	
	private String[] tagblack;
	
	private MediaTarget mediatarget;//媒体定向

	private String sdkinfo;// sdk版本信息

	private String[] deviceinfo;// 投放设备 手机 平板

	private String systeminfo;// 系统版本

	private ArrayList<Period> periodlist;

	public MediaTarget getMediatarget() {
		return mediatarget;
	}

	public void setMediatarget(MediaTarget mediatarget) {
		this.mediatarget = mediatarget;
	}
	public String getAdvstatus() {
		return advstatus;
	}

	public void setAdvstatus(String advstatus) {
		this.advstatus = advstatus;
	}

	public String getAdsid() {
		return adsid;
	}

	public void setAdsid(String adsid) {
		this.adsid = adsid;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getShowrate() {
		return showrate;
	}

	public void setShowrate(Integer showrate) {
		this.showrate = showrate;
	}

	public Integer getClickrate() {
		return clickrate;
	}

	public void setClickrate(Integer clickrate) {
		this.clickrate = clickrate;
	}

	public String getClicktype() {
		return clicktype;
	}

	public void setClicktype(String clicktype) {
		this.clicktype = clicktype;
	}

	public String getClickeffect() {
		return clickeffect;
	}

	public void setClickeffect(String clickeffect) {
		this.clickeffect = clickeffect;
	}

	public String[] getNettype() {
		return nettype;
	}

	public void setNettype(String[] nettype) {
		this.nettype = nettype;
	}

	public String[] getIsptype() {
		return isptype;
	}

	public void setIsptype(String[] isptype) {
		this.isptype = isptype;
	}

	public String[] getAreawhite() {
		return areawhite;
	}

	public void setAreawhite(String[] areawhite) {
		this.areawhite = areawhite;
	}

	public String[] getAreablack() {
		return areablack;
	}

	public void setAreablack(String[] areablack) {
		this.areablack = areablack;
	}

	public String[] getTagwhite() {
		return tagwhite;
	}

	public void setTagwhite(String[] tagwhite) {
		this.tagwhite = tagwhite;
	}

	public String[] getTagblack() {
		return tagblack;
	}

	public void setTagblack(String[] tagblack) {
		this.tagblack = tagblack;
	}

	public String getSdkinfo() {
		return sdkinfo;
	}

	public void setSdkinfo(String sdkinfo) {
		this.sdkinfo = sdkinfo;
	}

	public String[] getDeviceinfo() {
		return deviceinfo;
	}

	public void setDeviceinfo(String[] deviceinfo) {
		this.deviceinfo = deviceinfo;
	}

	public String getSysteminfo() {
		return systeminfo;
	}

	public void setSysteminfo(String systeminfo) {
		this.systeminfo = systeminfo;
	}

	public ArrayList<Period> getPeriodlist() {
		return periodlist;
	}

	public void setPeriodlist(ArrayList<Period> periodlist) {
		this.periodlist = periodlist;
	}

	@Override
	public String toString() {
		return "AdsPlan [adsid=" + adsid + ", advstatus=" + advstatus + ", starttime=" + starttime + ", endtime="
				+ endtime + ", showrate=" + showrate + ", clickrate=" + clickrate + ", clicktype=" + clicktype
				+ ", clickeffect=" + clickeffect + ", nettype=" + Arrays.toString(nettype) + ", isptype="
				+ Arrays.toString(isptype) + ", areawhite=" + Arrays.toString(areawhite) + ", areablack="
				+ Arrays.toString(areablack) + ", tagwhite=" + Arrays.toString(tagwhite) + ", tagblack="
				+ Arrays.toString(tagblack) + ", sdkinfo=" + sdkinfo + ", deviceinfo=" + Arrays.toString(deviceinfo)
				+ ", systeminfo=" + systeminfo + ", periodlist=" + periodlist + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adsid == null) ? 0 : adsid.hashCode());
		result = prime * result + ((advstatus == null) ? 0 : advstatus.hashCode());
		result = prime * result + Arrays.hashCode(areablack);
		result = prime * result + Arrays.hashCode(areawhite);
		result = prime * result + ((clickeffect == null) ? 0 : clickeffect.hashCode());
		result = prime * result + ((clickrate == null) ? 0 : clickrate.hashCode());
		result = prime * result + ((clicktype == null) ? 0 : clicktype.hashCode());
		result = prime * result + Arrays.hashCode(deviceinfo);
		result = prime * result + ((endtime == null) ? 0 : endtime.hashCode());
		result = prime * result + Arrays.hashCode(isptype);
		result = prime * result + ((mediatarget == null) ? 0 : mediatarget.hashCode());
		result = prime * result + Arrays.hashCode(nettype);
		result = prime * result + ((periodlist == null) ? 0 : periodlist.hashCode());
		result = prime * result + ((sdkinfo == null) ? 0 : sdkinfo.hashCode());
		result = prime * result + ((showrate == null) ? 0 : showrate.hashCode());
		result = prime * result + ((starttime == null) ? 0 : starttime.hashCode());
		result = prime * result + ((systeminfo == null) ? 0 : systeminfo.hashCode());
		result = prime * result + Arrays.hashCode(tagblack);
		result = prime * result + Arrays.hashCode(tagwhite);
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
		AdsPlan other = (AdsPlan) obj;
		if (adsid == null) {
			if (other.adsid != null)
				return false;
		} else if (!adsid.equals(other.adsid))
			return false;
		if (advstatus == null) {
			if (other.advstatus != null)
				return false;
		} else if (!advstatus.equals(other.advstatus))
			return false;
		if (!Arrays.equals(areablack, other.areablack))
			return false;
		if (!Arrays.equals(areawhite, other.areawhite))
			return false;
		if (clickeffect == null) {
			if (other.clickeffect != null)
				return false;
		} else if (!clickeffect.equals(other.clickeffect))
			return false;
		if (clickrate == null) {
			if (other.clickrate != null)
				return false;
		} else if (!clickrate.equals(other.clickrate))
			return false;
		if (clicktype == null) {
			if (other.clicktype != null)
				return false;
		} else if (!clicktype.equals(other.clicktype))
			return false;
		if (!Arrays.equals(deviceinfo, other.deviceinfo))
			return false;
		if (endtime == null) {
			if (other.endtime != null)
				return false;
		} else if (!endtime.equals(other.endtime))
			return false;
		if (!Arrays.equals(isptype, other.isptype))
			return false;
		if (mediatarget == null) {
			if (other.mediatarget != null)
				return false;
		} else if (!mediatarget.equals(other.mediatarget))
			return false;
		if (!Arrays.equals(nettype, other.nettype))
			return false;
		if (periodlist == null) {
			if (other.periodlist != null)
				return false;
		} else if (!periodlist.equals(other.periodlist))
			return false;
		if (sdkinfo == null) {
			if (other.sdkinfo != null)
				return false;
		} else if (!sdkinfo.equals(other.sdkinfo))
			return false;
		if (showrate == null) {
			if (other.showrate != null)
				return false;
		} else if (!showrate.equals(other.showrate))
			return false;
		if (starttime == null) {
			if (other.starttime != null)
				return false;
		} else if (!starttime.equals(other.starttime))
			return false;
		if (systeminfo == null) {
			if (other.systeminfo != null)
				return false;
		} else if (!systeminfo.equals(other.systeminfo))
			return false;
		if (!Arrays.equals(tagblack, other.tagblack))
			return false;
		if (!Arrays.equals(tagwhite, other.tagwhite))
			return false;
		return true;
	}

	

}
