package com.imopan.adv.platform.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imopan.adv.platform.common.ImopanConstants;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.entity.GzipCompressingEntity;

import java.io.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * http线程池
 *
 * HttpStackManager
 *
 * @author yangzhenyu
 *
 * @since 2016年1月22日 下午3:08:33
 *
 * @version 1.0.0
 */
public class HttpStackManager {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(HttpStackManager.class);

	private static final String ECODEING = "utf-8";

	RequestConfig requestConfig;

	private HttpStackManager() {
		requestConfig = RequestConfig.custom().setSocketTimeout(1000)
				.setConnectTimeout(1000).setConnectionRequestTimeout(1000)
				.build();
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(1200);
		cm.setDefaultMaxPerRoute(400);

		// cm.setDefaultMaxPerRoute(100); //定义每个路径的最大连接数量 总共两个地址 可以平均fen一下

		ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response,
					HttpContext context) {
				// 可以根据应答的keepalived 参数进行设置 'keep-alive' header
				// HeaderElementIterator it = new BasicHeaderElementIterator(
				// response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				// while (it.hasNext()) {
				// HeaderElement he = it.nextElement();
				// String param = he.getName();
				// String value = he.getValue();
				// if (value != null && param.equalsIgnoreCase("timeout")) {
				// try {
				// return Long.parseLong(value) * 1000;
				// } catch(NumberFormatException ignore) {
				// }
				// }
				// }
				// HttpHost target = (HttpHost) context.getAttribute(
				// HttpClientContext.HTTP_TARGET_HOST);
				return 1000 * 30;
			}
		};

		HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {

			public boolean retryRequest(IOException exception,
					int executionCount, HttpContext context) {
				if (executionCount >= 3) {
					// Do not retry if over max retry count
					return false;
				}
				if (exception instanceof InterruptedIOException) {
					// 超时
					return true;
				}
				if (exception instanceof UnknownHostException) {
					// Unknown host
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {
					// 拒绝连接的情况下
					return true;
				}
				if (exception instanceof SSLException) {
					// SSL 握手异常 不进行重试
					return false;
				}
				HttpClientContext clientContext = HttpClientContext
						.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					// 只重试幂等性的请求
					return true;
				}
				return false;
			}

		};

		httpclient = HttpClients.custom().setConnectionManager(cm)
				.setKeepAliveStrategy(myStrategy)
				.setRetryHandler(myRetryHandler).build();
	}

	public static HttpStackManager getInstance() {
		return InstanceHolder.instance;
	}

	// 用内部类来初始化单实例的Manager
	private static class InstanceHolder {
		private InstanceHolder() {
		}

		public static HttpStackManager instance = new HttpStackManager();
	}

	public CloseableHttpClient getHttpclient() {
		return httpclient;
	}

	private CloseableHttpClient httpclient;

	/**
	 * ＳＳ对接执行ＰＯＳＴ方法
	 */
	public String execPost(HttpUriRequest request) {

		logger.info("HttpStackManager : ip.dest = " + request.getURI()
				+ "    request args = " + request.getRequestLine());

		String respstr = "";

		try {
			CloseableHttpResponse resp = this.getHttpclient().execute(request);
			HttpEntity respEntity = resp.getEntity();
			respstr = EntityUtils.toString(respEntity, ECODEING);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("HttpStackManager  response = " + respstr);
		return respstr;
	}

	/**
	 * 
	 *
	 * findPostData
	 *
	 * @param url
	 * @param params
	 * @return String
	 *
	 * @exception
	 *
	 * @since 2016年2月26日 下午2:12:54
	 */
	public static String findPostData(String url, Map<String, String> params) {
		if (logger.isDebugEnabled()) {
			logger.debug("findPostData() - String url={}", url);
		}

		HttpClient httpclient = HttpStackManager.getInstance().getHttpclient();
		
		HttpPost httpost = new HttpPost(url);
		
		if (params != null) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}
			
			try {
				httpost.setEntity(new UrlEncodedFormEntity(nvps, ECODEING));
			} catch (UnsupportedEncodingException e) {
				logger.error("post()", e);
			}
		}
		
		HttpResponse response = null;

		try {
			response = httpclient.execute(httpost);
		} catch (ClientProtocolException e) {
			logger.warn("post() - exception ignored", e);
			
		} catch (IOException e) {
			logger.warn("post() - exception ignored", e);			
		}

		HttpEntity entity = null;

		String res = null;
		try {
			
			entity = response.getEntity();
			res = EntityUtils.toString(entity, ECODEING);

			EntityUtils.consume(entity);

			return res;
		} catch (ParseException e) {
			logger.warn("post() - exception ignored", e);			
		} catch (IOException e) {
			logger.warn("post() - exception ignored", e);			
		} finally {
			if (entity != null) {
				try {
					EntityUtils.consume(entity);
				} catch (IOException e) {
					logger.error("findGetData(String)", e);
				}
			}
		}
		
		return res;
	}

	public static String findGetData(String url) {
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendGet--url|"+url);
		HttpClient httpClient = HttpStackManager.getInstance().getHttpclient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = null;
		HttpEntity entity = null;
		try {
			response = httpClient.execute(httpGet);
			entity = response.getEntity();

			String res = EntityUtils.toString(entity, ECODEING);

			EntityUtils.consume(entity);
			logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendGet--result|"+res);
			return res;
		} catch (ClientProtocolException e) {
			logger.error("findGetData(String)", e);

		} catch (IOException e) {
			logger.error("findGetData(String)", e);

		} finally {
			if (entity != null) {
				try {
					EntityUtils.consume(entity);
				} catch (IOException e) {
					logger.error("findGetData(String)", e);

					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
/*	public static String postHttpsCall (String url, Map<String,String> map,String charset){
        HttpClient httpClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        try{  
            httpClient = new SSLClient();  
            httpPost = new HttpPost(url);
            
            logger.info("postHttpCall->url=" + url);
            logger.info("postHttpCall->map=" + map);
            
            //设置参数  
            if (map != null) {
	            List<NameValuePair> list = new ArrayList<NameValuePair>();  
	            Iterator iterator = map.entrySet().iterator();  
	            while(iterator.hasNext()){  
	                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
	                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
	            }  
	            if(list.size() > 0){  
	                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);  
	                httpPost.setEntity(entity);  
	            }  
            }
            HttpResponse response = httpClient.execute(httpPost);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){
			logger.error("postHttpCall(String, Map<String,String>, String)", ex);
   
        }  
        return result;  
    }
	*/
	/**
	 * 
	 * 上报日志
	 *
	 * execPostLog
	 *
	 * @param urlStr
	 * @param jsonStr void
	 *
	 * @exception
	 *
	 * @since 2015年11月19日 下午6:25:07
	 */
	public static void execPostJsonLog(String lOG_SERVICE_PATH, String msgJSONStr) {
		
		HttpClient httpClient = HttpStackManager.getInstance().getHttpclient();

		RequestConfig config = RequestConfig.custom()
			    .setConnectionRequestTimeout(500).setConnectTimeout(500)
			    .setSocketTimeout(500).build();
		
		HttpPost post = new HttpPost(lOG_SERVICE_PATH);
		post.setConfig(config);
		
		post.setHeader("Content-Type", "json/text;charset=UTF-8");
		
		HttpEntity postEntity = null;
		HttpEntity entity = null;
		HttpResponse response = null;
		try {
			postEntity = new GzipCompressingEntity(new StringEntity(msgJSONStr));
			
			post.setEntity(postEntity);
			
			response = httpClient.execute(post);
	        
	        int statusCode = response.getStatusLine().getStatusCode();
	        
	        if(statusCode != 200){
        		//发送失败
	        	logger.warn("发送失败->statusCode=" + statusCode);
	        	logger.warn(";lOG_SERVICE_PATH=" + lOG_SERVICE_PATH);
	        	logger.warn(";msgJSONStr=" + msgJSONStr);
        	}
	        
	        entity = response.getEntity();
	        
	        if (logger.isDebugEnabled()) {
	        	logger.debug(entity.toString());
	        }
	    		        
		} catch (UnsupportedEncodingException e) {
			logger.error("execPostLog(String, String)", e);

		} catch (ClientProtocolException e) {
			logger.error("execPostLog(String, String)", e);

		} catch (IOException e) {
			logger.error("execPostLog(String, String)", e);

		} finally {
			if (entity != null) {
				try {
					EntityUtils.consume(entity);
				} catch (IOException e) {
					logger.warn("execPostLog(String, String) - exception ignored", e);
				}
			}
			
//			try {
//				response.close();
//			} catch (IOException e) {
//				logger.warn("findPostData() - exception ignored", e);				
//			}
		}
	}
}
