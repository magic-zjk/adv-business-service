/** 
 * Project Name:adv-business-service 
 * File Name:IReceiveOrderService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年5月12日下午3:45:38 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosReceiveOrder;
import com.imopan.adv.platform.vo.fos.FosReceiveOrderVo;

/** 
 * ClassName:IReceiveOrderService <br/> 
 * Function: 收票出款接口. <br/>  
 * Date:     2016年5月12日 下午3:45:38 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IReceiveOrderService {

	int saveReceiveBill(FosReceiveOrderVo fos);

	PageBean<FosReceiveOrder> getReceiveHistoryList(VoPageBaseBean vpbb);

	int savePay(FosReceiveOrder fos);

	int updateReceiveHistory(FosReceiveOrder fos);

	PageBean<FosReceiveOrder> getReceiveOrderList(VoPageBaseBean vpbb);

	int exeReceiveOk(FosReceiveOrder fos);


}
