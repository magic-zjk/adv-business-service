/** 
 * Project Name:adv-business-service 
 * File Name:HistoryServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年6月15日下午4:01:55 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosDailyBill;
import com.imopan.adv.platform.entity.fos.FosOrderMonthHistory;
import com.imopan.adv.platform.entity.fos.FosOrderMonthHistoryExample;
import com.imopan.adv.platform.entity.fos.FosOrderMonthHistoryExample.Criteria;
import com.imopan.adv.platform.mapper.fos.FosOrderMonthHistoryMapper;
import com.imopan.adv.platform.service.fos.IHistoryService;

/** 
 * ClassName:HistoryServiceImpl <br/> 
 * Function: 历史数据. <br/>  
 * Date:     2016年6月15日 下午4:01:55 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class HistoryServiceImpl implements IHistoryService {
	
	@Autowired
	private FosOrderMonthHistoryMapper historyDao;

	@Override
	public PageBean<FosOrderMonthHistory> getHistoryList(VoPageBaseBean vpbb) {
		PageBean<FosOrderMonthHistory> pageBean = new PageBean<FosOrderMonthHistory>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("id") != null && StringUtils.isNotEmpty(map.get("id").toString())){
				hashMap.put("id", map.get("id"));
			}
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName")+"%");
			}
			if(map.get("productName") != null && StringUtils.isNotEmpty(map.get("productName").toString())){
				hashMap.put("productName", "%"+map.get("productName")+"%");
			}
			if(map.get("cooperateName") != null && StringUtils.isNotEmpty(map.get("cooperateName").toString())){
				hashMap.put("cooperateName","%"+map.get("cooperateName")+"%");
			}  
			if(map.get("extendType") != null && StringUtils.isNotEmpty(map.get("extendType").toString())){
				hashMap.put("extendType", map.get("directorName"));
			}  
			if(map.get("statusDraw") != null && StringUtils.isNotEmpty(map.get("statusDraw").toString())){
				hashMap.put("statusDraw", map.get("statusDraw"));
			}  
			if(map.get("statusReturn") != null && StringUtils.isNotEmpty(map.get("statusReturn").toString())){
				hashMap.put("statusReturn", map.get("statusReturn"));
			}  
			if(map.get("directorName") != null && StringUtils.isNotEmpty(map.get("directorName").toString())){
				hashMap.put("directorName", map.get("directorName"));
			}
			if(map.get("begintime") != null && StringUtils.isNotEmpty(map.get("begintime").toString())){
				hashMap.put("begintime",map.get("begintime").toString().split("T")[0]);
			}
			if(map.get("endtime") != null && StringUtils.isNotEmpty(map.get("endtime").toString())){
				hashMap.put("endtime",map.get("endtime").toString().split("T")[0]);
			}
		}
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
			hashMap.put("orderByName", "BEGIN_TIME DESC,END_TIME DESC");
		//查询记录
		List<FosOrderMonthHistory> list = historyDao.getHistoryList(hashMap);
		int i = historyDao.countGetHistoryList(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}

	@Override
	public PageBean<FosOrderMonthHistory> getHistoryListSum(VoPageBaseBean vpbb) {
		PageBean<FosOrderMonthHistory> pageBean = new PageBean<FosOrderMonthHistory>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName")+"%");
			}
			if(map.get("productName") != null && StringUtils.isNotEmpty(map.get("productName").toString())){
				hashMap.put("productName", "%"+map.get("productName")+"%");
			}
			if(map.get("cooperateName") != null && StringUtils.isNotEmpty(map.get("cooperateName").toString())){
				hashMap.put("cooperateName","%"+map.get("cooperateName")+"%");
			}  
			if(map.get("extendType") != null && StringUtils.isNotEmpty(map.get("extendType").toString())){
				hashMap.put("extendType", map.get("directorName"));
			}  
			if(map.get("statusDraw") != null && StringUtils.isNotEmpty(map.get("statusDraw").toString())){
				hashMap.put("statusDraw", map.get("statusDraw"));
			}  
			if(map.get("statusReturn") != null && StringUtils.isNotEmpty(map.get("statusReturn").toString())){
				hashMap.put("statusReturn", map.get("statusReturn"));
			}  
			if(map.get("directorName") != null && StringUtils.isNotEmpty(map.get("directorName").toString())){
				hashMap.put("directorName", map.get("directorName"));
			}
			if(map.get("begintime") != null && StringUtils.isNotEmpty(map.get("begintime").toString())){
				hashMap.put("begintime",map.get("begintime").toString().split("T")[0]);
			}
			if(map.get("endtime") != null && StringUtils.isNotEmpty(map.get("endtime").toString())){
				hashMap.put("endtime",map.get("endtime").toString().split("T")[0]);
			}
		}
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
		List<FosOrderMonthHistory> list = historyDao.getHistoryListSum(hashMap);
		pageBean.setDataList(list);
		return pageBean;
	}

	@Override
	public int updateHistory(FosOrderMonthHistory fos) {
		int i = historyDao.updateByPrimaryKeySelective(fos);
		return i;
	}

}
