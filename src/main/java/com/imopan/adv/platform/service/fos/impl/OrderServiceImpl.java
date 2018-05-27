/** 
 * Project Name:adv-business-service 
 * File Name:OrderServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年4月19日下午3:43:40 
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosChannelMonth;
import com.imopan.adv.platform.entity.fos.FosChannelMonthExample;
import com.imopan.adv.platform.entity.fos.FosOcDay;
import com.imopan.adv.platform.entity.fos.FosOcDayExample;
import com.imopan.adv.platform.entity.fos.FosOrder;
import com.imopan.adv.platform.entity.fos.FosOrderChannel;
import com.imopan.adv.platform.entity.fos.FosOrderChannelExample;
import com.imopan.adv.platform.entity.fos.FosOrderExample;
import com.imopan.adv.platform.entity.fos.FosOrderExample.Criteria;
import com.imopan.adv.platform.entity.fos.FosOrderMonth;
import com.imopan.adv.platform.entity.fos.FosOrderMonthExample;
import com.imopan.adv.platform.entity.fos.FosTicketOrder;
import com.imopan.adv.platform.entity.fos.FosTicketOrderExample;
import com.imopan.adv.platform.mapper.fos.FosChannelMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosOcDayMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderChannelMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderMonthMapper;
import com.imopan.adv.platform.service.fos.IOrderService;
import com.imopan.adv.platform.util.BeanUtil;
import com.imopan.adv.platform.util.FosDataControllerUtil;
import com.imopan.adv.platform.util.SpringWebUtil;
import com.imopan.adv.platform.vo.fos.FosOrderVo;

/** 
 * ClassName:OrderServiceImpl <br/> 
 * Function: 订单服务. <br/>  
 * Date:     2016年4月19日 下午3:43:40 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class OrderServiceImpl implements IOrderService {
	
	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private FosOrderMapper orderDao;
	@Autowired
	private FosOrderChannelMapper channelOrderDao;
	@Autowired
	private FosOcDayMapper ocDayDao;
	@Autowired
	private FosOrderMonthMapper orderMonthDao;
	@Autowired
	private FosChannelMonthMapper channelMonthDao;
	
	@Override
	public PageBean<FosOrder> selectByExample(VoPageBaseBean vpbb) {
		PageBean<FosOrder> pageBean = new PageBean<FosOrder>();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(vpbb.getParammap() != null){
			//TODO 添加查询条件
			if(vpbb.getParammap().get("orderId") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("orderId").toString())){
				hashMap.put("orderId", vpbb.getParammap().get("orderId").toString());
			}
			if(vpbb.getParammap().get("orderName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("orderName").toString())){
				hashMap.put("orderName", "%"+vpbb.getParammap().get("orderName").toString()+"%");
			}
			if(vpbb.getParammap().get("productName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("productName").toString())){
				hashMap.put("productName", "%"+vpbb.getParammap().get("productName").toString()+"%");
			}
			if(vpbb.getParammap().get("directorName") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("directorName").toString())){
				hashMap.put("directorName", "%"+vpbb.getParammap().get("directorName").toString()+"%");
			}
			if(vpbb.getParammap().get("isSplit") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("isSplit").toString())){
				hashMap.put("isSplit", vpbb.getParammap().get("isSplit").toString());
			}
			if(vpbb.getParammap().get("status") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("status").toString())){
				hashMap.put("status", vpbb.getParammap().get("status").toString());
			}
			/*if(vpbb.getParammap().get("currentDate") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("currentDate").toString())){
				//criteria.andBeginTimeLessThanOrEqualTo(new Date());
				//criteria.andEndTimeGreaterThanOrEqualTo(new Date());
				hashMap.put("currentDate", vpbb.getParammap().get("currentDate").toString());
			}*/
		}
		
		//数据级权限控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}
		
		hashMap.put("orderByName", "ORDER_ID desc");
		
		//查询记录
		List<FosOrder> list = orderDao.selectByExampleDataController(hashMap);
		int i = orderDao.countByExampleDataController(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}
	
	@Override
	@Transactional
	public int insertOrder(FosOrderVo order) {
		//添加字段信息
		order.setCreateTime(new Date());
		order.setModifyTime(new Date());
		String str = order.getDirectorName().split("\\(|\\)")[1];	
		order.setDirectorId(Integer.valueOf(str));
		//保存主订单
		//对象赋值
		FosOrder fosOrder = new FosOrder();
		BeanUtil.copyProperties(order, fosOrder);
		if(fosOrder.getAdvancePay() == null){
			fosOrder.setAdvancePay(new BigDecimal(0));
		}
		int i = orderDao.insert(fosOrder);
		//TODO 添加操作日志
		
		//保存子订单
		if(order.getSplitNameList().size()>=2){
			for (Map<String,String> map : order.getSplitNameList()) {
				String name = map.get("name");
				if(StringUtils.isNotEmpty(name)){
					FosOrder f = new FosOrder();
					BeanUtil.copyProperties(order, f);
					f.setIsSplit(0);
					f.setSplitParent(fosOrder.getOrderId());
					f.setOrderName(name+"【主:"+fosOrder.getOrderName()+"】");
					orderDao.insert(f);
					//TODO 添加操作日志
				}
				
			}
		}
		return i;
	}

	@Override
	@Transactional
	public int updateOrder(FosOrderVo order) {
		//修改订单信息
		FosOrder fosOrder = new FosOrder();
		//对象赋值
		BeanUtil.copyProperties(order, fosOrder);
		fosOrder.setModifyTime(new Date());
		int i = orderDao.updateByPrimaryKeySelective(fosOrder);
		
		//查看该订单是否拥有子订单
		FosOrderExample ex = new FosOrderExample();
		Criteria criteria = ex.createCriteria();
		criteria.andSplitParentEqualTo(fosOrder.getOrderId());
		List<FosOrder> list = orderDao.selectByExample(ex);
		if(list.size()>=2){
			for (FosOrder fos : list) {
				FosOrder f = new FosOrder();
				BeanUtil.copyProperties(fosOrder, f );
				f.setOrderId(fos.getOrderId());
				f.setOrderName(fos.getOrderName().split("【")[0]+"【主:"+fosOrder.getOrderName()+"】");
				f.setIsSplit(0);
				f.setSplitParent(fosOrder.getOrderId());
				orderDao.updateByPrimaryKeySelective(f);
			}
		}
		
		//更新渠道订单中的订单信息
		FosOrderChannelExample example = new FosOrderChannelExample();
		example.createCriteria().andOrderIdEqualTo(order.getOrderId());
		FosOrderChannel record = new FosOrderChannel();
		record.setPayUnit(order.getPayUnit());
		record.setRelationId(order.getRelationId());
		record.setOrderStatus(order.getStatus());
		channelOrderDao.updateByExampleSelective(record, example);
		
		//TODO 该逻辑暂时暂时不用----------start
		/*//为了保证修改的效率，先查询订单信息，看是否修改了负责人信息，如果修改了则更新一下功能；
		FosOrder f = orderDao.selectByPrimaryKey(order.getOrderId());
		if(order.getDirectorName().equals(f.getDirectorId())){
			System.out.println("负责人没有修改！！！");
			return i;
		}*/
		/**
		 * 如果订单负责人变更了，则需要更新每日数据、对账数据、财务数据
		 * 
		 */
		
		/*//更新每日数据
		FosOcDayExample fosOcDayExample = new FosOcDayExample();
		fosOcDayExample.createCriteria().andOrderIdEqualTo(order.getOrderId());
		FosOcDay fosOcDay = new FosOcDay();
		fosOcDay.setOrderDirectorName(order.getDirectorName());
		int j = ocDayDao.updateByExampleSelective(fosOcDay, fosOcDayExample);
		System.out.println("更新每日数据："+j);
		//更新订单对账数据
		FosOrderMonthExample fosOrderMonthExample = new FosOrderMonthExample();
		fosOrderMonthExample.createCriteria().andOrderIdEqualTo(order.getOrderId());
		FosOrderMonth fosOrderMonth = new FosOrderMonth();
		fosOrderMonth.setDirectorName(order.getDirectorName());
		int k = orderMonthDao.updateByExampleSelective(fosOrderMonth, fosOrderMonthExample);
		System.out.println("更新订单对账数据："+k);
		//更新渠道对账数据
		FosChannelMonthExample fosChannelMonthExample = new FosChannelMonthExample();
		fosChannelMonthExample.createCriteria().andOrderIdEqualTo(order.getOrderId());
		FosChannelMonth fosChannelMonth = new FosChannelMonth();
		fosChannelMonth.setOrderDirectorName(order.getDirectorName());
		int l = channelMonthDao.updateByExampleSelective(fosChannelMonth, fosChannelMonthExample);
		System.out.println("更新渠道数据："+l);*/
		//TODO 该逻辑暂时暂时不用----------end
		return i;
	}

	@Override
	public int saveAsOrder(FosOrderVo order) {
		//修改订单信息
		FosOrder fosOrder = new FosOrder();
		//对象赋值
		BeanUtil.copyProperties(order, fosOrder);
		fosOrder.setOrderId(null);
		fosOrder.setRelationId(null);
		fosOrder.setCreateTime(new Date());
		fosOrder.setModifyTime(new Date());
		fosOrder.setIsSplit(0);
		int i = orderDao.insertSelective(fosOrder);
		return i;
	}
	
	
	
	
}
