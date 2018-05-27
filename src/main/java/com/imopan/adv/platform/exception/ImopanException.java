package com.imopan.adv.platform.exception;


import com.imopan.adv.platform.common.ErrorMsgManager;


/**
 * ClassName: ImopanException <br/>
 * Desc:(全局异常类)
 * date: 2016年1月24日 下午3:21:57 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class ImopanException extends RuntimeException{
	private static final long serialVersionUID = -3116878121283778384L;
	private long perrorcode;
	private String perrormessage;
	
	public ImopanException(long perrorcode){
		this.perrorcode = perrorcode;
		this.perrormessage = ErrorMsgManager.GetErrorMsg(perrorcode);
	}
	
	public ImopanException(long perrorcode,String perrormessage){
		this.perrorcode = perrorcode;
		this.perrormessage = perrormessage;
	}

	

	public long getPerrorcode() {
		return perrorcode;
	}



	public void setPerrorcode(long perrorcode) {
		this.perrorcode = perrorcode;
	}



	public String getPerrormessage() {
		return perrormessage;
	}

	public void setPerrormessage(String perrormessage) {
		this.perrormessage = perrormessage;
	}
	
	
}
