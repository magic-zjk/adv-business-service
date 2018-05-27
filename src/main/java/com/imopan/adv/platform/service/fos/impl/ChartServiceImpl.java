/** 
 * Project Name:adv-business-service1.1 
 * File Name:ChartServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年7月19日上午10:47:16 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/

package com.imopan.adv.platform.service.fos.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.ChartData;
import com.imopan.adv.platform.entity.fos.ChertBean;
import com.imopan.adv.platform.mapper.fos.FosOcDayMapper;
import com.imopan.adv.platform.service.fos.IChartService;

/**
 * ClassName:ChartServiceImpl <br/>
 * Function: 画图实现类. <br/>
 * Date: 2016年7月19日 上午10:47:16 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.7
 */
@Service
public class ChartServiceImpl implements IChartService {
	private static Logger logger = LoggerFactory.getLogger(ChartServiceImpl.class);

	@Autowired
	private FosOcDayMapper ocDayDao;

	@Override
	public ChertBean chartcolumn(VoPageBaseBean vpbb) {
		ChertBean chertBean = new ChertBean();

		List<String> categories = new ArrayList<String>();
		List<Object> data = new ArrayList<Object>();
		List<Object> data_0 = new ArrayList<Object>();
		List<Object> data_1 = new ArrayList<Object>();
		List<ChartData> series = new ArrayList<ChartData>();

		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {

			if (map.get("beginTime") != null && StringUtils.isNotEmpty(map.get("beginTime").toString())) {
				hashMap.put("beginTime", map.get("beginTime").toString().split("T")[0]);
			}
			if (map.get("endTime") != null && StringUtils.isNotEmpty(map.get("endTime").toString())) {
				hashMap.put("endTime", map.get("endTime").toString().split("T")[0]);
			}
		}
		List<Map<String, Object>> list = null;
		if (map.get("flag").toString().equals("1")) {
			list = ocDayDao.getChartCooperateName(hashMap);// 按客户统计
		} else if (map.get("flag").toString().equals("2")) {
			list = ocDayDao.getChartChannel(hashMap);// 按渠道统计
		} else if (map.get("flag").toString().equals("3")) {
			list = ocDayDao.getChartOrderDirectorName(hashMap);// 按负责人统计
		}
		for (Map<String, Object> m : list) {

			if (map.get("flag").equals(1)) {
				if (m.get("COOPERATE_NAME") != null) {
					categories.add(m.get("COOPERATE_NAME").toString());
				} else {
					categories.add("0");
				}

			} else if (map.get("flag").equals(2)) {
				if (m.get("CHANNEL_NAME") != null) {
					categories.add(m.get("CHANNEL_NAME").toString());
				} else {
					categories.add("0");
				}

			} else if (map.get("flag").equals(3)) {
				if (m.get("ORDER_DIRECTOR_NAME") != null) {
					categories.add(m.get("ORDER_DIRECTOR_NAME").toString());
				} else {
					categories.add("0");
				}

			}

			if (m.get("O_AMOUNT") != null) {
				data.add(m.get("O_AMOUNT"));
			} else {
				data.add("0");
			}
			if (m.get("O_AMOUNT_0") != null) {
				data_0.add(m.get("O_AMOUNT_0"));
			} else {
				data_0.add("0");
			}
			if (m.get("O_AMOUNT_1") != null) {
				data_1.add(m.get("O_AMOUNT_1"));
			} else {
				data_1.add("0");
			}

		}

		ChartData chartData = new ChartData();
		ChartData chartData_0 = new ChartData();
		ChartData chartData_1 = new ChartData();
		chartData.setName("总金额");
		chartData.setData(data);
		series.add(chartData);
		chartData_0.setName("未对账");
		chartData_0.setData(data_0);
		series.add(chartData_0);
		chartData_1.setName("已对账");
		chartData_1.setData(data_1);
		series.add(chartData_1);

		chertBean.setCategories(categories);
		chertBean.setSeries(series);
		return chertBean;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ChertBean chartline(VoPageBaseBean vpbb) {
		ChertBean chertBean = new ChertBean();

		List<String> categories = new ArrayList<String>();
		List<ChartData> series = new ArrayList<ChartData>();

		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {

			if(map.get("name") != null && StringUtils.isNotEmpty(map.get("name").toString())){
				hashMap.put("name", map.get("name").toString());
			}
			if (map.get("beginTime") != null && StringUtils.isNotEmpty(map.get("beginTime").toString())) {
				hashMap.put("beginTime", map.get("beginTime").toString().split("T")[0]);
			}
			if (map.get("endTime") != null && StringUtils.isNotEmpty(map.get("endTime").toString())) {
				hashMap.put("endTime", map.get("endTime").toString().split("T")[0]);
			}
		}
		Date beginTime = new Date();
		Date endTime = new Date();
		try {
			beginTime = new SimpleDateFormat("yyyy-MM-dd").parse(map.get("beginTime").toString());
			endTime = new SimpleDateFormat("yyyy-MM-dd").parse(map.get("endTime").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LinkedHashSet calcCategoryArray = ChartServiceImpl.calcCategoryArray(
				new SimpleDateFormat("yyyyMMdd").format(beginTime), new SimpleDateFormat("yyyyMMdd").format(endTime),
				1l);
		ArrayList arraylist = ChartServiceImpl.linkedHashsetToArraylist(calcCategoryArray);
		for (Object object : arraylist) {

		}
		List<Map<String, Object>> list = null;
		if (map.get("flag").toString().equals("1")) {
			list = ocDayDao.getChartCooperateName_Line(hashMap);// 按客户统计
		} else if (map.get("flag").toString().equals("2")) {
			list = ocDayDao.getChartChannel_Line(hashMap);// 按渠道统计
		} else if (map.get("flag").toString().equals("3")) {
			list = ocDayDao.getChartOrderDirectorName_Line(hashMap);// 按负责人统计
		}

		HashSet<String> set = new LinkedHashSet<String>();

		// 缓存所有的名称，去重
		for (Map<String, Object> m : list) {
			String name = m.get("FLAG_NAME").toString();
			set.add(name);
		}

		for (String string : set) {
			ChartData chartData = new ChartData();
			chartData.setName(string);
			chartData.setData(new ArrayList<Object>());
			series.add(chartData);
		}

		//组装数据
		Iterator<ChartData> iterator = series.iterator();
		while (iterator.hasNext()) {
			ChartData next = iterator.next();
			for (Object time : arraylist) {
				Integer flag = 0;
				Date parse = new Date();
				try {
					parse = new SimpleDateFormat("yyyyMMdd").parse(time.toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				for (Map<String, Object> m : list) {
					if(next.getName().equals(m.get("FLAG_NAME"))){
						if(new SimpleDateFormat("yyyy-MM-dd").format(parse).toString().equals(m.get("ENTRY_TIME").toString())){
							if (m.get("O_AMOUNT") != null) {
								List<Object> data = next.getData();
								data.add(m.get("O_AMOUNT"));
								next.setData(data);
								flag = 1;
							}
						}
					}
				}
				if(flag == 0){
					List<Object> data = next.getData();
					data.add(0.00);
					next.setData(data);
				}
			}
		}
		chertBean.setCategories(arraylist);
		//if(series.size()>10){
			//chertBean.setSeries(series.subList(0, 10));
		//}else {
			chertBean.setSeries(series);
		//}
		return chertBean;
	}
	
	
	
	@Override
	public List<Map<String, Object>> getAllName(VoPageBaseBean vpbb) {
		HashMap<String, Object> map = vpbb.getParammap();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if (map != null) {
			if(map.get("flag") != null && StringUtils.isNotEmpty(map.get("flag").toString())){
				hashMap.put("flag", map.get("flag").toString());
			}
		}
		List<Map<String, Object>> list = ocDayDao.getAllName(hashMap);
		return list;
	}
	

	private static LinkedHashSet calcCategoryArray(String start, String end, long timetype) {

		// TODO timetype
		// start="20150120";
		// end="20150123";
		// 根据type 选择不同的时间类型
		if (timetype == 0) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			long date = 0;
			Date parsestart = null;
			try {
				parsestart = sdf.parse(start);
				Date parseend = sdf.parse(end);
				date = (parseend.getTime() - parsestart.getTime()) / 1000 / 3600 / 24;

			} catch (Exception e) {
				e.printStackTrace();
			}
			LinkedHashSet set = new LinkedHashSet();
			for (int j = 0; j < 24; j++) {
				String temp = start;
				if (j < 10) {
					temp = start + "0" + j;
				} else {
					temp = start + j;
				}
				set.add(temp);
			}

			if (date == 0) {// 同一天

			} else {
				// set.add(start);
				for (int i = 0; i < date; i++) {
					start = getSpecifiedDayAfter(start, "yyyyMMdd");

					for (int j = 0; j < 24; j++) {
						String temp = start;
						if (j < 10) {
							temp = start + "0" + j;
						} else {
							temp = start + j;
						}
						set.add(temp);
					}
				}
			}
			return set;
		} else if (timetype == 1) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			long date = 0;
			Date parsestart = null;
			try {
				parsestart = sdf.parse(start);
				Date parseend = sdf.parse(end);
				date = (parseend.getTime() - parsestart.getTime()) / 1000 / 3600 / 24;

			} catch (Exception e) {
				e.printStackTrace();
			}
			LinkedHashSet set = new LinkedHashSet();
			set.add(start);
			for (int i = 0; i < date; i++) {
				start = getSpecifiedDayAfter(start, "yyyyMMdd");
				set.add(start);
			}

			return set;
		}
		return null;
	}

	private static String getSpecifiedDayAfter(String specifiedDay, String format) {
		if (format == null) {
			format = "yy-MM-dd";
		}
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat(format).format(c.getTime());

		return dayAfter;
	}

	private static ArrayList linkedHashsetToArraylist(LinkedHashSet dim1) {
		ArrayList dimar = new ArrayList();
		for (Object object : dim1) {
			dimar.add(object);
		}
		return dimar;
	}

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String format2 = format.format(new Date());
		System.out.println(format2);
	}

	
}
