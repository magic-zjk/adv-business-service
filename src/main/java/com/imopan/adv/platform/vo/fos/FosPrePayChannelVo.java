package com.imopan.adv.platform.vo.fos;

import java.io.Serializable;

import com.imopan.adv.platform.common.VoBaseBean;
import com.imopan.adv.platform.exception.ImopanException;

/** 
 * Description:FosPrePayChannelVo vo<br>
 * Create Date: 2016年8月15日 下午6:28:28
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class FosPrePayChannelVo extends VoBaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3550468643438876300L;
	private Integer orderId;
	private String channelId;
	private String channelOrderId;
	private String orderName;
	private String channelName;
	private String channelFullName;
	private String productName;
	private String cooperateName;
	private String createTime;
	private String advancePayTotal;
	private String advancePayRemain;

	@Override
	public boolean verify(String str) throws ImopanException {
		// TODO Auto-generated method stub
		return false;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelOrderId() {
		return channelOrderId;
	}

	public void setChannelOrderId(String channelOrderId) {
		this.channelOrderId = channelOrderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelFullName() {
		return channelFullName;
	}

	public void setChannelFullName(String channelFullName) {
		this.channelFullName = channelFullName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCooperateName() {
		return cooperateName;
	}

	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAdvancePayTotal() {
		return advancePayTotal;
	}

	public void setAdvancePayTotal(String advancePayTotal) {
		this.advancePayTotal = advancePayTotal;
	}

	public String getAdvancePayRemain() {
		return advancePayRemain;
	}

	public void setAdvancePayRemain(String advancePayRemain) {
		this.advancePayRemain = advancePayRemain;
	}

}
