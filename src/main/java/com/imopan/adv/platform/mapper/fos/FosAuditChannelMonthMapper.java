package com.imopan.adv.platform.mapper.fos;

import com.imopan.adv.platform.entity.fos.FosAuditChannelMonth;
import com.imopan.adv.platform.entity.fos.FosAuditChannelMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FosAuditChannelMonthMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int countByExample(FosAuditChannelMonthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int insert(FosAuditChannelMonth record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int insertSelective(FosAuditChannelMonth record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	List<FosAuditChannelMonth> selectByExample(
			FosAuditChannelMonthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	FosAuditChannelMonth selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") FosAuditChannelMonth record,
			@Param("example") FosAuditChannelMonthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") FosAuditChannelMonth record,
			@Param("example") FosAuditChannelMonthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(FosAuditChannelMonth record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_audit_channel_month
	 * @mbggenerated
	 */
	int updateByPrimaryKey(FosAuditChannelMonth record);
}