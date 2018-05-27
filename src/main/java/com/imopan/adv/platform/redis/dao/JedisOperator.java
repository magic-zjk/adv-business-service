package com.imopan.adv.platform.redis.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * 将密钥数据存储到redis
 * 
 * @author bin
 */

@Component
public class JedisOperator {

    public static Logger logger = LoggerFactory.getLogger(JedisOperator.class);

	@Resource(name="redisSentinel_db13")
	private JedisSentinelPool jedisSentinelPool;
	
	
    public void hsave(String key, String field,int time, Object obj) {
        Jedis jedis = null;
        try {
          jedis = jedisSentinelPool.getResource();
   /*       if (jedis.exists(key)){
              jedis.del(key);
          }*/
          String objstr=new Gson().toJson(obj);
            jedis.hset(key,field,objstr);
           if(time!=-1){
        	   jedis.expire(key, time);
           }
        } catch (Exception e) {
            logger.error("hsave  error .", e);
        } finally {
            if (jedis != null) {
              jedisSentinelPool.returnResource(jedis);
//                pool.returnResource(jedis);
            }
        }
    }
    public String  hget(String key, String field) {
        Jedis jedis = null;
        try {
          jedis = jedisSentinelPool.getResource();
          String hget = jedis.hget(key, field);
          return hget;
        } catch (Exception e) {
            logger.error("hsave  error .", e);
        } finally {
            if (jedis != null) {
              jedisSentinelPool.returnResource(jedis);
//                pool.returnResource(jedis);
            }
        }
		return "";
    }
    public void hdelete(String key, String field) {
        Jedis jedis = null;
        try {
          jedis = jedisSentinelPool.getResource();
          if (jedis.exists(key)){
              jedis.hdel(key, field);
          }
        } catch (Exception e) {
            logger.error("hsave  error .", e);
        } finally {
            if (jedis != null) {
              jedisSentinelPool.returnResource(jedis);
//                pool.returnResource(jedis);
            }
        }
    }
	
	/*** 保存广告每天投放量信息 **/
    public void saveAdPutInfo(String key, int time, Map<String, String> putInfoMap) {
        Jedis jedis = null;
        try {
          jedis = jedisSentinelPool.getResource();
//            jedis = pool.getResource();
          if (jedis.exists(key)){
              jedis.del(key);
          }
            jedis.hmset(key, putInfoMap);
            jedis.expire(key, time);
        } catch (Exception e) {
            logger.error("saveAdPutInfo  error .", e);
        } finally {
            if (jedis != null) {
              jedisSentinelPool.returnResource(jedis);
//                pool.returnResource(jedis);
            }
        }
    }
    
    
    public boolean deleteAdPutInfo(String key) {
        Jedis jedis = null;
        try {
          jedis = jedisSentinelPool.getResource();
//            jedis = pool.getResource();
            if (jedis.exists(key)){
                jedis.del(key);
            }
            return true;
        } catch (Exception e) {
            logger.error("deleteAdPutInfo  error .", e.getMessage());
            return false;
        } finally {
            if (jedis != null) {
               jedisSentinelPool.returnResource(jedis);
//                pool.returnResource(jedis);
            }
        }
    }
    
    
    public Map<String,String> getAdPutInfo(String key) {
        Jedis jedis = null;
        try {
          jedis = jedisSentinelPool.getResource();
//            jedis = pool.getResource();
            return jedis.hgetAll(key);
        } catch (Exception e) {
            logger.error("getAdPutInfo  error .", e.getMessage());
        } finally {
            if (jedis != null) {
               jedisSentinelPool.returnResource(jedis);
//                pool.returnResource(jedis);
            }
        }
        return null;
    }
    
}
