/** 
 * Project Name:adv-business-service 
 * File Name:IOcDayService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年4月25日下午3:23:12 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import java.util.List;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;

/** 
 * ClassName:IIncomeAndCostService <br/> 
 * Function: 每日订单渠道维护接口 <br/>  
 * Date:     2016年4月25日 下午3:23:12 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IIncomeAndCostService {

	PageBean<FosAuditOcDayVo> getIncomeAndCostList(VoPageBaseBean vpbb);

	PageBean<FosAuditOcDayVo> getIncomeAndCostInfoSum(VoPageBaseBean vpbb);

	int saveIncomeAndCost(FosAuditOcDayVo fos);

	void addIncomeAndCostList(List<FosAuditOcDayVo> fosList);

	PageBean<FosAuditOcDayVo> getIncomeCostHistoryList(VoPageBaseBean vpbb);

	PageBean<FosAuditOcDayVo> getIncomeCostHistorySum(VoPageBaseBean vpbb);

}
