package com.imopan.adv.platform.mongo.bean;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity(value = "ads_plan",noClassnameStored=true)
@Entity(noClassnameStored = true)

public class PeriodListBackUp extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String adsid;


	private List<Period> periodlist;


	public String getAdsid() {
		return adsid;
	}


	public void setAdsid(String adsid) {
		this.adsid = adsid;
	}


	public List<Period> getPeriodlist() {
		return periodlist;
	}


	public void setPeriodlist(List<Period> periodlist) {
		this.periodlist = periodlist;
	}


	@Override
	public String toString() {
		return "PeriodListBackUp [adsid=" + adsid + ", periodlist=" + periodlist + "]";
	}

	
}
