package com.imopan.adv.platform.common;

/**
 * ClassName: ErrorCode <br/>
 * Desc:Errorcode
 * date: 2016年1月24日 上午11:57:41 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class ErrorCode {
	/**
	 * 输入输出异常！
	 */
	public final static long IMOPAN_REQJSON_IO_EXCEPTION = -10001;
	/**
	 * 输入输出异常！
	 */
	public final static long IMOPAN_REQJSON_CHARACTERCODING_EXCEPTION = -10002;
	/**
	 * 输入输出异常,协议体结构错误！
	 */
	public final static long IMOPAN_REQJSON_PARSEMSG_EXCEPTION = -10003;
	/**
	 * 输入输出异常！
	 */
	public final static long IMOPAN_REQJSON_C2SBASEMSG_ISNULL = -10004;	
	/**
	 * 参数错误，不合理的请求协议类型！
	 */
	public final static long IMOPAN_REQBODY_INVALID_MSGTYPE = -10005;
	
	/**
	 * 自定义服务相关异常！
	 */
	public final static long IMOPAN_SERVICE_EXCEPTION = -10006;

	/**
	 * 未查询出内容！
	 */
	public final static long IMOPAN_SEARCH_ISNULL_EXCEPTION = -10007;
	
	
	
	
	

}
