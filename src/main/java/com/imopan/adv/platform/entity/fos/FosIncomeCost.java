package com.imopan.adv.platform.entity.fos;

import com.imopan.adv.platform.common.BaseBean;
import java.io.Serializable;
import java.math.BigDecimal;

public class FosIncomeCost extends BaseBean implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.ID
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	private Integer channelOrderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.ORDER_ID
	 * @mbggenerated
	 */
	private Integer orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.ORDER_NAME
	 * @mbggenerated
	 */
	private String orderName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.PRODUCT_NAME
	 * @mbggenerated
	 */
	private String productName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.COOPERATE_NAME
	 * @mbggenerated
	 */
	private String cooperateName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.EXTEND_TYPE
	 * @mbggenerated
	 */
	private Byte extendType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.FINANCIAL_INCOME
	 * @mbggenerated
	 */
	private BigDecimal financialIncome;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.CHANNEL_ID
	 * @mbggenerated
	 */
	private Integer channelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.CHANNEL_NAME
	 * @mbggenerated
	 */
	private String channelName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.FINANCIAL_COST
	 * @mbggenerated
	 */
	private BigDecimal financialCost;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.MONEY_TAX
	 * @mbggenerated
	 */
	private BigDecimal moneyTax;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.PROFIT
	 * @mbggenerated
	 */
	private BigDecimal profit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.PROFIT_MARGIN
	 * @mbggenerated
	 */
	private BigDecimal profitMargin;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_income_cost.BUSINESS_TIME
	 * @mbggenerated
	 */
	private String businessTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table fos_income_cost
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.ID
	 * @return  the value of fos_income_cost.ID
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.ID
	 * @param id  the value for fos_income_cost.ID
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.CHANNEL_ORDER_ID
	 * @return  the value of fos_income_cost.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public Integer getChannelOrderId() {
		return channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.CHANNEL_ORDER_ID
	 * @param channelOrderId  the value for fos_income_cost.CHANNEL_ORDER_ID
	 * @mbggenerated
	 */
	public void setChannelOrderId(Integer channelOrderId) {
		this.channelOrderId = channelOrderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.ORDER_ID
	 * @return  the value of fos_income_cost.ORDER_ID
	 * @mbggenerated
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.ORDER_ID
	 * @param orderId  the value for fos_income_cost.ORDER_ID
	 * @mbggenerated
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.ORDER_NAME
	 * @return  the value of fos_income_cost.ORDER_NAME
	 * @mbggenerated
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.ORDER_NAME
	 * @param orderName  the value for fos_income_cost.ORDER_NAME
	 * @mbggenerated
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName == null ? null : orderName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.PRODUCT_NAME
	 * @return  the value of fos_income_cost.PRODUCT_NAME
	 * @mbggenerated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.PRODUCT_NAME
	 * @param productName  the value for fos_income_cost.PRODUCT_NAME
	 * @mbggenerated
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.COOPERATE_NAME
	 * @return  the value of fos_income_cost.COOPERATE_NAME
	 * @mbggenerated
	 */
	public String getCooperateName() {
		return cooperateName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.COOPERATE_NAME
	 * @param cooperateName  the value for fos_income_cost.COOPERATE_NAME
	 * @mbggenerated
	 */
	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName == null ? null : cooperateName
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.EXTEND_TYPE
	 * @return  the value of fos_income_cost.EXTEND_TYPE
	 * @mbggenerated
	 */
	public Byte getExtendType() {
		return extendType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.EXTEND_TYPE
	 * @param extendType  the value for fos_income_cost.EXTEND_TYPE
	 * @mbggenerated
	 */
	public void setExtendType(Byte extendType) {
		this.extendType = extendType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.FINANCIAL_INCOME
	 * @return  the value of fos_income_cost.FINANCIAL_INCOME
	 * @mbggenerated
	 */
	public BigDecimal getFinancialIncome() {
		return financialIncome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.FINANCIAL_INCOME
	 * @param financialIncome  the value for fos_income_cost.FINANCIAL_INCOME
	 * @mbggenerated
	 */
	public void setFinancialIncome(BigDecimal financialIncome) {
		this.financialIncome = financialIncome;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.CHANNEL_ID
	 * @return  the value of fos_income_cost.CHANNEL_ID
	 * @mbggenerated
	 */
	public Integer getChannelId() {
		return channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.CHANNEL_ID
	 * @param channelId  the value for fos_income_cost.CHANNEL_ID
	 * @mbggenerated
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.CHANNEL_NAME
	 * @return  the value of fos_income_cost.CHANNEL_NAME
	 * @mbggenerated
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.CHANNEL_NAME
	 * @param channelName  the value for fos_income_cost.CHANNEL_NAME
	 * @mbggenerated
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName == null ? null : channelName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.FINANCIAL_COST
	 * @return  the value of fos_income_cost.FINANCIAL_COST
	 * @mbggenerated
	 */
	public BigDecimal getFinancialCost() {
		return financialCost;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.FINANCIAL_COST
	 * @param financialCost  the value for fos_income_cost.FINANCIAL_COST
	 * @mbggenerated
	 */
	public void setFinancialCost(BigDecimal financialCost) {
		this.financialCost = financialCost;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.MONEY_TAX
	 * @return  the value of fos_income_cost.MONEY_TAX
	 * @mbggenerated
	 */
	public BigDecimal getMoneyTax() {
		return moneyTax;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.MONEY_TAX
	 * @param moneyTax  the value for fos_income_cost.MONEY_TAX
	 * @mbggenerated
	 */
	public void setMoneyTax(BigDecimal moneyTax) {
		this.moneyTax = moneyTax;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.PROFIT
	 * @return  the value of fos_income_cost.PROFIT
	 * @mbggenerated
	 */
	public BigDecimal getProfit() {
		return profit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.PROFIT
	 * @param profit  the value for fos_income_cost.PROFIT
	 * @mbggenerated
	 */
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.PROFIT_MARGIN
	 * @return  the value of fos_income_cost.PROFIT_MARGIN
	 * @mbggenerated
	 */
	public BigDecimal getProfitMargin() {
		return profitMargin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.PROFIT_MARGIN
	 * @param profitMargin  the value for fos_income_cost.PROFIT_MARGIN
	 * @mbggenerated
	 */
	public void setProfitMargin(BigDecimal profitMargin) {
		this.profitMargin = profitMargin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_income_cost.BUSINESS_TIME
	 * @return  the value of fos_income_cost.BUSINESS_TIME
	 * @mbggenerated
	 */
	public String getBusinessTime() {
		return businessTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_income_cost.BUSINESS_TIME
	 * @param businessTime  the value for fos_income_cost.BUSINESS_TIME
	 * @mbggenerated
	 */
	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime == null ? null : businessTime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_income_cost
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", channelOrderId=").append(channelOrderId);
		sb.append(", orderId=").append(orderId);
		sb.append(", orderName=").append(orderName);
		sb.append(", productName=").append(productName);
		sb.append(", cooperateName=").append(cooperateName);
		sb.append(", extendType=").append(extendType);
		sb.append(", financialIncome=").append(financialIncome);
		sb.append(", channelId=").append(channelId);
		sb.append(", channelName=").append(channelName);
		sb.append(", financialCost=").append(financialCost);
		sb.append(", moneyTax=").append(moneyTax);
		sb.append(", profit=").append(profit);
		sb.append(", profitMargin=").append(profitMargin);
		sb.append(", businessTime=").append(businessTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}