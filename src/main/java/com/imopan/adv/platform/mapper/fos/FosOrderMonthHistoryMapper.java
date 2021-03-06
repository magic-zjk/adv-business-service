package com.imopan.adv.platform.mapper.fos;

import com.imopan.adv.platform.entity.fos.FosOrderMonthHistory;
import com.imopan.adv.platform.entity.fos.FosOrderMonthHistoryExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FosOrderMonthHistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int countByExample(FosOrderMonthHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int insert(FosOrderMonthHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int insertSelective(FosOrderMonthHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	List<FosOrderMonthHistory> selectByExample(FosOrderMonthHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	FosOrderMonthHistory selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") FosOrderMonthHistory record,
			@Param("example") FosOrderMonthHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") FosOrderMonthHistory record,
			@Param("example") FosOrderMonthHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(FosOrderMonthHistory record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_order_month_history
	 * @mbggenerated
	 */
	int updateByPrimaryKey(FosOrderMonthHistory record);

	
	/**
	 * 
	 * getHistoryList:历史列表. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param hashMap
	 * @return 
	 * @since JDK 1.7
	 */
	List<FosOrderMonthHistory> getHistoryList(HashMap<String, Object> hashMap);

	/**
	 * 
	 * countGetHistoryList:历史列表总数. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param hashMap
	 * @return 
	 * @since JDK 1.7
	 */
	int countGetHistoryList(HashMap<String, Object> hashMap);
	
	
	/**
	 * 
	 * getHistoryListSum:.历史列表汇总 <br/> 
	 * 
	 * @author zhangjiakun
	 * @param hashMap
	 * @return 
	 * @since JDK 1.7
	 */
	List<FosOrderMonthHistory> getHistoryListSum(HashMap<String, Object> hashMap);

}