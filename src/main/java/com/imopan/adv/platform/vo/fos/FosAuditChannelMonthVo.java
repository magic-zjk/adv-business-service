package com.imopan.adv.platform.vo.fos;

import com.imopan.adv.platform.common.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FosAuditChannelMonthVo extends BaseBean implements Serializable {


	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.7 
	 */ 
	private static final long serialVersionUID = 677148149741415137L;

	private Integer id;
	
	private Integer channelOrderId;
	
	private Integer orderId;
	
	private String orderName;
	
	private String productName;
	
	private String orderDirectorName;
	
	private Byte cpMain;
	
	private Integer relationId;
	
	private Integer channelId;
	
	private String channelName;
	
	private String channelDirectorName;
	
	private BigDecimal cUnit;
	
	private Integer cCount;
	
	private BigDecimal cAmount;
	
	private BigDecimal subAmount;
	
	private Integer cCountSum;
	
	private BigDecimal cAmountSum;
	
	private BigDecimal mediaRebate;
	
	private BigDecimal otherExpense;
	
	private BigDecimal channelCut;
	
	private Byte entryMonthStatus;
	
	private Byte entryMoney;
	
	private Byte entryTicket;
	
	private Date entryBegintime;
	
	private Date entryEndtime;
	
	private Byte status;
	
	private Date createTime;
	
	private Date modifyTime;
	
	private Integer receiveId;
	
	/*=========================fosauditchannelmonth=========================*/
	
	private Integer auditChannelMonthId;//原属性id

	private Integer fosChannelMonthId;
	
	private Date channelSubmitConfirm;

	private Integer channelUpdateCCountSum;

	private BigDecimal channelUpdateCAmountSum;

	private BigDecimal channelUpdateMediaRebate;

	private BigDecimal channelUpdateOtherExpense;

	private BigDecimal channelUpdateChannelCut;

	private Byte financialSubmitChannelStatus;

	private Integer financialSubmitCCountSum;

	private BigDecimal financialSubmitCAmountSum;

	private BigDecimal financialSubmitMediaRebate;

	private BigDecimal financialSubmitOtherExpense;

	private BigDecimal financialSubmitChannelCut;

	private Date financialSubmitChannelDate;

	private Integer financialSubmitChannelNotthroughTime;

	private String financialSubmitChannelNotthroughReason;

	private Byte receiveBillStatus;

	/*=============================额外信息=====================*/
	private BigDecimal advancePayTotal;//预付总金额
	
	/*============order=============*/
	private Byte orderDepartment;
	
	
	public Byte getOrderDepartment() {
		return orderDepartment;
	}

	public void setOrderDepartment(Byte orderDepartment) {
		this.orderDepartment = orderDepartment;
	}

	private Byte extendType;//业务类型
	
	private String channelFullName;

	public String getChannelFullName() {
		return channelFullName;
	}

	public void setChannelFullName(String channelFullName) {
		this.channelFullName = channelFullName;
	}

	public BigDecimal getAdvancePayTotal() {
		return advancePayTotal;
	}

	public void setAdvancePayTotal(BigDecimal advancePayTotal) {
		this.advancePayTotal = advancePayTotal;
	}

	public Byte getExtendType() {
		return extendType;
	}

	public void setExtendType(Byte extendType) {
		this.extendType = extendType;
	}

	public BigDecimal getFinancialSubmitChannelCut() {
		return financialSubmitChannelCut;
	}

	public void setFinancialSubmitChannelCut(BigDecimal financialSubmitChannelCut) {
		this.financialSubmitChannelCut = financialSubmitChannelCut;
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

	public Byte getCpMain() {
		return cpMain;
	}

	public void setCpMain(Byte cpMain) {
		this.cpMain = cpMain;
	}

	public Integer getRelationId() {
		return relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
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

	public BigDecimal getcUnit() {
		return cUnit;
	}

	public void setcUnit(BigDecimal cUnit) {
		this.cUnit = cUnit;
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

	public BigDecimal getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(BigDecimal subAmount) {
		this.subAmount = subAmount;
	}

	public Integer getcCountSum() {
		return cCountSum;
	}

	public void setcCountSum(Integer cCountSum) {
		this.cCountSum = cCountSum;
	}

	public BigDecimal getcAmountSum() {
		return cAmountSum;
	}

	public void setcAmountSum(BigDecimal cAmountSum) {
		this.cAmountSum = cAmountSum;
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

	public Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	public Integer getAuditChannelMonthId() {
		return auditChannelMonthId;
	}

	public void setAuditChannelMonthId(Integer auditChannelMonthId) {
		this.auditChannelMonthId = auditChannelMonthId;
	}

	public Integer getFosChannelMonthId() {
		return fosChannelMonthId;
	}

	public void setFosChannelMonthId(Integer fosChannelMonthId) {
		this.fosChannelMonthId = fosChannelMonthId;
	}

	public Date getChannelSubmitConfirm() {
		return channelSubmitConfirm;
	}

	public void setChannelSubmitConfirm(Date channelSubmitConfirm) {
		this.channelSubmitConfirm = channelSubmitConfirm;
	}

	public Integer getChannelUpdateCCountSum() {
		return channelUpdateCCountSum;
	}

	public void setChannelUpdateCCountSum(Integer channelUpdateCCountSum) {
		this.channelUpdateCCountSum = channelUpdateCCountSum;
	}

	public BigDecimal getChannelUpdateCAmountSum() {
		return channelUpdateCAmountSum;
	}

	public void setChannelUpdateCAmountSum(BigDecimal channelUpdateCAmountSum) {
		this.channelUpdateCAmountSum = channelUpdateCAmountSum;
	}

	public BigDecimal getChannelUpdateMediaRebate() {
		return channelUpdateMediaRebate;
	}

	public void setChannelUpdateMediaRebate(BigDecimal channelUpdateMediaRebate) {
		this.channelUpdateMediaRebate = channelUpdateMediaRebate;
	}

	public BigDecimal getChannelUpdateOtherExpense() {
		return channelUpdateOtherExpense;
	}

	public void setChannelUpdateOtherExpense(BigDecimal channelUpdateOtherExpense) {
		this.channelUpdateOtherExpense = channelUpdateOtherExpense;
	}

	public BigDecimal getChannelUpdateChannelCut() {
		return channelUpdateChannelCut;
	}

	public void setChannelUpdateChannelCut(BigDecimal channelUpdateChannelCut) {
		this.channelUpdateChannelCut = channelUpdateChannelCut;
	}

	public Byte getFinancialSubmitChannelStatus() {
		return financialSubmitChannelStatus;
	}

	public void setFinancialSubmitChannelStatus(Byte financialSubmitChannelStatus) {
		this.financialSubmitChannelStatus = financialSubmitChannelStatus;
	}

	public Integer getFinancialSubmitCCountSum() {
		return financialSubmitCCountSum;
	}

	public void setFinancialSubmitCCountSum(Integer financialSubmitCCountSum) {
		this.financialSubmitCCountSum = financialSubmitCCountSum;
	}

	public BigDecimal getFinancialSubmitCAmountSum() {
		return financialSubmitCAmountSum;
	}

	public void setFinancialSubmitCAmountSum(BigDecimal financialSubmitCAmountSum) {
		this.financialSubmitCAmountSum = financialSubmitCAmountSum;
	}

	public BigDecimal getFinancialSubmitMediaRebate() {
		return financialSubmitMediaRebate;
	}

	public void setFinancialSubmitMediaRebate(BigDecimal financialSubmitMediaRebate) {
		this.financialSubmitMediaRebate = financialSubmitMediaRebate;
	}

	public BigDecimal getFinancialSubmitOtherExpense() {
		return financialSubmitOtherExpense;
	}

	public void setFinancialSubmitOtherExpense(
			BigDecimal financialSubmitOtherExpense) {
		this.financialSubmitOtherExpense = financialSubmitOtherExpense;
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

	public Byte getReceiveBillStatus() {
		return receiveBillStatus;
	}

	public void setReceiveBillStatus(Byte receiveBillStatus) {
		this.receiveBillStatus = receiveBillStatus;
	}
	
	
}