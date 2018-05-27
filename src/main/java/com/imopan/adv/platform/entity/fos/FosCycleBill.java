package com.imopan.adv.platform.entity.fos;

import com.imopan.adv.platform.common.BaseBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FosCycleBill extends BaseBean implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ID
	 * 
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ORDER_ID
	 * 
	 * @mbggenerated
	 */
	private Integer orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ORDER_NAME
	 * 
	 * @mbggenerated
	 */
	private String orderName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.PRODUCT_NAME
	 * 
	 * @mbggenerated
	 */
	private String productName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.DIRECTOR_NAME
	 * 
	 * @mbggenerated
	 */
	private String directorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.CP_MAIN
	 * 
	 * @mbggenerated
	 */
	private Byte cpMain;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ORDER_TYPE
	 * 
	 * @mbggenerated
	 */
	private Byte orderType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.COOPERATE_NAME
	 * 
	 * @mbggenerated
	 */
	private String cooperateName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.O_UNIT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal oUnit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.O_COUNT
	 * 
	 * @mbggenerated
	 */
	private Integer oCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.O_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal oAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.SUB_O_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal subOAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.C_COUNT
	 * 
	 * @mbggenerated
	 */
	private Integer cCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.C_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal cAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.SUB_C_AMOUNT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal subCAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.PROFIT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal profit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.PROFIT_MARGIN
	 * 
	 * @mbggenerated
	 */
	private BigDecimal profitMargin;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.CONVER_MARGIN
	 * 
	 * @mbggenerated
	 */
	private BigDecimal converMargin;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.O_COUNT_SUM
	 * 
	 * @mbggenerated
	 */
	private Integer oCountSum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.O_AMOUNT_SUM
	 * 
	 * @mbggenerated
	 */
	private BigDecimal oAmountSum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.CUT
	 * 
	 * @mbggenerated
	 */
	private BigDecimal cut;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.SALE_REBATE
	 * 
	 * @mbggenerated
	 */
	private BigDecimal saleRebate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ENTRY_MONTH_STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte entryMonthStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ENTRY_MONEY
	 * 
	 * @mbggenerated
	 */
	private Byte entryMoney;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ENTRY_TICKET
	 * 
	 * @mbggenerated
	 */
	private Byte entryTicket;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ENTRY_BEGINTIME
	 * 
	 * @mbggenerated
	 */
	private Date entryBegintime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.ENTRY_ENDTIME
	 * 
	 * @mbggenerated
	 */
	private Date entryEndtime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.STATUS
	 * 
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.CREATE_TIME
	 * 
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column fos_order_month.MODIFY_TIME
	 * 
	 * @mbggenerated
	 */
	private Date modifyTime;
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
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_oc_day.CHANNEL_ID
	 * @mbggenerated
	 */
	private Integer channelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_oc_day.CHANNEL_NAME
	 * @mbggenerated
	 */
	private String channelName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_channel_month.CHANNEL_DIRECTOR_NAME
	 * @mbggenerated
	 */
	private String channelDirectorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table fos_order_month
	 * 
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ID
	 * 
	 * @return the value of fos_order_month.ID
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ID
	 * 
	 * @param id
	 *            the value for fos_order_month.ID
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ORDER_ID
	 * 
	 * @return the value of fos_order_month.ORDER_ID
	 * @mbggenerated
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ORDER_ID
	 * 
	 * @param orderId
	 *            the value for fos_order_month.ORDER_ID
	 * @mbggenerated
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ORDER_NAME
	 * 
	 * @return the value of fos_order_month.ORDER_NAME
	 * @mbggenerated
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ORDER_NAME
	 * 
	 * @param orderName
	 *            the value for fos_order_month.ORDER_NAME
	 * @mbggenerated
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName == null ? null : orderName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.PRODUCT_NAME
	 * 
	 * @return the value of fos_order_month.PRODUCT_NAME
	 * @mbggenerated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.PRODUCT_NAME
	 * 
	 * @param productName
	 *            the value for fos_order_month.PRODUCT_NAME
	 * @mbggenerated
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.DIRECTOR_NAME
	 * 
	 * @return the value of fos_order_month.DIRECTOR_NAME
	 * @mbggenerated
	 */
	public String getDirectorName() {
		return directorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.DIRECTOR_NAME
	 * 
	 * @param directorName
	 *            the value for fos_order_month.DIRECTOR_NAME
	 * @mbggenerated
	 */
	public void setDirectorName(String directorName) {
		this.directorName = directorName == null ? null : directorName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.CP_MAIN
	 * 
	 * @return the value of fos_order_month.CP_MAIN
	 * @mbggenerated
	 */
	public Byte getCpMain() {
		return cpMain;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.CP_MAIN
	 * 
	 * @param cpMain
	 *            the value for fos_order_month.CP_MAIN
	 * @mbggenerated
	 */
	public void setCpMain(Byte cpMain) {
		this.cpMain = cpMain;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ORDER_TYPE
	 * 
	 * @return the value of fos_order_month.ORDER_TYPE
	 * @mbggenerated
	 */
	public Byte getOrderType() {
		return orderType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ORDER_TYPE
	 * 
	 * @param orderType
	 *            the value for fos_order_month.ORDER_TYPE
	 * @mbggenerated
	 */
	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.COOPERATE_NAME
	 * 
	 * @return the value of fos_order_month.COOPERATE_NAME
	 * @mbggenerated
	 */
	public String getCooperateName() {
		return cooperateName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.COOPERATE_NAME
	 * 
	 * @param cooperateName
	 *            the value for fos_order_month.COOPERATE_NAME
	 * @mbggenerated
	 */
	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName == null ? null : cooperateName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.O_UNIT
	 * 
	 * @return the value of fos_order_month.O_UNIT
	 * @mbggenerated
	 */
	public BigDecimal getoUnit() {
		return oUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.O_UNIT
	 * 
	 * @param oUnit
	 *            the value for fos_order_month.O_UNIT
	 * @mbggenerated
	 */
	public void setoUnit(BigDecimal oUnit) {
		this.oUnit = oUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.O_COUNT
	 * 
	 * @return the value of fos_order_month.O_COUNT
	 * @mbggenerated
	 */
	public Integer getoCount() {
		return oCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.O_COUNT
	 * 
	 * @param oCount
	 *            the value for fos_order_month.O_COUNT
	 * @mbggenerated
	 */
	public void setoCount(Integer oCount) {
		this.oCount = oCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.O_AMOUNT
	 * 
	 * @return the value of fos_order_month.O_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getoAmount() {
		return oAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.O_AMOUNT
	 * 
	 * @param oAmount
	 *            the value for fos_order_month.O_AMOUNT
	 * @mbggenerated
	 */
	public void setoAmount(BigDecimal oAmount) {
		this.oAmount = oAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.SUB_O_AMOUNT
	 * 
	 * @return the value of fos_order_month.SUB_O_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getSubOAmount() {
		return subOAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.SUB_O_AMOUNT
	 * 
	 * @param subOAmount
	 *            the value for fos_order_month.SUB_O_AMOUNT
	 * @mbggenerated
	 */
	public void setSubOAmount(BigDecimal subOAmount) {
		this.subOAmount = subOAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.C_COUNT
	 * 
	 * @return the value of fos_order_month.C_COUNT
	 * @mbggenerated
	 */
	public Integer getcCount() {
		return cCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.C_COUNT
	 * 
	 * @param cCount
	 *            the value for fos_order_month.C_COUNT
	 * @mbggenerated
	 */
	public void setcCount(Integer cCount) {
		this.cCount = cCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.C_AMOUNT
	 * 
	 * @return the value of fos_order_month.C_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getcAmount() {
		return cAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.C_AMOUNT
	 * 
	 * @param cAmount
	 *            the value for fos_order_month.C_AMOUNT
	 * @mbggenerated
	 */
	public void setcAmount(BigDecimal cAmount) {
		this.cAmount = cAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.SUB_C_AMOUNT
	 * 
	 * @return the value of fos_order_month.SUB_C_AMOUNT
	 * @mbggenerated
	 */
	public BigDecimal getSubCAmount() {
		return subCAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.SUB_C_AMOUNT
	 * 
	 * @param subCAmount
	 *            the value for fos_order_month.SUB_C_AMOUNT
	 * @mbggenerated
	 */
	public void setSubCAmount(BigDecimal subCAmount) {
		this.subCAmount = subCAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.PROFIT
	 * 
	 * @return the value of fos_order_month.PROFIT
	 * @mbggenerated
	 */
	public BigDecimal getProfit() {
		return profit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.PROFIT
	 * 
	 * @param profit
	 *            the value for fos_order_month.PROFIT
	 * @mbggenerated
	 */
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.PROFIT_MARGIN
	 * 
	 * @return the value of fos_order_month.PROFIT_MARGIN
	 * @mbggenerated
	 */
	public BigDecimal getProfitMargin() {
		return profitMargin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.PROFIT_MARGIN
	 * 
	 * @param profitMargin
	 *            the value for fos_order_month.PROFIT_MARGIN
	 * @mbggenerated
	 */
	public void setProfitMargin(BigDecimal profitMargin) {
		this.profitMargin = profitMargin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.CONVER_MARGIN
	 * 
	 * @return the value of fos_order_month.CONVER_MARGIN
	 * @mbggenerated
	 */
	public BigDecimal getConverMargin() {
		return converMargin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.CONVER_MARGIN
	 * 
	 * @param converMargin
	 *            the value for fos_order_month.CONVER_MARGIN
	 * @mbggenerated
	 */
	public void setConverMargin(BigDecimal converMargin) {
		this.converMargin = converMargin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.O_COUNT_SUM
	 * 
	 * @return the value of fos_order_month.O_COUNT_SUM
	 * @mbggenerated
	 */
	public Integer getoCountSum() {
		return oCountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.O_COUNT_SUM
	 * 
	 * @param oCountSum
	 *            the value for fos_order_month.O_COUNT_SUM
	 * @mbggenerated
	 */
	public void setoCountSum(Integer oCountSum) {
		this.oCountSum = oCountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.O_AMOUNT_SUM
	 * 
	 * @return the value of fos_order_month.O_AMOUNT_SUM
	 * @mbggenerated
	 */
	public BigDecimal getoAmountSum() {
		return oAmountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.O_AMOUNT_SUM
	 * 
	 * @param oAmountSum
	 *            the value for fos_order_month.O_AMOUNT_SUM
	 * @mbggenerated
	 */
	public void setoAmountSum(BigDecimal oAmountSum) {
		this.oAmountSum = oAmountSum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.CUT
	 * 
	 * @return the value of fos_order_month.CUT
	 * @mbggenerated
	 */
	public BigDecimal getCut() {
		return cut;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.CUT
	 * 
	 * @param cut
	 *            the value for fos_order_month.CUT
	 * @mbggenerated
	 */
	public void setCut(BigDecimal cut) {
		this.cut = cut;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.SALE_REBATE
	 * 
	 * @return the value of fos_order_month.SALE_REBATE
	 * @mbggenerated
	 */
	public BigDecimal getSaleRebate() {
		return saleRebate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.SALE_REBATE
	 * 
	 * @param saleRebate
	 *            the value for fos_order_month.SALE_REBATE
	 * @mbggenerated
	 */
	public void setSaleRebate(BigDecimal saleRebate) {
		this.saleRebate = saleRebate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ENTRY_MONTH_STATUS
	 * 
	 * @return the value of fos_order_month.ENTRY_MONTH_STATUS
	 * @mbggenerated
	 */
	public Byte getEntryMonthStatus() {
		return entryMonthStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ENTRY_MONTH_STATUS
	 * 
	 * @param entryMonthStatus
	 *            the value for fos_order_month.ENTRY_MONTH_STATUS
	 * @mbggenerated
	 */
	public void setEntryMonthStatus(Byte entryMonthStatus) {
		this.entryMonthStatus = entryMonthStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ENTRY_MONEY
	 * 
	 * @return the value of fos_order_month.ENTRY_MONEY
	 * @mbggenerated
	 */
	public Byte getEntryMoney() {
		return entryMoney;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ENTRY_MONEY
	 * 
	 * @param entryMoney
	 *            the value for fos_order_month.ENTRY_MONEY
	 * @mbggenerated
	 */
	public void setEntryMoney(Byte entryMoney) {
		this.entryMoney = entryMoney;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ENTRY_TICKET
	 * 
	 * @return the value of fos_order_month.ENTRY_TICKET
	 * @mbggenerated
	 */
	public Byte getEntryTicket() {
		return entryTicket;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ENTRY_TICKET
	 * 
	 * @param entryTicket
	 *            the value for fos_order_month.ENTRY_TICKET
	 * @mbggenerated
	 */
	public void setEntryTicket(Byte entryTicket) {
		this.entryTicket = entryTicket;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ENTRY_BEGINTIME
	 * 
	 * @return the value of fos_order_month.ENTRY_BEGINTIME
	 * @mbggenerated
	 */
	public Date getEntryBegintime() {
		return entryBegintime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ENTRY_BEGINTIME
	 * 
	 * @param entryBegintime
	 *            the value for fos_order_month.ENTRY_BEGINTIME
	 * @mbggenerated
	 */
	public void setEntryBegintime(Date entryBegintime) {
		this.entryBegintime = entryBegintime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.ENTRY_ENDTIME
	 * 
	 * @return the value of fos_order_month.ENTRY_ENDTIME
	 * @mbggenerated
	 */
	public Date getEntryEndtime() {
		return entryEndtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.ENTRY_ENDTIME
	 * 
	 * @param entryEndtime
	 *            the value for fos_order_month.ENTRY_ENDTIME
	 * @mbggenerated
	 */
	public void setEntryEndtime(Date entryEndtime) {
		this.entryEndtime = entryEndtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.STATUS
	 * 
	 * @return the value of fos_order_month.STATUS
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.STATUS
	 * 
	 * @param status
	 *            the value for fos_order_month.STATUS
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.CREATE_TIME
	 * 
	 * @return the value of fos_order_month.CREATE_TIME
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.CREATE_TIME
	 * 
	 * @param createTime
	 *            the value for fos_order_month.CREATE_TIME
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column fos_order_month.MODIFY_TIME
	 * 
	 * @return the value of fos_order_month.MODIFY_TIME
	 * @mbggenerated
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column fos_order_month.MODIFY_TIME
	 * 
	 * @param modifyTime
	 *            the value for fos_order_month.MODIFY_TIME
	 * @mbggenerated
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public BigDecimal getMediaRebate() {
		return mediaRebate;
	}

	public void setMediaRebate(BigDecimal mediaRebate) {
		this.mediaRebate = mediaRebate;
	}

	public BigDecimal getOtherExpense() {
		return otherExpense;
	}

	public void setOtherExpense(BigDecimal otherExpense) {
		this.otherExpense = otherExpense;
	}

	public BigDecimal getChannelCut() {
		return channelCut;
	}

	public void setChannelCut(BigDecimal channelCut) {
		this.channelCut = channelCut;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelDirectorName() {
		return channelDirectorName;
	}

	public void setChannelDirectorName(String channelDirectorName) {
		this.channelDirectorName = channelDirectorName;
	}

	@Override
	public String toString() {
		return "FosCycleBill [id=" + id + ", orderId=" + orderId + ", orderName=" + orderName + ", productName="
				+ productName + ", directorName=" + directorName + ", cpMain=" + cpMain + ", orderType=" + orderType
				+ ", cooperateName=" + cooperateName + ", oUnit=" + oUnit + ", oCount=" + oCount + ", oAmount="
				+ oAmount + ", subOAmount=" + subOAmount + ", cCount=" + cCount + ", cAmount=" + cAmount
				+ ", subCAmount=" + subCAmount + ", profit=" + profit + ", profitMargin=" + profitMargin
				+ ", converMargin=" + converMargin + ", oCountSum=" + oCountSum + ", oAmountSum=" + oAmountSum
				+ ", cut=" + cut + ", saleRebate=" + saleRebate + ", entryMonthStatus=" + entryMonthStatus
				+ ", entryMoney=" + entryMoney + ", entryTicket=" + entryTicket + ", entryBegintime=" + entryBegintime
				+ ", entryEndtime=" + entryEndtime + ", status=" + status + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", mediaRebate=" + mediaRebate + ", otherExpense=" + otherExpense
				+ ", channelCut=" + channelCut + ", channelId=" + channelId + ", channelName=" + channelName
				+ ", channelDirectorName=" + channelDirectorName + "]";
	}

	

	

}