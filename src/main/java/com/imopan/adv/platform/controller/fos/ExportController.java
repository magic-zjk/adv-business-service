/** 
 * Project Name:adv-business-service 
 * File Name:BillController.java 
 * Package Name:com.imopan.adv.platform.controller.fos 
 * Date:2016年5月25日下午2:15:59 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/

package com.imopan.adv.platform.controller.fos;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosDailyBill;
import com.imopan.adv.platform.service.fos.IChannelMonthService;
import com.imopan.adv.platform.service.fos.IIncomeAndCostService;
import com.imopan.adv.platform.service.fos.IOcDayService;
import com.imopan.adv.platform.service.fos.IOrderMonthService;
import com.imopan.adv.platform.util.ExcelExportUtil;
import com.imopan.adv.platform.util.PageUtil;
import com.imopan.adv.platform.vo.fos.FosAuditChannelMonthVo;
import com.imopan.adv.platform.vo.fos.FosAuditOcDayVo;
import com.imopan.adv.platform.vo.fos.FosAuditOrderMonthVo;

/**
 * ExportController <br/>
 * Function: 报表控制层. <br/>
 * Date: 2016年11月12日16:54:47<br/>
 * 
 * @author gcq
 * @version
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/fosexport")
public class ExportController {
	private static Logger logger = LoggerFactory.getLogger(ExportController.class);

	@Autowired
	private IOcDayService ocDayServiceImpl;
	@Autowired
	private IChannelMonthService channelMonthServiceImpl;
	
	@Autowired
	private IIncomeAndCostService incomeAndCostServiceImpl;

	@Autowired
	private IOrderMonthService orderMonthServiceImpl;


	/**
	 * 
	 * exportChannelMonthAuditList:渠道对账历史管理导出. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param orderName
	 * @param groupByName
	 * @param orderByName
	 * @param pageNo
	 * @param pageSize
	 * @param response 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "exportChannelMonthAuditList")
	@ResponseBody
	public void exportChannelMonthAuditList(
			@RequestParam(value = "ordername", required = false) String ordername,
			@RequestParam(value = "orderDepartment", required = false) Integer orderDepartment,
			@RequestParam(value = "channelname", required = false) String channelname,
			@RequestParam(value = "times", required = false) String times,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "pageSize", required = false) String pageSize, HttpServletResponse response) {
		// 校验
		VoPageBaseBean voPageBaseBean = new VoPageBaseBean();
		voPageBaseBean.setPageNo(Integer.valueOf(pageNo));
		voPageBaseBean.setPageSize(Integer.valueOf(pageSize));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ordername", ordername);
		map.put("orderDepartment", orderDepartment);
		map.put("channelname", channelname);
		map.put("times", times);
		map.put("status", status);
		voPageBaseBean.setParammap(map);

		PageBean<FosAuditChannelMonthVo> result = channelMonthServiceImpl.getChannelMonthHistoryList(voPageBaseBean);
		List<Map<String, Object>> dataList = PageUtil.formatMapData(result, "exportChannelMonthAuditList");
		LinkedHashMap<String, List> ss = new LinkedHashMap<String, List>();
		ss.put("渠道对账历史管理", dataList);
		//ss.put("总和", dataListSum);
		String[] titleEn = new String[] { 
				"orderName","orderDepartment", "orderDirectorName", "channelName", "channelDirectorName", "cAmountSum",
				"mediaRebate","otherExpense", "channelCut","subAmount","entryBegintime",
				"entryEndtime","financialSubmitChannelStatus", "channelSubmitConfirm","channelUpdateMediaRebate","channelUpdateOtherExpense",
				"channelUpdateChannelCut","financialSubmitChannelNotthroughReason", "financialSubmitChannelNotthroughTime","financialSubmitMediaRebate","financialSubmitOtherExpense",
				"financialSubmitChannelCut","financialSubmitChannelDate", 
				};
		String[] cnEn = new String[] { 
				"订单名称","部门", "商务负责人", "渠道名称", "渠道负责人", "运营成本", 
				"媒体补返","其他支出", "核减支出","实际支出","开始时间",
				"结束时间","审核状态", "提交审核时间","媒体补返修改","其他支出修改",
				"核减支出修改","不通过原因", "未通过次数","确认媒体补返","确认其他支出",
				"确认核减支出","确认通过时间"
				};
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode("渠道对账历史管理", "UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			try {
				ExcelExportUtil.createExcel(cnEn, titleEn, ss, "渠道对账历史管理", response);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	
	
	

	/**
	 * 
	 * exportPayHistoryList:日账单单订单导出. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param orderName
	 * @param groupByName
	 * @param orderByName
	 * @param pageNo
	 * @param pageSize
	 * @param response 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "exportDayBillList")
	@ResponseBody
	public void exportPayHistoryList(@RequestParam(value = "orderName", required = false) String orderName,
			@RequestParam(value = "groupByName", required = false) String groupByName,
			@RequestParam(value = "orderByName", required = false) String orderByName,
			@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "beginTime", required = false) String beginTime,
			@RequestParam(value = "endTime", required = false) String endTime,
			@RequestParam(value = "pageSize", required = false) String pageSize, HttpServletResponse response) {
		// 校验
		VoPageBaseBean voPageBaseBean = new VoPageBaseBean();
		voPageBaseBean.setPageNo(Integer.valueOf(pageNo));
		voPageBaseBean.setPageSize(Integer.valueOf(pageSize));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orderName", orderName);
		map.put("groupByName", groupByName);
		map.put("orderByName", orderByName);
		map.put("beginTime", beginTime.replace("\"", ""));
		map.put("endTime", endTime.replace("\"", ""));
		voPageBaseBean.setParammap(map);
		
		VoPageBaseBean vSum = new VoPageBaseBean();
		vSum.setPageNo(Integer.valueOf(pageNo));
		vSum.setPageSize(Integer.valueOf(pageSize));
		HashMap<String, Object> mapSum = new HashMap<String, Object>();
		mapSum.put("orderName", orderName);
		mapSum.put("beginTime", beginTime.replace("\"", ""));
		mapSum.put("endTime", endTime.replace("\"", ""));
		vSum.setParammap(mapSum);

		PageBean<FosDailyBill> result = ocDayServiceImpl.getDayBillList(voPageBaseBean);//详情数据
		List<Map<String, Object>> dataList = PageUtil.formatMapData(result, "dayBillList");
		PageBean<FosDailyBill> resultSum = ocDayServiceImpl.getDayBillList(vSum);//合计数据
		List<Map<String, Object>> dataListSum = PageUtil.formatMapData(resultSum, "dayBillList");
		Map<String, Object> sMap = new HashMap<String, Object>();
		sMap.put("orderId", "总计");
		sMap.put("oCount", dataListSum.get(0).get("oCount"));
		sMap.put("oAmount", dataListSum.get(0).get("oAmount"));
		sMap.put("cCount", dataListSum.get(0).get("cCount"));
		sMap.put("cAmount", dataListSum.get(0).get("cAmount"));
		sMap.put("profit", dataListSum.get(0).get("profit"));
		sMap.put("profitMargin", dataListSum.get(0).get("profitMargin"));
		dataList.add(0, sMap);
		LinkedHashMap<String, List> ss = new LinkedHashMap<String, List>();
		ss.put("流水", dataList);
		//ss.put("总和", dataListSum);
		String[] titleEn = new String[] { "orderId", "orderName", "productName", "orderDirectorName", "oCount", "oAmount",
				"cCount", "cAmount","profit","profitMargin" };
		String[] cnEn = new String[] { "订单Id", "订单名称", "产品名称", "商务负责人", "订单数量", "订单金额", "渠道数量", "渠道金额","利润","利润率" };
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode("流水记录", "UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			try {
				ExcelExportUtil.createExcel(cnEn, titleEn, ss, "流水记录("+map.get("beginTime").toString().split("T")[0]+"/"+map.get("endTime").toString().split("T")[0]+")", response);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 
	 * exportPayHistoryList:日账单单订单导出. <br/> 
	 * 
	 * @author crystal
	 * @param orderName
	 * @param orderByName
	 * @param pageNo
	 * @param pageSize
	 * @param response 
	 * @since JDK 1.7 
	 */
	@RequestMapping(value = "exportChannelDayAuditList")
	@ResponseBody
	public void exportChannelDayAuditList(
			@RequestParam(value = "orderName", required = false) String orderName,
			@RequestParam(value = "orderDirectorName", required = false) String orderDirectorName,
			@RequestParam(value = "orderDepartment", required = false) Integer orderDepartment,
			@RequestParam(value = "financialSubmitChannelStatus", required = false) String financialSubmitChannelStatus,
			@RequestParam(value = "channelMonthStatus", required = false) String channelMonthStatus,
			@RequestParam(value = "financialSubmitChannelNotthroughTime", required = false) String financialSubmitChannelNotthroughTime,
			@RequestParam(value = "channelName", required = false) String channelName,
			@RequestParam(value = "exportBegintime", required = false) String exportBegintime,
			@RequestParam(value = "exportEndtime", required = false) String exportEndtime,
			@RequestParam(value = "entryDayStatus", required = false) String entryDayStatus,
			@RequestParam(value = "ocDayStatus", required = false) String ocDayStatus,
			@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "pageSize", required = false) String pageSize, HttpServletResponse response) {
		// 校验
		VoPageBaseBean voPageBaseBean = new VoPageBaseBean();
		voPageBaseBean.setPageNo(Integer.valueOf(pageNo));
		voPageBaseBean.setPageSize(Integer.valueOf(pageSize));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orderName", orderName);
		map.put("orderDirectorName", orderDirectorName);
		map.put("orderDepartment", orderDepartment);
		map.put("financialSubmitChannelStatus", financialSubmitChannelStatus);
		map.put("channelMonthStatus", channelMonthStatus);
		map.put("financialSubmitChannelNotthroughTime", financialSubmitChannelNotthroughTime);
		map.put("channelName", channelName);
		map.put("entryDayStatus", entryDayStatus);
		map.put("ocDayStatus", ocDayStatus);
		map.put("beginTime", exportBegintime);
		map.put("endTime", exportEndtime);
		voPageBaseBean.setParammap(map);
		
		PageBean<FosAuditOcDayVo> result = ocDayServiceImpl.getAuditOcDayList(voPageBaseBean);//详情数据
		List<Map<String, Object>> dataList = PageUtil.formatMapData(result, "channelAuditDayList");
		PageBean<FosAuditOcDayVo> resultSum = ocDayServiceImpl.getOcDayInfoSum(voPageBaseBean);//合计数据
		List<Map<String, Object>> dataListSum = PageUtil.formatMapData(resultSum, "channelAuditDayList");
		Map<String, Object> sMap = new HashMap<String, Object>();
		sMap.put("orderName", "总计");
		sMap.put("cCount", dataListSum.get(0).get("cCount"));
		sMap.put("cAmount", dataListSum.get(0).get("cAmount"));
		sMap.put("financialSubmitCcount", dataListSum.get(0).get("financialSubmitCcount"));
		sMap.put("financialSubmitCamount", dataListSum.get(0).get("financialSubmitCamount"));
		dataList.add(0, sMap);
		LinkedHashMap<String, List> ss = new LinkedHashMap<String, List>();
		ss.put("渠道成本确认审核", dataList);
		//ss.put("总和", dataListSum);
		
		String[] titleEn = new String[] { "entryTime", "orderName","orderDepartment","channelName", "outerUnit", "cCount", "cAmount",
				"channelSubmitConfirm", "channelSubmitCcount","channelSubmitCamount","financialSubmitCcount",
				"financialSubmitCamount","financialSubmitChannelDate", "financialSubmitChannelStatus","financialSubmitChannelNotthroughTime","channelMonthStatus"};
		
		String[] cnEn = new String[] { "待录时间", "订单名称","部门","渠道简称", "外放单价(￥)", "渠道数量", "渠道金额(￥)", "提交审核时间", "渠道确认数量","渠道确认金额(￥)","财务确认数量",
				"财务确认金额(￥)","审核通过时间" ,"审核状态","未通过次数","对账状态"};

		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode("渠道成本确认审核", "UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			try {
				ExcelExportUtil.createExcel(cnEn, titleEn, ss, "渠道成本确认审核("+map.get("beginTime").toString().split("T")[0]+"-"+map.get("endTime").toString().split("T")[0]+")", response);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 
	 * exportDrawHistoryList:导出收款历史. <br/>
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "exportIncomeCostHistoryList")
	@ResponseBody
	public void exportIncomeCostHistoryList(
			@RequestParam(value = "orderName", required = false) String orderName,
			@RequestParam(value = "orderDirectorName", required = false) String orderDirectorName,
			@RequestParam(value = "orderDepartment", required = false) Integer orderDepartment,
			@RequestParam(value = "channelName", required = false) String channelName,
			@RequestParam(value = "exportBegintime", required = false) String exportBegintime,
			@RequestParam(value = "exportEndtime", required = false) String exportEndtime,
			@RequestParam(value = "entryDayStatus", required = false) String entryDayStatus,
			@RequestParam(value = "ocDayStatus", required = false) String ocDayStatus,
			@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "pageSize", required = false) String pageSize,
		    HttpServletResponse response) {	
		// 校验
		VoPageBaseBean voPageBaseBean = new VoPageBaseBean();
		voPageBaseBean.setPageNo(Integer.valueOf(pageNo));
		voPageBaseBean.setPageSize(Integer.valueOf(pageSize));
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("orderName", orderName);
		map.put("orderDirectorName", orderDirectorName);
		map.put("orderDepartment", orderDepartment);
		map.put("channelName", channelName);
		map.put("entryDayStatus", entryDayStatus);
		map.put("ocDayStatus", ocDayStatus);
		map.put("businessBeginTime", exportBegintime);
		map.put("businessEndTime", exportEndtime);
		voPageBaseBean.setParammap(map);
		
		
		logger.debug(voPageBaseBean.toString());
		PageBean<FosAuditOcDayVo> p = incomeAndCostServiceImpl.getIncomeCostHistoryList(voPageBaseBean);
		List<Map<String, Object>> dataList = PageUtil.formatMapData(p, "incomeCostHistoryList");
		LinkedHashMap<String, List> ss = new LinkedHashMap<String, List>();
		
		PageBean<FosAuditOcDayVo> resultSum = incomeAndCostServiceImpl.getIncomeCostHistorySum(voPageBaseBean);//合计数据
		List<Map<String, Object>> dataListSum = PageUtil.formatMapData(resultSum, "incomeCostHistoryList");
		
		
		Map<String, Object> sMap = new HashMap<String, Object>();
		sMap.put("orderName", "总计");
		sMap.put("financialSubmitOamount", dataListSum.get(0).get("financialSubmitOamount"));
		sMap.put("financialSubmitCamount", dataListSum.get(0).get("financialSubmitCamount"));
		sMap.put("profit", dataListSum.get(0).get("profit"));
		sMap.put("profitMargin", getProfitInfo(dataListSum));
		dataList.add(0, sMap);
		
		ss.put("收入成本历史", dataList);
		String[] titleEn = new String[] {"orderName","orderDepartment", "productName", "cooperateName","extendType","businessTime","financialSubmitOamount","channelName","financialSubmitCamount", "moneyTax", "profit",
				"profitMargin"};
		String[] cnEn = new String[] { "订单名称","部门", "产品名称", "CP公司全称","业务类型","业务发生时间","预确认收入(￥)","渠道名称", "预确认支出(￥)", "税额(￥)", "利润(￥)", "利润率(%)"};
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode("收入成本记录", "UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			try {
				ExcelExportUtil.createExcel(cnEn, titleEn, ss, "收入成本记录", response);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 
	 * exportOrderDayAuditList:广告主收入确认审核列表导出. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param orderName
	 * @param channelName
	 * @param orderDirectorName
	 * @param financialSubmitCpNotthroughTime
	 * @param financialSubmitCpStatus
	 * @param entryDayStatus
	 * @param ocDayStatus
	 * @param entryBegintime
	 * @param entryEndtime
	 * @param pageNo
	 * @param pageSize
	 * @param response 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "exportOrderDayAuditList")
	@ResponseBody
	public void exportOrderDayAuditList(@RequestParam(value = "orderName", required = false) String orderName,
			
			@RequestParam(value = "channelName", required = false) String channelName,
			@RequestParam(value = "orderDirectorName", required = false) String orderDirectorName,
			@RequestParam(value = "orderDepartment", required = false) Integer orderDepartment,
			@RequestParam(value = "financialSubmitCpNotthroughTime", required = false) String financialSubmitCpNotthroughTime,
			@RequestParam(value = "financialSubmitCpStatus", required = false) String financialSubmitCpStatus,
			@RequestParam(value = "orderMonthStatus", required = false) String orderMonthStatus,
			@RequestParam(value = "entryDayStatus", required = false) String entryDayStatus,
			@RequestParam(value = "ocDayStatus", required = false) String ocDayStatus,
			@RequestParam(value = "beginTime", required = false) String beginTime,
			@RequestParam(value = "endTime", required = false) String endTime,
			@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "pageSize", required = false) String pageSize,HttpServletResponse response) {
		// 校验
		VoPageBaseBean voPageBaseBean = new VoPageBaseBean();
		voPageBaseBean.setPageNo(Integer.valueOf(pageNo));
		voPageBaseBean.setPageSize(Integer.valueOf(pageSize));
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("orderName", orderName);
		map.put("channelName", channelName);
		map.put("orderDirectorName", orderDirectorName);
		map.put("orderDepartment", orderDepartment);
		map.put("financialSubmitCpNotthroughTime", financialSubmitCpNotthroughTime);
		map.put("financialSubmitCpStatus", financialSubmitCpStatus);
		map.put("orderMonthStatus", orderMonthStatus);
		map.put("entryDayStatus", entryDayStatus);
		map.put("ocDayStatus", ocDayStatus);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		voPageBaseBean.setParammap(map);
		
		
		logger.debug(voPageBaseBean.toString());
		PageBean<FosAuditOcDayVo>  list= ocDayServiceImpl.getAuditOcDayList(voPageBaseBean);
		List<Map<String, Object>> dataList = PageUtil.formatMapData(list, "auditOcDayList");
		LinkedHashMap<String, List> ss = new LinkedHashMap<String, List>();
		
		PageBean<FosAuditOcDayVo> resultSum = ocDayServiceImpl.getOcDayInfoSum(voPageBaseBean);//合计数据
		List<Map<String, Object>> dataListSum = PageUtil.formatMapData(resultSum, "auditOcDayList");
		Map<String, Object> sMap = new HashMap<String, Object>();
		sMap.put("entryTime", "总计");
		sMap.put("oCount", dataListSum.get(0).get("oCount"));
		sMap.put("oAmount", dataListSum.get(0).get("oAmount"));
		sMap.put("financialSubmitOcount", dataListSum.get(0).get("financialSubmitOcount"));
		sMap.put("financialSubmitOamount", dataListSum.get(0).get("financialSubmitOamount"));
		dataList.add(0, sMap);
		
		ss.put("广告主收入确认审核列表", dataList);
		String[] titleEn = new String[] { "entryTime", "orderName","orderDepartment", "channelName","orderDirectorName","payUnit","oCount","oAmount","orderSubmitConfirm", "cpSubmitOcount", "cpSubmitOamount",
				"financialSubmitOcount", "financialSubmitOamount", "financialSubmitCpDate", "financialSubmitCpStatus", "financialSubmitCpNotthroughReason", "financialSubmitCpNotthroughTime","orderMonthStatus"};
		String[] cnEn = new String[] {"待录时间" ,"订单名称","部门", "渠道简称", "商务负责人","接入单价","运营数量","运营金额","提交审核时间", "CP确认数量", "CP确认金额", "财务确认数量", "财务确认金额", "审核通过时间", "审核状态", "不通过原因",
				"未通过次数","对账状态"};
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode("广告主收入确认审核列表", "UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			try {
				ExcelExportUtil.createExcel(cnEn, titleEn, ss, "广告主收入确认审核列表", response);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping(value = "exportOrderMonthAuditList")
	@ResponseBody
	public void exportOrderMonthAuditList(@RequestParam(value = "orderName", required = false) String orderName,
			@RequestParam(value = "orderDepartment", required = false) Integer orderDepartment,
			@RequestParam(value = "drawBillStatus", required = false) String drawBillStatus,
			@RequestParam(value = "financialSubmitOrderNotthroughTime", required = false) String financialSubmitOrderNotthroughTime,
			@RequestParam(value = "financialSubmitOrderStatus", required = false) String financialSubmitOrderStatus,
			@RequestParam(value = "entryMoney", required = false) String entryMoney,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "pageNo", required = false) String pageNo,
			@RequestParam(value = "pageSize", required = false) String pageSize,HttpServletResponse response) {
		// 校验
		VoPageBaseBean voPageBaseBean = new VoPageBaseBean();
		voPageBaseBean.setPageNo(Integer.valueOf(pageNo));
		voPageBaseBean.setPageSize(Integer.valueOf(pageSize));
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("orderName", orderName);
		map.put("orderDepartment", orderDepartment);
		map.put("drawBillStatus", drawBillStatus);
		map.put("financialSubmitOrderNotthroughTime", financialSubmitOrderNotthroughTime);
		map.put("financialSubmitOrderStatus", financialSubmitOrderStatus);
		map.put("entryMoney", entryMoney);
		map.put("status", status);
		voPageBaseBean.setParammap(map);
		
		
		logger.debug(voPageBaseBean.toString());
		PageBean<FosAuditOrderMonthVo> list = orderMonthServiceImpl.getAuditOrderMonthList(voPageBaseBean);
		List<Map<String, Object>> dataList = PageUtil.formatMapData(list, "orderMonthAuditList");
		LinkedHashMap<String, List> ss = new LinkedHashMap<String, List>();
		
		ss.put("广告主对账确认审核列表", dataList);
		String[] titleEn = new String[] {"orderName","orderDepartment", "directorName","cooperateName","oAmountSum","oCount","oAmount","cut", "saleRebate", "entryBegintime",
				"entryEndtime", "financialSubmitOrderStatus", "orderSubmitConfirm", "orderUpdateOCount", "orderUpdateOAmount", "orderUpdateCut","orderUpdateSaleRebate","financialSubmitOrderNotthroughReason","financialSubmitOrderNotthroughTime","financialSubmitOCount","financialSubmitOAmount","financialSubmitCut","financialSubmitSaleRebate","financialSubmitOrderDate","drawBillStatus"};
		String[] cnEn = new String[] {"订单名称","部门" ,"负责人", "接入来源", "运营收入","对账数据","对账收入","核减收入","销售返点", "开始时间", "结束时间", "审核状态", "提交审核时间", "对账数据修改", "对账收入修改", "核减收入修改",
				"销售返点修改","不通过原因","未通过次数","确认对账数据","确认对账收入","确认核减收入","确认销售返点","确认通过时间","出票状态"};
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = java.net.URLEncoder.encode("广告主对账确认审核列表", "UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			try {
				ExcelExportUtil.createExcel(cnEn, titleEn, ss, "广告主收入确认审核列表", response);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	

	private static BigDecimal getProfitInfo(List<Map<String, Object>> fos) {
		
		BigDecimal profit = new BigDecimal((String)fos.get(0).get("profit"));
		BigDecimal profitPer = profit.multiply(new BigDecimal(100));
		return profitPer.divide((BigDecimal)fos.get(0).get("financialSubmitOamount"), 2, BigDecimal.ROUND_HALF_UP);
	}

}
