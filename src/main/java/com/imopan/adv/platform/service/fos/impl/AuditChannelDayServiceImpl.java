/** 
 * Project Name:adv-business-service 
 * File Name:AuditCpDayServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年11月3日上午10:42:06 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
 */

package com.imopan.adv.platform.service.fos.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.entity.fos.FosAuditChannelDay;
import com.imopan.adv.platform.mapper.fos.FosAuditChannelDayMapper;
import com.imopan.adv.platform.service.fos.IAuditChannelDayService;
import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;

/**
 * ClassName:AuditChannelDayServiceImpl <br/>
 * Date: 2016年11月8日 上午10:42:06 <br/>
 * 
 * @author crystal
 * @version
 */
@Service
public class AuditChannelDayServiceImpl implements IAuditChannelDayService {
	
	private static Logger logger = LoggerFactory.getLogger(AuditChannelDayServiceImpl.class);

	@Autowired
	private FosAuditChannelDayMapper auditChannelDayDao;

	@Override
	public int updateAuditChannelDay(FosAuditOcDayVo fos) {

		FosAuditChannelDay record = new FosAuditChannelDay();
		record.setId(fos.getAuditChannelId());
		record.setChannelSubmitCcount(fos.getChannelSubmitCcount());
		record.setChannelSubmitCamount(fos.getChannelSubmitCamount());
		int i = auditChannelDayDao.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public int submitAuditChannelDay(FosAuditOcDayVo fos) {
		FosAuditChannelDay record = new FosAuditChannelDay();
		
		record.setId(fos.getAuditChannelId());
		if(fos.getFinancialSubmitChannelStatus() == null || fos.getFinancialSubmitChannelStatus() == 0 || fos.getFinancialSubmitChannelStatus() == 2){
			record.setFinancialSubmitChannelStatus((byte)1);
			if(fos.getFinancialSubmitChannelStatus() == null || fos.getFinancialSubmitChannelStatus() == 0){
				record.setChannelSubmitConfirm(new Date());
			}
		}else{
			record.setFinancialSubmitChannelStatus(fos.getFinancialSubmitChannelStatus());
		}
		int i = auditChannelDayDao.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public void submitBatchAuditChannelDay(List<FosAuditOcDayVo> fosList) {
		
		for (FosAuditOcDayVo fosAuditOcDayVo : fosList) {
			int i = submitAuditChannelDay(fosAuditOcDayVo);
			logger.debug("更新auditChannelDay，id="+fosAuditOcDayVo.getAuditChannelId()+":"+i);
		}
	}

	
	@Override
	public int auditChannelDayOk(FosAuditOcDayVo fos) {
		FosAuditChannelDay fosAuditChannelDay = new FosAuditChannelDay();
		
		fosAuditChannelDay.setId(fos.getAuditChannelId());
		fosAuditChannelDay.setFinancialSubmitChannelDate(new Date());
		fosAuditChannelDay.setFinancialSubmitChannelStatus((byte)3);
		if(fos.getFinancialSubmitChannelNotthroughTime() <= 0){
			fosAuditChannelDay.setFinancialSubmitCcount(fos.getcCount());
			fosAuditChannelDay.setFinancialSubmitCamount(fos.getcAmount());
		}else {
			fosAuditChannelDay.setFinancialSubmitCcount(fos.getChannelSubmitCcount());
			fosAuditChannelDay.setFinancialSubmitCamount(fos.getChannelSubmitCamount());
		}
		int i = auditChannelDayDao.updateByPrimaryKeySelective(fosAuditChannelDay);
		return i;
	}

	@Override
	public int auditChannelDayNo(FosAuditOcDayVo fos) {
		FosAuditChannelDay fosAuditChannelDay = new FosAuditChannelDay();
		fosAuditChannelDay.setId(fos.getAuditChannelId());
		fosAuditChannelDay.setFinancialSubmitChannelNotthroughTime(fos.getFinancialSubmitChannelNotthroughTime()+1);
		fosAuditChannelDay.setFinancialSubmitChannelNotthroughReason(fos.getFinancialSubmitChannelNotthroughReason());
		fosAuditChannelDay.setFinancialSubmitChannelStatus((byte)2);
		int i = auditChannelDayDao.updateByPrimaryKeySelective(fosAuditChannelDay);
		return i;
	}

	@Override
	public void submitOkBatchAuditChannelDay(List<FosAuditOcDayVo> fosList) {
		for (FosAuditOcDayVo fosAuditOcDayVo : fosList) {
			int i = auditChannelDayOk(fosAuditOcDayVo);
			logger.debug("更新auditChannelDay，id="+fosAuditOcDayVo.getAuditCpId()+":"+i);
		}
	}
	
}
