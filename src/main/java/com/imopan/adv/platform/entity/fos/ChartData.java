/** 
 * Project Name:adv-business-service1.1 
 * File Name:ChartData.java 
 * Package Name:com.imopan.adv.platform.entity.fos 
 * Date:2016年7月19日上午11:16:35 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.entity.fos;

import java.util.List;

/** 
 * ClassName:ChartData <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年7月19日 上午11:16:35 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public class ChartData {
	private String name;
	private List<Object> data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	
	
}
