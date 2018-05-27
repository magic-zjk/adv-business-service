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
import com.imopan.adv.platform.entity.fos.FosDailyBill;
import com.imopan.adv.platform.entity.fos.FosOcDay;
import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;
import com.imopan.adv.platform.vo.fos.FosOcDayVo;

/** 
 * ClassName:IOcDayService <br/> 
 * Function: 每日订单渠道维护接口 <br/>  
 * Date:     2016年4月25日 下午3:23:12 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IOcDayService {

	PageBean<FosOcDay> getOcDayList(VoPageBaseBean vpbb);

	int saveOcDay(FosOcDayVo fos);

	List<FosOcDay> updateOcDay(List<FosOcDay> fos);

	int deleteOcDay(FosOcDay fos);

	int updateHistoryOcDay(FosOcDay fos);

	PageBean<FosDailyBill> getDayBillList(VoPageBaseBean vpbb);

	int deleteHistoryOcDay(FosAuditOcDayVo fos);


	FosOcDay selectByPrimaryKey(Integer id);

	PageBean<FosOcDay> getOcDayListSum(VoPageBaseBean vpbb);
	
	PageBean<FosAuditOcDayVo> getOcDayInfoSum(VoPageBaseBean vpbb);

	PageBean<FosAuditOcDayVo> getAuditOcDayList(VoPageBaseBean vpbb);

}
