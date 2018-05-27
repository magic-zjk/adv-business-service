package com.imopan.adv.platform.entity.fos;

import com.imopan.adv.platform.common.BaseBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FosDailyBill extends BaseBean implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.ID
	 * 
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.CHANNEL_ORDER_ID
	 * 
	 * @mbggenerated
	 */
	private Integer channelOrderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.ORDER_ID
	 * 
	 * @mbggenerated
	 */
	private Integer orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.ORDER_NAME
	 * 
	 * @mbggenerated
	 */
	private String orderName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.PRODUCT_NAME
	 * 
	 * @mbggenerated
	 */
	private String productName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.ORDER_DIRECTOR_NAME
	 * 
	 * @mbggenerated
	 */
	private String orderDirectorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.PAY_UNIT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal payUnit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.O_COUNT
	 * 
	 * @mbggenerated
	 */
	private Integer oCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.O_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal oAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.CHANNEL_ID
	 * 
	 * @mbggenerated
	 */
	private Integer channelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.CHANNEL_NAME
	 * 
	 * @mbggenerated
	 */
	private String channelName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.OUTER_UNIT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal outerUnit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.C_COUNT
	 * 
	 * @mbggenerated
	 */
	private Integer cCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.C_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal cAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.CHANNEL_DIRECTOR_NAME
	 * 
	 * @mbggenerated
	 */
	private String channelDirectorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.ENTRY_DAY_STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte entryDayStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.CREATE_TIME
	 * 
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.MODIFY_TIME
	 * 
	 * @mbggenerated
	 */
	private Date modifyTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.OC_DAY_STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte ocDayStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.ENTRY_TIME
	 * 
	 * @mbggenerated
	 */
	private Date entryTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.CHANNEL_MONTH_STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte channelMonthStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.AVG_MEDIA_REBATE
	 * 
	 * @mbggenerated
	 */
	private BigDecimal avgMediaRebate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.AVG_OTHER_EXPENSE
	 * 
	 * @mbggenerated
	 */
	private BigDecimal avgOtherExpense;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.AVG_CHANNEL_CUT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal avgChannelCut;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_oc_day.ORDER_MONTH_STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte orderMonthStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_oc_day.COOPERATE_NAME
	 * @mbggenerated
	 */
	private String cooperateName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_oc_day.CP_MAIN
	 * @mbggenerated
	 */
	private Byte cpMain;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table fos_oc_day
	 * 
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.ID
	 * 
	 * @return the value of fos_oc_day.ID
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.ID
	 * 
	 * @param id
	 *            the value for fos_oc_day.ID
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.CHANNEL_ORDER_ID
	 * 
	 * @return the value of fos_oc_day.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public Integer getChannelOrderId() {
		return channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.CHANNEL_ORDER_ID
	 * 
	 * @param channelOrderId
	 *            the value for fos_oc_day.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public void setChannelOrderId(Integer channelOrderId) {
		this.channelOrderId = channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.ORDER_ID
	 * 
	 * @return the value of fos_oc_day.ORDER_ID
	 * @mbggenerated
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.ORDER_ID
	 * 
	 * @param orderId
	 *            the value for fos_oc_day.ORDER_ID
	 * @mbggenerated
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.ORDER_NAME
	 * 
	 * @return the value of fos_oc_day.ORDER_NAME
	 * @mbggenerated
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.ORDER_NAME
	 * 
	 * @param orderName
	 *            the value for fos_oc_day.ORDER_NAME
	 * @mbggenerated
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName == null ? null : orderName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.PRODUCT_NAME
	 * 
	 * @return the value of fos_oc_day.PRODUCT_NAME
	 * @mbggenerated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.PRODUCT_NAME
	 * 
	 * @param productName
	 *            the value for fos_oc_day.PRODUCT_NAME
	 * @mbggenerated
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.ORDER_DIRECTOR_NAME
	 * 
	 * @return the value of fos_oc_day.ORDER_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public String getOrderDirectorName() {
		return orderDirectorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.ORDER_DIRECTOR_NAME
	 * 
	 * @param orderDirectorName
	 *            the value for fos_oc_day.ORDER_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public void setOrderDirectorName(String orderDirectorName) {
		this.orderDirectorName = orderDirectorName == null ? null : orderDirectorName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.PAY_UNIT
	 * 
	 * @return the value of fos_oc_day.PAY_UNIT
	 * @mbggenerated
	 */
	public BigDecimal getPayUnit() {
		return payUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.PAY_UNIT
	 * 
	 * @param payUnit
	 *            the value for fos_oc_day.PAY_UNIT
	 * @mbggenerated
	 */
	public void setPayUnit(BigDecimal payUnit) {
		this.payUnit = payUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.O_COUNT
	 * 
	 * @return the value of fos_oc_day.O_COUNT
	 * @mbggenerated
	 */
	public Integer getoCount() {
		return oCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.O_COUNT
	 * 
	 * @param oCount
	 *            the value for fos_oc_day.O_COUNT
	 * @mbggenerated
	 */
	public void setoCount(Integer oCount) {
		this.oCount = oCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.O_AMOUNT
	 * 
	 * @return the value of fos_oc_day.O_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getoAmount() {
		return oAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.O_AMOUNT
	 * 
	 * @param oAmount
	 *            the value for fos_oc_day.O_AMOUNT
	 * @mbggenerated
	 */
	public void setoAmount(BigDecimal oAmount) {
		this.oAmount = oAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.CHANNEL_ID
	 * 
	 * @return the value of fos_oc_day.CHANNEL_ID
	 * @mbggenerated
	 */
	public Integer getChannelId() {
		return channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.CHANNEL_ID
	 * 
	 * @param channelId
	 *            the value for fos_oc_day.CHANNEL_ID
	 * @mbggenerated
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.CHANNEL_NAME
	 * 
	 * @return the value of fos_oc_day.CHANNEL_NAME
	 * @mbggenerated
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.CHANNEL_NAME
	 * 
	 * @param channelName
	 *            the value for fos_oc_day.CHANNEL_NAME
	 * @mbggenerated
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName == null ? null : channelName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.OUTER_UNIT
	 * 
	 * @return the value of fos_oc_day.OUTER_UNIT
	 * @mbggenerated
	 */
	public BigDecimal getOuterUnit() {
		return outerUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.OUTER_UNIT
	 * 
	 * @param outerUnit
	 *            the value for fos_oc_day.OUTER_UNIT
	 * @mbggenerated
	 */
	public void setOuterUnit(BigDecimal outerUnit) {
		this.outerUnit = outerUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.C_COUNT
	 * 
	 * @return the value of fos_oc_day.C_COUNT
	 * @mbggenerated
	 */
	public Integer getcCount() {
		return cCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.C_COUNT
	 * 
	 * @param cCount
	 *            the value for fos_oc_day.C_COUNT
	 * @mbggenerated
	 */
	public void setcCount(Integer cCount) {
		this.cCount = cCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.C_AMOUNT
	 * 
	 * @return the value of fos_oc_day.C_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getcAmount() {
		return cAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.C_AMOUNT
	 * 
	 * @param cAmount
	 *            the value for fos_oc_day.C_AMOUNT
	 * @mbggenerated
	 */
	public void setcAmount(BigDecimal cAmount) {
		this.cAmount = cAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.CHANNEL_DIRECTOR_NAME
	 * 
	 * @return the value of fos_oc_day.CHANNEL_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public String getChannelDirectorName() {
		return channelDirectorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.CHANNEL_DIRECTOR_NAME
	 * 
	 * @param channelDirectorName
	 *            the value for fos_oc_day.CHANNEL_DIRECTOR_NAME
	 * @mbggenerated
	 */
	public void setChannelDirectorName(String channelDirectorName) {
		this.channelDirectorName = channelDirectorName == null ? null : channelDirectorName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.ENTRY_DAY_STATUS
	 * 
	 * @return the value of fos_oc_day.ENTRY_DAY_STATUS
	 * @mbggenerated
	 */
	public Byte getEntryDayStatus() {
		return entryDayStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.ENTRY_DAY_STATUS
	 * 
	 * @param entryDayStatus
	 *            the value for fos_oc_day.ENTRY_DAY_STATUS
	 * @mbggenerated
	 */
	public void setEntryDayStatus(Byte entryDayStatus) {
		this.entryDayStatus = entryDayStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.CREATE_TIME
	 * 
	 * @return the value of fos_oc_day.CREATE_TIME
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.CREATE_TIME
	 * 
	 * @param createTime
	 *            the value for fos_oc_day.CREATE_TIME
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.MODIFY_TIME
	 * 
	 * @return the value of fos_oc_day.MODIFY_TIME
	 * @mbggenerated
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.MODIFY_TIME
	 * 
	 * @param modifyTime
	 *            the value for fos_oc_day.MODIFY_TIME
	 * @mbggenerated
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.OC_DAY_STATUS
	 * 
	 * @return the value of fos_oc_day.OC_DAY_STATUS
	 * @mbggenerated
	 */
	public Byte getOcDayStatus() {
		return ocDayStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.OC_DAY_STATUS
	 * 
	 * @param ocDayStatus
	 *            the value for fos_oc_day.OC_DAY_STATUS
	 * @mbggenerated
	 */
	public void setOcDayStatus(Byte ocDayStatus) {
		this.ocDayStatus = ocDayStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.ENTRY_TIME
	 * 
	 * @return the value of fos_oc_day.ENTRY_TIME
	 * @mbggenerated
	 */
	public Date getEntryTime() {
		return entryTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.ENTRY_TIME
	 * 
	 * @param entryTime
	 *            the value for fos_oc_day.ENTRY_TIME
	 * @mbggenerated
	 */
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.CHANNEL_MONTH_STATUS
	 * 
	 * @return the value of fos_oc_day.CHANNEL_MONTH_STATUS
	 * @mbggenerated
	 */
	public Byte getChannelMonthStatus() {
		return channelMonthStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.CHANNEL_MONTH_STATUS
	 * 
	 * @param channelMonthStatus
	 *            the value for fos_oc_day.CHANNEL_MONTH_STATUS
	 * @mbggenerated
	 */
	public void setChannelMonthStatus(Byte channelMonthStatus) {
		this.channelMonthStatus = channelMonthStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.AVG_MEDIA_REBATE
	 * 
	 * @return the value of fos_oc_day.AVG_MEDIA_REBATE
	 * @mbggenerated
	 */
	public BigDecimal getAvgMediaRebate() {
		return avgMediaRebate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.AVG_MEDIA_REBATE
	 * 
	 * @param avgMediaRebate
	 *            the value for fos_oc_day.AVG_MEDIA_REBATE
	 * @mbggenerated
	 */
	public void setAvgMediaRebate(BigDecimal avgMediaRebate) {
		this.avgMediaRebate = avgMediaRebate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.AVG_OTHER_EXPENSE
	 * 
	 * @return the value of fos_oc_day.AVG_OTHER_EXPENSE
	 * @mbggenerated
	 */
	public BigDecimal getAvgOtherExpense() {
		return avgOtherExpense;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.AVG_OTHER_EXPENSE
	 * 
	 * @param avgOtherExpense
	 *            the value for fos_oc_day.AVG_OTHER_EXPENSE
	 * @mbggenerated
	 */
	public void setAvgOtherExpense(BigDecimal avgOtherExpense) {
		this.avgOtherExpense = avgOtherExpense;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.AVG_CHANNEL_CUT
	 * 
	 * @return the value of fos_oc_day.AVG_CHANNEL_CUT
	 * @mbggenerated
	 */
	public BigDecimal getAvgChannelCut() {
		return avgChannelCut;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.AVG_CHANNEL_CUT
	 * 
	 * @param avgChannelCut
	 *            the value for fos_oc_day.AVG_CHANNEL_CUT
	 * @mbggenerated
	 */
	public void setAvgChannelCut(BigDecimal avgChannelCut) {
		this.avgChannelCut = avgChannelCut;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_oc_day.ORDER_MONTH_STATUS
	 * 
	 * @return the value of fos_oc_day.ORDER_MONTH_STATUS
	 * @mbggenerated
	 */
	public Byte getOrderMonthStatus() {
		return orderMonthStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_oc_day.ORDER_MONTH_STATUS
	 * 
	 * @param orderMonthStatus
	 *            the value for fos_oc_day.ORDER_MONTH_STATUS
	 * @mbggenerated
	 */
	public void setOrderMonthStatus(Byte orderMonthStatus) {
		this.orderMonthStatus = orderMonthStatus;
	}

	private BigDecimal profit;
	private BigDecimal profitMargin;
	private byte orderDepartment;
	
	

	public byte getOrderDepartment() {
		return orderDepartment;
	}

	public void setOrderDepartment(byte orderDepartment) {
		this.orderDepartment = orderDepartment;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public BigDecimal getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(BigDecimal profitMargin) {
		this.profitMargin = profitMargin;
	}

	public String getCooperateName() {
		return cooperateName;
	}

	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName;
	}

	public Byte getCpMain() {
		return cpMain;
	}

	public void setCpMain(Byte cpMain) {
		this.cpMain = cpMain;
	}

	@Override
	public String toString() {
		return "FosDailyBill [id=" + id + ", channelOrderId=" + channelOrderId + ", orderId=" + orderId + ", orderName="
				+ orderName + ", productName=" + productName + ", orderDirectorName=" + orderDirectorName + ", payUnit="
				+ payUnit + ", oCount=" + oCount + ", oAmount=" + oAmount + ", channelId=" + channelId
				+ ", channelName=" + channelName + ", outerUnit=" + outerUnit + ", cCount=" + cCount + ", cAmount="
				+ cAmount + ", channelDirectorName=" + channelDirectorName + ", entryDayStatus=" + entryDayStatus
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", ocDayStatus=" + ocDayStatus
				+ ", entryTime=" + entryTime + ", channelMonthStatus=" + channelMonthStatus + ", avgMediaRebate="
				+ avgMediaRebate + ", avgOtherExpense=" + avgOtherExpense + ", avgChannelCut=" + avgChannelCut
				+ ", orderMonthStatus=" + orderMonthStatus + ", cooperateName=" + cooperateName + ", cpMain=" + cpMain
				+ ", profit=" + profit + ", profitMargin=" + profitMargin + "]";
	}

	

}