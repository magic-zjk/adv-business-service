/** 
 * Project Name:adv-business-service 
 * File Name:ITicketOrderService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年5月9日下午2:27:55 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosTicketOrder;
import com.imopan.adv.platform.entity.fos.FosTicketOrderImpl;
import com.imopan.adv.platform.vo.fos.FosTicketOrderVo;

/** 
 * ClassName:ITicketOrderService <br/> 
 * Function: 出票接口. <br/>  
 * Date:     2016年5月9日 下午2:27:55 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface ITicketOrderService {

	PageBean<FosTicketOrder> getDrawList(VoPageBaseBean vpbb);

	int saveTicketOrder(FosTicketOrder fos);

	PageBean<FosTicketOrder> getDrawHistoryList(VoPageBaseBean vpbb);
	
	PageBean<FosTicketOrderImpl> getMonthIncomeHistoryList(VoPageBaseBean vpbb);

	int saveReceipt(FosTicketOrder fos);

	PageBean<FosTicketOrderVo> getReceiptHistoryList(VoPageBaseBean vpbb);

	PageBean<FosTicketOrderVo> getReceiptHistoryListSum(VoPageBaseBean vpbb);

	int updateDrawHistory(FosTicketOrder fos);

	PageBean<FosTicketOrderImpl> getMonthIncomeSum(VoPageBaseBean vpbb);

}
