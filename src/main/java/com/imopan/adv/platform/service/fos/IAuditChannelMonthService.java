/** 
 * Project Name:adv-business-service 
 * File Name:IAuditOrderMonthService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年11月5日下午4:24:16 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosReceiveOrder;
import com.imopan.adv.platform.vo.fos.FosAuditChannelMonthVo;
import com.imopan.adv.platform.vo.fos.FosPrePayChannelVo;
import com.imopan.adv.platform.vo.fos.FosReceiveOrderV2Vo;

/** 
 * ClassName:IAuditOrderMonthService <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年11月5日 下午4:24:16 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IAuditChannelMonthService {

	int updateChannelMonthAudit(FosAuditChannelMonthVo fos);

	int updateChannelMonthAuditStatus(FosAuditChannelMonthVo fos);

	int submitReceiveChannelMonth(FosReceiveOrderV2Vo fos);

	PageBean<FosPrePayChannelVo> getPrePaymentChannelList(VoPageBaseBean vpbb);

	FosPrePayChannelVo getPrePaymentChannelList_TotalAndRemain(VoPageBaseBean vpbb);

	PageBean<FosReceiveOrder> getPrePaymentChannelListDetial(VoPageBaseBean vpbb);


}
