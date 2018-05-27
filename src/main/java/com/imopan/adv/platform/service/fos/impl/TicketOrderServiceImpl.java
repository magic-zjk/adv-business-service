/** 
 * Project Name:adv-business-service 
 * File Name:TicketOrderServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年5月9日下午2:28:56 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosAuditOrderMonth;
import com.imopan.adv.platform.entity.fos.FosAuditOrderMonthExample;
import com.imopan.adv.platform.entity.fos.FosOrder;
import com.imopan.adv.platform.entity.fos.FosOrderMonth;
import com.imopan.adv.platform.entity.fos.FosOrderMonthExample;
import com.imopan.adv.platform.entity.fos.FosTicketOrder;
import com.imopan.adv.platform.entity.fos.FosTicketOrderExample;
import com.imopan.adv.platform.entity.fos.FosTicketOrderExample.Criteria;
import com.imopan.adv.platform.entity.fos.FosTicketOrderImpl;
import com.imopan.adv.platform.mapper.fos.FosAuditOrderMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosTicketOrderMapper;
import com.imopan.adv.platform.service.fos.ITicketOrderService;
import com.imopan.adv.platform.util.FosDataControllerUtil;
import com.imopan.adv.platform.vo.fos.FosTicketOrderVo;

/** 
 * ClassName:TicketOrderServiceImpl <br/> 
 * Function: 出票实现类. <br/>  
 * Date:     2016年5月9日 下午2:28:56 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class TicketOrderServiceImpl implements ITicketOrderService {
	
	@Autowired
	private FosTicketOrderMapper ticketOrderDao;
	@Autowired
	private FosOrderMonthMapper orderMonthDao;
	@Autowired
	private FosOrderMapper orderDao;
	@Autowired
	private FosAuditOrderMonthMapper auditOrderMonthDao;

	@Override
	public PageBean<FosTicketOrder> getDrawList(VoPageBaseBean vpbb) {


		PageBean<FosTicketOrder> pageBean = new PageBean<FosTicketOrder>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName")+"%");
			}
			if(map.get("productName") != null && StringUtils.isNotEmpty(map.get("productName").toString())){
				hashMap.put("productName","%"+map.get("productName")+"%");
			}
			if(map.get("orderId") != null && StringUtils.isNotEmpty(map.get("orderId").toString())){
				hashMap.put("orderId",map.get("orderId"));
			}
			if(map.get("entryBegintime") != null && StringUtils.isNotEmpty(map.get("entryBegintime").toString())){
				hashMap.put("entryBegintime",map.get("entryBegintime").toString().split("T")[0]);
			}
			if(map.get("entryEndtime") != null && StringUtils.isNotEmpty(map.get("entryEndtime").toString())){
				hashMap.put("entryEndtime",map.get("entryEndtime").toString().split("T")[0]);
			}
		}
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
		
		/*List<FosTicketOrder> list = ticketOrderDao.findTicketOrder(hashMap);
		int i = ticketOrderDao.countFindTicketOrder(hashMap);*/
		
		//数据级控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		List<FosTicketOrder> list = ticketOrderDao.findAdutiTicketOrder(hashMap);
		int i = ticketOrderDao.countFindAdutiTicketOrder(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	
	
	}


	@Override
	@Transactional
	public int saveTicketOrder(FosTicketOrder fos) {
		fos.setMoney(fos.getSubOAmount());
		fos.setStatus((byte)0);
		//fos.setDataTime(new Date());
		int j = ticketOrderDao.insertSelective(fos);
		//修改订单对账的状态
		FosOrderMonthExample orderMonthExample = new FosOrderMonthExample();
		com.imopan.adv.platform.entity.fos.FosOrderMonthExample.Criteria criteria = orderMonthExample.createCriteria();
		criteria.andOrderIdEqualTo(fos.getOrderId());
		criteria.andEntryBegintimeEqualTo(fos.getTicketBegintime());
		criteria.andEntryEndtimeEqualTo(fos.getTicketEndtime());
		FosOrderMonth orderMonth = new FosOrderMonth();
		orderMonth.setEntryTicket((byte)2);
		orderMonth.setModifyTime(new Date());
		int i = orderMonthDao.updateByExampleSelective(orderMonth, orderMonthExample);
		//修改订单的预付款金额，为0
		FosOrder fosOrder = new FosOrder();
		fosOrder.setOrderId(fos.getOrderId());
		fosOrder.setAdvancePay(new BigDecimal(0));
		int k = orderDao.updateByPrimaryKeySelective(fosOrder);
		//更新字表DRAW_BILL_STATUS的状态为2
		List<FosOrderMonth> selectByExample = orderMonthDao.selectByExample(orderMonthExample);
		FosAuditOrderMonth fosAuditOrderMonth = new FosAuditOrderMonth();
		fosAuditOrderMonth.setDrawBillStatus((byte)2);
		FosAuditOrderMonthExample fosAuditOrderMonthExample = new FosAuditOrderMonthExample();
		com.imopan.adv.platform.entity.fos.FosAuditOrderMonthExample.Criteria createCriteria = fosAuditOrderMonthExample.createCriteria();
		if(selectByExample.size() == 1){
			createCriteria.andFosOrderMonthIdEqualTo(selectByExample.get(0).getId());
			auditOrderMonthDao.updateByExampleSelective(fosAuditOrderMonth, fosAuditOrderMonthExample);
		}
		return i;
	}


	@Override
	public PageBean<FosTicketOrder> getDrawHistoryList(VoPageBaseBean vpbb) {
		PageBean<FosTicketOrder> pageBean = new PageBean<FosTicketOrder>();
		Map<String,Object> hashMap = new HashMap<String, Object>();
		if(vpbb.getParammap() != null){
			//TODO 添加查询条件
			if(vpbb.getParammap().get("orderName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("orderName").toString())){
				hashMap.put("orderName", "%"+vpbb.getParammap().get("orderName").toString()+"%");
			}
			if(vpbb.getParammap().get("productName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("productName").toString())){
				hashMap.put("productName", "%"+vpbb.getParammap().get("productName").toString()+"%");
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				hashMap.put("status", vpbb.getParammap().get("status").toString());
			}
			if(vpbb.getParammap().get("id") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("id").toString())){
				hashMap.put("id", vpbb.getParammap().get("id").toString());
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
		List<FosTicketOrder> list = ticketOrderDao.getDrawHistoryList(hashMap);
		int i = ticketOrderDao.countGetDrawHistoryList(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}

	@Override
	public PageBean<FosTicketOrderVo> getReceiptHistoryList(VoPageBaseBean vpbb) {
		PageBean<FosTicketOrderVo> pageBean = new PageBean<FosTicketOrderVo>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName")+"%");
			}
			
			if(map.get("orderDepartment") != null && StringUtils.isNotEmpty(map.get("orderDepartment").toString())){
				hashMap.put("orderDepartment", map.get("orderDepartment").toString());
			}
			
			if(map.get("productName") != null && StringUtils.isNotEmpty(map.get("productName").toString())){
				hashMap.put("productName","%"+map.get("productName")+"%");
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				hashMap.put("status",vpbb.getParammap().get("status").toString());
			}
			if(map.get("directorName") != null && StringUtils.isNotEmpty(map.get("directorName").toString())){
				hashMap.put("directorName","%"+map.get("directorName")+"%");
			}
			if(map.get("extendType") != null && StringUtils.isNotEmpty(map.get("extendType").toString())){
				hashMap.put("extendType",map.get("extendType"));
			}
			if(map.get("company") != null && StringUtils.isNotEmpty(map.get("company").toString())){
				hashMap.put("company","%"+map.get("company")+"%");
			}
			if(map.get("entryBegintime") != null && StringUtils.isNotEmpty(map.get("entryBegintime").toString())){
				hashMap.put("entryBegintime",map.get("entryBegintime").toString().split("T")[0]);
			}
			if(map.get("entryEndtime") != null && StringUtils.isNotEmpty(map.get("entryEndtime").toString())){
				hashMap.put("entryEndtime",map.get("entryEndtime").toString().split("T")[0]);
			}
		}
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
		
		//数据级控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		List<FosTicketOrderVo> list = ticketOrderDao.findReceiptHistoryList(hashMap);
		int i = ticketOrderDao.countFindReceiptHistoryList(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}
	
	@Override
	public int saveReceipt(FosTicketOrder fos) {
		FosTicketOrder fosTicketOrder = new FosTicketOrder();
		fosTicketOrder.setId(fos.getId());
		fosTicketOrder.setReturnMoney(fos.getReturnMoney());
		fosTicketOrder.setReturnDate(fos.getReturnDate());
		fosTicketOrder.setReturnTime(new Date());
		fosTicketOrder.setStatus((byte)1);
		int i = ticketOrderDao.updateByPrimaryKeySelective(fosTicketOrder);
		
		//更新订单对账表的entry_ticket状态为3
		FosOrderMonthExample orderMonthExample = new FosOrderMonthExample();
		com.imopan.adv.platform.entity.fos.FosOrderMonthExample.Criteria criteria = orderMonthExample.createCriteria();
		criteria.andOrderIdEqualTo(fos.getOrderId());
		criteria.andEntryBegintimeEqualTo(fos.getTicketBegintime());
		criteria.andEntryEndtimeEqualTo(fos.getTicketEndtime());
		FosOrderMonth orderMonth = new FosOrderMonth();
		orderMonth.setEntryTicket((byte)3);
		orderMonthDao.updateByExampleSelective(orderMonth, orderMonthExample);
		return i;
	}


	@Override
	public PageBean<FosTicketOrderVo> getReceiptHistoryListSum(VoPageBaseBean vpbb) {
		PageBean<FosTicketOrderVo> pageBean = new PageBean<FosTicketOrderVo>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName")+"%");
			}
			
			if(map.get("orderDepartment") != null && StringUtils.isNotEmpty(map.get("orderDepartment").toString())){
				hashMap.put("orderDepartment", map.get("orderDepartment").toString());
			}
			
			if(map.get("productName") != null && StringUtils.isNotEmpty(map.get("productName").toString())){
				hashMap.put("productName","%"+map.get("productName")+"%");
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				hashMap.put("status",vpbb.getParammap().get("status").toString());
			}
			if(map.get("directorName") != null && StringUtils.isNotEmpty(map.get("directorName").toString())){
				hashMap.put("directorName","%"+map.get("directorName")+"%");
			}
			if(map.get("extendType") != null && StringUtils.isNotEmpty(map.get("extendType").toString())){
				hashMap.put("extendType",map.get("extendType"));
			}
			if(map.get("company") != null && StringUtils.isNotEmpty(map.get("company").toString())){
				hashMap.put("company","%"+map.get("company")+"%");
			}
			if(map.get("entryBegintime") != null && StringUtils.isNotEmpty(map.get("entryBegintime").toString())){
				hashMap.put("entryBegintime",map.get("entryBegintime").toString().split("T")[0]);
			}
			if(map.get("entryEndtime") != null && StringUtils.isNotEmpty(map.get("entryEndtime").toString())){
				hashMap.put("entryEndtime",map.get("entryEndtime").toString().split("T")[0]);
			}
		}
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
		
		//数据级控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		List<FosTicketOrderVo> list = ticketOrderDao.findReceiptHistoryListSum(hashMap);
		pageBean.setDataList(list);
		return pageBean;
	}


	@Override
	public int updateDrawHistory(FosTicketOrder fos) {
		FosTicketOrder fosTicketOrder = new FosTicketOrder();
		fosTicketOrder.setId(fos.getId());
		fosTicketOrder.setTicketNum(fos.getTicketNum());
		fosTicketOrder.setIsCashierTicket(fos.getIsCashierTicket());
		fosTicketOrder.setDataTime(fos.getDataTime());
		int i = ticketOrderDao.updateByPrimaryKeySelective(fosTicketOrder);
		return i;
	}


	@Override
	public PageBean<FosTicketOrderImpl> getMonthIncomeHistoryList(VoPageBaseBean vpbb) {
		PageBean<FosTicketOrderImpl> pageBean = new PageBean<FosTicketOrderImpl>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(vpbb.getParammap() != null){
			//TODO 添加查询条件
			if(vpbb.getParammap().get("orderName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("orderName").toString())){
				map.put("orderName", "%"+vpbb.getParammap().get("orderName").toString()+"%");
			}
			if(vpbb.getParammap().get("company") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("company").toString())){
				map.put("company", "%"+vpbb.getParammap().get("company").toString()+"%");
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				map.put("status", Integer.valueOf(vpbb.getParammap().get("status").toString()).byteValue());
			}
			if(vpbb.getParammap().get("id") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("id").toString())){
				map.put("id", Integer.valueOf(vpbb.getParammap().get("id").toString()));
			}
			if(vpbb.getParammap().get("beginTime") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("beginTime").toString())){
				map.put("beginTime", vpbb.getParammap().get("beginTime").toString().split("T")[0]);
			}
			if(vpbb.getParammap().get("endTime") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("endTime").toString())){
				map.put("endTime", vpbb.getParammap().get("endTime").toString().split("T")[0]);
			}
			if(vpbb.getParammap().get("directorId") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("directorId").toString())){
				map.put("directorId", Integer.valueOf(vpbb.getParammap().get("directorId").toString()));
			}
		}
		//数据级权限控制
		FosDataControllerUtil.assignmentMap(map);
				
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			map.put("limitStart", vpbb.getLimitStart());
			map.put("limitEnd", vpbb.getLimitEnd());
		}
		//查询
		List<FosTicketOrderImpl> list = ticketOrderDao.getMonthIncomeHistoryList(map);
		int i = ticketOrderDao.countMonthIncomeByExample(map);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}


	@Override
	public PageBean<FosTicketOrderImpl> getMonthIncomeSum(VoPageBaseBean vpbb) {
		// TODO Auto-generated method stub
		PageBean<FosTicketOrderImpl> pageBean = new PageBean<FosTicketOrderImpl>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(vpbb.getParammap() != null){
			//TODO 添加查询条件
			if(vpbb.getParammap().get("orderName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("orderName").toString())){
				map.put("orderName", "%"+vpbb.getParammap().get("orderName").toString()+"%");
			}
			if(vpbb.getParammap().get("company") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("company").toString())){
				map.put("company", "%"+vpbb.getParammap().get("company").toString()+"%");
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				map.put("status", Integer.valueOf(vpbb.getParammap().get("status").toString()).byteValue());
			}
			if(vpbb.getParammap().get("id") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("id").toString())){
				map.put("id", Integer.valueOf(vpbb.getParammap().get("id").toString()));
			}
			if(vpbb.getParammap().get("beginTime") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("beginTime").toString())){
				map.put("beginTime", vpbb.getParammap().get("beginTime").toString().split("T")[0]);
			}
			if(vpbb.getParammap().get("endTime") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("endTime").toString())){
				map.put("endTime", vpbb.getParammap().get("endTime").toString().split("T")[0]);
			}
			if(vpbb.getParammap().get("directorId") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("directorId").toString())){
				map.put("directorId", Integer.valueOf(vpbb.getParammap().get("directorId").toString()));
			}
		}
		//数据级权限控制
		FosDataControllerUtil.assignmentMap(map);
		//查询
		List<FosTicketOrderImpl> list = ticketOrderDao.getMonthIncomeSum(map);
		pageBean.setDataList(list);
		return pageBean;
	}
	
}
