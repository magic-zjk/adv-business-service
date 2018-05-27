package com.imopan.adv.platform.vo.fos;

import com.imopan.adv.platform.common.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FosAuditOcDayVo extends BaseBean implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 4008351546594569966L;

	private Integer id;

	private Integer channelOrderId;

	private Integer orderId;

	private String orderName;

	private String productName;

	private String orderDirectorName;

	private String cooperateName;

	private Byte cpMain;

	private BigDecimal payUnit;

	private Integer oCount;

	private BigDecimal oAmount;

	private Integer channelId;

	private String channelName;

	private BigDecimal outerUnit;

	private Integer cCount;

	private BigDecimal cAmount;

	private String channelDirectorName;

	private Byte entryDayStatus;

	private Date createTime;

	private Date modifyTime;

	private Byte ocDayStatus;

	private Date entryTime;

	private Byte channelMonthStatus;

	private BigDecimal avgMediaRebate;

	private BigDecimal avgOtherExpense;

	private BigDecimal avgChannelCut;

	private Byte orderMonthStatus;

	/* ==========fosAuditCpDay 实体======== */

	private Integer auditCpId;// 原属性id

	private Integer auditCpOcDayId;// 原属性 ocDayId

	private Date orderSubmitConfirm;

	private BigDecimal cpSubmitPayunit;

	private Integer cpSubmitOcount;

	private BigDecimal cpSubmitOamount;

	private Byte financialSubmitCpStatus;

	private BigDecimal financialSubmitPayunit;

	private Integer financialSubmitOcount;

	private BigDecimal financialSubmitOamount;

	private Date financialSubmitCpDate;

	private Integer financialSubmitCpNotthroughTime;

	private String financialSubmitCpNotthroughReason;

	private Integer avgMonthOcount;

	private BigDecimal avgMonthOamount;

	private BigDecimal avgCut;

	private BigDecimal avgSaleRebate;

	private BigDecimal auditCpAvgMoney;// 原属性avgMoney

	private BigDecimal avgReturnMoney;

	private Byte fosAuditCpDayOrderMonthStatus;//原属性orderMonthStatus

	private Byte financialDrawbillStatus;

	private Byte financialReceiptStatus;

	/* ==========fosAuditChannelDay 实体============ */

	private Integer auditChannelId;// 原属性id

	private Integer ocDayId;

	private Date channelSubmitConfirm;

	private BigDecimal channelSubmitOuterunit;

	private Integer channelSubmitCcount;

	private BigDecimal channelSubmitCamount;

	private Byte financialSubmitChannelStatus;

	private BigDecimal financialSubmitOuterunit;

	private Integer financialSubmitCcount;

	private BigDecimal financialSubmitCamount;

	private Date financialSubmitChannelDate;

	private Integer financialSubmitChannelNotthroughTime;

	private String financialSubmitChannelNotthroughReason;

	private Integer avgMonthCcount;

	private BigDecimal avgMonthCamount;

	private BigDecimal avgSubAmount;

	private BigDecimal auditChannelAvgMediaRebate;// 原属性avgMediaRebate

	private BigDecimal auditChannelAvgOtherExpense;// 原属性avgOtherExpense

	private BigDecimal auditChannelAvgChannelCut;// 原属性avgChannelCut

	private BigDecimal avgMoney;

	private BigDecimal avgPayMoney;

	private Byte fosAuditChannelDayMonthStatus;// 原属性channelMonthStatus

	private Byte financialReceiveStatus;

	private Byte financialPayStatus;
	
	// 汇总信息
	private String extendType; //业务类型
	
	private String fullName;   //全称
	
	private String moneyTax;  //税额
	
	private String businessTime;
	
	private String profit;
	
	private String profitMargin;
	
	private String entryTimeStr;
	
	/*================订单的部门================*/
	private Byte orderDepartment;
	
	

	public Byte getOrderDepartment() {
		return orderDepartment;
	}

	public void setOrderDepartment(Byte orderDepartment) {
		this.orderDepartment = orderDepartment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChannelOrderId() {
		return channelOrderId;
	}

	public void setChannelOrderId(Integer channelOrderId) {
		this.channelOrderId = channelOrderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderDirectorName() {
		return orderDirectorName;
	}

	public void setOrderDirectorName(String orderDirectorName) {
		this.orderDirectorName = orderDirectorName;
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

	public BigDecimal getPayUnit() {
		return payUnit;
	}

	public void setPayUnit(BigDecimal payUnit) {
		this.payUnit = payUnit;
	}

	public Integer getoCount() {
		return oCount;
	}

	public void setoCount(Integer oCount) {
		this.oCount = oCount;
	}

	public BigDecimal getoAmount() {
		return oAmount;
	}

	public void setoAmount(BigDecimal oAmount) {
		this.oAmount = oAmount;
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

	public BigDecimal getOuterUnit() {
		return outerUnit;
	}

	public void setOuterUnit(BigDecimal outerUnit) {
		this.outerUnit = outerUnit;
	}

	public Integer getcCount() {
		return cCount;
	}

	public void setcCount(Integer cCount) {
		this.cCount = cCount;
	}

	public BigDecimal getcAmount() {
		return cAmount;
	}

	public void setcAmount(BigDecimal cAmount) {
		this.cAmount = cAmount;
	}

	public String getChannelDirectorName() {
		return channelDirectorName;
	}

	public void setChannelDirectorName(String channelDirectorName) {
		this.channelDirectorName = channelDirectorName;
	}

	public Byte getEntryDayStatus() {
		return entryDayStatus;
	}

	public void setEntryDayStatus(Byte entryDayStatus) {
		this.entryDayStatus = entryDayStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Byte getOcDayStatus() {
		return ocDayStatus;
	}

	public void setOcDayStatus(Byte ocDayStatus) {
		this.ocDayStatus = ocDayStatus;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Byte getChannelMonthStatus() {
		return channelMonthStatus;
	}

	public void setChannelMonthStatus(Byte channelMonthStatus) {
		this.channelMonthStatus = channelMonthStatus;
	}

	public BigDecimal getAvgMediaRebate() {
		return avgMediaRebate;
	}

	public void setAvgMediaRebate(BigDecimal avgMediaRebate) {
		this.avgMediaRebate = avgMediaRebate;
	}

	public BigDecimal getAvgOtherExpense() {
		return avgOtherExpense;
	}

	public void setAvgOtherExpense(BigDecimal avgOtherExpense) {
		this.avgOtherExpense = avgOtherExpense;
	}

	public BigDecimal getAvgChannelCut() {
		return avgChannelCut;
	}

	public void setAvgChannelCut(BigDecimal avgChannelCut) {
		this.avgChannelCut = avgChannelCut;
	}

	public Byte getOrderMonthStatus() {
		return orderMonthStatus;
	}

	public void setOrderMonthStatus(Byte orderMonthStatus) {
		this.orderMonthStatus = orderMonthStatus;
	}

	public Integer getAuditCpId() {
		return auditCpId;
	}

	public void setAuditCpId(Integer auditCpId) {
		this.auditCpId = auditCpId;
	}

	public Integer getAuditCpOcDayId() {
		return auditCpOcDayId;
	}

	public void setAuditCpOcDayId(Integer auditCpOcDayId) {
		this.auditCpOcDayId = auditCpOcDayId;
	}

	public Date getOrderSubmitConfirm() {
		return orderSubmitConfirm;
	}

	public void setOrderSubmitConfirm(Date orderSubmitConfirm) {
		this.orderSubmitConfirm = orderSubmitConfirm;
	}

	public BigDecimal getCpSubmitPayunit() {
		return cpSubmitPayunit;
	}

	public void setCpSubmitPayunit(BigDecimal cpSubmitPayunit) {
		this.cpSubmitPayunit = cpSubmitPayunit;
	}

	public Integer getCpSubmitOcount() {
		return cpSubmitOcount;
	}

	public void setCpSubmitOcount(Integer cpSubmitOcount) {
		this.cpSubmitOcount = cpSubmitOcount;
	}

	public BigDecimal getCpSubmitOamount() {
		return cpSubmitOamount;
	}

	public void setCpSubmitOamount(BigDecimal cpSubmitOamount) {
		this.cpSubmitOamount = cpSubmitOamount;
	}

	public Byte getFinancialSubmitCpStatus() {
		return financialSubmitCpStatus;
	}

	public void setFinancialSubmitCpStatus(Byte financialSubmitCpStatus) {
		this.financialSubmitCpStatus = financialSubmitCpStatus;
	}

	public BigDecimal getFinancialSubmitPayunit() {
		return financialSubmitPayunit;
	}

	public void setFinancialSubmitPayunit(BigDecimal financialSubmitPayunit) {
		this.financialSubmitPayunit = financialSubmitPayunit;
	}

	public Integer getFinancialSubmitOcount() {
		return financialSubmitOcount;
	}

	public void setFinancialSubmitOcount(Integer financialSubmitOcount) {
		this.financialSubmitOcount = financialSubmitOcount;
	}

	public BigDecimal getFinancialSubmitOamount() {
		return financialSubmitOamount;
	}

	public void setFinancialSubmitOamount(BigDecimal financialSubmitOamount) {
		this.financialSubmitOamount = financialSubmitOamount;
	}

	public Date getFinancialSubmitCpDate() {
		return financialSubmitCpDate;
	}

	public void setFinancialSubmitCpDate(Date financialSubmitCpDate) {
		this.financialSubmitCpDate = financialSubmitCpDate;
	}

	public Integer getFinancialSubmitCpNotthroughTime() {
		return financialSubmitCpNotthroughTime;
	}

	public void setFinancialSubmitCpNotthroughTime(
			Integer financialSubmitCpNotthroughTime) {
		this.financialSubmitCpNotthroughTime = financialSubmitCpNotthroughTime;
	}

	public String getFinancialSubmitCpNotthroughReason() {
		return financialSubmitCpNotthroughReason;
	}

	public void setFinancialSubmitCpNotthroughReason(
			String financialSubmitCpNotthroughReason) {
		this.financialSubmitCpNotthroughReason = financialSubmitCpNotthroughReason;
	}

	public Integer getAvgMonthOcount() {
		return avgMonthOcount;
	}

	public void setAvgMonthOcount(Integer avgMonthOcount) {
		this.avgMonthOcount = avgMonthOcount;
	}

	public BigDecimal getAvgMonthOamount() {
		return avgMonthOamount;
	}

	public void setAvgMonthOamount(BigDecimal avgMonthOamount) {
		this.avgMonthOamount = avgMonthOamount;
	}

	public BigDecimal getAvgCut() {
		return avgCut;
	}

	public void setAvgCut(BigDecimal avgCut) {
		this.avgCut = avgCut;
	}

	public BigDecimal getAvgSaleRebate() {
		return avgSaleRebate;
	}

	public void setAvgSaleRebate(BigDecimal avgSaleRebate) {
		this.avgSaleRebate = avgSaleRebate;
	}

	public BigDecimal getAuditCpAvgMoney() {
		return auditCpAvgMoney;
	}

	public void setAuditCpAvgMoney(BigDecimal auditCpAvgMoney) {
		this.auditCpAvgMoney = auditCpAvgMoney;
	}

	public BigDecimal getAvgReturnMoney() {
		return avgReturnMoney;
	}

	public void setAvgReturnMoney(BigDecimal avgReturnMoney) {
		this.avgReturnMoney = avgReturnMoney;
	}

	public Byte getFosAuditCpDayOrderMonthStatus() {
		return fosAuditCpDayOrderMonthStatus;
	}

	public void setFosAuditCpDayOrderMonthStatus(Byte fosAuditCpDayOrderMonthStatus) {
		this.fosAuditCpDayOrderMonthStatus = fosAuditCpDayOrderMonthStatus;
	}

	public Byte getFinancialDrawbillStatus() {
		return financialDrawbillStatus;
	}

	public void setFinancialDrawbillStatus(Byte financialDrawbillStatus) {
		this.financialDrawbillStatus = financialDrawbillStatus;
	}

	public Byte getFinancialReceiptStatus() {
		return financialReceiptStatus;
	}

	public void setFinancialReceiptStatus(Byte financialReceiptStatus) {
		this.financialReceiptStatus = financialReceiptStatus;
	}

	public Integer getAuditChannelId() {
		return auditChannelId;
	}

	public void setAuditChannelId(Integer auditChannelId) {
		this.auditChannelId = auditChannelId;
	}

	public Integer getOcDayId() {
		return ocDayId;
	}

	public void setOcDayId(Integer ocDayId) {
		this.ocDayId = ocDayId;
	}

	public Date getChannelSubmitConfirm() {
		return channelSubmitConfirm;
	}

	public void setChannelSubmitConfirm(Date channelSubmitConfirm) {
		this.channelSubmitConfirm = channelSubmitConfirm;
	}

	public BigDecimal getChannelSubmitOuterunit() {
		return channelSubmitOuterunit;
	}

	public void setChannelSubmitOuterunit(BigDecimal channelSubmitOuterunit) {
		this.channelSubmitOuterunit = channelSubmitOuterunit;
	}

	public Integer getChannelSubmitCcount() {
		return channelSubmitCcount;
	}

	public void setChannelSubmitCcount(Integer channelSubmitCcount) {
		this.channelSubmitCcount = channelSubmitCcount;
	}

	public BigDecimal getChannelSubmitCamount() {
		return channelSubmitCamount;
	}

	public void setChannelSubmitCamount(BigDecimal channelSubmitCamount) {
		this.channelSubmitCamount = channelSubmitCamount;
	}

	public Byte getFinancialSubmitChannelStatus() {
		return financialSubmitChannelStatus;
	}

	public void setFinancialSubmitChannelStatus(Byte financialSubmitChannelStatus) {
		this.financialSubmitChannelStatus = financialSubmitChannelStatus;
	}

	public BigDecimal getFinancialSubmitOuterunit() {
		return financialSubmitOuterunit;
	}

	public void setFinancialSubmitOuterunit(BigDecimal financialSubmitOuterunit) {
		this.financialSubmitOuterunit = financialSubmitOuterunit;
	}

	public Integer getFinancialSubmitCcount() {
		return financialSubmitCcount;
	}

	public void setFinancialSubmitCcount(Integer financialSubmitCcount) {
		this.financialSubmitCcount = financialSubmitCcount;
	}

	public BigDecimal getFinancialSubmitCamount() {
		return financialSubmitCamount;
	}

	public void setFinancialSubmitCamount(BigDecimal financialSubmitCamount) {
		this.financialSubmitCamount = financialSubmitCamount;
	}

	public Date getFinancialSubmitChannelDate() {
		return financialSubmitChannelDate;
	}

	public void setFinancialSubmitChannelDate(Date financialSubmitChannelDate) {
		this.financialSubmitChannelDate = financialSubmitChannelDate;
	}

	public Integer getFinancialSubmitChannelNotthroughTime() {
		return financialSubmitChannelNotthroughTime;
	}

	public void setFinancialSubmitChannelNotthroughTime(
			Integer financialSubmitChannelNotthroughTime) {
		this.financialSubmitChannelNotthroughTime = financialSubmitChannelNotthroughTime;
	}

	public String getFinancialSubmitChannelNotthroughReason() {
		return financialSubmitChannelNotthroughReason;
	}

	public void setFinancialSubmitChannelNotthroughReason(
			String financialSubmitChannelNotthroughReason) {
		this.financialSubmitChannelNotthroughReason = financialSubmitChannelNotthroughReason;
	}

	public Integer getAvgMonthCcount() {
		return avgMonthCcount;
	}

	public void setAvgMonthCcount(Integer avgMonthCcount) {
		this.avgMonthCcount = avgMonthCcount;
	}

	public BigDecimal getAvgMonthCamount() {
		return avgMonthCamount;
	}

	public void setAvgMonthCamount(BigDecimal avgMonthCamount) {
		this.avgMonthCamount = avgMonthCamount;
	}

	public BigDecimal getAvgSubAmount() {
		return avgSubAmount;
	}

	public void setAvgSubAmount(BigDecimal avgSubAmount) {
		this.avgSubAmount = avgSubAmount;
	}

	public BigDecimal getAuditChannelAvgMediaRebate() {
		return auditChannelAvgMediaRebate;
	}

	public void setAuditChannelAvgMediaRebate(BigDecimal auditChannelAvgMediaRebate) {
		this.auditChannelAvgMediaRebate = auditChannelAvgMediaRebate;
	}

	public BigDecimal getAuditChannelAvgOtherExpense() {
		return auditChannelAvgOtherExpense;
	}

	public void setAuditChannelAvgOtherExpense(
			BigDecimal auditChannelAvgOtherExpense) {
		this.auditChannelAvgOtherExpense = auditChannelAvgOtherExpense;
	}

	public BigDecimal getAuditChannelAvgChannelCut() {
		return auditChannelAvgChannelCut;
	}

	public void setAuditChannelAvgChannelCut(BigDecimal auditChannelAvgChannelCut) {
		this.auditChannelAvgChannelCut = auditChannelAvgChannelCut;
	}

	public BigDecimal getAvgMoney() {
		return avgMoney;
	}

	public void setAvgMoney(BigDecimal avgMoney) {
		this.avgMoney = avgMoney;
	}

	public BigDecimal getAvgPayMoney() {
		return avgPayMoney;
	}

	public void setAvgPayMoney(BigDecimal avgPayMoney) {
		this.avgPayMoney = avgPayMoney;
	}

	public Byte getFosAuditChannelDayMonthStatus() {
		return fosAuditChannelDayMonthStatus;
	}

	public void setFosAuditChannelDayMonthStatus(Byte fosAuditChannelDayMonthStatus) {
		this.fosAuditChannelDayMonthStatus = fosAuditChannelDayMonthStatus;
	}

	public Byte getFinancialReceiveStatus() {
		return financialReceiveStatus;
	}

	public void setFinancialReceiveStatus(Byte financialReceiveStatus) {
		this.financialReceiveStatus = financialReceiveStatus;
	}

	public Byte getFinancialPayStatus() {
		return financialPayStatus;
	}

	public void setFinancialPayStatus(Byte financialPayStatus) {
		this.financialPayStatus = financialPayStatus;
	}
	
	public String getExtendType() {
		return extendType;
	}

	public void setExtendType(String extendType) {
		this.extendType = extendType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMoneyTax() {
		return moneyTax;
	}

	public void setMoneyTax(String moneyTax) {
		this.moneyTax = moneyTax;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(String profitMargin) {
		this.profitMargin = profitMargin;
	}
	
	public String getEntryTimeStr() {
		return entryTimeStr;
	}

	public void setEntryTimeStr(String entryTimeStr) {
		this.entryTimeStr = entryTimeStr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FosAuditOcDayVo [id=" + id + ", channelOrderId="
				+ channelOrderId + ", orderId=" + orderId + ", orderName="
				+ orderName + ", productName=" + productName
				+ ", orderDirectorName=" + orderDirectorName
				+ ", cooperateName=" + cooperateName + ", cpMain=" + cpMain
				+ ", payUnit=" + payUnit + ", oCount=" + oCount + ", oAmount="
				+ oAmount + ", channelId=" + channelId + ", channelName="
				+ channelName + ", outerUnit=" + outerUnit + ", cCount="
				+ cCount + ", cAmount=" + cAmount + ", channelDirectorName="
				+ channelDirectorName + ", entryDayStatus=" + entryDayStatus
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ ", ocDayStatus=" + ocDayStatus + ", entryTime=" + entryTime
				+ ", channelMonthStatus=" + channelMonthStatus
				+ ", avgMediaRebate=" + avgMediaRebate + ", avgOtherExpense="
				+ avgOtherExpense + ", avgChannelCut=" + avgChannelCut
				+ ", orderMonthStatus=" + orderMonthStatus + ", auditCpId="
				+ auditCpId + ", auditCpOcDayId=" + auditCpOcDayId
				+ ", orderSubmitConfirm=" + orderSubmitConfirm
				+ ", cpSubmitPayunit=" + cpSubmitPayunit + ", cpSubmitOcount="
				+ cpSubmitOcount + ", cpSubmitOamount=" + cpSubmitOamount
				+ ", financialSubmitCpStatus=" + financialSubmitCpStatus
				+ ", financialSubmitPayunit=" + financialSubmitPayunit
				+ ", financialSubmitOcount=" + financialSubmitOcount
				+ ", financialSubmitOamount=" + financialSubmitOamount
				+ ", financialSubmitCpDate=" + financialSubmitCpDate
				+ ", financialSubmitCpNotthroughTime="
				+ financialSubmitCpNotthroughTime
				+ ", financialSubmitCpNotthroughReason="
				+ financialSubmitCpNotthroughReason + ", avgMonthOcount="
				+ avgMonthOcount + ", avgMonthOamount=" + avgMonthOamount
				+ ", avgCut=" + avgCut + ", avgSaleRebate=" + avgSaleRebate
				+ ", auditCpAvgMoney=" + auditCpAvgMoney + ", avgReturnMoney="
				+ avgReturnMoney + ", fosAuditCpDayOrderMonthStatus="
				+ fosAuditCpDayOrderMonthStatus + ", financialDrawbillStatus="
				+ financialDrawbillStatus + ", financialReceiptStatus="
				+ financialReceiptStatus + ", auditChannelId=" + auditChannelId
				+ ", ocDayId=" + ocDayId + ", channelSubmitConfirm="
				+ channelSubmitConfirm + ", channelSubmitOuterunit="
				+ channelSubmitOuterunit + ", channelSubmitCcount="
				+ channelSubmitCcount + ", channelSubmitCamount="
				+ channelSubmitCamount + ", financialSubmitChannelStatus="
				+ financialSubmitChannelStatus + ", financialSubmitOuterunit="
				+ financialSubmitOuterunit + ", financialSubmitCcount="
				+ financialSubmitCcount + ", financialSubmitCamount="
				+ financialSubmitCamount + ", financialSubmitChannelDate="
				+ financialSubmitChannelDate
				+ ", financialSubmitChannelNotthroughTime="
				+ financialSubmitChannelNotthroughTime
				+ ", financialSubmitChannelNotthroughReason="
				+ financialSubmitChannelNotthroughReason + ", avgMonthCcount="
				+ avgMonthCcount + ", avgMonthCamount=" + avgMonthCamount
				+ ", avgSubAmount=" + avgSubAmount
				+ ", auditChannelAvgMediaRebate=" + auditChannelAvgMediaRebate
				+ ", auditChannelAvgOtherExpense="
				+ auditChannelAvgOtherExpense + ", auditChannelAvgChannelCut="
				+ auditChannelAvgChannelCut + ", avgMoney=" + avgMoney
				+ ", avgPayMoney=" + avgPayMoney
				+ ", fosAuditChannelDayMonthStatus="
				+ fosAuditChannelDayMonthStatus + ", financialReceiveStatus="
				+ financialReceiveStatus + ", financialPayStatus="
				+ financialPayStatus + ", extendType=" + extendType
				+ ", fullName=" + fullName + ", moneyTax=" + moneyTax
				+ ", businessTime=" + businessTime + ", profit=" + profit
				+ ", profitMargin=" + profitMargin + ", entryTimeStr="
				+ entryTimeStr + ", orderDepartment=" + orderDepartment + "]";
	}

	

	
	
	

}