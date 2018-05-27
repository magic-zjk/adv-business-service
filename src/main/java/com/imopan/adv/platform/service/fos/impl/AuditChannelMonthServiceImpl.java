/** 
 * Project Name:adv-business-service 
 * File Name:AuditOrderMonthServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年11月5日下午4:25:11 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosAuditChannelMonth;
import com.imopan.adv.platform.entity.fos.FosAuditChannelMonthExample;
import com.imopan.adv.platform.entity.fos.FosOcDay;
import com.imopan.adv.platform.entity.fos.FosOcDayExample;
import com.imopan.adv.platform.entity.fos.FosReceiveOrder;
import com.imopan.adv.platform.mapper.fos.FosAuditChannelMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosOcDayMapper;
import com.imopan.adv.platform.mapper.fos.FosReceiveOrderMapper;
import com.imopan.adv.platform.service.fos.IAuditChannelMonthService;
import com.imopan.adv.platform.util.BeanUtil;
import com.imopan.adv.platform.util.FosDataControllerUtil;
import com.imopan.adv.platform.vo.fos.FosAuditChannelMonthVo;
import com.imopan.adv.platform.vo.fos.FosPrePayChannelVo;
import com.imopan.adv.platform.vo.fos.FosReceiveOrderV2Vo;

/** 
 * AuditChannelMonthServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年11月5日 下午4:25:11 <br/> 
 * @author   gcq 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class AuditChannelMonthServiceImpl implements IAuditChannelMonthService {
	
	@Autowired
	private FosAuditChannelMonthMapper auditChannelMonthDao;
	@Autowired
	private FosReceiveOrderMapper fosReceiveOrderMapper;
	@Autowired
	private FosOcDayMapper ocDayDao;

	@Override
	public int updateChannelMonthAudit(FosAuditChannelMonthVo fos) {
		FosAuditChannelMonth facm=new FosAuditChannelMonth();
		facm.setId(fos.getAuditChannelMonthId());
		facm.setChannelUpdateMediaRebate(fos.getChannelUpdateMediaRebate());
		facm.setChannelUpdateOtherExpense(fos.getChannelUpdateOtherExpense());
		facm.setChannelUpdateChannelCut(fos.getChannelUpdateChannelCut());
		int affectnum=auditChannelMonthDao.updateByPrimaryKeySelective(facm);
		return affectnum;
	}

	@Override
	public int updateChannelMonthAuditStatus(FosAuditChannelMonthVo fos) {
		int affectnum =0;
		FosAuditChannelMonth facm=new FosAuditChannelMonth();
		facm.setId(fos.getAuditChannelMonthId());
		if(fos.getFinancialSubmitChannelStatus()==3){//
			if(fos.getFinancialSubmitChannelNotthroughTime()==0){
				facm.setFinancialSubmitMediaRebate(fos.getMediaRebate());
				facm.setFinancialSubmitOtherExpense(fos.getOtherExpense());
				facm.setFinancialSubmitChannelCut(fos.getChannelCut());
			}else{
				facm.setFinancialSubmitMediaRebate(fos.getChannelUpdateMediaRebate());
				facm.setFinancialSubmitOtherExpense(fos.getChannelUpdateOtherExpense());
				facm.setFinancialSubmitChannelCut(fos.getChannelUpdateChannelCut());
			}
			facm.setFinancialSubmitChannelDate(new Date());
			facm.setFinancialSubmitChannelStatus((byte)3);
			affectnum=auditChannelMonthDao.updateByPrimaryKeySelective(facm);
			
			//财务确认通过后需要将媒体返点、其他支出、核减支出平均到每日数据中
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
			
			FosOcDay fosOcDay = new FosOcDay();
			if(fos.getMediaRebate() != null){
				fosOcDay.setAvgMediaRebate(facm.getFinancialSubmitMediaRebate().divide(new BigDecimal(j),4, BigDecimal.ROUND_HALF_EVEN));
			}
			if(fos.getOtherExpense() != null){
				fosOcDay.setAvgOtherExpense(facm.getFinancialSubmitOtherExpense().divide(new BigDecimal(j),4, BigDecimal.ROUND_HALF_EVEN));
			}
			if(fos.getChannelCut() != null){
				fosOcDay.setAvgChannelCut(facm.getFinancialSubmitChannelCut().divide(new BigDecimal(j),4, BigDecimal.ROUND_HALF_EVEN));
			}
			ocDayDao.updateByExampleSelective(fosOcDay, ocDayExample);//平均媒体返点、平均其他支出、平均核减金额
			
			
		}else if(fos.getFinancialSubmitChannelStatus()==2){
			facm.setFinancialSubmitChannelStatus((byte)2);
			facm.setFinancialSubmitChannelNotthroughReason(fos.getFinancialSubmitChannelNotthroughReason());
			facm.setFinancialSubmitChannelNotthroughTime(fos.getFinancialSubmitChannelNotthroughTime()+1);
			affectnum=auditChannelMonthDao.updateByPrimaryKeySelective(facm);
		}else{
			facm.setFinancialSubmitChannelStatus(fos.getFinancialSubmitChannelStatus());
			affectnum=auditChannelMonthDao.updateByPrimaryKeySelective(facm);
		}
		return affectnum;
	}

	@Override
	public int submitReceiveChannelMonth(FosReceiveOrderV2Vo fos) {
		FosReceiveOrder frio2=new FosReceiveOrder();
		BeanUtil.copyProperties(fos, frio2);
		int affectnum = fosReceiveOrderMapper.insertSelective(frio2);
		
		FosAuditChannelMonthExample fosAuditChannelMonthExample = new FosAuditChannelMonthExample();
		fosAuditChannelMonthExample.createCriteria().andFosChannelMonthIdEqualTo(Integer.valueOf(fos.getIds()));
		FosAuditChannelMonth facm=new FosAuditChannelMonth();
		facm.setReceiveBillStatus((byte)1);
		auditChannelMonthDao.updateByExampleSelective(facm, fosAuditChannelMonthExample);
		return affectnum;
	}

	@Override
	public PageBean<FosPrePayChannelVo> getPrePaymentChannelList(VoPageBaseBean vpbb) {

		PageBean<FosPrePayChannelVo> pageBean = new PageBean<FosPrePayChannelVo>();
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("limitstart", vpbb.getLimitStart());
		map.put("limitend", vpbb.getLimitEnd());
		HashMap<String, Object> parammap = vpbb.getParammap();
		if(!"".equals(parammap.get("ordername"))){
			map.put("ordername", parammap.get("ordername"));
		}
		if(!"".equals(parammap.get("channelname"))){
			map.put("channelname", parammap.get("channelname"));
		}
		
		//数据级控制
		FosDataControllerUtil.assignmentMap(map);
		
		
		List<FosPrePayChannelVo> list = fosReceiveOrderMapper.getPrePaymentChannelList(map);
		int i = fosReceiveOrderMapper.getPrePaymentChannelList_count(map);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}

	@Override
	public FosPrePayChannelVo getPrePaymentChannelList_TotalAndRemain(VoPageBaseBean vpbb) {
		PageBean<FosPrePayChannelVo> pageBean = new PageBean<FosPrePayChannelVo>();
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("limitstart", vpbb.getLimitStart());
		map.put("limitend", vpbb.getLimitEnd());
		HashMap<String, Object> parammap = vpbb.getParammap();
		if(!"".equals(parammap.get("ordername"))){
			map.put("ordername", parammap.get("ordername"));
		}
		if(!"".equals(parammap.get("channelname"))){
			map.put("channelname", parammap.get("channelname"));
		}
		FosPrePayChannelVo fos = fosReceiveOrderMapper.getPrePaymentChannelList_TotalAndRemain(map);
		return fos;
	}

	@Override
	public PageBean<FosReceiveOrder> getPrePaymentChannelListDetial(VoPageBaseBean vpbb) {
		PageBean<FosReceiveOrder> pageBean = new PageBean<FosReceiveOrder>();
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		HashMap<String, Object> parammap = vpbb.getParammap();
		if(!"".equals(parammap.get("channelorderid"))){
			map.put("channelorderid", parammap.get("channelorderid"));
		}
		List<FosReceiveOrder> list = fosReceiveOrderMapper.getPrePaymentChannelListDetial(map);
		pageBean.setDataList(list);
		return pageBean;
	}


}
