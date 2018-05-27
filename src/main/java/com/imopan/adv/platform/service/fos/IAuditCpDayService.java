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
 * ClassName:IAuditCpDayService <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年11月3日 上午10:41:12 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IAuditCpDayService {

	int updateAuditCpDay(FosAuditOcDayVo fos);

	int submitAuditCpDay(FosAuditOcDayVo fos);

	void submitBatchAuditCpDay(List<FosAuditOcDayVo> fosList);

	int auditCpDayOk(FosAuditOcDayVo fos);

	int auditCpDayNo(FosAuditOcDayVo fos);

	void submitOkBatchAuditCpDay(List<FosAuditOcDayVo> fosList);

}
