/** 
 * Project Name:adv-business-service1.1 
 * File Name:ChartController.java 
 * Package Name:com.imopan.adv.platform.controller.fos 
 * Date:2016年7月19日上午10:36:45 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.controller.fos;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imopan.adv.platform.common.ResultBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.ChertBean;
import com.imopan.adv.platform.service.fos.IChartService;

/** 
 * ClassName:ChartController <br/> 
 * Function: 画图. <br/>  
 * Date:     2016年7月19日 上午10:36:45 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Controller
@RequestMapping(value="/fos_chart")
public class FosChartController {
	
	private static Logger logger = LoggerFactory.getLogger(FosChartController.class);

	@Autowired
	private IChartService chartServiceImpl;

	/**
	 * 
	 * deleteOcDay:柱形图. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param fos
	 * @param request
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "chartcolumn")
	@ResponseBody
	public ResultBean chartcolumn(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		// 查询 list中保存了成功或者失败信息
		ChertBean p = chartServiceImpl.chartcolumn(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, p, "");
	}
	
	/**
	 * 
	 * chartline:线形图. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "chartline")
	@ResponseBody
	public ResultBean chartline(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		// 查询 list中保存了成功或者失败信息
		ChertBean p = chartServiceImpl.chartline(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, p, "");
	}
	
	/**
	 * 
	 * getAllName:回去所有name信息，根据flag传入职. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getAllName")
	@ResponseBody
	public ResultBean getAllName(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		// 查询 list中保存了成功或者失败信息
		List<Map<String, Object>> p = chartServiceImpl.getAllName(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, p, "");
	}
	
}
