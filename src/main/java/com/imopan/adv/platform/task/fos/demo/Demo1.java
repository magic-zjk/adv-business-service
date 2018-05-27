/** 
 * Project Name:adv-business-service 
 * File Name:Demo1.java 
 * Package Name:com.imopan.adv.platform.task.fos.demo 
 * Date:2016年5月18日上午10:53:26 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.task.fos.demo;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/** 
 * ClassName:Demo1 <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年5月18日 上午10:53:26 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Component
public class Demo1 {
	
	/**
	 * 
	 * doJob:每小时执行一次. <br/> 
	 * 
	 * @author zhangjiakun 
	 * @since JDK 1.7
	 */
	//@Scheduled(cron = "0 0 * * * ?")
	public void doJob(){
		System.out.println("（每小时一次）");
	}
	/**
	 * 
	 * doJob1:固定每分钟执行一次. <br/> 
	 * 
	 * @author zhangjiakun 
	 * @since JDK 1.7
	 */
	//@Scheduled(fixedRate = 1000)
	public void doJob1(){
		System.out.println(new Date() + "-----------------doJob1");
	}
	/**
	 * 
	 * doJob2:上次任务结束后10秒钟后再次执行. <br/> 
	 * 
	 * @author zhangjiakun 
	 * @since JDK 1.7
	 */
	//@Scheduled(fixedDelay = 10*1000)
	public void doJob2(){
		System.out.println(new Date() + "-----------------doJob2");
	}
}
