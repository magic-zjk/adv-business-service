package com.imopan.adv.platform.vo.fos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.imopan.adv.platform.common.VoBaseBean;
import com.imopan.adv.platform.exception.ImopanException;

public class FosChannelMonthVo extends VoBaseBean implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ID
	 * 
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.CHANNEL_ORDER_ID
	 * 
	 * @mbggenerated
	 */
	private Integer channelOrderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ORDER_ID
	 * 
	 * @mbggenerated
	 */
	private Integer orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ORDER_NAME
	 * 
	 * @mbggenerated
	 */
	private String orderName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.PRODUCT_NAME
	 * 
	 * @mbggenerated
	 */
	private String productName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ORDER_DIRECTOR_NAME
	 * 
	 * @mbggenerated
	 */
	private String orderDirectorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.CP_MAIN
	 * 
	 * @mbggenerated
	 */
	private Byte cpMain;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.RELATION_ID
	 * 
	 * @mbggenerated
	 */
	private Integer relationId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.CHANNEL_ID
	 * 
	 * @mbggenerated
	 */
	private Integer channelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.CHANNEL_NAME
	 * 
	 * @mbggenerated
	 */
	private String channelName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.CHANNEL_DIRECTOR_NAME
	 * 
	 * @mbggenerated
	 */
	private String channelDirectorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.C_UNIT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal cUnit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.C_COUNT
	 * 
	 * @mbggenerated
	 */
	private Integer cCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.C_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal cAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.SUB_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal subAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.C_COUNT_SUM
	 * 
	 * @mbggenerated
	 */
	private Integer cCountSum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.C_AMOUNT_SUM
	 * 
	 * @mbggenerated
	 */
	private BigDecimal cAmountSum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.MEDIA_REBATE
	 * 
	 * @mbggenerated
	 */
	private BigDecimal mediaRebate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.OTHER_EXPENSE
	 * 
	 * @mbggenerated
	 */
	private BigDecimal otherExpense;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.CHANNEL_CUT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal channelCut;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ENTRY_MONTH_STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte entryMonthStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ENTRY_MONEY
	 * 
	 * @mbggenerated
	 */
	private Byte entryMoney;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ENTRY_TICKET
	 * 
	 * @mbggenerated
	 */
	private Byte entryTicket;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ENTRY_BEGINTIME
	 * 
	 * @mbggenerated
	 */
	private Date entryBegintime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.ENTRY_ENDTIME
	 * 
	 * @mbggenerated
	 */
	private Date entryEndtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.CREATE_TIME
	 * 
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_channel_month.MODIFY_TIME
	 * 
	 * @mbggenerated
	 */
	private Date modifyTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table fos_channel_month
	 * 
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ID
	 * 
	 * @return the value of fos_channel_month.ID
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ID
	 * 
	 * @param id
	 *            the value for fos_channel_month.ID
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.CHANNEL_ORDER_ID
	 * 
	 * @return the value of fos_channel_month.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public Integer getChannelOrderId() {
		return channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.CHANNEL_ORDER_ID
	 * 
	 * @param channelOrderId
	 *            the value for fos_channel_month.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public void setChannelOrderId(Integer channelOrderId) {
		this.channelOrderId = channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ORDER_ID
	 * 
	 * @return the value of fos_channel_month.ORDER_ID
	 * @mbggenerated
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ORDER_ID
	 * 
	 * @param orderId
	 *            the value for fos_channel_month.ORDER_ID
	 * @mbggenerated
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ORDER_NAME
	 * 
	 * @return the value of fos_channel_month.ORDER_NAME
	 * @mbggenerated
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ORDER_NAME
	 * 
	 * @param orderName
	 *            the value for fos_channel_month.ORDER_NAME
	 * @mbggenerated
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName == null ? null : orderName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.PRODUCT_NAME
	 * 
	 * @return the value of fos_channel_month.PRODUCT_NAME
	 * @mbggenerated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.PRODUCT_NAME
	 * 
	 * @param productName
	 *            the value for fos_channel_month.PRODUCT_NAME
	 * @mbggenerated
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ORDER_DIRECTOR_NAME
	 * 
	 * @return the value of fos_channel_month.ORDER_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public String getOrderDirectorName() {
		return orderDirectorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ORDER_DIRECTOR_NAME
	 * 
	 * @param orderDirectorName
	 *            the value for fos_channel_month.ORDER_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public void setOrderDirectorName(String orderDirectorName) {
		this.orderDirectorName = orderDirectorName == null ? null
				: orderDirectorName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.CP_MAIN
	 * 
	 * @return the value of fos_channel_month.CP_MAIN
	 * @mbggenerated
	 */
	public Byte getCpMain() {
		return cpMain;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.CP_MAIN
	 * 
	 * @param cpMain
	 *            the value for fos_channel_month.CP_MAIN
	 * @mbggenerated
	 */
	public void setCpMain(Byte cpMain) {
		this.cpMain = cpMain;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.RELATION_ID
	 * 
	 * @return the value of fos_channel_month.RELATION_ID
	 * @mbggenerated
	 */
	public Integer getRelationId() {
		return relationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.RELATION_ID
	 * 
	 * @param relationId
	 *            the value for fos_channel_month.RELATION_ID
	 * @mbggenerated
	 */
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.CHANNEL_ID
	 * 
	 * @return the value of fos_channel_month.CHANNEL_ID
	 * @mbggenerated
	 */
	public Integer getChannelId() {
		return channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.CHANNEL_ID
	 * 
	 * @param channelId
	 *            the value for fos_channel_month.CHANNEL_ID
	 * @mbggenerated
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.CHANNEL_NAME
	 * 
	 * @return the value of fos_channel_month.CHANNEL_NAME
	 * @mbggenerated
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.CHANNEL_NAME
	 * 
	 * @param channelName
	 *            the value for fos_channel_month.CHANNEL_NAME
	 * @mbggenerated
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName == null ? null : channelName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.CHANNEL_DIRECTOR_NAME
	 * 
	 * @return the value of fos_channel_month.CHANNEL_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public String getChannelDirectorName() {
		return channelDirectorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.CHANNEL_DIRECTOR_NAME
	 * 
	 * @param channelDirectorName
	 *            the value for fos_channel_month.CHANNEL_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public void setChannelDirectorName(String channelDirectorName) {
		this.channelDirectorName = channelDirectorName == null ? null
				: channelDirectorName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.C_UNIT
	 * 
	 * @return the value of fos_channel_month.C_UNIT
	 * @mbggenerated
	 */
	public BigDecimal getcUnit() {
		return cUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.C_UNIT
	 * 
	 * @param cUnit
	 *            the value for fos_channel_month.C_UNIT
	 * @mbggenerated
	 */
	public void setcUnit(BigDecimal cUnit) {
		this.cUnit = cUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.C_COUNT
	 * 
	 * @return the value of fos_channel_month.C_COUNT
	 * @mbggenerated
	 */
	public Integer getcCount() {
		return cCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.C_COUNT
	 * 
	 * @param cCount
	 *            the value for fos_channel_month.C_COUNT
	 * @mbggenerated
	 */
	public void setcCount(Integer cCount) {
		this.cCount = cCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.C_AMOUNT
	 * 
	 * @return the value of fos_channel_month.C_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getcAmount() {
		return cAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.C_AMOUNT
	 * 
	 * @param cAmount
	 *            the value for fos_channel_month.C_AMOUNT
	 * @mbggenerated
	 */
	public void setcAmount(BigDecimal cAmount) {
		this.cAmount = cAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.SUB_AMOUNT
	 * 
	 * @return the value of fos_channel_month.SUB_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getSubAmount() {
		return subAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.SUB_AMOUNT
	 * 
	 * @param subAmount
	 *            the value for fos_channel_month.SUB_AMOUNT
	 * @mbggenerated
	 */
	public void setSubAmount(BigDecimal subAmount) {
		this.subAmount = subAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.C_COUNT_SUM
	 * 
	 * @return the value of fos_channel_month.C_COUNT_SUM
	 * @mbggenerated
	 */
	public Integer getcCountSum() {
		return cCountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.C_COUNT_SUM
	 * 
	 * @param cCountSum
	 *            the value for fos_channel_month.C_COUNT_SUM
	 * @mbggenerated
	 */
	public void setcCountSum(Integer cCountSum) {
		this.cCountSum = cCountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.C_AMOUNT_SUM
	 * 
	 * @return the value of fos_channel_month.C_AMOUNT_SUM
	 * @mbggenerated
	 */
	public BigDecimal getcAmountSum() {
		return cAmountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.C_AMOUNT_SUM
	 * 
	 * @param cAmountSum
	 *            the value for fos_channel_month.C_AMOUNT_SUM
	 * @mbggenerated
	 */
	public void setcAmountSum(BigDecimal cAmountSum) {
		this.cAmountSum = cAmountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.MEDIA_REBATE
	 * 
	 * @return the value of fos_channel_month.MEDIA_REBATE
	 * @mbggenerated
	 */
	public BigDecimal getMediaRebate() {
		return mediaRebate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.MEDIA_REBATE
	 * 
	 * @param mediaRebate
	 *            the value for fos_channel_month.MEDIA_REBATE
	 * @mbggenerated
	 */
	public void setMediaRebate(BigDecimal mediaRebate) {
		this.mediaRebate = mediaRebate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.OTHER_EXPENSE
	 * 
	 * @return the value of fos_channel_month.OTHER_EXPENSE
	 * @mbggenerated
	 */
	public BigDecimal getOtherExpense() {
		return otherExpense;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.OTHER_EXPENSE
	 * 
	 * @param otherExpense
	 *            the value for fos_channel_month.OTHER_EXPENSE
	 * @mbggenerated
	 */
	public void setOtherExpense(BigDecimal otherExpense) {
		this.otherExpense = otherExpense;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.CHANNEL_CUT
	 * 
	 * @return the value of fos_channel_month.CHANNEL_CUT
	 * @mbggenerated
	 */
	public BigDecimal getChannelCut() {
		return channelCut;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.CHANNEL_CUT
	 * 
	 * @param channelCut
	 *            the value for fos_channel_month.CHANNEL_CUT
	 * @mbggenerated
	 */
	public void setChannelCut(BigDecimal channelCut) {
		this.channelCut = channelCut;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ENTRY_MONTH_STATUS
	 * 
	 * @return the value of fos_channel_month.ENTRY_MONTH_STATUS
	 * @mbggenerated
	 */
	public Byte getEntryMonthStatus() {
		return entryMonthStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ENTRY_MONTH_STATUS
	 * 
	 * @param entryMonthStatus
	 *            the value for fos_channel_month.ENTRY_MONTH_STATUS
	 * @mbggenerated
	 */
	public void setEntryMonthStatus(Byte entryMonthStatus) {
		this.entryMonthStatus = entryMonthStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ENTRY_MONEY
	 * 
	 * @return the value of fos_channel_month.ENTRY_MONEY
	 * @mbggenerated
	 */
	public Byte getEntryMoney() {
		return entryMoney;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ENTRY_MONEY
	 * 
	 * @param entryMoney
	 *            the value for fos_channel_month.ENTRY_MONEY
	 * @mbggenerated
	 */
	public void setEntryMoney(Byte entryMoney) {
		this.entryMoney = entryMoney;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ENTRY_TICKET
	 * 
	 * @return the value of fos_channel_month.ENTRY_TICKET
	 * @mbggenerated
	 */
	public Byte getEntryTicket() {
		return entryTicket;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ENTRY_TICKET
	 * 
	 * @param entryTicket
	 *            the value for fos_channel_month.ENTRY_TICKET
	 * @mbggenerated
	 */
	public void setEntryTicket(Byte entryTicket) {
		this.entryTicket = entryTicket;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ENTRY_BEGINTIME
	 * 
	 * @return the value of fos_channel_month.ENTRY_BEGINTIME
	 * @mbggenerated
	 */
	public Date getEntryBegintime() {
		return entryBegintime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ENTRY_BEGINTIME
	 * 
	 * @param entryBegintime
	 *            the value for fos_channel_month.ENTRY_BEGINTIME
	 * @mbggenerated
	 */
	public void setEntryBegintime(Date entryBegintime) {
		this.entryBegintime = entryBegintime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.ENTRY_ENDTIME
	 * 
	 * @return the value of fos_channel_month.ENTRY_ENDTIME
	 * @mbggenerated
	 */
	public Date getEntryEndtime() {
		return entryEndtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.ENTRY_ENDTIME
	 * 
	 * @param entryEndtime
	 *            the value for fos_channel_month.ENTRY_ENDTIME
	 * @mbggenerated
	 */
	public void setEntryEndtime(Date entryEndtime) {
		this.entryEndtime = entryEndtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.STATUS
	 * 
	 * @return the value of fos_channel_month.STATUS
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.STATUS
	 * 
	 * @param status
	 *            the value for fos_channel_month.STATUS
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.CREATE_TIME
	 * 
	 * @return the value of fos_channel_month.CREATE_TIME
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.CREATE_TIME
	 * 
	 * @param createTime
	 *            the value for fos_channel_month.CREATE_TIME
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_channel_month.MODIFY_TIME
	 * 
	 * @return the value of fos_channel_month.MODIFY_TIME
	 * @mbggenerated
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_channel_month.MODIFY_TIME
	 * 
	 * @param modifyTime
	 *            the value for fos_channel_month.MODIFY_TIME
	 * @mbggenerated
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table fos_channel_month
	 * 
	 * @mbggenerated
	 */
	

	@Override
	public boolean verify(String str) throws ImopanException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "FosChannelMonthVo [id=" + id + ", channelOrderId="
				+ channelOrderId + ", orderId=" + orderId + ", orderName="
				+ orderName + ", productName=" + productName
				+ ", orderDirectorName=" + orderDirectorName + ", cpMain="
				+ cpMain + ", relationId=" + relationId + ", channelId="
				+ channelId + ", channelName=" + channelName
				+ ", channelDirectorName=" + channelDirectorName + ", cUnit="
				+ cUnit + ", cCount=" + cCount + ", cAmount=" + cAmount
				+ ", subAmount=" + subAmount + ", cCountSum=" + cCountSum
				+ ", cAmountSum=" + cAmountSum + ", mediaRebate=" + mediaRebate
				+ ", otherExpense=" + otherExpense + ", channelCut="
				+ channelCut + ", entryMonthStatus=" + entryMonthStatus
				+ ", entryMoney=" + entryMoney + ", entryTicket=" + entryTicket
				+ ", entryBegintime=" + entryBegintime + ", entryEndtime="
				+ entryEndtime + ", status=" + status + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", advancePay="
				+ advancePay + ", fullName=" + fullName + "]";
	}

	private BigDecimal advancePay;
	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigDecimal getAdvancePay() {
		return advancePay;
	}

	public void setAdvancePay(BigDecimal advancePay) {
		this.advancePay = advancePay;
	}

}