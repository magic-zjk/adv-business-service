/** 
 * File Name:AppStoreInfoJedisHandler.java
 * Project Name:adv-business-service  
 * Package Name:com.imopan.adv.platform.redis.dao 
 * Create Date:2016年8月18日下午10:18:36 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */  
package com.imopan.adv.platform.redis.dao;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.imopan.adv.platform.redis.bean.AppStoreInfo4Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/** 
 * Description: 处理appstoreinfo redis存储<br>
 * Create Date: 2016年8月18日 下午10:18:36
 * 
 * @author liangbing 
 * @version 1.0 
 */
@Component
public class AppStoreInfoJedisHandler {

	private static Logger logger = LoggerFactory.getLogger(AppStoreInfoJedisHandler.class);
	
	@Resource(name="redisSentinel_db13")
	private JedisSentinelPool jedisSentinelPool;
	
	/**
	 * redis 存储appstoreinfo
	 * @param key imopan:appsotreinfo
	 * @param field appStoreId
	 * @param expireTime seconds
	 * @param fieldValue appStoreInfo.toJson
	 * @version liangbing
	 */
	public void saveAppStoreInfo(String key,String value,int expireTime){
		Jedis jedis = null;
		try {
			jedis = jedisSentinelPool.getResource();
			if(jedis.exists(key)){//防止过期时间被覆盖
				jedis.del(key);
			}
	        jedis.set(key, value);
	        jedis.expire(key, expireTime);	
		} catch (Exception e) {
			logger.error("AppStoreInfoJedisHandler saveAppStoreInfo 异常 [key="+key+";value="+value+"]",e);
		}finally{
			 if (jedis != null) {
				 jedisSentinelPool.returnResource(jedis);
			 }
		}
	}
	
	public AppStoreInfo4Redis getAppStoreInfo(String key){
		Jedis jedis = null;
		AppStoreInfo4Redis appStoreInfo = null;
		try {
			jedis = jedisSentinelPool.getResource();
			String value = jedis.get(key);
			if(!StringUtils.isBlank(value)){
				appStoreInfo = new Gson().fromJson(value, AppStoreInfo4Redis.class);
			}
			return appStoreInfo;
		} catch (Exception e) {
			logger.error("AppStoreInfoJedisHandler getAppStoreInfo 异常 [key="+key+"]",e);
		}finally{
			if(jedis != null){
				jedisSentinelPool.returnResource(jedis);
			}
		}
		return null;
	}
	
}
