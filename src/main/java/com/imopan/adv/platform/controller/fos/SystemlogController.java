/** 
 * Project Name:adv-business-service1.1 
 * File Name:SystemlogController.java 
 * Package Name:com.imopan.adv.platform.controller.fos 
 * Date:2016年7月9日下午4:44:03 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.controller.fos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.ResultBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosDailyBill;
import com.imopan.adv.platform.entity.fos.FosSystemLog;
import com.imopan.adv.platform.service.fos.ISystemLogService;

/** 
 * ClassName:SystemlogController <br/> 
 * Function: 系统日志. <br/>  
 * Date:     2016年7月9日 下午4:44:03 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Controller
@RequestMapping(value="/systemlog")
public class SystemlogController {

	private static Logger foslog = LoggerFactory.getLogger(SystemlogController.class);
	
	@Autowired
	private ISystemLogService systemLogServiceImpl;
	
	
	/**
	 * 
	 * getSystemlogs:查询系统日志. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getSystemlogs")
	@ResponseBody
	public ResultBean getSystemlogs(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		// 查询
		PageBean<FosSystemLog> result = systemLogServiceImpl.getSystemlogs(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
	}
}
