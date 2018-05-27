package com.imopan.adv.platform.common;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imopan.adv.platform.exception.ImopanException;
import com.imopan.adv.platform.util.CheckUtil;

/**
 * ClassName: PageBaseBean <br/>
 * Desc:(分页+模糊查询基础类--入参)
 * date: 2016年1月24日 下午5:36:23 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
public class VoPageBaseBean extends VoBaseBean {
	
	private Integer pageNo;
	private Integer pageSize;//为-负数 代表不分页全取
	private String parm;//模糊查询参数
	private HashMap<String,Object> parammap;
	
	
	public String getParm() {
		return parm;
	}

	public void setParm(String parm) {
		this.parm = parm;
	}

	


	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public HashMap<String, Object> getParammap() {
		return parammap;
	}

	public void setParammap(HashMap<String, Object> parammap) {
		this.parammap = parammap;
	}
	@Override
	public String toString() {
		return "PageBaseBean [pageNo=" + pageNo + ", pageSize=" + pageSize + ", parm=" + parm + ", parammap=" + parammap
				+ "]";
	}
	
	public Integer getLimitStart() {
		if(pageSize<0){
			return null;
		}
		return (pageNo-1)*pageSize;
	}
	public Integer getLimitEnd() {
		return pageSize;
	}
	
	public String getQueryparam(){
		String temp = "";
		if(!StringUtils.isBlank(parm)){
			for (int i = 0; i < parm.length(); i++) {  
	            if (parm.charAt(i) == '%' || parm.charAt(i) == '_') {  
	                temp += "\\" + parm.charAt(i);  
	            } else {  
	                temp += parm.charAt(i);  
	            }  
	        }  
		}
		return "%"+temp+"%";
	}
	
	@Override
	public boolean verify(String str) throws ImopanException {
		CheckUtil.checkLegal(pageNo, "pageNo", CheckUtil.INTEGERMINTYPE+"-1");
		//CheckUtil.checkLegal(pageSize, "pageSize", CheckUtil.INTEGERMINTYPE+"-1");
		return true;
	}

}
