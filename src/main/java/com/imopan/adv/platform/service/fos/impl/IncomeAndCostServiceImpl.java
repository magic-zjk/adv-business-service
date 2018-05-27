/** 
 * Project Name:adv-business-service 
 * File Name:OcDayServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年4月25日下午3:23:52 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/

package com.imopan.adv.platform.service.fos.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosIncomeCost;
import com.imopan.adv.platform.mapper.fos.FosIncomeCostMapper;
import com.imopan.adv.platform.mapper.fos.FosOcDayMapper;
import com.imopan.adv.platform.service.fos.IIncomeAndCostService;
import com.imopan.adv.platform.util.FosDataControllerUtil;
import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;

/**
 * ClassName:IncomeAndCostServiceImpl <br/>
 * Function: 收入成本控制. <br/>
 * Date: 2016年4月25日 下午3:23:52 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.7
 */
@Service
public class IncomeAndCostServiceImpl implements IIncomeAndCostService {

	private static Logger logger = LoggerFactory.getLogger(IncomeAndCostServiceImpl.class);
	
	private static final String PROFIT = "profit";
	private static final String PERCENT = "percent";
	
	@Autowired
	private FosOcDayMapper ocDayDao;
	
	@Autowired
	private FosIncomeCostMapper incomeCostMapper;
	
	@Override
	public PageBean<FosAuditOcDayVo> getIncomeAndCostList(VoPageBaseBean vpbb) {
		PageBean<FosAuditOcDayVo> pageBean = new PageBean<FosAuditOcDayVo>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("entryDayStatus") != null && StringUtils.isNotEmpty(map.get("entryDayStatus").toString())){
				hashMap.put("entryDayStatus", map.get("entryDayStatus").toString());
			}
			if(map.get("ocDayStatus") != null && StringUtils.isNotEmpty(map.get("ocDayStatus").toString())){
				hashMap.put("ocDayStatus", map.get("ocDayStatus").toString());
			}
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName").toString()+"%");
			}
			if(map.get("orderDirectorName") != null && StringUtils.isNotEmpty(map.get("orderDirectorName").toString())){
				hashMap.put("orderDirectorName", "%"+map.get("orderDirectorName").toString()+"%");
			}
			if(map.get("orderDepartment") != null && StringUtils.isNotEmpty(map.get("orderDepartment").toString())){
				hashMap.put("orderDepartment", map.get("orderDepartment").toString());
			}
			if(map.get("channelName") != null && StringUtils.isNotEmpty(map.get("channelName").toString())){
				hashMap.put("channelName", "%"+map.get("channelName").toString()+"%");
			}
//			if(map.get("beginTime") != null && StringUtils.isNotEmpty(map.get("beginTime").toString())){
//				hashMap.put("beginTime",map.get("beginTime").toString().split("T")[0]);
//			}
//			if(map.get("endTime") != null && StringUtils.isNotEmpty(map.get("endTime").toString())){
//				hashMap.put("endTime",map.get("endTime").toString().split("T")[0]);
//			}
			if(map.get("financialSubmitCpStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpStatus").toString())){
				hashMap.put("financialSubmitCpStatus", map.get("financialSubmitCpStatus").toString());
			}
			if(map.get("financialSubmitCpNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpNotthroughTime").toString())){
				hashMap.put("financialSubmitCpNotthroughTime", map.get("financialSubmitCpNotthroughTime").toString());
			}
			if(map.get("financialSubmitChannelStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelStatus").toString())){
				hashMap.put("financialSubmitChannelStatus", map.get("financialSubmitChannelStatus").toString());
			}
			if(map.get("financialSubmitChannelNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelNotthroughTime").toString())){
				hashMap.put("financialSubmitChannelNotthroughTime", map.get("financialSubmitChannelNotthroughTime").toString());
			}
			if(map.get("businessTime") !=null && StringUtils.isNotEmpty(map.get("businessTime").toString())){
				String date = map.get("businessTime").toString().split("T")[0];
				hashMap.put("businessTime", getBusinessTime(date));
				hashMap.put("beginTime", getStartDate(date));
				hashMap.put("endTime", getEndDate(date));
			}
		}
		
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
		
		//数据级控制
		FosDataControllerUtil.assignmentMap(hashMap);
		
		List<FosAuditOcDayVo> list = ocDayDao.getIncomeAndCostList(hashMap);
		int i = ocDayDao.countGetIncomeAndCostList(hashMap);
		pageBean.setTotalRecord(i);
		pageBean.setDataList(list);
		return pageBean;
	}
	
	@Override
	public PageBean<FosAuditOcDayVo> getIncomeCostHistoryList(VoPageBaseBean vpbb) {
		PageBean<FosAuditOcDayVo> pageBean = new PageBean<FosAuditOcDayVo>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("entryDayStatus") != null && StringUtils.isNotEmpty(map.get("entryDayStatus").toString())){
				hashMap.put("entryDayStatus", map.get("entryDayStatus").toString());
			}
			if(map.get("ocDayStatus") != null && StringUtils.isNotEmpty(map.get("ocDayStatus").toString())){
				hashMap.put("ocDayStatus", map.get("ocDayStatus").toString());
			}
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName").toString()+"%");
			}
			if(map.get("orderDirectorName") != null && StringUtils.isNotEmpty(map.get("orderDirectorName").toString())){
				hashMap.put("orderDirectorName", "%"+map.get("orderDirectorName").toString()+"%");
			}
			
			if(map.get("orderDepartment") != null && StringUtils.isNotEmpty(map.get("orderDepartment").toString())){
				hashMap.put("orderDepartment", map.get("orderDepartment").toString());
			}
			
			if(map.get("channelName") != null && StringUtils.isNotEmpty(map.get("channelName").toString())){
				hashMap.put("channelName", "%"+map.get("channelName").toString()+"%");
			}
//			if(map.get("beginTime") != null && StringUtils.isNotEmpty(map.get("beginTime").toString())){
//				hashMap.put("beginTime",map.get("beginTime").toString().split("T")[0]);
//			}
//			if(map.get("endTime") != null && StringUtils.isNotEmpty(map.get("endTime").toString())){
//				hashMap.put("endTime",map.get("endTime").toString().split("T")[0]);
//			}
			if(map.get("financialSubmitCpStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpStatus").toString())){
				hashMap.put("financialSubmitCpStatus", map.get("financialSubmitCpStatus").toString());
			}
			if(map.get("financialSubmitCpNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpNotthroughTime").toString())){
				hashMap.put("financialSubmitCpNotthroughTime", map.get("financialSubmitCpNotthroughTime").toString());
			}
			if(map.get("financialSubmitChannelStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelStatus").toString())){
				hashMap.put("financialSubmitChannelStatus", map.get("financialSubmitChannelStatus").toString());
			}
			if(map.get("financialSubmitChannelNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelNotthroughTime").toString())){
				hashMap.put("financialSubmitChannelNotthroughTime", map.get("financialSubmitChannelNotthroughTime").toString());
			}
			if(map.get("businessBeginTime") !=null && StringUtils.isNotEmpty(map.get("businessBeginTime").toString())){
				String startDate = map.get("businessBeginTime").toString().split("T")[0];
				hashMap.put("beginTime", getBusinessTime(startDate));
			}
			if (map.get("businessEndTime") !=null && StringUtils.isNotEmpty(map.get("businessEndTime").toString())) {
				String endDate = map.get("businessEndTime").toString().split("T")[0];
				hashMap.put("endTime", getBusinessTime(endDate));
			}
		}
		if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd",vpbb.getLimitEnd());
		}
		List<FosAuditOcDayVo> list = incomeCostMapper.getIncomeCostHistoryList(hashMap);
		int i = incomeCostMapper.countGetIncomeCostHistoryList(hashMap);
		pageBean.setTotalRecord(i);
		pageBean.setDataList(list);
		return pageBean;
	}
	
	@Override
	public PageBean<FosAuditOcDayVo> getIncomeAndCostInfoSum(VoPageBaseBean vpbb) {
		PageBean<FosAuditOcDayVo> pageBean = new PageBean<FosAuditOcDayVo>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("entryDayStatus") != null && StringUtils.isNotEmpty(map.get("entryDayStatus").toString())){
				hashMap.put("entryDayStatus", map.get("entryDayStatus").toString());
			}
			if(map.get("ocDayStatus") != null && StringUtils.isNotEmpty(map.get("ocDayStatus").toString())){
				hashMap.put("ocDayStatus", map.get("ocDayStatus").toString());
			}
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName").toString()+"%");
			}
			if(map.get("orderDirectorName") != null && StringUtils.isNotEmpty(map.get("orderDirectorName").toString())){
				hashMap.put("orderDirectorName", "%"+map.get("orderDirectorName").toString()+"%");
			}
			if(map.get("channelName") != null && StringUtils.isNotEmpty(map.get("channelName").toString())){
				hashMap.put("channelName", "%"+map.get("channelName").toString()+"%");
			}
			if(map.get("financialSubmitCpStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpStatus").toString())){
				hashMap.put("financialSubmitCpStatus", map.get("financialSubmitCpStatus").toString());
			}
			if(map.get("financialSubmitCpNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpNotthroughTime").toString())){
				hashMap.put("financialSubmitCpNotthroughTime", map.get("financialSubmitCpNotthroughTime").toString());
			}
			if(map.get("financialSubmitChannelStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelStatus").toString())){
				hashMap.put("financialSubmitChannelStatus", map.get("financialSubmitChannelStatus").toString());
			}
			if(map.get("financialSubmitChannelNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelNotthroughTime").toString())){
				hashMap.put("financialSubmitChannelNotthroughTime", map.get("financialSubmitChannelNotthroughTime").toString());
			}
			if(map.get("businessTime") !=null && StringUtils.isNotEmpty(map.get("businessTime").toString())){
				String date = map.get("businessTime").toString().split("T")[0];
				hashMap.put("beginTime", getStartDate(date));
				hashMap.put("endTime", getEndDate(date));
			}
			
		}
		
		List<FosAuditOcDayVo> list = ocDayDao.getIncomeAndCostList(hashMap);
		pageBean.setDataList(list);
		return pageBean;
	}
	
	@Override
	public PageBean<FosAuditOcDayVo> getIncomeCostHistorySum(VoPageBaseBean vpbb) {
		PageBean<FosAuditOcDayVo> pageBean = new PageBean<FosAuditOcDayVo>();
		HashMap<String,Object> map = vpbb.getParammap();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		if(map != null){
			if(map.get("entryDayStatus") != null && StringUtils.isNotEmpty(map.get("entryDayStatus").toString())){
				hashMap.put("entryDayStatus", map.get("entryDayStatus").toString());
			}
			if(map.get("ocDayStatus") != null && StringUtils.isNotEmpty(map.get("ocDayStatus").toString())){
				hashMap.put("ocDayStatus", map.get("ocDayStatus").toString());
			}
			if(map.get("orderName") != null && StringUtils.isNotEmpty(map.get("orderName").toString())){
				hashMap.put("orderName", "%"+map.get("orderName").toString()+"%");
			}
			if(map.get("orderDirectorName") != null && StringUtils.isNotEmpty(map.get("orderDirectorName").toString())){
				hashMap.put("orderDirectorName", "%"+map.get("orderDirectorName").toString()+"%");
			}
			
			if(map.get("orderDepartment") != null && StringUtils.isNotEmpty(map.get("orderDepartment").toString())){
				hashMap.put("orderDepartment", map.get("orderDepartment").toString());
			}
			
			if(map.get("channelName") != null && StringUtils.isNotEmpty(map.get("channelName").toString())){
				hashMap.put("channelName", "%"+map.get("channelName").toString()+"%");
			}
//			if(map.get("beginTime") != null && StringUtils.isNotEmpty(map.get("beginTime").toString())){
//				hashMap.put("beginTime",map.get("beginTime").toString().split("T")[0]);
//			}
//			if(map.get("endTime") != null && StringUtils.isNotEmpty(map.get("endTime").toString())){
//				hashMap.put("endTime",map.get("endTime").toString().split("T")[0]);
//			}
			if(map.get("financialSubmitCpStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpStatus").toString())){
				hashMap.put("financialSubmitCpStatus", map.get("financialSubmitCpStatus").toString());
			}
			if(map.get("financialSubmitCpNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitCpNotthroughTime").toString())){
				hashMap.put("financialSubmitCpNotthroughTime", map.get("financialSubmitCpNotthroughTime").toString());
			}
			if(map.get("financialSubmitChannelStatus") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelStatus").toString())){
				hashMap.put("financialSubmitChannelStatus", map.get("financialSubmitChannelStatus").toString());
			}
			if(map.get("financialSubmitChannelNotthroughTime") != null && StringUtils.isNotEmpty(map.get("financialSubmitChannelNotthroughTime").toString())){
				hashMap.put("financialSubmitChannelNotthroughTime", map.get("financialSubmitChannelNotthroughTime").toString());
			}
			if(map.get("businessBeginTime") !=null && StringUtils.isNotEmpty(map.get("businessBeginTime").toString())){
				String startDate = map.get("businessBeginTime").toString().split("T")[0];
				hashMap.put("beginTime", getBusinessTime(startDate));
			}
			if (map.get("businessEndTime") !=null && StringUtils.isNotEmpty(map.get("businessEndTime").toString())) {
				String endDate = map.get("businessEndTime").toString().split("T")[0];
				hashMap.put("endTime", getBusinessTime(endDate));
			}
		}
		List<FosAuditOcDayVo> list = incomeCostMapper.getIncomeCostHistorySum(hashMap);
		pageBean.setDataList(list);
		return pageBean;
	}
	
	@Override
	public int saveIncomeAndCost(FosAuditOcDayVo fos) {
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("channelOrderId", fos.getChannelOrderId());
		hashMap.put("businessTime", fos.getEntryTimeStr());
		int i = incomeCostMapper.countByChannelOrderId(hashMap);
		if (StringUtils.isNotBlank(fos.getMoneyTax()) && i<1) {
			FosIncomeCost fosIncomeAndCost = new FosIncomeCost();
			fosIncomeAndCost.setChannelId(fos.getChannelId());
			fosIncomeAndCost.setChannelName(fos.getChannelName());
			fosIncomeAndCost.setExtendType(Byte.valueOf(fos.getExtendType()));
			fosIncomeAndCost.setMoneyTax(new BigDecimal(fos.getMoneyTax()));
			fosIncomeAndCost.setChannelName(fos.getChannelName());
			fosIncomeAndCost.setOrderId(fos.getOrderId());
			fosIncomeAndCost.setChannelOrderId(fos.getChannelOrderId());
			fosIncomeAndCost.setOrderName(fos.getOrderName());
			fosIncomeAndCost.setCooperateName(fos.getCooperateName());
			fosIncomeAndCost.setProductName(fos.getProductName());
			fosIncomeAndCost.setFinancialIncome(fos.getFinancialSubmitOamount());
			fosIncomeAndCost.setFinancialCost(fos.getFinancialSubmitCamount());
			fosIncomeAndCost.setProfit(getProfitInfo(fos, PROFIT));
			fosIncomeAndCost.setProfitMargin(getProfitInfo(fos,PERCENT));
			fosIncomeAndCost.setBusinessTime(fos.getEntryTimeStr());
			incomeCostMapper.insert(fosIncomeAndCost);
		}
		return 0;
	}
	
	@Override
	public void addIncomeAndCostList(List<FosAuditOcDayVo> fosList) {
		for (FosAuditOcDayVo fosAuditOcDayVo : fosList) {
			int i = saveIncomeAndCost(fosAuditOcDayVo);
			logger.debug("更新auditChannelDay，id="+fosAuditOcDayVo.getAuditCpId()+":"+i);
		}
	}
	
	private static BigDecimal getProfitInfo(FosAuditOcDayVo fos, String type) {
		BigDecimal income = fos.getFinancialSubmitOamount().subtract(fos.getFinancialSubmitCamount());
		BigDecimal profit = income.subtract(new BigDecimal(fos.getMoneyTax()));
		BigDecimal profitPer = profit.multiply(new BigDecimal(100));
		
		if (PROFIT.equals(type)){
			return profit;
		} else if (PERCENT.equals(type)) {
			if(fos.getFinancialSubmitOamount() != null && fos.getFinancialSubmitOamount() !=  BigDecimal.valueOf(0)){
				return profitPer.divide(fos.getFinancialSubmitOamount(), 2, BigDecimal.ROUND_HALF_UP);
			}
		}
		return BigDecimal.valueOf(0);
	}

	private static String getStartDate(String date){
		String [] dateArr = date.split("-");
		return dateArr[0] + "-" + dateArr[1] + "-01";
	}
	
	private static String getBusinessTime(String date){
		String [] dateArr = date.split("-");
		return dateArr[0] + "-" + dateArr[1];
	}
	
	private static String getEndDate(String date){
		String [] dateArr = date.split("-");
		int year = Integer.valueOf(dateArr[0]);
		int month = Integer.valueOf(dateArr[1]);
		String lastDay = getLastDayOfMonth(year,month);
		return lastDay ;
	}
	
    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());      
        return lastDayOfMonth;
    }

}
