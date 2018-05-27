/** 
 * Project Name:adv-business-service1.1 
 * File Name:JedisBusiness.java 
 * Package Name:com.imopan.adv.platform.task.fos.redis 
 * Date:2016年7月4日下午2:51:59 
 * Copyright (c) 2016, zhangjiakun@imopan.com All Rights Reserved. 
 * 
*/ 

package com.imopan.adv.platform.task.fos.redis;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.imopan.adv.platform.redis.dao.JedisOperator;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/** 
 * ClassName:JedisBusiness <br/> 
 * Function: jedis核心操作 <br/>  
 * Date:     2016年7月4日 下午2:51:59 <br/> 
 * @author   zhangjiakun 
 * @version   
 * @since    JDK 1.7       
 */
@Component
public class JedisBusiness {
	 public static Logger jdislogger = LoggerFactory.getLogger(JedisOperator.class);

		@Resource(name="redisSentinel_db13")
		private JedisSentinelPool jedisSentinelPool;

		//执行setnx方法,0:获得执行权；1：执行成功
		public Long setNx_0(String key) {
			 Jedis jedis = null;
		        try {
		          jedis = jedisSentinelPool.getResource();
		          
		          Long setnx = jedis.setnx(key, "0");//0:获得执行权；1：执行成功
		          jedis.expire(key, 86400);
		            return setnx;
		        } catch (Exception e) {
		        	jdislogger.error("", e.getMessage());
		            return 0l;
		        } finally {
		            if (jedis != null) {
		               jedisSentinelPool.returnResource(jedis);
		            }
		        }
		}
}
