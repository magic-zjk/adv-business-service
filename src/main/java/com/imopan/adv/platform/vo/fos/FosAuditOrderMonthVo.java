package com.imopan.adv.platform.vo.fos;

import com.imopan.adv.platform.common.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FosAuditOrderMonthVo extends BaseBean implements Serializable {

	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.7 
	 */ 
	private static final long serialVersionUID = 3397462517318762965L;

	private Integer id;

	private Integer orderId;

	private String orderName;

	private String productName;

	private String directorName;

	private Byte cpMain;

	private Byte orderType;

	private String cooperateName;

	private BigDecimal oUnit;

	private Integer oCount;

	private BigDecimal oAmount;

	private BigDecimal subOAmount;

	private Integer cCount;

	private BigDecimal cAmount;

	private BigDecimal subCAmount;

	private BigDecimal profit;

	private BigDecimal profitMargin;

	private BigDecimal converMargin;

	private Integer oCountSum;

	private BigDecimal oAmountSum;

	private BigDecimal cut;

	private BigDecimal saleRebate;

	private Byte entryMonthStatus;

	private Byte entryMoney;

	private Byte entryTicket;

	private Date entryBegintime;

	private Date entryEndtime;

	private Byte status;

	private Date createTime;

	private Date modifyTime;
	
	/*======================fosauditordermonth============================*/
	
	private Integer auditOrderMonthId;
	
	private Integer fosOrderMonthId;
	
	private Date orderSubmitConfirm;
	
	private Integer orderUpdateOCount;
	
	private BigDecimal orderUpdateOAmount;
	
	private BigDecimal orderUpdateCut;
	
	private BigDecimal orderUpdateSaleRebate;
	
	private Byte financialSubmitOrderStatus;
	
	private Integer financialSubmitOCount;
	
	private BigDecimal financialSubmitOAmount;
	
	private BigDecimal financialSubmitCut;
	
	private BigDecimal financialSubmitSaleRebate;
	
	private Date financialSubmitOrderDate;
	
	private Integer financialSubmitOrderNotthroughTime;
	
	private String financialSubmitOrderNotthroughReason;
	
	private Byte drawBillStatus;
	
	/*============order=============*/
	
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

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Byte getCpMain() {
		return cpMain;
	}

	public void setCpMain(Byte cpMain) {
		this.cpMain = cpMain;
	}

	public Byte getOrderType() {
		return orderType;
	}

	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	public String getCooperateName() {
		return cooperateName;
	}

	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName;
	}

	public BigDecimal getoUnit() {
		return oUnit;
	}

	public void setoUnit(BigDecimal oUnit) {
		this.oUnit = oUnit;
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

	public BigDecimal getSubOAmount() {
		return subOAmount;
	}

	public void setSubOAmount(BigDecimal subOAmount) {
		this.subOAmount = subOAmount;
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

	public BigDecimal getSubCAmount() {
		return subCAmount;
	}

	public void setSubCAmount(BigDecimal subCAmount) {
		this.subCAmount = subCAmount;
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

	public BigDecimal getConverMargin() {
		return converMargin;
	}

	public void setConverMargin(BigDecimal converMargin) {
		this.converMargin = converMargin;
	}

	public Integer getoCountSum() {
		return oCountSum;
	}

	public void setoCountSum(Integer oCountSum) {
		this.oCountSum = oCountSum;
	}

	public BigDecimal getoAmountSum() {
		return oAmountSum;
	}

	public void setoAmountSum(BigDecimal oAmountSum) {
		this.oAmountSum = oAmountSum;
	}

	public BigDecimal getCut() {
		return cut;
	}

	public void setCut(BigDecimal cut) {
		this.cut = cut;
	}

	public BigDecimal getSaleRebate() {
		return saleRebate;
	}

	public void setSaleRebate(BigDecimal saleRebate) {
		this.saleRebate = saleRebate;
	}

	public Byte getEntryMonthStatus() {
		return entryMonthStatus;
	}

	public void setEntryMonthStatus(Byte entryMonthStatus) {
		this.entryMonthStatus = entryMonthStatus;
	}

	public Byte getEntryMoney() {
		return entryMoney;
	}

	public void setEntryMoney(Byte entryMoney) {
		this.entryMoney = entryMoney;
	}

	public Byte getEntryTicket() {
		return entryTicket;
	}

	public void setEntryTicket(Byte entryTicket) {
		this.entryTicket = entryTicket;
	}

	public Date getEntryBegintime() {
		return entryBegintime;
	}

	public void setEntryBegintime(Date entryBegintime) {
		this.entryBegintime = entryBegintime;
	}

	public Date getEntryEndtime() {
		return entryEndtime;
	}

	public void setEntryEndtime(Date entryEndtime) {
		this.entryEndtime = entryEndtime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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

	public Integer getAuditOrderMonthId() {
		return auditOrderMonthId;
	}

	public void setAuditOrderMonthId(Integer auditOrderMonthId) {
		this.auditOrderMonthId = auditOrderMonthId;
	}

	public Integer getFosOrderMonthId() {
		return fosOrderMonthId;
	}

	public void setFosOrderMonthId(Integer fosOrderMonthId) {
		this.fosOrderMonthId = fosOrderMonthId;
	}

	public Date getOrderSubmitConfirm() {
		return orderSubmitConfirm;
	}

	public void setOrderSubmitConfirm(Date orderSubmitConfirm) {
		this.orderSubmitConfirm = orderSubmitConfirm;
	}

	public Integer getOrderUpdateOCount() {
		return orderUpdateOCount;
	}

	public void setOrderUpdateOCount(Integer orderUpdateOCount) {
		this.orderUpdateOCount = orderUpdateOCount;
	}

	public BigDecimal getOrderUpdateOAmount() {
		return orderUpdateOAmount;
	}

	public void setOrderUpdateOAmount(BigDecimal orderUpdateOAmount) {
		this.orderUpdateOAmount = orderUpdateOAmount;
	}

	public BigDecimal getOrderUpdateCut() {
		return orderUpdateCut;
	}

	public void setOrderUpdateCut(BigDecimal orderUpdateCut) {
		this.orderUpdateCut = orderUpdateCut;
	}

	public BigDecimal getOrderUpdateSaleRebate() {
		return orderUpdateSaleRebate;
	}

	public void setOrderUpdateSaleRebate(BigDecimal orderUpdateSaleRebate) {
		this.orderUpdateSaleRebate = orderUpdateSaleRebate;
	}

	public Byte getFinancialSubmitOrderStatus() {
		return financialSubmitOrderStatus;
	}

	public void setFinancialSubmitOrderStatus(Byte financialSubmitOrderStatus) {
		this.financialSubmitOrderStatus = financialSubmitOrderStatus;
	}

	public Integer getFinancialSubmitOCount() {
		return financialSubmitOCount;
	}

	public void setFinancialSubmitOCount(Integer financialSubmitOCount) {
		this.financialSubmitOCount = financialSubmitOCount;
	}

	public BigDecimal getFinancialSubmitOAmount() {
		return financialSubmitOAmount;
	}

	public void setFinancialSubmitOAmount(BigDecimal financialSubmitOAmount) {
		this.financialSubmitOAmount = financialSubmitOAmount;
	}

	public BigDecimal getFinancialSubmitCut() {
		return financialSubmitCut;
	}

	public void setFinancialSubmitCut(BigDecimal financialSubmitCut) {
		this.financialSubmitCut = financialSubmitCut;
	}

	public BigDecimal getFinancialSubmitSaleRebate() {
		return financialSubmitSaleRebate;
	}

	public void setFinancialSubmitSaleRebate(BigDecimal financialSubmitSaleRebate) {
		this.financialSubmitSaleRebate = financialSubmitSaleRebate;
	}

	public Date getFinancialSubmitOrderDate() {
		return financialSubmitOrderDate;
	}

	public void setFinancialSubmitOrderDate(Date financialSubmitOrderDate) {
		this.financialSubmitOrderDate = financialSubmitOrderDate;
	}

	public Integer getFinancialSubmitOrderNotthroughTime() {
		return financialSubmitOrderNotthroughTime;
	}

	public void setFinancialSubmitOrderNotthroughTime(
			Integer financialSubmitOrderNotthroughTime) {
		this.financialSubmitOrderNotthroughTime = financialSubmitOrderNotthroughTime;
	}

	public String getFinancialSubmitOrderNotthroughReason() {
		return financialSubmitOrderNotthroughReason;
	}

	public void setFinancialSubmitOrderNotthroughReason(
			String financialSubmitOrderNotthroughReason) {
		this.financialSubmitOrderNotthroughReason = financialSubmitOrderNotthroughReason;
	}

	public Byte getDrawBillStatus() {
		return drawBillStatus;
	}

	public void setDrawBillStatus(Byte drawBillStatus) {
		this.drawBillStatus = drawBillStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FosAuditOrderMonthVo [id=" + id + ", orderId=" + orderId
				+ ", orderName=" + orderName + ", productName=" + productName
				+ ", directorName=" + directorName + ", cpMain=" + cpMain
				+ ", orderType=" + orderType + ", cooperateName="
				+ cooperateName + ", oUnit=" + oUnit + ", oCount=" + oCount
				+ ", oAmount=" + oAmount + ", subOAmount=" + subOAmount
				+ ", cCount=" + cCount + ", cAmount=" + cAmount
				+ ", subCAmount=" + subCAmount + ", profit=" + profit
				+ ", profitMargin=" + profitMargin + ", converMargin="
				+ converMargin + ", oCountSum=" + oCountSum + ", oAmountSum="
				+ oAmountSum + ", cut=" + cut + ", saleRebate=" + saleRebate
				+ ", entryMonthStatus=" + entryMonthStatus + ", entryMoney="
				+ entryMoney + ", entryTicket=" + entryTicket
				+ ", entryBegintime=" + entryBegintime + ", entryEndtime="
				+ entryEndtime + ", status=" + status + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime
				+ ", auditOrderMonthId=" + auditOrderMonthId
				+ ", fosOrderMonthId=" + fosOrderMonthId
				+ ", orderSubmitConfirm=" + orderSubmitConfirm
				+ ", orderUpdateOCount=" + orderUpdateOCount
				+ ", orderUpdateOAmount=" + orderUpdateOAmount
				+ ", orderUpdateCut=" + orderUpdateCut
				+ ", orderUpdateSaleRebate=" + orderUpdateSaleRebate
				+ ", financialSubmitOrderStatus=" + financialSubmitOrderStatus
				+ ", financialSubmitOCount=" + financialSubmitOCount
				+ ", financialSubmitOAmount=" + financialSubmitOAmount
				+ ", financialSubmitCut=" + financialSubmitCut
				+ ", financialSubmitSaleRebate=" + financialSubmitSaleRebate
				+ ", financialSubmitOrderDate=" + financialSubmitOrderDate
				+ ", financialSubmitOrderNotthroughTime="
				+ financialSubmitOrderNotthroughTime
				+ ", financialSubmitOrderNotthroughReason="
				+ financialSubmitOrderNotthroughReason + ", drawBillStatus="
				+ drawBillStatus + "]";
	}
	
	
	
	

}