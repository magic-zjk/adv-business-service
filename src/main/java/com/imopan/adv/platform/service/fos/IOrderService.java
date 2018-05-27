/** 
 * Project Name:adv-business-service 
 * File Name:IOrderService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年4月19日下午3:42:27 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosOrder;
import com.imopan.adv.platform.vo.fos.FosOrderVo;

/** 
 * ClassName:IOrderService <br/> 
 * Function: 订单接口 <br/>  
 * Date:     2016年4月19日 下午3:42:27 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IOrderService {

	PageBean<FosOrder> selectByExample(VoPageBaseBean vpbb);

	int insertOrder(FosOrderVo order);

	int updateOrder(FosOrderVo order);

	int saveAsOrder(FosOrderVo order);
	
}
