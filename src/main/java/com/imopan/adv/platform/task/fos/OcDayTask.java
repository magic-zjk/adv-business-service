/** 
 * Project Name:adv-business-service 
 * File Name:OcDayTask.java 
 * Package Name:com.imopan.adv.platform.task.fos 
 * Date:2016年5月18日上午11:10:03 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/

package com.imopan.adv.platform.task.fos;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imopan.adv.platform.mapper.fos.FosAuditChannelDayMapper;
import com.imopan.adv.platform.mapper.fos.FosAuditCpDayMapper;
import com.imopan.adv.platform.mapper.fos.FosOcDayMapper;
import com.imopan.adv.platform.mapper.fos.FosOrderMapper;
import com.imopan.adv.platform.task.fos.redis.JedisBusiness;
import com.imopan.adv.platform.task.fos.service.IOcDayTaskService;

/**
 * ClassName:OcDayTask <br/>
 * Function: 每日渠道订单维护. <br/>
 * Date: 2016年5月18日 上午11:10:03 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.7
 */
@Component
public class OcDayTask {

	private static Logger fosLog = LoggerFactory.getLogger(OcDayTask.class);

	@Autowired
	private IOcDayTaskService ocDayTaskServiceImpl;
	@Autowired
	private FosOrderMapper orderDao;
	@Autowired
	private FosOcDayMapper ocDayDao;
	@Autowired
	private JedisBusiness jedisBusiness;
	@Autowired
	private FosAuditCpDayMapper auditCpDayDao;
	@Autowired
	private FosAuditChannelDayMapper auditChannelDayDao;

	private static final String COMMONKEY = "OcDayTask";

	/**
	 * 
	 * doJob:每天凌晨执行一次. <br/>
	 * 
	 * @author zhangjiakun
	 * @since JDK 1.7
	 */
	// @Scheduled(cron = "0 0 3 * * ?")
	// @Scheduled(fixedRate = 3000)
	public void doJob() {

		fosLog.info(new Date() + "每天凌晨3点执行一次");

		// 解决多台服务器负载均衡时要求只执行一次
		boolean b = checkExecute(OcDayTask.COMMONKEY, "doJob");
		if (b) {
			fosLog.info("该job已经被其他执行！！！");
			return;
		}

		// 查询出所有符合标准的渠道订单记录
		/**
		 * 查询出所有符合标准的渠道订单记录 1.渠道订单状态：正常 2.订单状态：正常 3.渠道状态：正常 4.自动读取标识：正常 5.关联的活动id：不为空
		 * 
		 */

		/* ==============创建关联的cp确认信息表================ */

		/* ==============创建关联的渠道确认信息表================ */

	}

	public static void main(String[] args) {
		Object a = 9.99999974737875E-05;
		BigDecimal bigDecimal = new BigDecimal(a.toString());
		System.out.println(bigDecimal.toString());

	}

	// 检查是否有一台机器执行了
	private boolean checkExecute(String commonKey, String jobName) {
		String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String key = commonKey + "_" + format + "_" + jobName;
		Long flag = jedisBusiness.setNx_0(key);
		if (flag == 0) {
			return true;
		}
		return false;
	}
}
