package com.imopan.adv.platform.mongo.bean;



import java.io.Serializable;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseEntity implements Serializable{
    
	private static final long serialVersionUID = 1L;
	@Id
	@JsonIgnore(true)
	private ObjectId id;
	
	private String createtime;//创建时间
	
	private String updatetime;//最后更新时间

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public ObjectId getId() {
		if (id == null ){
			return new ObjectId();
		}
		return id;
	}

	public void setId(final ObjectId id) {
		this.id = id;
	}
}
