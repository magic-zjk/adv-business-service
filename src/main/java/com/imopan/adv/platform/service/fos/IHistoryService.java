/** 
 * Project Name:adv-business-service 
 * File Name:IHistoryService.java 
 * Package Name:com.imopan.adv.platform.service.fos 
 * Date:2016年6月15日下午4:00:48 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosHistory;
import com.imopan.adv.platform.entity.fos.FosOrderMonthHistory;

/** 
 * ClassName:IHistoryService <br/> 
 * Function: 历史数据. <br/>  
 * Date:     2016年6月15日 下午4:00:48 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public interface IHistoryService {

	PageBean<FosOrderMonthHistory> getHistoryList(VoPageBaseBean vpbb);

	PageBean<FosOrderMonthHistory> getHistoryListSum(VoPageBaseBean vpbb);

	int updateHistory(FosOrderMonthHistory fos);

}
