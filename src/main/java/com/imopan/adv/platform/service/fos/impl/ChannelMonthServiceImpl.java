/** 
 * Project Name:adv-business-service 
 * File Name:ChannelMonthServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年5月3日下午3:16:14 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.imopan.adv.platform.entity.fos.FosAuditChannelMonth;
import com.imopan.adv.platform.entity.fos.FosChannelMonth;
import com.imopan.adv.platform.entity.fos.FosOcDay;
import com.imopan.adv.platform.entity.fos.FosOcDayExample;
import com.imopan.adv.platform.mapper.fos.FosAuditChannelMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosChannelMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosOcDayMapper;
import com.imopan.adv.platform.service.fos.IChannelMonthService;
import com.imopan.adv.platform.util.FosDataControllerUtil;
import com.imopan.adv.platform.vo.fos.FosAuditChannelMonthVo;

/** 
 * ClassName:ChannelMonthServiceImpl <br/> 
 * Function: 渠道对账实现类. <br/>  
 * Date:     2016年5月3日 下午3:16:14 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class ChannelMonthServiceImpl implements IChannelMonthService {

	@Autowired
	private FosChannelMonthMapper channelMonthDao;
	@Autowired
	private FosOcDayMapper ocDayDao;
	@Autowired
	private FosAuditChannelMonthMapper auditChannelDayDao;

	
	@Override
	public PageBean<FosChannelMonth> getChannelMonthList(VoPageBaseBean vpbb) {

		PageBean<FosChannelMonth> pageBean = new PageBean<FosChannelMonth>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName")+"%");
			}
			if(map.get("productName") != null && StringUtils.isNotEmpty(map.get("productName").toString())){
				hashMap.put("productName","%"+map.get("productName")+"%");
			}
			if(map.get("channelName") != null && StringUtils.isNotEmpty(map.get("channelName").toString())){
				hashMap.put("channelName","%"+map.get("channelName")+"%");
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
		
		//数据级权限控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		List<FosChannelMonth> list = channelMonthDao.findChannelMonth(hashMap);
		int i = channelMonthDao.countFindChannelMonth(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	
	}

	@Override
	@Transactional
	public int checkchannelmonth(FosChannelMonth fos) {
		//查询所有符合条件的每日数据，如果每日数据中的CHANNEL_MONTH_STATUS的值为1,则返回不可对账。
		FosOcDayExample ocDayExample = new FosOcDayExample();
		com.imopan.adv.platform.entity.fos.FosOcDayExample.Criteria criteria = ocDayExample.createCriteria();
		criteria.andChannelOrderIdEqualTo(fos.getChannelOrderId());
		criteria.andEntryDayStatusEqualTo((byte)1);
		criteria.andOcDayStatusEqualTo((byte)0);
		criteria.andEntryTimeGreaterThanOrEqualTo(fos.getEntryBegintime());
		criteria.andEntryTimeLessThanOrEqualTo(fos.getEntryEndtime());
		//int k = ocDayDao.countByExample(ocDayExample);
		criteria.andChannelMonthStatusEqualTo((byte)1);
		int j = ocDayDao.countByExample(ocDayExample);
		
		if(j>=1){
			return -1;
		}
		/*FosOcDay fosOcDay = new FosOcDay();
		fosOcDay.setChannelMonthStatus((byte)1);*/
		/*if(fos.getMediaRebate() != null){
			fosOcDay.setAvgMediaRebate(fos.getMediaRebate().divide(new BigDecimal(k),4, BigDecimal.ROUND_HALF_EVEN));
		}
		if(fos.getOtherExpense() != null){
			fosOcDay.setAvgOtherExpense(fos.getOtherExpense().divide(new BigDecimal(k),4, BigDecimal.ROUND_HALF_EVEN));
		}
		if(fos.getChannelCut() != null){
			fosOcDay.setAvgChannelCut(fos.getChannelCut().divide(new BigDecimal(k),4, BigDecimal.ROUND_HALF_EVEN));
		}*/
		
		/*FosOcDayExample ocDayExample1 = new FosOcDayExample();
		com.imopan.adv.platform.entity.fos.FosOcDayExample.Criteria criteria1 = ocDayExample1.createCriteria();
		criteria1.andChannelOrderIdEqualTo(fos.getChannelOrderId());
		criteria1.andEntryDayStatusEqualTo((byte)1);
		criteria1.andOcDayStatusEqualTo((byte)0);
		criteria1.andEntryTimeGreaterThanOrEqualTo(fos.getEntryBegintime());
		criteria1.andEntryTimeLessThanOrEqualTo(fos.getEntryEndtime());*/
		
		//ocDayDao.updateByExampleSelective(fosOcDay, ocDayExample1);//更新每日数据的渠道对账状态、平均媒体返点、平均其他支出、平均核减金额
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("channelOrderId", fos.getChannelOrderId());
		map.put("entryDayStatus", 1);
		map.put("ocDayStatus", 0);
		map.put("entryBegintime", fos.getEntryBegintime());
		map.put("entryEndtime", fos.getEntryEndtime());
		map.put("financialSubmitChannelStatus", 3);
		ocDayDao.updateChannelMonthStatus(map);////更新每日数据的渠道对账状态
		
		
		fos.setcCount(fos.getcCountSum());
		fos.setcAmount(fos.getcAmountSum());
		fos.setCreateTime(new Date());
		fos.setModifyTime(new Date());
		fos.setSubAmount(fos.getcAmount());
		if(fos.getMediaRebate() != null){
			fos.setSubAmount(fos.getcAmount().add(fos.getMediaRebate()));
		}else {
			fos.setSubAmount(fos.getcAmount());
		}
		if(fos.getOtherExpense() != null){
			fos.setSubAmount(fos.getSubAmount().add(fos.getOtherExpense()));
		}
		if(fos.getChannelCut() != null){
			fos.setSubAmount(fos.getSubAmount().subtract(fos.getChannelCut()));
		}
		fos.setEntryMoney((byte)1);
		fos.setEntryTicket((byte)1);
		
		int i = channelMonthDao.insertSelectiveGetId(fos);
		
		FosAuditChannelMonth fosAuditChannelMonth = new FosAuditChannelMonth();
		fosAuditChannelMonth.setFosChannelMonthId(fos.getId());
		fosAuditChannelMonth.setChannelSubmitConfirm(new Date());
		fosAuditChannelMonth.setFinancialSubmitChannelStatus((byte)1);
		fosAuditChannelMonth.setReceiveBillStatus((byte)0);
		int m = auditChannelDayDao.insertSelective(fosAuditChannelMonth);
		
		
		
		return i;
	}

	@Override
	public PageBean<FosAuditChannelMonthVo> getChannelMonthHistoryList(VoPageBaseBean vpbb) {

		PageBean<FosAuditChannelMonthVo> pageBean = new PageBean<FosAuditChannelMonthVo>();
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("limitstart", vpbb.getLimitStart());
		map.put("limitend", vpbb.getLimitEnd());
		HashMap<String, Object> parammap = vpbb.getParammap();
		if(!"".equals(parammap.get("status"))){
			map.put("status", parammap.get("status"));
		}
		if(!"".equals(parammap.get("receivebillstatus"))){
			map.put("receivebillstatus", parammap.get("receivebillstatus"));
		}
		if(!"".equals(parammap.get("times"))){
			map.put("times", parammap.get("times"));
		}
		if(!"".equals(parammap.get("ordername"))){
			map.put("ordername", parammap.get("ordername"));
		}
		if(!"".equals(parammap.get("channelname"))){
			map.put("channelname", parammap.get("channelname"));
		}
		
		if(parammap.get("orderDepartment") != null && StringUtils.isNotEmpty(parammap.get("orderDepartment").toString())){
			map.put("orderDepartment", parammap.get("orderDepartment").toString());
		}
		
		//数据级权限控制
		FosDataControllerUtil.assignmentMap(map);
		
		List<FosAuditChannelMonthVo> list = channelMonthDao.getChannelMonthHistoryList(map);
		int i = channelMonthDao.getChannelMonthHistoryList_count(map);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}

	@Override
	@Transactional
	public int updateChannelMonth(FosChannelMonth fos) {
		FosChannelMonth fosChannelMonth = new FosChannelMonth();
		fosChannelMonth.setId(fos.getId());
		fosChannelMonth.setMediaRebate(fos.getMediaRebate());
		fosChannelMonth.setOtherExpense(fos.getOtherExpense());
		fosChannelMonth.setChannelCut(fos.getChannelCut());
		fosChannelMonth.setModifyTime(new Date());
		fosChannelMonth.setSubAmount(fos.getcAmount());
		if(fos.getMediaRebate() != null){
			fosChannelMonth.setSubAmount(fos.getcAmount().add(fos.getMediaRebate()));
		}else {
			fosChannelMonth.setSubAmount(fos.getcAmount());
		}
		if(fos.getOtherExpense() != null){
			fosChannelMonth.setSubAmount(fosChannelMonth.getSubAmount().add(fos.getOtherExpense()));
		}
		if(fos.getChannelCut() != null){
			fosChannelMonth.setSubAmount(fosChannelMonth.getSubAmount().subtract(fos.getChannelCut()));
		}
		int i = channelMonthDao.updateByPrimaryKeySelective(fosChannelMonth);
		
		
		//更新每日订单渠道数据
		
		FosOcDayExample ocDayExample = new FosOcDayExample();
		com.imopan.adv.platform.entity.fos.FosOcDayExample.Criteria criteria = ocDayExample.createCriteria();
		criteria.andChannelOrderIdEqualTo(fos.getChannelOrderId());
		criteria.andEntryDayStatusEqualTo((byte)1);
		criteria.andOcDayStatusEqualTo((byte)0);
		criteria.andEntryTimeGreaterThanOrEqualTo(fos.getEntryBegintime());
		criteria.andEntryTimeLessThanOrEqualTo(fos.getEntryEndtime());
		int k = ocDayDao.countByExample(ocDayExample);
		
		FosOcDay fosOcDay = new FosOcDay();
		if(fos.getMediaRebate() != null){
			fosOcDay.setAvgMediaRebate(fos.getMediaRebate().divide(new BigDecimal(k),4, BigDecimal.ROUND_HALF_EVEN));
		}
		if(fos.getOtherExpense() != null){
			fosOcDay.setAvgOtherExpense(fos.getOtherExpense().divide(new BigDecimal(k),4, BigDecimal.ROUND_HALF_EVEN));
		}
		if(fos.getChannelCut() != null){
			fosOcDay.setAvgChannelCut(fos.getChannelCut().divide(new BigDecimal(k),4, BigDecimal.ROUND_HALF_EVEN));
		}

		fosOcDay.setChannelMonthStatus((byte)1);
		ocDayDao.updateByExampleSelective(fosOcDay, ocDayExample);//更新每日数据的渠道对账状态、平均媒体返点、平均其他支出
	
		return i;
	}

	@Override
	public PageBean<FosChannelMonth> getChannelMonthReceiveList(VoPageBaseBean vpbb) {

		PageBean<FosChannelMonth> pageBean = new PageBean<FosChannelMonth>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		
		if(map != null){

			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName")+"%");
			}
			if(map.get("channelName") != null && StringUtils.isNotEmpty(map.get("channelName").toString())){
				hashMap.put("channelName", "%"+map.get("channelName")+"%");
			}
			if(map.get("id") != null && StringUtils.isNotEmpty(map.get("id").toString())){
				hashMap.put("id", map.get("id").toString());
			}
			if(map.get("entryBegintime") != null && StringUtils.isNotEmpty(map.get("entryBegintime").toString())){
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(map.get("entryBegintime").toString());
					hashMap.put("entryBegintime", date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			if(map.get("entryEndtime") != null && StringUtils.isNotEmpty(map.get("entryEndtime").toString())){
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(map.get("entryEndtime").toString());
					hashMap.put("entryEndtime", date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(map.get("status") != null && StringUtils.isNotEmpty(map.get("status").toString())){
				hashMap.put("status", Integer.valueOf(map.get("status").toString()).byteValue());
			}
			if(map.get("entryMoney") != null && StringUtils.isNotEmpty(map.get("entryMoney").toString())){
				hashMap.put("entryMoney", Integer.valueOf(map.get("entryMoney").toString()).byteValue());
			}
			if(map.get("entryTicket") != null && StringUtils.isNotEmpty(map.get("entryTicket").toString())){
				hashMap.put("entryTicket", Integer.valueOf(map.get("entryTicket").toString()).byteValue());
			}
		
		}
		
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
		
		hashMap.put("OrderByClause", "MODIFY_TIME desc");
		//查询
		List<FosChannelMonth> list = channelMonthDao.findChannelMonthForReceive(hashMap);
		int i = channelMonthDao.countFindChannelMonthForReceive(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		
		return pageBean;
	
	}


	

}
