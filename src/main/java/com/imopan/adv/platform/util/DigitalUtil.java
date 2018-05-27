package com.imopan.adv.platform.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DigitalUtil {

	public static boolean isOdd(int input) {
		return input % 2 != 0;
	}

	public static boolean isEven(int input) {
		return input % 2 == 0;
	}

	/**
	 * 检查字符串中是否是Float型数字
	 * 
	 * @param input 输入字符串
	 * @return 如果包含非Float型字符则返回false
	 */
	public static boolean isFloat(String input) {
		if (StringUtil.isEmpty(input)) {
			return false;
		}
		try {
			Float.parseFloat(input);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 检查字符串中是否是Double型数字
	 * 
	 * @param input 输入字符串
	 * @return 如果包含非Double型字符则返回false
	 */
	public static boolean isDouble(String input) {
		if (StringUtil.isEmpty(input)) {
			return false;
		}

		try {
			Double.parseDouble(input);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 检查字串中是否全部是数字字符
	 * 
	 * @param input 输入字符串
	 * @return 如果包含非数字字符则返回false
	 */
	public static boolean isDigital(String input) {
		if (StringUtil.isEmpty(input)) {
			return false;
		}
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否是int型
	 * 
	 * @param input String
	 * @return boolean
	 */
	public static boolean isInt(String input) {
		if (StringUtil.isEmpty(input)) {
			return false;
		}

		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 * 在数字前面补零. <p/> 在数值前面补零，整个字符串达到固定长度，主要用于银行帐号，单据编号等
	 * 
	 * @param num 转换的数值
	 * @param length 使整个串达到的长度
	 * @return 数值前面补零的固定长度的字符串
	 */
	public static String appendZero(int num, int length) {
		String tmpString = String.valueOf(num);
		for (int i = tmpString.length(); i < length; i++) {
			tmpString = "0" + tmpString;
		}
		return tmpString;
	}

	/**
	 * 格式化数值
	 * 
	 * @param num 待格式化整形数值
	 * @param pattern 格式样式："####"和"#,###"， #表示整数位数，0表示小数位数，如果不是指定样式，返回原数值
	 * @return 符合格式的字符串
	 */
	public static String numberFormat(long num, String pattern) {
		String patterns[] = { "####", "#,###" };
		if (!StringUtil.isIn(pattern, patterns)) {
			return String.valueOf(num);
		}
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(num);
	}

	/**
	 * 格式化数值
	 * 
	 * @param num 待格式化实型数值
	 * @param pattern 格式样式："#,###.00"、"####.00"和"####", "#,###"， #表示整数位数，0表示小数位数，如果不是指定样式，返回原数值
	 * @return 符合格式的字符串
	 */
	public static String numberFormat(double num, String pattern) {
		String patterns[] = { "#,###.00", "####.00", "####", "#,###" };
		if (!StringUtil.isIn(pattern, patterns)) {
			return String.valueOf(num);
		}
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(num);
	}

	public static int MatchDouble(double a, double[] b) {

		int index = 0;
		double s = 0.0;
		for (int i = 0; i < b.length; i++) {
			if (i == 0) {
				s = Math.abs(a - b[i]);
			} else {
				if (Math.abs((a - b[i])) < s) {
					index = i;
					s = Math.abs((a - b[i]));

				}
			}
		}
		// System.out.println(index);
		return index;
	}

	/**
	 * 将double类型进行取整或者按照precision来确定精度
	 * 
	 * @param number
	 * @param quZheng 是否取整
	 * @param precision 保留多少为小数
	 * @return
	 */
	public static Object formartDouble(double number, boolean quZheng, int precision) {
		if (quZheng) {
			return Math.round(Double.valueOf(number));
			// return Double.valueOf(number).intValue();
		}
		BigDecimal bd = new BigDecimal(number);
		bd = bd.setScale(precision, BigDecimal.ROUND_HALF_EVEN);
		return bd.doubleValue();

	}
}
