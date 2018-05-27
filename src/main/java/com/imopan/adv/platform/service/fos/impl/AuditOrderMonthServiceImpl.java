/** 
 * Project Name:adv-business-service 
 * File Name:AuditOrderMonthServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年11月5日下午4:25:11 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.entity.fos.FosAuditOrderMonth;
import com.imopan.adv.platform.mapper.fos.FosAuditOrderMonthMapper;
import com.imopan.adv.platform.service.fos.IAuditOrderMonthService;
import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;
import com.imopan.adv.platform.vo.fos.FosAuditOrderMonthVo;

/** 
 * ClassName:AuditOrderMonthServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年11月5日 下午4:25:11 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class AuditOrderMonthServiceImpl implements IAuditOrderMonthService {
	
	@Autowired
	private FosAuditOrderMonthMapper auditOrderMonthDao;

	@Override
	public int submitAuditOrderMonth(FosAuditOrderMonthVo fos) {
		FosAuditOrderMonth fosAuditOrderMonth = new FosAuditOrderMonth();
		fosAuditOrderMonth.setId(fos.getAuditOrderMonthId());
		if(fos.getFinancialSubmitOrderStatus() == null || fos.getFinancialSubmitOrderStatus() == 0 || fos.getFinancialSubmitOrderStatus() == 2 ){
			fosAuditOrderMonth.setFinancialSubmitOrderStatus((byte)1);
			if(fos.getFinancialSubmitOrderStatus() == null || fos.getFinancialSubmitOrderStatus() == 0){
				fosAuditOrderMonth.setOrderSubmitConfirm(new Date());
			}
		}else{
			fosAuditOrderMonth.setFinancialSubmitOrderStatus(fos.getFinancialSubmitOrderStatus());
		}
		int i = auditOrderMonthDao.updateByPrimaryKeySelective(fosAuditOrderMonth);
		
		return i;
	}

	@Override
	public int updateOrderMonthAudit(FosAuditOrderMonthVo fos) {
		
		FosAuditOrderMonth fosAuditOrderMonth = new FosAuditOrderMonth();
		fosAuditOrderMonth.setId(fos.getAuditOrderMonthId());
		fosAuditOrderMonth.setOrderUpdateOCount(fos.getOrderUpdateOCount());
		fosAuditOrderMonth.setOrderUpdateOAmount(fos.getOrderUpdateOAmount());
		fosAuditOrderMonth.setOrderUpdateCut(fos.getOrderUpdateCut());
		fosAuditOrderMonth.setOrderUpdateSaleRebate(fos.getOrderUpdateSaleRebate());
		int i = auditOrderMonthDao.updateByPrimaryKeySelective(fosAuditOrderMonth);
		return i;
	}

	@Override
	public int auditOrderMonthOk(FosAuditOrderMonthVo fos) {
		
		FosAuditOrderMonth fosAuditOrderMonth = new FosAuditOrderMonth();
		fosAuditOrderMonth.setId(fos.getAuditOrderMonthId());
		
		fosAuditOrderMonth.setFinancialSubmitOrderDate(new Date());
		fosAuditOrderMonth.setFinancialSubmitOrderStatus((byte)3);
		if(fos.getFinancialSubmitOrderNotthroughTime() <= 0){
			fosAuditOrderMonth.setFinancialSubmitOCount(fos.getoCount());
			fosAuditOrderMonth.setFinancialSubmitOAmount(fos.getoAmount());
			fosAuditOrderMonth.setFinancialSubmitCut(fos.getCut());
			fosAuditOrderMonth.setFinancialSubmitSaleRebate(fos.getSaleRebate());
		}else{
			fosAuditOrderMonth.setFinancialSubmitOCount(fos.getOrderUpdateOCount());
			fosAuditOrderMonth.setFinancialSubmitOAmount(fos.getOrderUpdateOAmount());
			fosAuditOrderMonth.setFinancialSubmitCut(fos.getOrderUpdateCut());
			fosAuditOrderMonth.setFinancialSubmitSaleRebate(fos.getOrderUpdateSaleRebate());
		}
		
		int i = auditOrderMonthDao.updateByPrimaryKeySelective(fosAuditOrderMonth);
		
		//计算平均值
		
		
		return i;
	}

	@Override
	public int auditOrderMonthNo(FosAuditOrderMonthVo fos) {
		FosAuditOrderMonth fosAuditOrderMonth = new FosAuditOrderMonth();
		fosAuditOrderMonth.setId(fos.getAuditOrderMonthId());
		
		fosAuditOrderMonth.setFinancialSubmitOrderNotthroughTime(fos.getFinancialSubmitOrderNotthroughTime()+1);
		fosAuditOrderMonth.setFinancialSubmitOrderNotthroughReason(fos.getFinancialSubmitOrderNotthroughReason());
		fosAuditOrderMonth.setFinancialSubmitOrderStatus((byte)2);
		int i = auditOrderMonthDao.updateByPrimaryKeySelective(fosAuditOrderMonth);
		return i;
	}

	@Override
	public int submitDrawOrderMonth(FosAuditOrderMonthVo fos) {
		FosAuditOrderMonth fosAuditOrderMonth = new FosAuditOrderMonth();
		fosAuditOrderMonth.setId(fos.getAuditOrderMonthId());
		if(fos.getDrawBillStatus() == 0){
			fosAuditOrderMonth.setDrawBillStatus((byte)1);
			int i = auditOrderMonthDao.updateByPrimaryKeySelective(fosAuditOrderMonth);
			return i;
		}
		return 0;
	}

}
