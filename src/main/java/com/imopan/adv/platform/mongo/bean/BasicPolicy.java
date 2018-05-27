package com.imopan.adv.platform.mongo.bean;

import java.io.Serializable;
import java.util.Arrays;

import org.mongodb.morphia.annotations.Embedded;



@Embedded
public class BasicPolicy implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String isuniformspeed;//1 正常 2 匀速
	
	private String[] throwintime;
	
	private Integer showlimit;
	
	private Integer clicklimit;

    public String getIsuniformspeed() {
        return isuniformspeed;
    }

    public void setIsuniformspeed(String isuniformspeed) {
        this.isuniformspeed = isuniformspeed;
    }
    
	public String[] getThrowintime() {
		return throwintime;
	}

	public void setThrowintime(String[] throwintime) {
		this.throwintime = throwintime;
	}

	public Integer getShowlimit() {
		return showlimit;
	}

	public void setShowlimit(Integer showlimit) {
		this.showlimit = showlimit;
	}

	public Integer getClicklimit() {
		return clicklimit;
	}

	public void setClicklimit(Integer clicklimit) {
		this.clicklimit = clicklimit;
	}

	@Override
	public String toString() {
		return "BasicPolicy [isuniformspeed=" + isuniformspeed + ", throwintime=" + Arrays.toString(throwintime)
				+ ", showlimit=" + showlimit + ", clicklimit=" + clicklimit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clicklimit == null) ? 0 : clicklimit.hashCode());
		result = prime * result + ((isuniformspeed == null) ? 0 : isuniformspeed.hashCode());
		result = prime * result + ((showlimit == null) ? 0 : showlimit.hashCode());
		result = prime * result + Arrays.hashCode(throwintime);
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
		BasicPolicy other = (BasicPolicy) obj;
		if (clicklimit == null) {
			if (other.clicklimit != null)
				return false;
		} else if (!clicklimit.equals(other.clicklimit))
			return false;
		if (isuniformspeed == null) {
			if (other.isuniformspeed != null)
				return false;
		} else if (!isuniformspeed.equals(other.isuniformspeed))
			return false;
		if (showlimit == null) {
			if (other.showlimit != null)
				return false;
		} else if (!showlimit.equals(other.showlimit))
			return false;
		if (!Arrays.equals(throwintime, other.throwintime))
			return false;
		return true;
	}




}
