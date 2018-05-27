package com.imopan.adv.platform.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class MyProperty {
	private static Properties sysProperties;
	static {
		try {
			sysProperties = PropertiesLoaderUtils.loadAllProperties("/sysconfig.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getImageSave() {
		return sysProperties.getProperty("imgsave", "/res2/adimg/");
	}

	public static String getImageVirtual() {
		return sysProperties.getProperty("imgwebpath", "/adimg/");
	}
	
//	public static String getTempImageSave() {
//		return sysProperties.getProperty("tempimgsave", "/res2/adimg/");
//	}
//
//	public static String getTempImgWebpath() {
//		return sysProperties.getProperty("tempimgwebpath", "/tempimg/");
//	}

	public static String getAppSave() {
		return sysProperties.getProperty("appsave", "/res2/appsoft/");
	}

	public static String getAppVirtual() {
		return sysProperties.getProperty("appwebpath", "/appsoft/");
	}
	
	public static String getTempSave() {
		return sysProperties.getProperty("tempsave", "/res2/appsoft/");
	}
	
	public static String getTemp() {
		return sysProperties.getProperty("temp", "/res2/temp/");
	}
	
//	public static String getdownLoadApp() {
//		return sysProperties.getProperty("appwebpath", "/appsoft/") + sysProperties.getProperty("downLoadApp");
//	}
	
	public static String getAdvAckUrl() {
		return sysProperties.getProperty("advAckUrl", "http://imopan.com/cas/advAck.bin");
	}
	
	public static String getExportDomain() {
		return sysProperties.getProperty("exportDomain", "http://imopan.com/appsoft/export/");
	}
	
	public static String[] getServerRecCpaUrlList() {
		String str = sysProperties.getProperty("serverRecCpaUrlList");
		if(str == null) return null;
		return str.split(",");
	}
	
	public static String[] getDownApkUrls() {
		String str = sysProperties.getProperty("downApkUrl");
		if(str == null) return null;
		return str.split(",");
	}

	public static void main(String[] args) {
		System.out.println(MyProperty.getAppSave());
	}
}
