/** 
 * Project Name:adv-business-service 
 * File Name:FosDataControllerUtil.java 
 * Package Name:com.imopan.adv.platform.util 
 * Date:2016年12月2日下午4:39:56 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/** 
 * ClassName:FosDataControllerUtil <br/> 
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2016年12月2日 下午4:39:56 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public class FosDataControllerUtil {

	/**
	 * 
	 * checkRoleIsIn:判断当前用户是否为super、经理、财务总监、财务经理. <br/> 
	 * 
	 * @author zhangjiakun
	 * @return 
	 * @since JDK 1.7
	 */
	public static Boolean checkRoleIsIn(){
		//获取用户角色ID
		Integer roleId = Integer.valueOf(SpringWebUtil.getSession().getAttribute("role_id").toString());
		if(roleId == 1 || roleId == 2 || roleId == 17 || roleId == 20){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * checkRoleIsOperation:判断是否为运营角色. <br/> 
	 * 
	 * @author zhangjiakun
	 * @return 
	 * @since JDK 1.7
	 */
	public static Boolean checkRoleIsOperation(){
		//获取用户角色名称
		String role = SpringWebUtil.getSession().getAttribute("role").toString();
		if(role != null && role.contains("运营")){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * checkRoleIsBusiness:判断是否为商务角色. <br/> 
	 * 
	 * @author zhangjiakun
	 * @return 
	 * @since JDK 1.7
	 */
	public static Boolean checkRoleIsBusiness(){
		//获取用户角色名称
		String role = SpringWebUtil.getSession().getAttribute("role").toString();
		if(role != null && role.contains("商务")){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * checkRoleIsChannel:判断是否为渠道角色. <br/> 
	 * 
	 * @author zhangjiakun
	 * @return 
	 * @since JDK 1.7
	 */
	public static Boolean checkRoleIsChannel(){
		//获取用户角色名称
		String role = SpringWebUtil.getSession().getAttribute("role").toString();
		if(role != null && role.contains("媒介")){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * getUserNamesID:获取当前用户所有下属包括自己. <br/> 
	 * 格式：username 比如：张三
	 * @author zhangjiakun
	 * @return 
	 * @since JDK 1.7
	 */
	public static String getUserNames(){
		List userList = (List)SpringWebUtil.getSession().getAttribute("userList");
		List<String> userNameList = new ArrayList<String>();
		for (Object user : userList) {
			JSONObject u = new JSONObject(user);
			Object trueName = u.get("true_name");
			String name = "'"+trueName+"'";
			userNameList.add("'"+name+"'");
		}
		
		//userNameList.add("'符晓琴'");
		//userNameList.add("'张晗'");
		
		String join = StringUtils.join(userNameList, ",");
		return "("+join+")";
	}
	
	/**
	 * 
	 * getUserNames:获取当前用户所有下属包括自己. <br/> 
	 * 格式：username（userid） 比如：张三（1）
	 * @author zhangjiakun
	 * @return 
	 * @since JDK 1.7
	 */
	public static String getUserNamesID(){
		@SuppressWarnings("rawtypes")
		List userList = (List)SpringWebUtil.getSession().getAttribute("userList");
		List<String> userNameList = new ArrayList<String>();
		for (Object user : userList) {
			JSONObject u = new JSONObject(user.toString());
			Object trueName = u.get("true_name");
			Object userId = u.get("user_id");
			String name = trueName+"("+userId+")";
			userNameList.add("'"+name+"'");
		}
		//userNameList.add("'符晓琴(10171)'");
		//userNameList.add("'沈洁(10141)'");
		
		//userNameList.add("'任原龙(10131)'");
		//userNameList.add("'王鹏飞(10130)'");
		String join = StringUtils.join(userNameList,",");
		return "("+join+")";
	}
	
	/**
	 * 
	 * getTeamId:获取项目组id. <br/> 
	 * 
	 * @author zhangjiakun
	 * @return 
	 * @since JDK 1.7
	 */
	public static Integer getTeamId(){
		Integer teamId = Integer.valueOf(SpringWebUtil.getSession().getAttribute("team_id").toString());
		return teamId;
	}
	
	/**
	 * 
	 * assignmentMap:数据级权限控制，将需要控制的map字段进行封装. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param hashMap
	 * @return 
	 * @since JDK 1.7
	 */
	public static Map<String,Object> assignmentMap(Map<String,Object> hashMap){
		
		if(!checkRoleIsIn()){
			//加入数据级控制
			Integer teamId = getTeamId();
			hashMap.put("teamId", teamId);
			if(!checkRoleIsOperation()){
				String names = getUserNamesID();
				if(checkRoleIsBusiness()){
					hashMap.put("businessNames", names);
				}else if(checkRoleIsChannel()){
					hashMap.put("channelNames", names);
				}
			}
		}
		return hashMap;
	}
	
	/**
	 * 
	 * getSessionValue:根据key获取session的值. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param key
	 * @return 
	 * @since JDK 1.7
	 */
	public static Object getSessionValue(String key){
		Object attribute = SpringWebUtil.getSession().getAttribute(key);
		return attribute;
	}
	
}
