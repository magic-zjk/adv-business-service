package com.imopan.adv.platform.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static void main(String[] args) {
		
	}

	/**
	 * 将指定的日期加上指定的天数
	 */
	public static Date addDays(Date d, int days) {
		if(days == 0) return d;
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, days);
		setNoTime(c);
		return c.getTime();
	}
	
	/**
	 * 转换成yyyy-MM-dd
	 */
	public static String dateToStr(Date d) {
		if(d == null) return "";
		return new SimpleDateFormat("yyyy-MM-dd").format(d);
	}
	
	/**
	 * 转换成format
	 */
	public static String dateToStr(Date d, String format) {
		if(d == null) return "";
		return new SimpleDateFormat(format).format(d);
	}
	
	/**
	 * 把指定日期的时分秒设为0
	 * @param c 指定的日期
	 */
	private static void setNoTime(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
	}

	/**
	 * 获取当天日期 yyyy-MM-dd
	 */
	public static Date getCurrentDay() {
		Calendar c = Calendar.getInstance();
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取当天日期之前的日期
	 * @param i 之前几天
	 */
	public static Date getPreDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -i);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期的前一天
	 * @param d 指定的日期
	 */
	public static Date getPreviousDay(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, -1);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期的后一天
	 * @param d 指定的日期
	 */
	public static Date getNextDay(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, 1);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取当月第一天
	 * @return
	 */
	public static Date getCurrentMonthFirst() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 计算当月最后一天
	 * @return
	 */
	public static Date getCurrentMonthLast() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		c.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取指定日期所在月第一天
	 */
	public static Date getCurrentMonthFirst(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取指定日期所在月最后一天
	 */
	public static Date getCurrentMonthLast(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		c.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取指定日期所在上一月第一天
	 */
	public static Date getPreviousMonthFirst(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);// 设为指定月的1号
		c.add(Calendar.MONTH, -1);// 减一个月，变为上月的1号
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取指定日期所在上一月最后一天
	 */
	public static Date getPreviousMonthLast(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);// 把日期设置为指定月第一天
		c.add(Calendar.DATE, -1);// 减一天，上月最后一天
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取指定日期所在下一月第一天
	 */
	public static Date getNextMonthFirst(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);// 设为指定月的1号
		c.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取指定日期所在下一月最后一天
	 */
	public static Date getNextMonthLast(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);// 把日期设置为指定月第一天
		c.add(Calendar.MONTH, 2);// 加两个月，下下月第一天
		c.add(Calendar.DATE, -1);// 减一天，下月最后一天
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取上一月第一天
	 */
	public static Date getPreviousMonthFirst() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为指定月的1号
		c.add(Calendar.MONTH, -1);// 减一个月，变为上月的1号
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取上一月最后一天
	 */
	public static Date getPreviousMonthLast() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 把日期设置为指定月第一天
		c.add(Calendar.DATE, -1);// 减一天，上月最后一天
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取下一月第一天
	 */
	public static Date getNextMonthFirst() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为指定月的1号
		c.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获取下一月最后一天
	 */
	public static Date getNextMonthLast() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 把日期设置为指定月第一天
		c.add(Calendar.MONTH, 2);// 加两个月，下下月第一天
		c.add(Calendar.DATE, -1);// 减一天，下月最后一天
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获得当前日期与本周日相差的天数
	 */
	private static int getMondayPlus() {
		Calendar c = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		return 1 - dayOfWeek;
	}

	/**
	 * 获得指定日期与本周日相差的天数
	 */
	private static int getMondayPlus(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		return 1 - dayOfWeek;
	}

	/**
	 * 本周日的日期
	 */
	public static Date getCurrentSunday() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, getMondayPlus() + 6);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 本周一的日期
	 */
	public static Date getCurrentMonday() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, getMondayPlus());
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获得上周日的日期
	 */
	public static Date getPreviousSunday() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, getMondayPlus() + 6 - 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获得上周一的日期
	 */
	public static Date getPreviousMonday() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, getMondayPlus() - 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获得下周日的日期
	 */
	public static Date getNextSunday() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, getMondayPlus() + 6 + 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 获得下周一的日期
	 */
	public static Date getNextMonday() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, getMondayPlus() + 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期所在周周日的日期
	 */
	public static Date getCurrentSunday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getMondayPlus(date) + 6);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期所在周周一的日期
	 */
	public static Date getCurrentMonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getMondayPlus(date));
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期所在周上周日的日期
	 */
	public static Date getPreviousSunday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getMondayPlus(date) + 6 - 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期所在周上周一的日期
	 */
	public static Date getPreviousMonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getMondayPlus(date) - 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期所在周下周日的日期
	 */
	public static Date getNextSunday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getMondayPlus(date) + 6 + 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 指定日期所在周下周一的日期
	 */
	public static Date getNextMonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, getMondayPlus(date) + 7);
		setNoTime(c);
		return c.getTime();
	}

	/**
	 * 将短时间格式yyyy-MM-dd字符串转换为日期
	 */
	public static Date strToDate(String strDate) {
		return new SimpleDateFormat("yyyy-MM-dd").parse(strDate, new ParsePosition(0));
	}
	public static Date strToDate1(String strDate) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate, new ParsePosition(0));
	}

	/**
	 * 两个时间之间的天数
	 */
	public static int getDays(Date date1, Date date2) {
		long day = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
		return (int) day;
	}

	/**
	 * 获取当前时间指定的格式字符串
	 */
	public static String getNowTimeStr(String dateformat) {
		return new SimpleDateFormat(dateformat).format(new Date());
	}

	/**
	 * 是否闰年
	 * @param year 年
	 */
	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	/**
	 * 获取某年某月的天数
	 * @param year 年份
	 * @param month 月份，一月是1 二月是2
	 * @return
	 */
	public static int getDaysOfMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		}
		return 0;
	}
	
	// 获得上个季度的第一天
	public static Date getLastSeasonFirst() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cd = Calendar.getInstance();
		return new java.sql.Date(sdf.parse((getLastSeasonTime(cd.get(Calendar.MONTH) + 1).split(";"))[0]).getTime());
	}

	// 获得上个季度的最后一天
	public static Date getLastSeasonEnd() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cd = Calendar.getInstance();
		return new java.sql.Date(sdf.parse((getLastSeasonTime(cd.get(Calendar.MONTH) + 1).split(";"))[1]).getTime());
	}

	private static String getLastSeasonTime(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) { // 这里应该得到的是上一年的第四季度
			season = 4;
		}
		if (month >= 4 && month <= 6) {
			season = 1;
		}
		if (month >= 7 && month <= 9) {
			season = 2;
		}
		if (month >= 10 && month <= 12) {
			season = 3;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		if (season != 4) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
			String years = dateFormat.format(date);
			int years_value = Integer.parseInt(years);

			int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
			int end_days = getDaysOfMonth(years_value, end_month);
			String seasonDate = years_value + "-" + start_month + "-" + start_days + ";" + years_value + "-" + end_month + "-"
					+ end_days;
			return seasonDate;
		} else {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
			String years = dateFormat.format(date);
			int years_value = Integer.parseInt(years) - 1;

			int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
			int end_days = getDaysOfMonth(years_value, end_month);
			String seasonDate = years_value + "-" + start_month + "-" + start_days + "," + years_value + "-" + end_month + "-"
					+ end_days;
			return seasonDate;

		}
	}

	/**
	 * 上一个月的月底离今天有几天
	 * @return
	 */
	public static int getLastMonthEndDayToNow() {
		return (int) getDays(getCurrentDay(), getPreviousMonthLast());
	}

	/**
	 * 上一个月的月头离今天有几天
	 * @return
	 */
	public static int getLastMonthStartDayToNow() {
		return (int) getDays(getCurrentDay(), getPreviousMonthFirst());
	}

	/**
	 * 上一个季度的最后一天离今天有几天
	 * @return
	 * @throws ParseException
	 */
	public static int getLastSeasonEndDayToNow() throws ParseException {
		return (int) getDays(getCurrentDay(), getLastSeasonEnd());
	}

	/**
	 * 上一个季度的开始一天离今天有几天
	 * @return
	 * @throws ParseException
	 */
	public static int getLastSeasonStartDayToNow() throws ParseException {
		return (int) getDays(getCurrentDay(), getLastSeasonFirst());
	}

	/**
	 * 今天之前的第7天
	 * @param sdate
	 * @return
	 */
	public static Date getLast7Day() {
		return getPreDate(7);
	}

	/**
	 * 今天之前的第30天
	 * @param sdate
	 * @return
	 */
	public static Date getLast30Day() {
		return getPreDate(30);
	}

	/**
	 * 今天之前的第90天
	 * @param sdate
	 * @return
	 */
	public static Date getLast90Day() {
		return getPreDate(90);
	}
	
	
	public static List<String> getIntervalDays(String beginDate1, String endDate1,String format)
			throws ParseException {
		List<String> dates = new ArrayList<String>();
		DateFormat df = DateFormat.getDateInstance();
		df = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = df.parse(beginDate1);
		Date endDate = df.parse(endDate1);
		Calendar bc = Calendar.getInstance();
		bc.setTime(beginDate);
		Calendar ec = Calendar.getInstance();
		ec.setTime(endDate);
		while (bc.getTimeInMillis() <= ec.getTimeInMillis()) {
			dates.add((new SimpleDateFormat(format)).format(new Date(bc.getTimeInMillis())));
			bc.add(Calendar.DATE, 1);
		}
		return dates;
	}


}