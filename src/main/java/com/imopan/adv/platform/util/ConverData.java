

package com.imopan.adv.platform.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;

/**
 * 
 * ClassName: ConverData <br/>
 * Function: 用于数据的转换 <br/>
 * date: 2016年5月17日 上午11:48:56 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.7
 */
@Controller
public class ConverData {

	/**
	 * 数据转换
	 * 
	 * @param mark
	 * @param object
	 */
	public static void converData(String mark, Map<String, Object> map) {
		if ("receipthistorylist".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("status".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 0) {
							entry.setValue("未结算");
						} else if (status == 1) {
							entry.setValue("已结算");
						}
					}
				}
				if ("cpMain".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte cpMain = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (cpMain == 1) {
							entry.setValue("磨盘精准");
						} else if (cpMain == 2) {
							entry.setValue("磨盘云讯");
						} else if (cpMain == 3) {
							entry.setValue("中传佳讯");
						}else if (cpMain == 3) {
							entry.setValue("机锋科技");
						}
					}
				}
				if ("orderDepartment".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 4) {
							entry.setValue("移动广告部");
						} else if (status == 5) {
							entry.setValue("效果广告部");
						} else if (status == 6) {
							entry.setValue("游戏联运(单机)");
						} 
					}
				}
				if ("isCashierTicket".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte isCashierTicket = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (isCashierTicket == 0) {
							entry.setValue("是");
						} else if (isCashierTicket == 1) {
							entry.setValue("否");
						}
					}
				}
				/*
				 * if ("money".equals(entry.getKey())) { if (entry.getValue() ==
				 * null || entry.getValue() == "") { entry.setValue("--"); }
				 * else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * } if ("subOAmount".equals(entry.getKey())) { if
				 * (entry.getValue() == null || entry.getValue() == "") {
				 * entry.setValue("--"); } else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * } if ("cut".equals(entry.getKey())) { if (entry.getValue() ==
				 * null || entry.getValue() == "") { entry.setValue("--"); }
				 * else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * } if ("returnMoney".equals(entry.getKey())) { if
				 * (entry.getValue() == null || entry.getValue() == "") {
				 * entry.setValue("--"); } else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * }
				 */
				if ("operateTime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("dataTime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("ticketBegintime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("ticketEndtime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("returnDate".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
			}
		}
		else if ("incomeCostHistoryList".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("extendType".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
					    switch (status) {
						case 1:
							entry.setValue("CPC");
							break;
						case 2:
							entry.setValue("CPA");
							break;
						case 3:
							entry.setValue("CPT");
							break;
						case 4:
							entry.setValue("冲榜");
							break;
						case 5:
							entry.setValue("CPD");
							break;
						case 6:
							entry.setValue("快速任务");
							break;
						case 7:
							entry.setValue("ASO");
							break;
						case 8:
							entry.setValue("CPS");
							break;
						case 9:
							entry.setValue("CPM");
							break;
						case 10:
							entry.setValue("其他");
							break;
						default:
							break;
						}        
					}
				}
				
				
				if ("orderDepartment".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 4) {
							entry.setValue("移动广告部");
						} else if (status == 5) {
							entry.setValue("效果广告部");
						} else if (status == 6) {
							entry.setValue("游戏联运(单机)");
						} 
					}
				}
			}
		}
		else if ("channelAuditDayList".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("financialSubmitChannelDate".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("entryTime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("orderDepartment".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 4) {
							entry.setValue("移动广告部");
						} else if (status == 5) {
							entry.setValue("效果广告部");
						} else if (status == 6) {
							entry.setValue("游戏联运(单机)");
						} 
					}
				}
				if ("channelSubmitConfirm".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("financialSubmitChannelStatus".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
					    switch (status) {
						case 0:
							entry.setValue("未提交");
							break;
						case 1:
							entry.setValue("提交未审核");
							break;
						case 2:
							entry.setValue("提交未通过");
							break;
						case 3:
							entry.setValue("提交通过");
							break;
						default:
							break;
						}        
					}
				}
				if ("channelMonthStatus".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
					    switch (status) {
						case 0:
							entry.setValue("未对账");
							break;
						case 1:
							entry.setValue("已对账");
							break;
						default:
							break;
						}        
					}
				}
				
				
			}
		}
		else if ("receivehistorylist".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {

				/*
				 * if ("money".equals(entry.getKey())) { if (entry.getValue() ==
				 * null || entry.getValue() == "") { entry.setValue("--"); }
				 * else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * } if ("payMoney".equals(entry.getKey())) { if
				 * (entry.getValue() == null || entry.getValue() == "") {
				 * entry.setValue("--"); } else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * }
				 */
				if ("channelTime".equals(entry.getKey())) {

					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("dataTime".equals(entry.getKey())) {
					Date createTime = (Date) entry.getValue();
					entry.setValue(DateUtil.dateToStr(createTime));
				}
				if ("payDate".equals(entry.getKey())) {
					Date createTime = (Date) entry.getValue();
					entry.setValue(DateUtil.dateToStr(createTime));
				}
				if ("status".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 0) {
							entry.setValue("未结算");
						} else if (status == 1) {
							entry.setValue("已结算");
						}
					}
				}
			}
		} else if ("dayBillList".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {

				/*
				 * if ("oAmount".equals(entry.getKey())) { if (entry.getValue()
				 * == null || entry.getValue() == "") { entry.setValue("--"); }
				 * else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * } if ("cAmount".equals(entry.getKey())) { if
				 * (entry.getValue() == null || entry.getValue() == "") {
				 * entry.setValue("--"); } else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * } if ("profit".equals(entry.getKey())) { if (entry.getValue()
				 * == null || entry.getValue() == "") { entry.setValue("--"); }
				 * else { entry.setValue("￥" +
				 * String.valueOf(entry.getValue())); }
				 * 
				 * }
				 */
				if ("profitMargin".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						entry.setValue(new BigDecimal(Float.valueOf(entry.getValue().toString()) * 100)
								.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "%");
					}

				}
				if ("orderDepartment".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 4) {
							entry.setValue("移动广告部");
						} else if (status == 5) {
							entry.setValue("效果广告部");
						} else if (status == 6) {
							entry.setValue("游戏联运(单机)");
						} 
					}
				}
			}
		} else if ("**".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {

				if ("ocUnit".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						entry.setValue("￥" + String.valueOf(entry.getValue()));
					}
				}
				if ("ocAmount".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						entry.setValue("￥" + String.valueOf(entry.getValue()));
					}
				}

				if ("entryData".equals(entry.getKey())) {
					if ("0".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("未录");
					}
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("已录");
					}
				}

			}
		} else if ("developerdrawlist".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {

				if ("drawmoney".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						entry.setValue("￥" + String.valueOf(entry.getValue()));
					}
				}
				if ("developertype".equals(entry.getKey())) {
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("个人");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("公司");
					}
				}
				if ("status".equals(entry.getKey())) {// 1 待审核 2 审核通过 3
					// 审核拒绝4取消申请
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("待审核");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("审核通过");
					}
					if ("3".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("审核拒绝");
					}
					if ("4".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("取消申请");
					}
				}

			}
		} else if ("exportChannelMonthAuditList".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("financialSubmitChannelStatus".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 0) {
							entry.setValue("未提交");
						} else if (status == 1) {
							entry.setValue("提交未审核");
						} else if (status == 2) {
							entry.setValue("审核未通过");
						} else if (status == 3) {
							entry.setValue("审核通过");
						}
					}
				}
				
				if ("orderDepartment".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 4) {
							entry.setValue("移动广告部");
						} else if (status == 5) {
							entry.setValue("效果广告部");
						} else if (status == 6) {
							entry.setValue("游戏联运(单机)");
						} 
					}
				}
				
				if ("financialSubmitChannelDate".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("entryBegintime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("entryEndtime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("channelSubmitConfirm".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
			}
		}else if ("auditOcDayList".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("financialSubmitCpStatus".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 0) {
							entry.setValue("未提交");
						} else if (status == 1) {
							entry.setValue("提交未审核");
						} else if (status == 2) {
							entry.setValue("审核未通过");
						} else if (status == 3) {
							entry.setValue("审核通过");
						}
					}
				}
				if ("orderMonthStatus".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 0) {
							entry.setValue("未对账");
						} else if (status == 1) {
							entry.setValue("已对账");
						} 
					}
				}
				if ("orderDepartment".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 4) {
							entry.setValue("移动广告部");
						} else if (status == 5) {
							entry.setValue("效果广告部");
						} else if (status == 6) {
							entry.setValue("游戏联运(单机)");
						} 
					}
				}
				if ("entryTime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("orderSubmitConfirm".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("financialSubmitCpDate".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				
				/*if ("cpSubmitOcount".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					}
				}
				if ("cpSubmitOamount".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					}
				}
				if ("financialSubmitOcount".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					}
				}
				if ("financialSubmitOamount".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					}
				}*/
				
				
			}
		}else if ("orderMonthAuditList".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("financialSubmitOrderStatus".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 0) {
							entry.setValue("未提交");
						} else if (status == 1) {
							entry.setValue("提交未审核");
						} else if (status == 2) {
							entry.setValue("审核未通过");
						} else if (status == 3) {
							entry.setValue("审核通过");
						}
					}
				}
				if ("drawBillStatus".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 0) {
							entry.setValue("未申请出票");
						} else if (status == 1) {
							entry.setValue("已申请未出票");
						} else if (status == 2) {
							entry.setValue("已出票");
						} 
					}
				}
				if ("orderDepartment".equals(entry.getKey())) {
					if (entry.getValue() != null && entry.getValue() != "") {
						Byte status = Integer.valueOf(entry.getValue().toString()).byteValue();
						if (status == 4) {
							entry.setValue("移动广告部");
						} else if (status == 5) {
							entry.setValue("效果广告部");
						} else if (status == 6) {
							entry.setValue("游戏联运(单机)");
						} 
					}
				}
				if ("entryBegintime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("entryEndtime".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("orderSubmitConfirm".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				if ("financialSubmitOrderDate".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						Date createTime = (Date) entry.getValue();
						entry.setValue(DateUtil.dateToStr(createTime));
					}
				}
				
			}
		}
	}

	public static void converData2(String mark, Map<String, Object> map, HashMap resmap) {
		if ("**".equals(mark)) {
			for (Entry<String, Object> entry : map.entrySet()) {

				if ("ocUnit".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						entry.setValue("￥" + String.valueOf(entry.getValue()));
					}
				}
				if ("ocAmount".equals(entry.getKey())) {
					if (entry.getValue() == null || entry.getValue() == "") {
						entry.setValue("--");
					} else {
						entry.setValue("￥" + String.valueOf(entry.getValue()));
					}
				}

				if ("entryData".equals(entry.getKey())) {
					if ("0".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("未录");
					}
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("已录");
					}
				}

			}
		} else if ("mediaday".equals(mark)) {

			for (Entry<String, Object> entry : map.entrySet()) {

				if ("MEDIA_ID".equals(entry.getKey())) {

					String mediaid = String.valueOf(entry.getValue());
					if (mediaid != null && !"".equals(mediaid) && !"null".equals(mediaid)) {
						Object medianame = resmap.get(Integer.parseInt(mediaid));
						entry.setValue(mediaid + "-" + medianame);
					}

				}
				if ("AD_TYPE".equals(entry.getKey())) {
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("banner");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("插屏");
					}
				}
				if ("OS".equals(entry.getKey())) {// 1 待审核 2 审核通过 3 审核拒绝4取消申请
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("IOS");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("Android");
					}

				}
				// "reqCount","showCount","clkCount","money"
				// ,"clkR","fillR"
				if ("reqCount".equals(entry.getKey()) || "showCount".equals(entry.getKey())
						|| "clkCount".equals(entry.getKey()) || "money".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())));
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue);
				}
				if ("clkR".equals(entry.getKey()) || "fillR".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())) * 100);
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue + "%");
				}

			}

		} else if ("throwinday".equals(mark)) {

			for (Entry<String, Object> entry : map.entrySet()) {

				if ("AID".equals(entry.getKey())) {

					String aid = String.valueOf(entry.getValue());
					if (aid != null && !"".equals(aid) && !"null".equals(aid)) {
						Object aname = resmap.get((aid));
						entry.setValue(aid + "-" + aname);
					}
				}

				if ("AD_TYPE".equals(entry.getKey())) {
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("banner");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("插屏");
					}
				}
				if ("OS".equals(entry.getKey())) {
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("IOS");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("Android");
					}

				}
				//
				if ("sCount".equals(entry.getKey()) || "cClick".equals(entry.getKey())
						|| "acCount".equals(entry.getKey()) || "money".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())));
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue);
				}
				if ("crCount".equals(entry.getKey()) || "acrCount".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())) * 100);
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue + "%");
				}

			}

		} else if ("throwinadincome".equals(mark)) {

			for (Entry<String, Object> entry : map.entrySet()) {

				if ("AID".equals(entry.getKey())) {

					String aid = String.valueOf(entry.getValue());
					if (aid != null && !"".equals(aid) && !"null".equals(aid)) {
						Object aname = resmap.get((aid));
						entry.setValue(aid + "-" + aname);
					}
				}
				if ("AD_TYPE".equals(entry.getKey())) {
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("banner");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("插屏");
					}
				}
				if ("OS".equals(entry.getKey())) {
					if ("1".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("IOS");
					}
					if ("2".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("Android");
					}

				}
				if ("PAY_TYPE".equals(entry.getKey())) {
					if ("102".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("cpm");
					}
					if ("103".equals(String.valueOf(entry.getValue()))) {
						entry.setValue("cpc");
					}

				}
				if ("icount".equals(entry.getKey()) || "imoney".equals(entry.getKey())
						|| "omoney".equals(entry.getKey()) || "cmoney".equals(entry.getKey())
						|| "ecpm".equals(entry.getKey()) || "ecpc".equals(entry.getKey())
						|| "ecpa".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())));
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue);
				}
				if ("cr".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())) * 100);
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue + "%");
				}

			}

		}else if ("basicindicator".equals(mark)) {

			for (Entry<String, Object> entry : map.entrySet()) {
				if ( "amountPaid".equals(entry.getKey())|| "amountWithdrawCash".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())));
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue);
				}
				if ("totalincome".equals(entry.getKey())) {
					JSONArray value = (JSONArray)entry.getValue();
					Object valuestr = value.get(0);
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(valuestr)));
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue);
				}
				if ("taskcomper".equals(entry.getKey())) {
					JSONArray value = (JSONArray)entry.getValue();
					Object valuestr = value.get(0);
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(valuestr)) * 100);
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue + "%");
				}

			}

		}else if ("basicindicatordetail".equals(mark)) {

			for (Entry<String, Object> entry : map.entrySet()) {
				if ( "amountPaid".equals(entry.getKey())|| "amountWithdrawCash".equals(entry.getKey())) {
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(entry.getValue())));
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue);
				}
				if ("totalincome".equals(entry.getKey())||"taskcompernum".equals(entry.getKey())) {
					JSONArray value = (JSONArray)entry.getValue();
					Object valuestr = value.get(0);
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(valuestr)));
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue);
				}
				if ("taskcomper".equals(entry.getKey())) {
					JSONArray value = (JSONArray)entry.getValue();
					Object valuestr = value.get(0);
					BigDecimal b = new BigDecimal(Double.parseDouble(String.valueOf(valuestr)) * 100);
					double doubleValue = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					entry.setValue(doubleValue + "%");
				}

			}

		}
	}
	
	
}
