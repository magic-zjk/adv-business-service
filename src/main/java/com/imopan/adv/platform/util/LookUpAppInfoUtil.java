/** 
 * File Name:LookUpAppInfoUtil.java
 * Project Name:adv-business-service  
 * Package Name:com.imopan.adv.platform.util 
 * Create Date:2016年8月9日下午10:10:55 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */  
package com.imopan.adv.platform.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/** 
 * Description: look up ios application info from itunes.apple.com<br>
 * Create Date: 2016年8月9日 下午10:10:55
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class LookUpAppInfoUtil {
	
	private static final String ITUNES_URL_OF_LOOKUP = "http://itunes.apple.com/cn/lookup";

	/**
	 * look up full info by itunesid
	 * @param itunesid
	 * @author liangbing
	 * @return full info json
	 */
	public static String lookUpAllInfoByITunesId(String itunesid)throws Exception{
		String retJson = new String("");
		if(!StringUtils.isBlank(itunesid)){
			try {
				retJson = HttpStackManager.findGetData(ITUNES_URL_OF_LOOKUP+"?id="+itunesid);
				//retJson = HttpRequest.sendGet(ITUNES_URL_OF_LOOKUP, "id="+itunesid);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
		return retJson;
	}
	
	/**
	 * 获取 trackid、trackName、bundleId、trackViewUrl、artworkUrl100、fileSizeBytes对应的value
	 * @param itunesid
	 * @return 
	 * @version liangbing
	 */
	public static Map<String, String> lookUpValues(String itunesid)throws Exception{
		String fullJson = lookUpAllInfoByITunesId(itunesid);
		Map<String,String> map = new HashMap<String, String>(16);
		if(!StringUtils.isBlank(fullJson)){
			JSONObject object = new JSONObject(fullJson);
			if(object.get("resultCount") != null){
				int resultCount = Integer.parseInt(object.get("resultCount").toString());
				if(resultCount >=1 ){
					JSONArray results = (JSONArray)object.get("results");
					if(results.length() > 0){
						JSONObject o = (JSONObject)results.get(0);
						map.put("trackId", o.getInt("trackId")+"");
						map.put("trackName", o.getString("trackName"));
						map.put("bundleId", o.getString("bundleId"));
						map.put("trackViewUrl", o.getString("trackViewUrl"));
						map.put("artworkUrl100", o.getString("artworkUrl100"));
						map.put("fileSizeBytes", o.getString("fileSizeBytes"));
					}
				}
			}		
		}
		return map;
	}
	
	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++)
		System.out.println(LookUpAppInfoUtil.lookUpValues("1106815611"));
	}
}
