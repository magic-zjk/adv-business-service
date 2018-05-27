/** 
 * Project Name:adv-business-service1.1 
 * File Name:ChertBean.java 
 * Package Name:com.imopan.adv.platform.entity.fos 
 * Date:2016年7月19日上午11:08:53 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.entity.fos;

import java.util.List;

/** 
 * ClassName:ChertBean <br/> 
 * Function: 画图实体. <br/>  
 * Date:     2016年7月19日 上午11:08:53 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public class ChertBean {
	private List<String> categories;
	
	private List<ChartData> series;

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<ChartData> getSeries() {
		return series;
	}

	public void setSeries(List<ChartData> series) {
		this.series = series;
	}

	
	
	
	
	
}
