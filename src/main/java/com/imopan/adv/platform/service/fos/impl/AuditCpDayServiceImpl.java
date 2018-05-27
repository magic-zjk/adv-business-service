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

import com.imopan.adv.platform.entity.fos.FosAuditCpDay;
import com.imopan.adv.platform.mapper.fos.FosAuditCpDayMapper;
import com.imopan.adv.platform.service.fos.IAuditCpDayService;
import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;

/**
 * ClassName:AuditCpDayServiceImpl <br/>
 * Function: 财务内核服务. <br/>
 * Date: 2016年11月3日 上午10:42:06 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.7
 */
@Service
public class AuditCpDayServiceImpl implements IAuditCpDayService {
	
	private static Logger logger = LoggerFactory.getLogger(AuditCpDayServiceImpl.class);

	@Autowired
	private FosAuditCpDayMapper auditCpDayDao;

	@Override
	public int updateAuditCpDay(FosAuditOcDayVo fos) {

		FosAuditCpDay record = new FosAuditCpDay();
		record.setId(fos.getAuditCpId());
		record.setCpSubmitOcount(fos.getCpSubmitOcount());
		record.setCpSubmitOamount(fos.getCpSubmitOamount());
		int i = auditCpDayDao.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public int submitAuditCpDay(FosAuditOcDayVo fos) {
		FosAuditCpDay record = new FosAuditCpDay();
		
		record.setId(fos.getAuditCpId());
		if(fos.getFinancialSubmitCpStatus() == null || fos.getFinancialSubmitCpStatus() == 0 || fos.getFinancialSubmitCpStatus() == 2){
			record.setFinancialSubmitCpStatus((byte)1);
			if(fos.getFinancialSubmitCpStatus() == null || fos.getFinancialSubmitCpStatus() == 0){
				record.setOrderSubmitConfirm(new Date());
			}
		}else{
			record.setFinancialSubmitCpStatus(fos.getFinancialSubmitCpStatus());
		}
		int i = auditCpDayDao.updateByPrimaryKeySelective(record);
		return i;
	}

	@Override
	public void submitBatchAuditCpDay(List<FosAuditOcDayVo> fosList) {
		
		for (FosAuditOcDayVo fosAuditOcDayVo : fosList) {
			int i = submitAuditCpDay(fosAuditOcDayVo);
			logger.debug("更新auditCpDay，id="+fosAuditOcDayVo.getAuditCpId()+":"+i);
		}
		
	}

	@Override
	public int auditCpDayOk(FosAuditOcDayVo fos) {
		
		FosAuditCpDay fosAuditCpDay = new FosAuditCpDay();
		
		fosAuditCpDay.setId(fos.getAuditCpId());
		fosAuditCpDay.setFinancialSubmitCpDate(new Date());
		fosAuditCpDay.setFinancialSubmitCpStatus((byte)3);
		if(fos.getFinancialSubmitCpNotthroughTime() <= 0){
			fosAuditCpDay.setFinancialSubmitOcount(fos.getoCount());
			fosAuditCpDay.setFinancialSubmitOamount(fos.getoAmount());
		}else {
			fosAuditCpDay.setFinancialSubmitOcount(fos.getCpSubmitOcount());
			fosAuditCpDay.setFinancialSubmitOamount(fos.getCpSubmitOamount());
		}
		int i = auditCpDayDao.updateByPrimaryKeySelective(fosAuditCpDay);
		return i;
	}

	@Override
	public int auditCpDayNo(FosAuditOcDayVo fos) {
		FosAuditCpDay fosAuditCpDay = new FosAuditCpDay();
		fosAuditCpDay.setId(fos.getAuditCpId());
		fosAuditCpDay.setFinancialSubmitCpNotthroughTime(fos.getFinancialSubmitCpNotthroughTime()+1);
		fosAuditCpDay.setFinancialSubmitCpNotthroughReason(fos.getFinancialSubmitCpNotthroughReason());
		fosAuditCpDay.setFinancialSubmitCpStatus((byte)2);
		int i = auditCpDayDao.updateByPrimaryKeySelective(fosAuditCpDay);
		return i;
	}

	@Override
	public void submitOkBatchAuditCpDay(List<FosAuditOcDayVo> fosList) {
		for (FosAuditOcDayVo fosAuditOcDayVo : fosList) {
			int i = auditCpDayOk(fosAuditOcDayVo);
			logger.debug("更新auditCpDay，id="+fosAuditOcDayVo.getAuditCpId()+":"+i);
		}
		
	}
}
