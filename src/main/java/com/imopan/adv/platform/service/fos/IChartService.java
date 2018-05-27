/** 
 * Project Name:adv-business-service1.1 
 * File Name:IChartService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年7月19日上午10:45:59 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import java.util.List;
import java.util.Map;

import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.ChertBean;

/** 
 * ClassName:IChartService <br/> 
 * Function: 画图服务. <br/>  
 * Date:     2016年7月19日 上午10:45:59 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IChartService {

	ChertBean chartcolumn(VoPageBaseBean vpbb);

	ChertBean chartline(VoPageBaseBean vpbb);

	List<Map<String, Object>> getAllName(VoPageBaseBean vpbb);

}
