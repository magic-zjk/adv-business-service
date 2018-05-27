/** 
 * Project Name:adv-business-service 
 * File Name:IChannelMonthService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年5月3日下午3:14:47 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosChannelMonth;
import com.imopan.adv.platform.vo.fos.FosAuditChannelMonthVo;

/** 
 * ClassName:IChannelMonthService <br/> 
 * Function: 渠道对账接口. <br/>  
 * Date:     2016年5月3日 下午3:14:47 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IChannelMonthService {

	PageBean<FosChannelMonth> getChannelMonthList(VoPageBaseBean vpbb);

	int checkchannelmonth(FosChannelMonth fos);

	PageBean<FosAuditChannelMonthVo> getChannelMonthHistoryList(VoPageBaseBean vpbb);

	int updateChannelMonth(FosChannelMonth fos);

	PageBean<FosChannelMonth> getChannelMonthReceiveList(VoPageBaseBean vpbb);


}
