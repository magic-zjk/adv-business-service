/** 
 * Project Name:adv-business-service 
 * File Name:IAuditCpDayService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年11月3日上午10:41:12 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import java.util.List;

import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;

/** 
 * ClassName:IAuditChannelDayService <br/> 
 * Date:     2016年11月8日 上午10:41:12 <br/> 
 * @author   crystal    
 */
public interface IAuditChannelDayService {

	int updateAuditChannelDay(FosAuditOcDayVo fos);

	int submitAuditChannelDay(FosAuditOcDayVo fos);

	void submitBatchAuditChannelDay(List<FosAuditOcDayVo> fosList);
	
	int auditChannelDayOk(FosAuditOcDayVo fos);

	int auditChannelDayNo(FosAuditOcDayVo fos);

	void submitOkBatchAuditChannelDay(List<FosAuditOcDayVo> fosList);
	
}
