/** 
 * Project Name:adv-business-service 
 * File Name:BeanUtil.java 
 * Package Name:com.imopan.adv.platform.util 
 * Date:2016年3月19日上午11:30:59 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

/** 
 * ClassName:BeanUtil <br/> 
 * Function: 实体工具类. <br/>  
 * Date:     2016年3月19日 上午11:30:59 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
public final class BeanUtil {

	/**
	 * 利用反射实现对象之间相同属性复制
	 * 
	 * @param source 要复制的
	 * @param to	 复制给
	 */
	public static void copyProperties(Object source, Object target) {
		try {
			copyPropertiesExclude(source, target, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 复制对象属性
	 * 
	 * @param from
	 * @param to
	 * @param excludsArray
	 *            排除属性列表
	 * @throws Exception
	 */
	public static void copyPropertiesExclude(Object from, Object to,
			String[] excludsArray) throws Exception {
		
		List<String> excludesList = null;
		
		if (excludsArray != null && excludsArray.length > 0) {
			
			excludesList = Arrays.asList(excludsArray); // 构造列表对象
		}
		
		Method[] fromMethods = from.getClass().getDeclaredMethods();
		Method[] toMethods = to.getClass().getDeclaredMethods();
		Method fromMethod = null, toMethod = null;
		String fromMethodName = null, toMethodName = null;
		
		for (int i = 0; i < fromMethods.length; i++) {
			
			fromMethod = fromMethods[i];

			fromMethodName = fromMethod.getName();
			if (!fromMethodName.contains("get"))
				continue;
			//此处有bug 字段名字含有get时出现
			if (fromMethodName.contains("Target"))
				continue;
			// 排除列表检测
			if (excludesList != null
					&& excludesList.contains(fromMethodName.substring(3)
							.toLowerCase())) {
				
				continue;
			}
			toMethodName = "set" + fromMethodName.substring(3);
			toMethod = findMethodByName(toMethods, toMethodName);
			
			if (toMethod == null)
				continue;
			Object value = fromMethod.invoke(from, new Object[0]);
			
			if (value == null)
				continue;
			// 集合类判空处理
			if (value instanceof Collection) {
				
				Collection<?> newValue = (Collection<?>) value;
				
				if (newValue.size() <= 0)
					continue;
			}
			
			toMethod.invoke(to, new Object[] { value });
		}
	}

	/**
	 * 对象属性值复制，仅复制指定名称的属性值
	 * 
	 * @param from
	 * @param to
	 * @param includsArray
	 * @throws Exception
	 */
	public static void copyPropertiesInclude(Object from, Object to,
			String[] includsArray) throws Exception {
		
		List<String> includesList = null;
		
		if (includsArray != null && includsArray.length > 0) {
			
			includesList = Arrays.asList(includsArray); 
			
		} else {
			
			return;
		}
		Method[] fromMethods = from.getClass().getDeclaredMethods();
		Method[] toMethods = to.getClass().getDeclaredMethods();
		Method fromMethod = null, toMethod = null;
		String fromMethodName = null, toMethodName = null;
		
		for (int i = 0; i < fromMethods.length; i++) {
			
			fromMethod = fromMethods[i];
			fromMethodName = fromMethod.getName();
			
			if (!fromMethodName.contains("get"))
				continue;
			
			// 排除列表检测
			String str = fromMethodName.substring(3);
			
			if (!includesList.contains(str.substring(0, 1).toLowerCase()
					+ str.substring(1))) {
				continue;
			}
			
			toMethodName = "set" + fromMethodName.substring(3);
			toMethod = findMethodByName(toMethods, toMethodName);
			
			if (toMethod == null)
				continue;
			
			Object value = fromMethod.invoke(from, new Object[0]);
			
			if (value == null)
				continue;
			
			// 集合类判空处理
			if (value instanceof Collection) {
				
				Collection<?> newValue = (Collection<?>) value;
				
				if (newValue.size() <= 0)
					continue;
			}
			
			toMethod.invoke(to, new Object[] { value });
		}
	}

	/**
	 * 从方法数组中获取指定名称的方法
	 * 
	 * @param methods
	 * @param name
	 * @return
	 */
	public static Method findMethodByName(Method[] methods, String name) {
		
		for (int j = 0; j < methods.length; j++) {
			
			if (methods[j].getName().equals(name)) {
				
				return methods[j];
			}
				
		}
		return null;
	}

	
	/**
	 * 
	 * applyIf:对象之间的转换. <br/> 
	 * 
	 * @author zhangjiakun
	 * @param dest
	 * @param orig
	 * @throws Exception 
	 * @since JDK 1.7
	 */
	  public static void applyIf(Object dest, Object orig) throws Exception {  
	        try {  
	            if (orig instanceof Map) {  
	                Iterator names = ((Map) orig).keySet().iterator();  
	                while (names.hasNext()) {  
	                    String name = (String) names.next();  
	                    if (PropertyUtils.isWriteable(dest, name)) {  
	                        Object value = ((Map) orig).get(name);  
	                        if (value != null) {  
	                            try {
									PropertyUtils.setSimpleProperty(dest, name, value);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}  
	                        }  
	                    }  
	                }  
	            } else {  
	                java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();  
	                for (int i = 0; i < fields.length; i++) {  
	                    String name = fields[i].getName();  
	                    if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {  
	                        Object value = PropertyUtils.getSimpleProperty(orig, name);  
	                        if (value != null) {  
	                            PropertyUtils.setSimpleProperty(dest, name, value);  
	                        }  
	                    }  
	                }  
	            }  
	        } catch (Exception e) {  
	            throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);  
	        }  
	    }  
}
