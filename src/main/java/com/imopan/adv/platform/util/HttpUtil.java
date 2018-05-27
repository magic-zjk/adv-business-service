
package com.imopan.adv.platform.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imopan.adv.platform.common.ImopanConstants;


public class HttpUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	public static String host = "http://localhost:80";
	
	//public static String host = "http://10.0.0.21:50";
	
	public String sendRequest(String url1,String requestMethod,String data){
		return sendRequest(url1, requestMethod, data, null);
	}

	public void sendRequest(String url1,String requestMethod,Map<String,String> headParamMap){
		sendRequest(url1, requestMethod, null, headParamMap);
	}

	private String sendRequest(String url1,String requestMethod,String data,Map<String,String> headParamMap){
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpUtil.sendRequest--url|"+url1);
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpUtil.sendRequest--入参data|"+data);
		try {

			URL url = new URL(url1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			conn.setRequestProperty("Accept", "application/json");

			if(headParamMap!=null && !headParamMap.isEmpty()){
				for(String key:headParamMap.keySet()){
					String value = headParamMap.get(key);
					conn.addRequestProperty(key, value);
				}
			}

			if(data!=null && data.trim().length()>0){
				conn.setDoOutput(true);
				conn.setRequestProperty("Content-Type", "application/json");
				String input = data;

				//System.out.println("outputString:"+input+"\n");

				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();
			}

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream()),"UTF-8"));

			String output;
			String jsonoutput = "";
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				
				jsonoutput+=output;
				
			}

			conn.disconnect();
			logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpUtil.sendRequest--出参data|"+jsonoutput);
			return jsonoutput;

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		return "no response";
	}

}
