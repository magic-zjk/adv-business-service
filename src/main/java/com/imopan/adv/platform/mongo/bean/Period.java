package com.imopan.adv.platform.mongo.bean;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Embedded;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embedded
@JsonIgnoreProperties({ "hours", "chkAll","ischkall","choseArr","startopen","endopen","dates2"})
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;

    private String startperiod;

    private String endperiod;

    private BasicPolicy basicpolicy;

    public String getStartperiod() {
        return startperiod;
    }

    public void setStartperiod(String startperiod) {
        this.startperiod = startperiod;
    }

    public String getEndperiod() {
        return endperiod;
    }

    public void setEndperiod(String endperiod) {
        this.endperiod = endperiod;
    }

    public BasicPolicy getBasicpolicy() {
        return basicpolicy;
    }

    public void setBasicpolicy(BasicPolicy basicpolicy) {
        this.basicpolicy = basicpolicy;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basicpolicy == null) ? 0 : basicpolicy.hashCode());
		result = prime * result + ((endperiod == null) ? 0 : endperiod.hashCode());
		result = prime * result + ((startperiod == null) ? 0 : startperiod.hashCode());
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
		Period other = (Period) obj;
		if (basicpolicy == null) {
			if (other.basicpolicy != null)
				return false;
		} else if (!basicpolicy.equals(other.basicpolicy))
			return false;
		if (endperiod == null) {
			if (other.endperiod != null)
				return false;
		} else if (!endperiod.equals(other.endperiod))
			return false;
		if (startperiod == null) {
			if (other.startperiod != null)
				return false;
		} else if (!startperiod.equals(other.startperiod))
			return false;
		return true;
	}

}
