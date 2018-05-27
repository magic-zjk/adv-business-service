package com.imopan.adv.platform.common;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: PageBean <br/>
 * Desc:(分页返回bean)
 * date: 2016年1月26日 上午10:44:12 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public final class PageBean<T> implements Serializable{

	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = 1723532825470487560L; 
    private int totalRecord;// 总记录数    
    private List<T> dataList;// 分页数据   
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	@Override
	public String toString() {
		return "PageBean [totalRecord=" + totalRecord + ", dataList=" + dataList + "]";
	}

}
