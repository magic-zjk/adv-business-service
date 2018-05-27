package com.imopan.adv.platform.mapper.fos;

import com.imopan.adv.platform.entity.fos.FosReceiveOrder;
import com.imopan.adv.platform.entity.fos.FosReceiveOrderExample;
import com.imopan.adv.platform.vo.fos.FosPrePayChannelVo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FosReceiveOrderMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int countByExample(FosReceiveOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int insert(FosReceiveOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int insertSelective(FosReceiveOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	List<FosReceiveOrder> selectByExample(FosReceiveOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	FosReceiveOrder selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") FosReceiveOrder record,
			@Param("example") FosReceiveOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") FosReceiveOrder record, @Param("example") FosReceiveOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(FosReceiveOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_receive_order
	 * @mbggenerated
	 */
	int updateByPrimaryKey(FosReceiveOrder record);

	/**
	 * 
	 * insertSelectiveReturnId:插入收票数据返回id. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param fos
	 * @return 
	 * @since JDK 1.7
	 */
	int insertSelectiveReturnId(FosReceiveOrder fos);

	List<FosPrePayChannelVo> getPrePaymentChannelList(HashMap<String, Object> map);

	int getPrePaymentChannelList_count(HashMap<String, Object> map);

	FosPrePayChannelVo getPrePaymentChannelList_TotalAndRemain(HashMap<String, Object> map);

	List<FosReceiveOrder> getPrePaymentChannelListDetial(HashMap<String, Object> map);

	List<FosReceiveOrder> getReceiveOrderList(HashMap<String, Object> hashMap);

	int countGetReceiveOrderList(HashMap<String, Object> hashMap);

	List<FosReceiveOrder> getReceiveHistoryList(HashMap<String, Object> hashMap);

	int countGetReceiveHistoryList(HashMap<String, Object> hashMap);
}