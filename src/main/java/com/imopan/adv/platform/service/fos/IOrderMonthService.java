/** 
 * Project Name:adv-business-service 
 * File Name:IOrderMonthService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年4月28日下午3:33:22 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosCycleBill;
import com.imopan.adv.platform.entity.fos.FosOrderMonth;
import com.imopan.adv.platform.vo.fos.FosAuditOrderMonthVo;

/** 
 * ClassName:IOrderMonthService <br/> 
 * Function: 订单对账接口. <br/>  
 * Date:     2016年4月28日 下午3:33:22 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IOrderMonthService {

	PageBean<FosOrderMonth> getOrderMonthList(VoPageBaseBean vpbb);

	int checkordermonth(FosOrderMonth fos, boolean b);

	PageBean<FosOrderMonth> getOrderMonthHistoryList(VoPageBaseBean vpbb);

	int updateOrderMonth(FosOrderMonth fos);

	PageBean<FosCycleBill> getCycleBillList(VoPageBaseBean vpbb);

	FosCycleBill getCycleBillListSum(VoPageBaseBean vpbb);

	PageBean<FosCycleBill> getCycleBillDetail(VoPageBaseBean vpbb);

	int checkOrderMonthSubmit(FosOrderMonth fos, boolean b);

	PageBean<FosAuditOrderMonthVo> getAuditOrderMonthList(VoPageBaseBean vpbb);


}
