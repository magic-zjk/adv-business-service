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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.ResultBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosCycleBill;
import com.imopan.adv.platform.entity.fos.FosDailyBill;
import com.imopan.adv.platform.entity.fos.FosHistory;
import com.imopan.adv.platform.entity.fos.FosOrderMonthHistory;
import com.imopan.adv.platform.entity.fos.FosReceiveOrder;
import com.imopan.adv.platform.entity.fos.FosTicketOrder;
import com.imopan.adv.platform.entity.fos.FosTicketOrderImpl;
import com.imopan.adv.platform.service.fos.IHistoryService;
import com.imopan.adv.platform.service.fos.IOcDayService;
import com.imopan.adv.platform.service.fos.IOrderMonthService;
import com.imopan.adv.platform.service.fos.ITicketOrderService;
import com.imopan.adv.platform.util.ExcelExportUtil;
import com.imopan.adv.platform.util.PageUtil;
import com.imopan.adv.platform.vo.fos.FosOrderVo;

/**
 * ClassName:BillController <br/>
 * Function: 报表控制层. <br/>
 * Date: 2016年5月25日 下午2:15:59 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/bill")
public class BillController {
	private static Logger foslog = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private IOcDayService ocDayServiceImpl;
	@Autowired
	private IOrderMonthService orderMonthServiceImpl;
	@Autowired
	private IHistoryService historyServiceImpl;
	@Autowired
	private ITicketOrderService ticketOrderServiceImpl;
	/**
	 * 
	 * getDayBillList:每日账单. <br/>
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getDayBillList")
	@ResponseBody
	public ResultBean getDayBillList(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		// 查询
		PageBean<FosDailyBill> result = ocDayServiceImpl.getDayBillList(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
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
			@RequestParam(value = "cooperateName", required = false) String cooperateName,
			@RequestParam(value = "orderDepartment", required = false) Integer orderDepartment,
			@RequestParam(value = "orderMonthStatus", required = false) String orderMonthStatus,
			@RequestParam(value = "channelMonthStatus", required = false) String channelMonthStatus,
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
		map.put("cooperateName", cooperateName);
		map.put("orderDepartment", orderDepartment);
		map.put("orderMonthStatus", orderMonthStatus);
		map.put("channelMonthStatus", channelMonthStatus);
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
		mapSum.put("cooperateName", cooperateName);
		mapSum.put("orderDepartment", orderDepartment);
		mapSum.put("orderMonthStatus", orderMonthStatus);
		mapSum.put("channelMonthStatus", channelMonthStatus);
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
		String[] titleEn = new String[] { "orderId", "orderName","orderDepartment", "productName", "orderDirectorName", "oCount", "oAmount",
				"cCount", "cAmount","profit","profitMargin" };
		String[] cnEn = new String[] { "订单Id", "订单名称","部门", "产品名称", "商务负责人", "订单数量", "订单金额", "渠道数量", "渠道金额","利润","利润率" };
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
	 * getHistoryList:历史数据查询. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getHistoryList")
	@ResponseBody
	public ResultBean getHistoryList(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		// 查询
		PageBean<FosOrderMonthHistory> result = historyServiceImpl.getHistoryList(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
	}
	
	@RequestMapping(value = "updateHistory")
	@ResponseBody
	public ResultBean updateHistory(@RequestBody FosOrderMonthHistory fos) {
		// 校验
		foslog.debug(fos.toString());
		// 查询
		int result = historyServiceImpl.updateHistory(fos);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
	}

	/**
	 * 
	 * getHistoryListSum：历史数据汇总. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return 
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getHistoryListSum")
	@ResponseBody
	public ResultBean getHistoryListSum(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		// 查询
		PageBean<FosOrderMonthHistory> result = historyServiceImpl.getHistoryListSum(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
	}
	
	/**
	 * 
	 * getCycleBillList:周期账单 <br/>
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getCycleBillList")
	@ResponseBody
	public ResultBean getCycleBillList(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		// 查询
		PageBean<FosCycleBill> result = orderMonthServiceImpl.getCycleBillList(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
	}

	/**
	 * 
	 * getCycleBillListSum:周期账单合计. <br/>
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getCycleBillListSum")
	@ResponseBody
	public ResultBean getCycleBillListSum(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		// 查询
		FosCycleBill result = orderMonthServiceImpl.getCycleBillListSum(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
	}

	/**
	 * 
	 * getCycleBillDetail:. <br/>
	 * 
	 * @author zhangjiakun
	 * @param vpbb
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getCycleBillDetail")
	@ResponseBody
	public ResultBean getCycleBillDetail(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		// 查询
		PageBean<FosCycleBill> result = orderMonthServiceImpl.getCycleBillDetail(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, result, "");
	}
	/**
	 * 
	 * getMonthIncomeHistoryList:获取出票历史列表,用于显示月收入查询列表 <br/>
	 * 
	 * @author sushengli
	 * @param vpbb
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getMonthIncomeHistoryList")
	@ResponseBody
	public ResultBean getMonthIncomeHistoryList(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		PageBean<FosTicketOrderImpl> p = ticketOrderServiceImpl.getMonthIncomeHistoryList(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, p, "");
	}
	
	/**
	 * 
	 * getMonthIncomeHistoryList:获取出票历史列表,用于显示月收入查询列表 <br/>
	 * 
	 * @author sushengli
	 * @param vpbb
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value = "getMonthIncomeSum")
	@ResponseBody
	public ResultBean getMonthIncomeSum(@RequestBody VoPageBaseBean vpbb) {
		// 校验
		foslog.debug(vpbb.toString());
		PageBean<FosTicketOrderImpl> p = ticketOrderServiceImpl.getMonthIncomeSum(vpbb);
		return new ResultBean(ResultBean.CODE_SUCCESS, 0, p, "");
	}
}
