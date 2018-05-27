/** 
 * Project Name:adv-business-service 
 * File Name:ISystemLogService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年6月3日下午4:34:49 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import javax.servlet.http.HttpServletRequest;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosSystemLog;

/** 
 * ClassName:ISystemLogService <br/> 
 * Function: 操作日志接口. <br/>  
 * Date:     2016年6月3日 下午4:34:49 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface ISystemLogService {

	void insertSystemLog(String string, HttpServletRequest request);

	void insertSystemLog(String string, HttpServletRequest request, String table, String column, String value);

	PageBean<FosSystemLog> getSystemlogs(VoPageBaseBean vpbb);

}
