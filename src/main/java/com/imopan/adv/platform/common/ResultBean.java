package com.imopan.adv.platform.common;



import java.io.Serializable;
/**
 * ClassName: ResultBean <br/>
 * Desc:接口返回类
 * date: 2016年1月24日 上午11:58:34 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class ResultBean implements Serializable{

	private static final long serialVersionUID = -8363923199593511398L;
	
	public static final long CODE_ERROR = 0;
	public static final long CODE_SUCCESS = 1;
	public static final long CODE_NOSESSION = 1000;//没有用户session
	public static final long CODE_UNIQUE = -1;//数据库索引唯一
	
	private long code;
	private long errorCode;
	private Object data;
	private String errorMessage;
	private long bizStatus=0;//业务状态 0 无标记 1 查询单个实体 2 更改单个实体 3 新建 4删除
	


	public ResultBean(){}
	
	public ResultBean(long code, long errorCode, Object data, String errorMessage) {
		super();
		this.code = code;
		this.errorCode = errorCode;
		this.data = data;
		this.errorMessage = errorMessage;
	}
	public ResultBean(long code, long errorCode, Object data, String errorMessage,long bizStatus) {
		super();
		this.code = code;
		this.errorCode = errorCode;
		this.data = data;
		this.errorMessage = errorMessage;
		this.bizStatus = bizStatus;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public long getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public long getBizStatus() {
		return bizStatus;
	}

	public void setBizStatus(long bizStatus) {
		this.bizStatus = bizStatus;
	}
	@Override
	public String toString() {
		return "ResultBean [code=" + code + ", errorCode=" + errorCode + ", data=" + data + ", errorMessage="
				+ errorMessage + ", bizStatus=" + bizStatus + "]";
	}

	
}
