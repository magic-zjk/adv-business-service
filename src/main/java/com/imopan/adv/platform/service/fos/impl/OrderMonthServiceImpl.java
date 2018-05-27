/** 
 * Project Name:adv-business-service 
 * File Name:OrderMonthServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年4月28日下午3:34:43 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
 */

package com.imopan.adv.platform.service.fos.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosAuditOrderMonth;
import com.imopan.adv.platform.entity.fos.FosCycleBill;
import com.imopan.adv.platform.entity.fos.FosOcDay;
import com.imopan.adv.platform.entity.fos.FosOcDayExample;
import com.imopan.adv.platform.entity.fos.FosOrderMonth;
import com.imopan.adv.platform.entity.fos.FosOrderMonthExample;
import com.imopan.adv.platform.entity.fos.FosOrderMonthExample.Criteria;
import com.imopan.adv.platform.mapper.fos.FosAuditOrderMonthMapper;
import com.imopan.adv.platform.mapper.fos.FosOcDayMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderMonthMapper;
import com.imopan.adv.platform.service.fos.IOrderMonthService;
import com.imopan.adv.platform.util.FosDataControllerUtil;
import com.imopan.adv.platform.vo.fos.FosAuditOrderMonthVo;

/**
 * ClassName:OrderMonthServiceImpl <br/>
 * Function: 订单对账实现类. <br/>
 * Date: 2016年4月28日 下午3:34:43 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.7
 */
@Service
public class OrderMonthServiceImpl implements IOrderMonthService {

	@Autowired
	private FosOrderMonthMapper orderMonthDao;
	@Autowired
	private FosOcDayMapper ocDayDao;
	@Autowired
	private FosAuditOrderMonthMapper auditOrderMonthDao;

	@Override
	public PageBean<FosOrderMonth> getOrderMonthList(VoPageBaseBean vpbb) {
		PageBean<FosOrderMonth> pageBean = new PageBean<FosOrderMonth>();
		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {
			if (map.get("orderName") != null
					&& StringUtils.isNotEmpty(map.get("orderName").toString())) {
				hashMap.put("orderName", "%" + map.get("orderName") + "%");
			}
			if (map.get("productName") != null
					&& StringUtils
							.isNotEmpty(map.get("productName").toString())) {
				hashMap.put("productName", "%" + map.get("productName") + "%");
			}
			if (map.get("orderId") != null
					&& StringUtils.isNotEmpty(map.get("orderId").toString())) {
				hashMap.put("orderId", map.get("orderId"));
			}
			if (map.get("entryBegintime") != null
					&& StringUtils.isNotEmpty(map.get("entryBegintime")
							.toString())) {
				hashMap.put("entryBegintime", map.get("entryBegintime")
						.toString().split("T")[0]);
			}
			if (map.get("entryEndtime") != null
					&& StringUtils.isNotEmpty(map.get("entryEndtime")
							.toString())) {
				hashMap.put("entryEndtime", map.get("entryEndtime").toString()
						.split("T")[0]);
			}
		}
		if (vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null) {
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}

		// 数据级权限控制
		FosDataControllerUtil.assignmentMap(hashMap);

		List<FosOrderMonth> list = orderMonthDao.findOrderMonth(hashMap);
		int i = orderMonthDao.countFindOrderMonth(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;
	}

	@Override
	@Transactional
	public int checkordermonth(FosOrderMonth fos, boolean b) {
		// 查询所有符合条件的每日数据，如果每日数据中的ORDER_MONTH_STATUS的值为1,则返回不可对账。
		FosOcDayExample ocDayExample = new FosOcDayExample();
		com.imopan.adv.platform.entity.fos.FosOcDayExample.Criteria criteria = ocDayExample
				.createCriteria();
		criteria.andOrderIdEqualTo(fos.getOrderId());
		criteria.andEntryDayStatusEqualTo((byte) 1);
		criteria.andOcDayStatusEqualTo((byte) 0);
		criteria.andEntryTimeGreaterThanOrEqualTo(fos.getEntryBegintime());
		criteria.andEntryTimeLessThanOrEqualTo(fos.getEntryEndtime());
		criteria.andOrderMonthStatusEqualTo((byte) 1);
		int j = ocDayDao.countByExample(ocDayExample);

		if (j >= 1) {
			return -1;
		}
		FosOcDay fosOcDay = new FosOcDay();
		fosOcDay.setOrderMonthStatus((byte) 1);

		// if(!b){
		FosOcDayExample ocDayExample1 = new FosOcDayExample();
		com.imopan.adv.platform.entity.fos.FosOcDayExample.Criteria criteria1 = ocDayExample1
				.createCriteria();
		criteria1.andOrderIdEqualTo(fos.getOrderId());
		criteria1.andEntryDayStatusEqualTo((byte) 1);
		criteria1.andOcDayStatusEqualTo((byte) 0);
		criteria1.andEntryTimeGreaterThanOrEqualTo(fos.getEntryBegintime());
		criteria1.andEntryTimeLessThanOrEqualTo(fos.getEntryEndtime());
		ocDayDao.updateByExampleSelective(fosOcDay, ocDayExample1);// 更新每日数据的订单对账状态
		// }

		fos.setCreateTime(new Date());
		fos.setModifyTime(new Date());
		if (b) {
			fos.setEntryMonthStatus((byte) 2);// 设置部分对账
		} else {
			fos.setEntryMonthStatus((byte) 1);
		}
		fos.setEntryMoney((byte) 1);
		fos.setEntryTicket((byte) 1);
		fos.setSubOAmount(fos.getoAmount());
		int i = orderMonthDao.insertSelective(fos);
		return i;
	}

	@Override
	public PageBean<FosOrderMonth> getOrderMonthHistoryList(VoPageBaseBean vpbb) {
		PageBean<FosOrderMonth> pageBean = new PageBean<FosOrderMonth>();
		FosOrderMonthExample ex = new FosOrderMonthExample();
		Criteria criteria = ex.createCriteria();
		HashMap<String, Object> map = vpbb.getParammap();
		if (map != null) {

			if (map.get("orderName") != null
					&& StringUtils.isNotEmpty(map.get("orderName").toString())) {
				criteria.andOrderNameLike("%" + map.get("orderName") + "%");
			}
			if (map.get("productName") != null
					&& StringUtils
							.isNotEmpty(map.get("productName").toString())) {
				criteria.andProductNameLike("%" + map.get("productName") + "%");
			}
			if (map.get("id") != null
					&& StringUtils.isNotEmpty(map.get("id").toString())) {
				criteria.andIdEqualTo(Integer.valueOf(map.get("id").toString()));
			}
			if (map.get("entryBegintime") != null
					&& StringUtils.isNotEmpty(map.get("entryBegintime")
							.toString())) {
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(map.get(
							"entryBegintime").toString());
					criteria.andEntryBegintimeEqualTo(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
			if (map.get("entryEndtime") != null
					&& StringUtils.isNotEmpty(map.get("entryEndtime")
							.toString())) {
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(map.get(
							"entryEndtime").toString());
					criteria.andEntryEndtimeEqualTo(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (map.get("status") != null
					&& StringUtils.isNotEmpty(map.get("status").toString())) {
				criteria.andStatusEqualTo(Integer.valueOf(
						map.get("status").toString()).byteValue());
			}
			if (map.get("entryMoney") != null
					&& StringUtils.isNotEmpty(map.get("entryMoney").toString())) {
				criteria.andEntryMoneyEqualTo(Integer.valueOf(
						map.get("entryMoney").toString()).byteValue());
			}
			if (map.get("entryTicket") != null
					&& StringUtils
							.isNotEmpty(map.get("entryTicket").toString())) {
				criteria.andEntryTicketEqualTo(Integer.valueOf(
						map.get("entryTicket").toString()).byteValue());
			}

		}

		if (vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null) {
			ex.setLimitStart(vpbb.getLimitStart());
			ex.setLimitEnd(vpbb.getLimitEnd());
		} else {
			ex.setLimitStart(new Integer(0));
			ex.setLimitEnd(new Integer(20));
		}

		ex.setOrderByClause("MODIFY_TIME desc");
		// 查询
		List<FosOrderMonth> list = orderMonthDao.selectByExample(ex);
		int i = orderMonthDao.countByExample(ex);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);

		return pageBean;
	}

	@Override
	public int updateOrderMonth(FosOrderMonth fos) {
		FosOrderMonth fosOrderMonth = new FosOrderMonth();
		fosOrderMonth.setId(fos.getId());
		fosOrderMonth.setoCount(fos.getoCount());
		fosOrderMonth.setoAmount(fos.getoAmount());
		fosOrderMonth.setSubOAmount(fos.getSubOAmount());
		fosOrderMonth.setCut(fos.getCut());
		fosOrderMonth.setSaleRebate(fos.getSaleRebate());
		fosOrderMonth.setModifyTime(new Date());
		int i = orderMonthDao.updateByPrimaryKeySelective(fosOrderMonth);
		return i;
	}

	@Override
	public PageBean<FosCycleBill> getCycleBillList(VoPageBaseBean vpbb) {

		PageBean<FosCycleBill> pageBean = new PageBean<FosCycleBill>();
		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {
			if (map.get("orderName") != null
					&& StringUtils.isNotEmpty(map.get("orderName").toString())) {
				hashMap.put("orderName", "%" + map.get("orderName") + "%");
			}
			/*
			 * if(map.get("productName") != null &&
			 * StringUtils.isNotEmpty(map.get("productName").toString())){
			 * hashMap.put("productName","%"+map.get("productName")+"%"); }
			 * if(map.get("orderId") != null &&
			 * StringUtils.isNotEmpty(map.get("orderId").toString())){
			 * hashMap.put("orderId",map.get("orderId")); }
			 * if(map.get("entryBegintime") != null &&
			 * StringUtils.isNotEmpty(map.get("entryBegintime").toString())){
			 * hashMap
			 * .put("entryBegintime",map.get("entryBegintime").toString().
			 * split("T")[0]); } if(map.get("entryEndtime") != null &&
			 * StringUtils.isNotEmpty(map.get("entryEndtime").toString())){
			 * hashMap
			 * .put("entryEndtime",map.get("entryEndtime").toString().split
			 * ("T")[0]); }
			 */
		}
		if (vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null) {
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}

		List<FosCycleBill> list = orderMonthDao.findCycleBillList(hashMap);
		int i = orderMonthDao.countFindCycleBillList(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;

	}

	@Override
	public FosCycleBill getCycleBillListSum(VoPageBaseBean vpbb) {

		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {
			if (map.get("orderName") != null
					&& StringUtils.isNotEmpty(map.get("orderName").toString())) {
				hashMap.put("orderName", "%" + map.get("orderName") + "%");
			}
			if (map.get("productName") != null
					&& StringUtils
							.isNotEmpty(map.get("productName").toString())) {
				hashMap.put("productName", "%" + map.get("productName") + "%");
			}
			if (map.get("orderId") != null
					&& StringUtils.isNotEmpty(map.get("orderId").toString())) {
				hashMap.put("orderId", map.get("orderId"));
			}
			if (map.get("entryBegintime") != null
					&& StringUtils.isNotEmpty(map.get("entryBegintime")
							.toString())) {
				hashMap.put("entryBegintime", map.get("entryBegintime")
						.toString().split("T")[0]);
			}
			if (map.get("entryEndtime") != null
					&& StringUtils.isNotEmpty(map.get("entryEndtime")
							.toString())) {
				hashMap.put("entryEndtime", map.get("entryEndtime").toString()
						.split("T")[0]);
			}
		}
		if (vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null) {
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}

		FosCycleBill fos = orderMonthDao.findCycleBillListSum(hashMap).get(0);
		return fos;

	}

	@Override
	public PageBean<FosCycleBill> getCycleBillDetail(VoPageBaseBean vpbb) {

		PageBean<FosCycleBill> pageBean = new PageBean<FosCycleBill>();
		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {
			if (map.get("orderName") != null
					&& StringUtils.isNotEmpty(map.get("orderName").toString())) {
				hashMap.put("orderName", "%" + map.get("orderName") + "%");
			}
			if (map.get("productName") != null
					&& StringUtils
							.isNotEmpty(map.get("productName").toString())) {
				hashMap.put("productName", "%" + map.get("productName") + "%");
			}
			if (map.get("channelName") != null
					&& StringUtils
							.isNotEmpty(map.get("channelName").toString())) {
				hashMap.put("channelName", "%" + map.get("channelName") + "%");
			}
			if (map.get("orderId") != null
					&& StringUtils.isNotEmpty(map.get("orderId").toString())) {
				hashMap.put("orderId", map.get("orderId"));
			}
			if (map.get("entryBegintime") != null
					&& StringUtils.isNotEmpty(map.get("entryBegintime")
							.toString())) {
				hashMap.put("entryBegintime", map.get("entryBegintime")
						.toString().split("T")[0]);
			}
			if (map.get("entryEndtime") != null
					&& StringUtils.isNotEmpty(map.get("entryEndtime")
							.toString())) {
				hashMap.put("entryEndtime", map.get("entryEndtime").toString()
						.split("T")[0]);
			}
			if (map.get("groupByName") != null
					&& StringUtils
							.isNotEmpty(map.get("groupByName").toString())) {
				hashMap.put("groupByName", map.get("groupByName"));
			}
		}
		if (vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null) {
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}

		List<FosCycleBill> list = orderMonthDao.findCycleBillDetail(hashMap);
		int i = orderMonthDao.countFindCycleBillDetail(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);
		return pageBean;

	}

	@Override
	public int checkOrderMonthSubmit(FosOrderMonth fos, boolean b) {
		// 查询所有符合条件的每日数据，如果每日数据中的ORDER_MONTH_STATUS的值为1,则返回不可对账。
		FosOcDayExample ocDayExample = new FosOcDayExample();
		com.imopan.adv.platform.entity.fos.FosOcDayExample.Criteria criteria = ocDayExample
				.createCriteria();
		criteria.andOrderIdEqualTo(fos.getOrderId());
		criteria.andEntryDayStatusEqualTo((byte) 1);
		criteria.andOcDayStatusEqualTo((byte) 0);
		criteria.andEntryTimeGreaterThanOrEqualTo(fos.getEntryBegintime());
		criteria.andEntryTimeLessThanOrEqualTo(fos.getEntryEndtime());
		// int k = ocDayDao.countByExample(ocDayExample);
		criteria.andOrderMonthStatusEqualTo((byte) 1);
		int j = ocDayDao.countByExample(ocDayExample);

		if (j >= 1) {
			return -1;
		}

		/*
		 * FosOcDay fosOcDay = new FosOcDay();
		 * fosOcDay.setOrderMonthStatus((byte)1);
		 * 
		 * FosOcDayExample ocDayExample1 = new FosOcDayExample();
		 * com.imopan.adv.platform.entity.fos.FosOcDayExample.Criteria criteria1
		 * = ocDayExample1.createCriteria();
		 * criteria1.andOrderIdEqualTo(fos.getOrderId());
		 * criteria1.andEntryDayStatusEqualTo((byte)1);
		 * criteria1.andOcDayStatusEqualTo((byte)0);
		 * criteria1.andEntryTimeGreaterThanOrEqualTo(fos.getEntryBegintime());
		 * criteria1.andEntryTimeLessThanOrEqualTo(fos.getEntryEndtime());
		 * ocDayDao.updateByExampleSelective(fosOcDay,
		 * ocDayExample1);//更新每日数据的订单对账状态
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", fos.getOrderId());
		map.put("entryDayStatus", 1);
		map.put("ocDayStatus", 0);
		map.put("entryBegintime", fos.getEntryBegintime());
		map.put("entryEndtime", fos.getEntryEndtime());
		map.put("financialSubmitCpStatus", 3);
		ocDayDao.updateOrderMonthStatus(map);
		
		

		fos.setCreateTime(new Date());
		fos.setModifyTime(new Date());
		fos.setEntryMonthStatus((byte) 1);
		fos.setEntryMoney((byte) 1);
		fos.setEntryTicket((byte) 1);
		fos.setSubOAmount(fos.getoAmount());
		int i = orderMonthDao.insertSelectiveGetId(fos);

		// 创建与订单对账表关联的订单对账财务审核表
		FosAuditOrderMonth fosAuditOrderMonth = new FosAuditOrderMonth();
		fosAuditOrderMonth.setFosOrderMonthId(fos.getId());
		fosAuditOrderMonth.setOrderSubmitConfirm(new Date());
		fosAuditOrderMonth.setFinancialSubmitOrderStatus((byte) 1);
		fosAuditOrderMonth.setDrawBillStatus((byte) 0);
		int m = auditOrderMonthDao.insertSelective(fosAuditOrderMonth);

		return i;
	}

	@Override
	public PageBean<FosAuditOrderMonthVo> getAuditOrderMonthList(
			VoPageBaseBean vpbb) {
		PageBean<FosAuditOrderMonthVo> pageBean = new PageBean<FosAuditOrderMonthVo>();
		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {

			if (map.get("orderName") != null
					&& StringUtils.isNotEmpty(map.get("orderName").toString())) {
				hashMap.put("orderName", "%" + map.get("orderName") + "%");
			}
			if (map.get("productName") != null
					&& StringUtils
							.isNotEmpty(map.get("productName").toString())) {
				hashMap.put("productName", "%" + map.get("productName") + "%");
			}
			if (map.get("id") != null
					&& StringUtils.isNotEmpty(map.get("id").toString())) {
				hashMap.put("id", map.get("id").toString());
			}

			if (map.get("orderDepartment") != null
					&& StringUtils.isNotEmpty(map.get("orderDepartment")
							.toString())) {
				hashMap.put("orderDepartment", map.get("orderDepartment")
						.toString());
			}

			/*
			 * if(map.get("entryBegintime") != null &&
			 * StringUtils.isNotEmpty(map.get("entryBegintime").toString())){
			 * hashMap
			 * .put("entryBegintime",map.get("entryBegintime").toString().
			 * split("T")[0]); } if(map.get("entryEndtime") != null &&
			 * StringUtils.isNotEmpty(map.get("entryEndtime").toString())){
			 * hashMap
			 * .put("entryEndtime",map.get("entryEndtime").toString().split
			 * ("T")[0]); }
			 */

			if (map.get("status") != null
					&& StringUtils.isNotEmpty(map.get("status").toString())) {
				hashMap.put("status", map.get(map.get("status").toString()));
			}
			if (map.get("entryMoney") != null
					&& StringUtils.isNotEmpty(map.get("entryMoney").toString())) {
				hashMap.put("entryMoney", map.get("entryMoney").toString());
			}
			if (map.get("entryTicket") != null
					&& StringUtils
							.isNotEmpty(map.get("entryTicket").toString())) {
				hashMap.put("entryTicket", map.get("entryTicket").toString());
			}

			if (map.get("financialSubmitOrderStatus") != null
					&& StringUtils.isNotEmpty(map.get(
							"financialSubmitOrderStatus").toString())) {
				hashMap.put("financialSubmitOrderStatus",
						map.get("financialSubmitOrderStatus").toString());
			}
			if (map.get("financialSubmitOrderNotthroughTime") != null
					&& StringUtils.isNotEmpty(map.get(
							"financialSubmitOrderNotthroughTime").toString())) {
				hashMap.put("financialSubmitOrderNotthroughTime",
						map.get("financialSubmitOrderNotthroughTime")
								.toString());
			}
			if (map.get("drawBillStatus") != null
					&& StringUtils.isNotEmpty(map.get("drawBillStatus")
							.toString())) {
				hashMap.put("drawBillStatus", map.get("drawBillStatus")
						.toString());
			}

		}

		if (vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null) {
			hashMap.put("LimitStart", vpbb.getLimitStart());
			hashMap.put("LimitEnd", vpbb.getLimitEnd());
		}

		// 数据级权限控制
		FosDataControllerUtil.assignmentMap(hashMap);

		// hashMap.put("orderBy", "MODIFY_TIME desc");

		// 查询
		List<FosAuditOrderMonthVo> list = orderMonthDao
				.getAuditOrderMonthList(hashMap);
		int i = orderMonthDao.countGetAuditOrderMonthList(hashMap);
		pageBean.setDataList(list);
		pageBean.setTotalRecord(i);

		return pageBean;
	}

}
