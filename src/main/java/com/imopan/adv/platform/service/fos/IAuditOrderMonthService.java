/** 
 * Project Name:adv-business-service 
 * File Name:IAuditOrderMonthService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年11月5日下午4:24:16 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;
import com.imopan.adv.platform.vo.fos.FosAuditOrderMonthVo;

/** 
 * ClassName:IAuditOrderMonthService <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年11月5日 下午4:24:16 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IAuditOrderMonthService {

	int submitAuditOrderMonth(FosAuditOrderMonthVo fos);

	int updateOrderMonthAudit(FosAuditOrderMonthVo fos);

	int auditOrderMonthOk(FosAuditOrderMonthVo fos);

	int auditOrderMonthNo(FosAuditOrderMonthVo fos);

	int submitDrawOrderMonth(FosAuditOrderMonthVo fos);

}
