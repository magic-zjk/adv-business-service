package com.imopan.adv.platform.vo.fos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.imopan.adv.platform.common.VoBaseBean;
import com.imopan.adv.platform.exception.ImopanException;

public class FosOrderVo extends VoBaseBean implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.ORDER_ID
	 * @mbggenerated
	 */
	private Integer orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.ORDER_NAME
	 * @mbggenerated
	 */
	private String orderName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.PRODUCT_NAME
	 * @mbggenerated
	 */
	private String productName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.DIRECTOR_ID
	 * @mbggenerated
	 */
	private Integer directorId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.DIRECTOR_NAME
	 * @mbggenerated
	 */
	private String directorName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.COOPERATE_NAME
	 * @mbggenerated
	 */
	private String cooperateName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.CP_MAIN
	 * @mbggenerated
	 */
	private Byte cpMain;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.PAY_UNIT
	 * @mbggenerated
	 */
	private BigDecimal payUnit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.STATUS
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.ADVANCE_PAY
	 * @mbggenerated
	 */
	private BigDecimal advancePay;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.ORDER_TYPE
	 * @mbggenerated
	 */
	private Byte orderType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.BEGIN_TIME
	 * @mbggenerated
	 */
	private Date beginTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.END_TIME
	 * @mbggenerated
	 */
	private Date endTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.CREATE_TIME
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.MODIFY_TIME
	 * @mbggenerated
	 */
	private Date modifyTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.REMARK
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.RELATION_ID
	 * @mbggenerated
	 */
	private Integer relationId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.IS_SPLIT
	 * @mbggenerated
	 */
	private Integer isSplit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.SPLIT_PARENT
	 * @mbggenerated
	 */
	private Integer splitParent;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.EXTEND_TYPE
	 * @mbggenerated
	 */
	private Byte extendType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.ORDER_DEPARTMENT
	 * @mbggenerated
	 */
	private Byte orderDepartment;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.CONTRACT_NUMBER
	 * @mbggenerated
	 */
	private String contractNumber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_order.ACCESS_TYPE
	 * @mbggenerated
	 */
	private Byte accessType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table fos_order
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.ORDER_ID
	 * @return  the value of fos_order.ORDER_ID
	 * @mbggenerated
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.ORDER_ID
	 * @param orderId  the value for fos_order.ORDER_ID
	 * @mbggenerated
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.ORDER_NAME
	 * @return  the value of fos_order.ORDER_NAME
	 * @mbggenerated
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.ORDER_NAME
	 * @param orderName  the value for fos_order.ORDER_NAME
	 * @mbggenerated
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName == null ? null : orderName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.PRODUCT_NAME
	 * @return  the value of fos_order.PRODUCT_NAME
	 * @mbggenerated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.PRODUCT_NAME
	 * @param productName  the value for fos_order.PRODUCT_NAME
	 * @mbggenerated
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.DIRECTOR_ID
	 * @return  the value of fos_order.DIRECTOR_ID
	 * @mbggenerated
	 */
	public Integer getDirectorId() {
		return directorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.DIRECTOR_ID
	 * @param directorId  the value for fos_order.DIRECTOR_ID
	 * @mbggenerated
	 */
	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.DIRECTOR_NAME
	 * @return  the value of fos_order.DIRECTOR_NAME
	 * @mbggenerated
	 */
	public String getDirectorName() {
		return directorName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.DIRECTOR_NAME
	 * @param directorName  the value for fos_order.DIRECTOR_NAME
	 * @mbggenerated
	 */
	public void setDirectorName(String directorName) {
		this.directorName = directorName == null ? null : directorName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.COOPERATE_NAME
	 * @return  the value of fos_order.COOPERATE_NAME
	 * @mbggenerated
	 */
	public String getCooperateName() {
		return cooperateName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.COOPERATE_NAME
	 * @param cooperateName  the value for fos_order.COOPERATE_NAME
	 * @mbggenerated
	 */
	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName == null ? null : cooperateName
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.CP_MAIN
	 * @return  the value of fos_order.CP_MAIN
	 * @mbggenerated
	 */
	public Byte getCpMain() {
		return cpMain;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.CP_MAIN
	 * @param cpMain  the value for fos_order.CP_MAIN
	 * @mbggenerated
	 */
	public void setCpMain(Byte cpMain) {
		this.cpMain = cpMain;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.PAY_UNIT
	 * @return  the value of fos_order.PAY_UNIT
	 * @mbggenerated
	 */
	public BigDecimal getPayUnit() {
		return payUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.PAY_UNIT
	 * @param payUnit  the value for fos_order.PAY_UNIT
	 * @mbggenerated
	 */
	public void setPayUnit(BigDecimal payUnit) {
		this.payUnit = payUnit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.STATUS
	 * @return  the value of fos_order.STATUS
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.STATUS
	 * @param status  the value for fos_order.STATUS
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.ADVANCE_PAY
	 * @return  the value of fos_order.ADVANCE_PAY
	 * @mbggenerated
	 */
	public BigDecimal getAdvancePay() {
		return advancePay;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.ADVANCE_PAY
	 * @param advancePay  the value for fos_order.ADVANCE_PAY
	 * @mbggenerated
	 */
	public void setAdvancePay(BigDecimal advancePay) {
		this.advancePay = advancePay;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.ORDER_TYPE
	 * @return  the value of fos_order.ORDER_TYPE
	 * @mbggenerated
	 */
	public Byte getOrderType() {
		return orderType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.ORDER_TYPE
	 * @param orderType  the value for fos_order.ORDER_TYPE
	 * @mbggenerated
	 */
	public void setOrderType(Byte orderType) {
		this.orderType = orderType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.BEGIN_TIME
	 * @return  the value of fos_order.BEGIN_TIME
	 * @mbggenerated
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.BEGIN_TIME
	 * @param beginTime  the value for fos_order.BEGIN_TIME
	 * @mbggenerated
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.END_TIME
	 * @return  the value of fos_order.END_TIME
	 * @mbggenerated
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.END_TIME
	 * @param endTime  the value for fos_order.END_TIME
	 * @mbggenerated
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.CREATE_TIME
	 * @return  the value of fos_order.CREATE_TIME
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.CREATE_TIME
	 * @param createTime  the value for fos_order.CREATE_TIME
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.MODIFY_TIME
	 * @return  the value of fos_order.MODIFY_TIME
	 * @mbggenerated
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.MODIFY_TIME
	 * @param modifyTime  the value for fos_order.MODIFY_TIME
	 * @mbggenerated
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.REMARK
	 * @return  the value of fos_order.REMARK
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.REMARK
	 * @param remark  the value for fos_order.REMARK
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.RELATION_ID
	 * @return  the value of fos_order.RELATION_ID
	 * @mbggenerated
	 */
	public Integer getRelationId() {
		return relationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.RELATION_ID
	 * @param relationId  the value for fos_order.RELATION_ID
	 * @mbggenerated
	 */
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.IS_SPLIT
	 * @return  the value of fos_order.IS_SPLIT
	 * @mbggenerated
	 */
	public Integer getIsSplit() {
		return isSplit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.IS_SPLIT
	 * @param isSplit  the value for fos_order.IS_SPLIT
	 * @mbggenerated
	 */
	public void setIsSplit(Integer isSplit) {
		this.isSplit = isSplit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.SPLIT_PARENT
	 * @return  the value of fos_order.SPLIT_PARENT
	 * @mbggenerated
	 */
	public Integer getSplitParent() {
		return splitParent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.SPLIT_PARENT
	 * @param splitParent  the value for fos_order.SPLIT_PARENT
	 * @mbggenerated
	 */
	public void setSplitParent(Integer splitParent) {
		this.splitParent = splitParent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.EXTEND_TYPE
	 * @return  the value of fos_order.EXTEND_TYPE
	 * @mbggenerated
	 */
	public Byte getExtendType() {
		return extendType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.EXTEND_TYPE
	 * @param extendType  the value for fos_order.EXTEND_TYPE
	 * @mbggenerated
	 */
	public void setExtendType(Byte extendType) {
		this.extendType = extendType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.ORDER_DEPARTMENT
	 * @return  the value of fos_order.ORDER_DEPARTMENT
	 * @mbggenerated
	 */
	public Byte getOrderDepartment() {
		return orderDepartment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.ORDER_DEPARTMENT
	 * @param orderDepartment  the value for fos_order.ORDER_DEPARTMENT
	 * @mbggenerated
	 */
	public void setOrderDepartment(Byte orderDepartment) {
		this.orderDepartment = orderDepartment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.CONTRACT_NUMBER
	 * @return  the value of fos_order.CONTRACT_NUMBER
	 * @mbggenerated
	 */
	public String getContractNumber() {
		return contractNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.CONTRACT_NUMBER
	 * @param contractNumber  the value for fos_order.CONTRACT_NUMBER
	 * @mbggenerated
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber == null ? null : contractNumber
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_order.ACCESS_TYPE
	 * @return  the value of fos_order.ACCESS_TYPE
	 * @mbggenerated
	 */
	public Byte getAccessType() {
		return accessType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_order.ACCESS_TYPE
	 * @param accessType  the value for fos_order.ACCESS_TYPE
	 * @mbggenerated
	 */
	public void setAccessType(Byte accessType) {
		this.accessType = accessType;
	}


	@Override
	public String toString() {
		return "FosOrderVo [orderId=" + orderId + ", orderName=" + orderName
				+ ", productName=" + productName + ", directorId=" + directorId
				+ ", directorName=" + directorName + ", cooperateName="
				+ cooperateName + ", cpMain=" + cpMain + ", payUnit=" + payUnit
				+ ", status=" + status + ", advancePay=" + advancePay
				+ ", orderType=" + orderType + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", remark=" + remark
				+ ", relationId=" + relationId + ", isSplit=" + isSplit
				+ ", splitParent=" + splitParent + ", extendType=" + extendType
				+ ", orderDepartment=" + orderDepartment + ", contractNumber="
				+ contractNumber + ", accessType=" + accessType
				+ ", splitNameList=" + splitNameList + "]";
	}

	@Override
	public boolean verify(String str) throws ImopanException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private ArrayList<Map<String,String>> splitNameList;

	public ArrayList<Map<String, String>> getSplitNameList() {
		return splitNameList;
	}

	public void setSplitNameList(ArrayList<Map<String, String>> splitNameList) {
		this.splitNameList = splitNameList;
	}
	
	
	
	
}