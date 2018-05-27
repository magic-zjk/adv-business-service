package com.imopan.adv.platform.entity.fos;

import com.imopan.adv.platform.common.BaseBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FosOrderChannel extends BaseBean implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	private Integer channelOrderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.ORDER_ID
	 * @mbggenerated
	 */
	private Integer orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.PAY_UNIT
	 * @mbggenerated
	 */
	private BigDecimal payUnit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.ORDER_STATUS
	 * @mbggenerated
	 */
	private Byte orderStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.CHANNEL_ID
	 * @mbggenerated
	 */
	private Integer channelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.OUTER_UNIT
	 * @mbggenerated
	 */
	private BigDecimal outerUnit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.CHANNEL_STATUS
	 * @mbggenerated
	 */
	private Byte channelStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.STATUS
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.BEGIN_TIME
	 * @mbggenerated
	 */
	private Date beginTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.END_TIME
	 * @mbggenerated
	 */
	private Date endTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.CREATE_TIME
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.MODIFY_TIME
	 * @mbggenerated
	 */
	private Date modifyTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.RELATION_ID
	 * @mbggenerated
	 */
	private Integer relationId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.RELATION_CHANNELID
	 * @mbggenerated
	 */
	private Integer relationChannelid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.REMARK
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.AUTOFLAG
	 * @mbggenerated
	 */
	private Byte autoflag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order_channel.ADVANCE_PAY
	 * @mbggenerated
	 */
	private BigDecimal advancePay;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table fos_order_channel
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.CHANNEL_ORDER_ID
	 * @return  the value of fos_order_channel.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public Integer getChannelOrderId() {
		return channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.CHANNEL_ORDER_ID
	 * @param channelOrderId  the value for fos_order_channel.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public void setChannelOrderId(Integer channelOrderId) {
		this.channelOrderId = channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.ORDER_ID
	 * @return  the value of fos_order_channel.ORDER_ID
	 * @mbggenerated
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.ORDER_ID
	 * @param orderId  the value for fos_order_channel.ORDER_ID
	 * @mbggenerated
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.PAY_UNIT
	 * @return  the value of fos_order_channel.PAY_UNIT
	 * @mbggenerated
	 */
	public BigDecimal getPayUnit() {
		return payUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.PAY_UNIT
	 * @param payUnit  the value for fos_order_channel.PAY_UNIT
	 * @mbggenerated
	 */
	public void setPayUnit(BigDecimal payUnit) {
		this.payUnit = payUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.ORDER_STATUS
	 * @return  the value of fos_order_channel.ORDER_STATUS
	 * @mbggenerated
	 */
	public Byte getOrderStatus() {
		return orderStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.ORDER_STATUS
	 * @param orderStatus  the value for fos_order_channel.ORDER_STATUS
	 * @mbggenerated
	 */
	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.CHANNEL_ID
	 * @return  the value of fos_order_channel.CHANNEL_ID
	 * @mbggenerated
	 */
	public Integer getChannelId() {
		return channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.CHANNEL_ID
	 * @param channelId  the value for fos_order_channel.CHANNEL_ID
	 * @mbggenerated
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.OUTER_UNIT
	 * @return  the value of fos_order_channel.OUTER_UNIT
	 * @mbggenerated
	 */
	public BigDecimal getOuterUnit() {
		return outerUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.OUTER_UNIT
	 * @param outerUnit  the value for fos_order_channel.OUTER_UNIT
	 * @mbggenerated
	 */
	public void setOuterUnit(BigDecimal outerUnit) {
		this.outerUnit = outerUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.CHANNEL_STATUS
	 * @return  the value of fos_order_channel.CHANNEL_STATUS
	 * @mbggenerated
	 */
	public Byte getChannelStatus() {
		return channelStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.CHANNEL_STATUS
	 * @param channelStatus  the value for fos_order_channel.CHANNEL_STATUS
	 * @mbggenerated
	 */
	public void setChannelStatus(Byte channelStatus) {
		this.channelStatus = channelStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.STATUS
	 * @return  the value of fos_order_channel.STATUS
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.STATUS
	 * @param status  the value for fos_order_channel.STATUS
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.BEGIN_TIME
	 * @return  the value of fos_order_channel.BEGIN_TIME
	 * @mbggenerated
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.BEGIN_TIME
	 * @param beginTime  the value for fos_order_channel.BEGIN_TIME
	 * @mbggenerated
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.END_TIME
	 * @return  the value of fos_order_channel.END_TIME
	 * @mbggenerated
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.END_TIME
	 * @param endTime  the value for fos_order_channel.END_TIME
	 * @mbggenerated
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.CREATE_TIME
	 * @return  the value of fos_order_channel.CREATE_TIME
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.CREATE_TIME
	 * @param createTime  the value for fos_order_channel.CREATE_TIME
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.MODIFY_TIME
	 * @return  the value of fos_order_channel.MODIFY_TIME
	 * @mbggenerated
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.MODIFY_TIME
	 * @param modifyTime  the value for fos_order_channel.MODIFY_TIME
	 * @mbggenerated
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.RELATION_ID
	 * @return  the value of fos_order_channel.RELATION_ID
	 * @mbggenerated
	 */
	public Integer getRelationId() {
		return relationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.RELATION_ID
	 * @param relationId  the value for fos_order_channel.RELATION_ID
	 * @mbggenerated
	 */
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.RELATION_CHANNELID
	 * @return  the value of fos_order_channel.RELATION_CHANNELID
	 * @mbggenerated
	 */
	public Integer getRelationChannelid() {
		return relationChannelid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.RELATION_CHANNELID
	 * @param relationChannelid  the value for fos_order_channel.RELATION_CHANNELID
	 * @mbggenerated
	 */
	public void setRelationChannelid(Integer relationChannelid) {
		this.relationChannelid = relationChannelid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.REMARK
	 * @return  the value of fos_order_channel.REMARK
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.REMARK
	 * @param remark  the value for fos_order_channel.REMARK
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.AUTOFLAG
	 * @return  the value of fos_order_channel.AUTOFLAG
	 * @mbggenerated
	 */
	public Byte getAutoflag() {
		return autoflag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.AUTOFLAG
	 * @param autoflag  the value for fos_order_channel.AUTOFLAG
	 * @mbggenerated
	 */
	public void setAutoflag(Byte autoflag) {
		this.autoflag = autoflag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order_channel.ADVANCE_PAY
	 * @return  the value of fos_order_channel.ADVANCE_PAY
	 * @mbggenerated
	 */
	public BigDecimal getAdvancePay() {
		return advancePay;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order_channel.ADVANCE_PAY
	 * @param advancePay  the value for fos_order_channel.ADVANCE_PAY
	 * @mbggenerated
	 */
	public void setAdvancePay(BigDecimal advancePay) {
		this.advancePay = advancePay;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_channel
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", channelOrderId=").append(channelOrderId);
		sb.append(", orderId=").append(orderId);
		sb.append(", payUnit=").append(payUnit);
		sb.append(", orderStatus=").append(orderStatus);
		sb.append(", channelId=").append(channelId);
		sb.append(", outerUnit=").append(outerUnit);
		sb.append(", channelStatus=").append(channelStatus);
		sb.append(", status=").append(status);
		sb.append(", beginTime=").append(beginTime);
		sb.append(", endTime=").append(endTime);
		sb.append(", createTime=").append(createTime);
		sb.append(", modifyTime=").append(modifyTime);
		sb.append(", relationId=").append(relationId);
		sb.append(", relationChannelid=").append(relationChannelid);
		sb.append(", remark=").append(remark);
		sb.append(", autoflag=").append(autoflag);
		sb.append(", advancePay=").append(advancePay);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}