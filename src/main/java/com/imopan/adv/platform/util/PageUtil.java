
package com.imopan.adv.platform.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.imopan.adv.platform.common.PageBean;

/**
 * 
 * ClassName: PageUtil <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * date: 2016年5月17日 下午6:33:39 <br/> 
 * 
 * @author zhangjiakun
 * @version  
 * @since JDK 1.7
 */
public class PageUtil {

	public static List<Map<String, Object>> formatMapData( PageBean<?> result,String mark) {
		List<Map<String, Object>> listMap = PageUtil.convertList(result.getDataList());
		for (int i = 0; i < listMap.size(); i++) {
			Map<String, Object> object=listMap.get(i);
			try {
				ConverData.converData(mark, object);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMap;
	  }
	public static List<Map<String, Object>> formatMapDatafromJsonObjectList(ArrayList result,String mark,HashMap map) {
		List<Map<String, Object>> listMap = PageUtil.convertListFromJsonObject(result);
		for (int i = 0; i < listMap.size(); i++) {
			Map<String, Object> object=listMap.get(i);
			try {
				ConverData.converData2(mark, object,map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMap;
	  }
	
	
	/**
	 * 将集合对象转换为集合map
	 * @param list
	 * @return
	 */
	public static List<Map<String,Object>> convertList(List<?> list){
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		if(list.size()>0){
			for (Object object : list) {
				listMap.add(convertBean(object));
			}
		}
		return listMap;
	}
	
	/**
	 * 将集合对象转换为集合map
	 * @param list
	 * @return
	 */
	public static List<Map<String,Object>> convertListFromJsonObject(List<?> list){
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		if(list.size()>0){
			for (Object object : list) {
				listMap.add(convertBeanFromJsonObject(object));
			}
		}
		return listMap;
	}
	
	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Map<String, Object> convertBean(Object bean) {
		Map<String, Object> returnMap = null;
		try {
			Class<? extends Object> type = bean.getClass();
			returnMap = new HashMap<String, Object>();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return returnMap;
	}
	
	/**
	 * 将一个 JsonObject 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Map<String, Object> convertBeanFromJsonObject(Object bean) {
		Map<String, Object> returnMap = null;
			try {
				Class cls = Class.forName("org.json.JSONObject");
				Object obj_ref = cls.newInstance();
				Object cast = cls.cast(bean);
				Field field = cls.getDeclaredField("map");
				field.setAccessible(true);
				returnMap = (Map<String, Object>) field.get(cast);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return returnMap;
	}
	
}
