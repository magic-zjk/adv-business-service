package com.imopan.adv.platform.common;


/**
 * ClassName: ErrorMsgManager <br/>
 * Desc:(Errorcode对应的信息)
 * date: 2016年1月24日 下午3:19:58 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class ErrorMsgManager {

	
	public static String GetErrorMsg(long errorCode){
		String _errorMsg = "";
		
		if(errorCode == ErrorCode.IMOPAN_REQJSON_IO_EXCEPTION){
			_errorMsg = "输入输出异常！";
		}
		else if(errorCode == ErrorCode.IMOPAN_REQJSON_CHARACTERCODING_EXCEPTION){
			_errorMsg = "输入输出异常！";
		}
		else if(errorCode == ErrorCode.IMOPAN_REQJSON_PARSEMSG_EXCEPTION){
			_errorMsg = "输入输出异常,协议体结构错误！";
		}
		else if(errorCode == ErrorCode.IMOPAN_REQJSON_C2SBASEMSG_ISNULL){
			_errorMsg = "输入输出异常！";
		}
		else if(errorCode == ErrorCode.IMOPAN_REQBODY_INVALID_MSGTYPE){
			_errorMsg = "参数错误，不合理的请求协议类型！";
		}
		else if(errorCode == ErrorCode.IMOPAN_SERVICE_EXCEPTION){
			_errorMsg = "自定义服务相关异常！";
		}
		return _errorMsg;
	}
	
	
}
