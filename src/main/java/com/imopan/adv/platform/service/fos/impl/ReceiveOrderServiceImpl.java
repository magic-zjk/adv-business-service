/** 
 * Project Name:adv-business-service 
 * File Name:ReceiveOrderServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年5月12日下午3:47:13 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosAuditChannelMonth;
import com.imopan.adv.platform.entity.fos.FosAuditChannelMonthExample;
import com.imopan.adv.platform.entity.fos.FosChannelMonth;
import com.imopan.adv.platform.entity.fos.FosOrderChannel;
import com.imopan.adv.platform.entity.fos.FosReceiveOrder;
import com.imopan.adv.platform.entity.fos.FosReceiveOrderExample;
import com.imopan.adv.platform.entity.fos.FosReceiveOrderExample.Criteria;
import com.imopan.adv.platform.mapper.fos.FosAuditChannelMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosChannelMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderChannelMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosReceiveOrderMapper;
import com.imopan.adv.platform.service.fos.IReceiveOrderService;
import com.imopan.adv.platform.util.BeanUtil;
import com.imopan.adv.platform.util.FosDataControllerUtil;
import com.imopan.adv.platform.vo.fos.FosReceiveOrderVo;

/** 
 * ClassName:ReceiveOrderServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年5月12日 下午3:47:13 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class ReceiveOrderServiceImpl implements IReceiveOrderService {

	@Autowired
	private FosReceiveOrderMapper receiveOrderDao;
	@Autowired
	private FosChannelMonthMapper channelMonthDao;
	@Autowired
	private FosOrderChannelMapper orderChannelDao;
	@Autowired
	private FosAuditChannelMonthMapper auditChannelMonthDao;

	
	@Override
	@Transactional
	public int saveReceiveBill(FosReceiveOrderVo fos) {
		if(fos.getAdvanceConsume() == null){
			fos.setAdvanceConsume(new BigDecimal(0));
		}
		fos.setChannelTime(fos.getCreateTime());
		FosReceiveOrder receiveOrder = new FosReceiveOrder();
		//对象复制
		BeanUtil.copyProperties(fos, receiveOrder);
		
		receiveOrder.setDataTime(new Date());
		receiveOrder.setStatus((byte)0);
		if(fos.getAdvancePay() == null){
			receiveOrder.setAdvancePay(fos.getAdvancePay().subtract(fos.getAdvanceConsume()));
		}else {
			receiveOrder.setAdvancePay(new BigDecimal(0));
		}
		int i = receiveOrderDao.insertSelectiveReturnId(receiveOrder);
		//修改渠道对账的状态
		String[] split = fos.getIds().split(",");
		for (String id : split) {
			FosChannelMonth record = new FosChannelMonth();
			record.setId(Integer.valueOf(id));
			record.setReceiveId(fos.getId());
			record.setEntryTicket((byte)2);
			channelMonthDao.updateByPrimaryKeySelective(record);
		}	
		//修改渠道订单的预付款金额
		BigDecimal advanceConsume = fos.getAdvanceConsume();
		BigDecimal advancePay = fos.getAdvancePay();
		Integer channelOrderId = fos.getChannelOrderId();
		FosOrderChannel fosOrderChannel = new FosOrderChannel();
		fosOrderChannel.setAdvancePay(advancePay.subtract(advanceConsume));
		fosOrderChannel.setChannelOrderId(channelOrderId);
		orderChannelDao.updateByPrimaryKeySelective(fosOrderChannel);
		//TODO 增加流水表
		return i;
	}

	@Override
	public PageBean<FosReceiveOrder> getReceiveHistoryList(VoPageBaseBean vpbb) {
		PageBean<FosReceiveOrder> pageBean = new PageBean<FosReceiveOrder>();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(vpbb.getParammap() != null){
			//TODO 添加查询条件
			if(vpbb.getParammap().get("id") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("id").toString())){
				hashMap.put("id", vpbb.getParammap().get("id").toString());
			}
			if(vpbb.getParammap().get("channelOrderName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("channelOrderName").toString())){
				hashMap.put("channelOrderName", "%"+vpbb.getParammap().get("channelOrderName").toString()+"%");
			}
			if(vpbb.getParammap().get("channelName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("channelName").toString())){
				hashMap.put("channelName", "%"+vpbb.getParammap().get("channelName").toString()+"%");
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				hashMap.put("status", vpbb.getParammap().get("status").toString());
			}
			if(vpbb.getParammap().get("receiveStatus") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("receiveStatus").toString())){
				hashMap.put("receiveStatus", vpbb.getParammap().get("receiveStatus").toString());
			}
		}
		
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}
		hashMap.put("orderByName", "DATA_TIME desc");
		
		//数据级控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		//查询
		List<FosReceiveOrder> list = receiveOrderDao.getReceiveHistoryList(hashMap);
		int i = receiveOrderDao.countGetReceiveHistoryList(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	
	}

	@Override
	public int savePay(FosReceiveOrder fos) {
		FosReceiveOrder fosReceiveOrder = new FosReceiveOrder();
		fosReceiveOrder.setId(fos.getId());
		fosReceiveOrder.setPayMoney(fos.getPayMoney());
		fosReceiveOrder.setPayDate(fos.getPayDate());
		fosReceiveOrder.setStatus((byte)1);
		int i = receiveOrderDao.updateByPrimaryKeySelective(fosReceiveOrder);
		//更新渠道对账中的entry_ticket状态
		String[] ids = fos.getIds().split(",");
		for (String s : ids) {
			FosChannelMonth fosChannelMonth = new FosChannelMonth();
			fosChannelMonth.setId(Integer.valueOf(s));
			fosChannelMonth.setEntryTicket((byte)3);
			channelMonthDao.updateByPrimaryKeySelective(fosChannelMonth);
		}
		
		
		
		return i;
	}

	@Override
	public int updateReceiveHistory(FosReceiveOrder fos) {
		FosReceiveOrder fosReceiveOrder = new FosReceiveOrder();
		fosReceiveOrder.setId(fos.getId());
		fosReceiveOrder.setTicketNum(fos.getTicketNum());
		fosReceiveOrder.setDataTime(fos.getDataTime());
		//修改次数
		if(fos.getUpdateBillTime()==1){
			fosReceiveOrder.setUpdateBillTime(fos.getUpdateBillTime());
		}
		int i = receiveOrderDao.updateByPrimaryKeySelective(fosReceiveOrder);
		return i;
	}

	@Override
	public PageBean<FosReceiveOrder> getReceiveOrderList(VoPageBaseBean vpbb) {
		PageBean<FosReceiveOrder> pageBean = new PageBean<FosReceiveOrder>();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(vpbb.getParammap() != null){
			//TODO 添加查询条件
			if(vpbb.getParammap().get("id") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("id").toString())){
				hashMap.put("id", vpbb.getParammap().get("id").toString());
			}
			if(vpbb.getParammap().get("channelOrderName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("channelOrderName").toString())){
				hashMap.put("channelOrderName", "%"+vpbb.getParammap().get("channelOrderName").toString()+"%");
			}
			if(vpbb.getParammap().get("orderName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("orderName").toString())){
				hashMap.put("orderName", "%"+vpbb.getParammap().get("orderName").toString()+"%");
			}
			if(vpbb.getParammap().get("channelName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("channelName").toString())){
				hashMap.put("channelName", "%"+vpbb.getParammap().get("channelName").toString()+"%");
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				hashMap.put("status", vpbb.getParammap().get("status").toString());
			}
			if(vpbb.getParammap().get("receiveStatus") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("receiveStatus").toString())){
				hashMap.put("receiveStatus", vpbb.getParammap().get("receiveStatus").toString());
			}
		}
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}
		hashMap.put("orderByName", "ID desc");
		
		//数据级控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		//查询
		List<FosReceiveOrder> list = receiveOrderDao.getReceiveOrderList(hashMap);
		int i = receiveOrderDao.countGetReceiveOrderList(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	
	}

	@Override
	public int exeReceiveOk(FosReceiveOrder fos) {
		
		//更新fos_receive_order表的收票状态
		FosReceiveOrder fosReceiveOrder = new FosReceiveOrder();
		fosReceiveOrder.setId(fos.getId());
		fosReceiveOrder.setReceiveStatus((byte)2);
		int i = receiveOrderDao.updateByPrimaryKeySelective(fosReceiveOrder);
		
		//更新fos_audit_channel_month表的收票状态：RECEIVE_BILL_STATUS
		String[] ids = fos.getIds().split(",");//渠道对账的id,之前的是可以针对多个渠道对账进行收票，后来改为只只对单个
		for (String s : ids) {
			FosAuditChannelMonth fosAuditChannelMonth = new FosAuditChannelMonth();
			fosAuditChannelMonth.setReceiveBillStatus((byte)2);
			FosAuditChannelMonthExample example = new FosAuditChannelMonthExample();
			com.imopan.adv.platform.entity.fos.FosAuditChannelMonthExample.Criteria criteria = example.createCriteria();
			criteria.andFosChannelMonthIdEqualTo(Integer.valueOf(s));
			auditChannelMonthDao.updateByExampleSelective(fosAuditChannelMonth, example );
		}
		
		FosOrderChannel foc = orderChannelDao.selectByPrimaryKey(fos.getChannelOrderId());
		
		
		FosOrderChannel fosOrderChannel = new FosOrderChannel();
		fosOrderChannel.setAdvancePay(foc.getAdvancePay().subtract(fos.getAdvancePayConsume()));
		fosOrderChannel.setChannelOrderId(fos.getChannelOrderId());
		orderChannelDao.updateByPrimaryKeySelective(fosOrderChannel);
		
		return i;
	}
	
}

