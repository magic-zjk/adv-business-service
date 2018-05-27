/** 
 * Project Name:adv-business-service 
 * File Name:SystemLogServiceImpl.java 
 * Package Name:com.imopan.adv.platform.service.fos.impl 
 * Date:2016年6月3日下午4:35:32 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.service.fos.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.common.PageBean;
import com.imopan.adv.platform.common.VoPageBaseBean;
import com.imopan.adv.platform.entity.fos.FosOrder;
import com.imopan.adv.platform.entity.fos.FosSystemLog;
import com.imopan.adv.platform.entity.fos.FosSystemLogExample;
import com.imopan.adv.platform.entity.fos.FosSystemLogExample.Criteria;
import com.imopan.adv.platform.mapper.fos.FosSystemLogMapper;
import com.imopan.adv.platform.service.fos.ISystemLogService;

/** 
 * ClassName:SystemLogServiceImpl <br/> 
 * Function: 操作日志实现类. <br/>  
 * Date:     2016年6月3日 下午4:35:32 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Service
public class SystemLogServiceImpl implements ISystemLogService {
	
	@Autowired
	private FosSystemLogMapper systemLogDao;

	@Override
	public void insertSystemLog(String content, HttpServletRequest request) {
		
		String userName = String.valueOf(request.getSession().getAttribute("user_name"));
		String phone = String.valueOf(request.getSession().getAttribute("phone"));
		String email = String.valueOf(request.getSession().getAttribute("email"));
		String trueName = String.valueOf(request.getSession().getAttribute("true_name"));
		Integer userId = Integer.valueOf(request.getSession().getAttribute("user_id").toString());
		Integer roleId = Integer.valueOf(request.getSession().getAttribute("role_id").toString());
		String roleName = String.valueOf(request.getSession().getAttribute("role"));
		FosSystemLog systemLog = new FosSystemLog();
		systemLog.setUserName(userName);
		systemLog.setPhone(phone);
		systemLog.setEmail(email);
		systemLog.setTrueName(trueName);
		systemLog.setUserId(userId);
		systemLog.setRoleId(roleId);
		systemLog.setRoleName(roleName);
		systemLog.setDateTime(new Date());
		systemLog.setContent(content);
		systemLogDao.insert(systemLog);
	}

	@Override
	public void insertSystemLog(String content, HttpServletRequest request, String table, String column, String value) {
		String userName = String.valueOf(request.getSession().getAttribute("user_name"));
		String phone = String.valueOf(request.getSession().getAttribute("phone"));
		String email = String.valueOf(request.getSession().getAttribute("email"));
		String trueName = String.valueOf(request.getSession().getAttribute("true_name"));
		Integer userId = Integer.valueOf(request.getSession().getAttribute("user_id").toString());
		Integer roleId = Integer.valueOf(request.getSession().getAttribute("role_id").toString());
		String roleName = String.valueOf(request.getSession().getAttribute("role"));
		FosSystemLog systemLog = new FosSystemLog();
		systemLog.setUserName(userName);
		systemLog.setPhone(phone);
		systemLog.setEmail(email);
		systemLog.setTrueName(trueName);
		systemLog.setUserId(userId);
		systemLog.setRoleId(roleId);
		systemLog.setRoleName(roleName);
		systemLog.setDateTime(new Date());
		systemLog.setContent(content);
		systemLog.setTableName(table);
		systemLog.setTableColumn(column);
		systemLog.setTableValue(value);
		systemLogDao.insert(systemLog);
	}

	@Override
	public PageBean<FosSystemLog> getSystemlogs(VoPageBaseBean vpbb) {
		PageBean<FosSystemLog> pageBean = new PageBean<FosSystemLog>();
		FosSystemLogExample ex = new FosSystemLogExample();
		Criteria criteria = ex.createCriteria();
				if(vpbb.getParammap() != null){
					//TODO 添加查询条件
					if(vpbb.getParammap().get("orderId") != null && StringUtils.isNotEmpty(vpbb.getParammap().get("orderId").toString())){
						criteria.andTableColumnEqualTo("order_id");
						criteria.andTableValueEqualTo(vpbb.getParammap().get("orderId").toString());
					}
				}
				if(vpbb.getLimitStart() != null && vpbb.getLimitEnd() != null){
					ex.setLimitStart(vpbb.getLimitStart());
					ex.setLimitEnd(vpbb.getLimitEnd());
				}
				ex.setOrderByClause("DATE_TIME desc");
				//查询记录
				List<FosSystemLog> list = systemLogDao.selectByExampleWithBLOBs(ex);
				int i = systemLogDao.countByExample(ex);
				pageBean.setDataList(list);
				pageBean.setTotalRecord(i);
		return pageBean;
	}
	
}
