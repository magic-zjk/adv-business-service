package com.imopan.adv.platform.util;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imopan.adv.platform.common.ErrorCode;
import com.imopan.adv.platform.exception.ImopanException;


/**
 * ClassName: CheckUtil <br/>
 * Desc:(校验工具类)
 * date: 2016年1月24日 下午4:26:12 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class CheckUtil {
	private static Logger log = LoggerFactory.getLogger(CheckUtil.class);
	public static final int TIMESTAMPTYPE = 1;
	public static final int STRINGMAXLENTYPE = 2;// 如:2-9
	public static final int INTEGERMAXTYPE=3;
	public static final int INTEGERMINTYPE=4;
	public static final int INTEGERMINMAXTYPE=5;
	
	/**
	 * 检验Object是否为空,如果是String类型,检验是否是空字符串
	 * @param obj
	 * @return str为null或者空字符串则返回true,否则返回false
	 * @author guochangqing
	 * @version 创建时间：2014-12-3 下午5:21:42
	 */
	public static boolean checkEmptyObject(Object obj){
		return obj==null||"".equals(obj);
	}
	
	/**
	 * 比较两个时间的大小
	 * @param time1
	 * @param time2
	 * @return time1小于time2  小于0,
	 *			time1等于time2  0,
	 *			time1大于time2  大于0
	 * @author guochangqing
	 * @version 创建时间：2014-12-4 下午6:05:08
	 */
	public static int compareTimeStamp(String time1,String time2) throws ImopanException{
		checkMust(time1, "time1");
		checkMust(time2, "time2");
		int result =0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			result = sdf.parse(time1).compareTo(sdf.parse(time2));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ImopanException(ErrorCode.IMOPAN_SERVICE_EXCEPTION, "比较时间前后出错,请联系系统管理员");
		}
		return result;
	}
	
	
	
	
	/**
	 * 校验时间戳字符串是否合法
	 * @param timestr yyyy-MM-dd HH:mm:ss
	 * @return 符合则返回true,否则false
	 * @author guochangqing
	 * @version 创建时间：2014-12-3 下午5:40:39
	 */
	public static boolean checkTimestampString(String timestr){
		boolean result=true;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setLenient(false);
			sdf.parse(timestr);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	/**
	 * 检查必填项,value为空则抛出异常
	 * @param value
	 * @param message
	 * @throws ImopanException
	 * @author guochangqing
	 * @version 创建时间：2014-12-4 上午9:09:54
	 */
	public static void checkMust(Object value,String message) throws ImopanException{
		if(value==null||"".equals(value)){
			throw new ImopanException(ErrorCode.IMOPAN_SERVICE_EXCEPTION, "参数"+message+"为空");
		}
	}
	/**
	 * 首先会验证value是否为空
	 * @param law checkUtil的静态常量,大于1的时候必须加上    "-参数2"
	 * @param value
	 * @param fieldname 属性名
	 * @throws ImopanException
	 * @author guochangqing
	 * @version 创建时间：2014-12-4 下午12:32:34
	 */
	public static void checkLegal(Object val,String fieldname,String law) throws ImopanException{
		checkMust(val, fieldname);
		if("".equals(law)){
			return;
		}
		String value=String.valueOf(val);
		Integer checkType=null;
		String[] arr = null;
		if(law.contains("-")){
			arr = law.split("-");
			checkType=Integer.parseInt(arr[0]);
		}else{
			checkType=Integer.parseInt(law);
		}
		
		Integer intval = null;
		if(checkType>2&&checkType<6){
			intval=Integer.parseInt(value);
		}
		
		switch (checkType) {
		case TIMESTAMPTYPE:
			if(!checkTimestampString(value)){
				error(fieldname+"不合法,必须为yyyy-mm-dd HH:mm:ss格式");
			}
			break;
		case STRINGMAXLENTYPE:
			int max_len=Integer.parseInt(arr[1]);
			if(value.length()>max_len){
				error(fieldname+"不合法,长度最多为"+max_len);
			}
			break;
		case INTEGERMAXTYPE:
			int max_val=Integer.parseInt(arr[1]);
			if(intval>max_val){
				error(fieldname+"不合法,值必须小于等于"+max_val);
			}
			break;
		case INTEGERMINTYPE:
			int min_val=Integer.parseInt(arr[1]);
			if(intval<min_val){
				error(fieldname+"不合法,值必须大于等于"+min_val);
			}
			break;
		case INTEGERMINMAXTYPE:
			int minVal = Integer.parseInt(arr[1]);
			int maxVal = Integer.parseInt(arr[2]);
			if(intval<minVal||intval>maxVal){
				error(fieldname+"不合法,值必须在["+minVal+","+maxVal+"]之间");
			}
			break;
		default:
			break;
		}
		
	}
	
	public static String DebugString(Object obj){
		if(obj==null){
			return null;
		}else{
			return obj.toString();
		}
	}
	
	
	public static void error(String message) throws ImopanException{
		log.error(message);
		throw new ImopanException(ErrorCode.IMOPAN_SERVICE_EXCEPTION, message);
	}
	
	public static void logerr(String message) throws ImopanException{
		log.error(message);
		throw new ImopanException(ErrorCode.IMOPAN_SERVICE_EXCEPTION, message);
	}
	
	public static void main(String[] args) {
		
	}
	
}
