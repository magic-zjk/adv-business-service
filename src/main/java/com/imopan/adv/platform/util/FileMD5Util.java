package com.imopan.adv.platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class FileMD5Util {

	public static String getMd5ByFile(File file) throws FileNotFoundException {
		String value = null;
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
	public static String getfilemd5(File file){
		
		String md5Hex = null;
		try {
			md5Hex = DigestUtils.md5Hex(new FileInputStream(file));
//			md5Hex = DigestUtils.md5Hex(new FileInputStream(new File(path)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(md5Hex);
		return md5Hex;
	}
	public static String getFileMD5Bybytes(byte[] bytes){
		String md5Hex = null;
		try {
			md5Hex = DigestUtils.md5Hex(bytes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(md5Hex);
		return md5Hex;
	}
	public static void main(String[] args) throws IOException {

		String path="F:\\Baidudownload\\commons-codec-1.10-bin.zip";

		String v = getMd5ByFile(new File(path));
		System.out.println("MD5:"+v.toUpperCase());

		FileInputStream fis= new FileInputStream(path);  
		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));  
		IOUtils.closeQuietly(fis);  
		System.out.println("MD5:"+md5); 

		//System.out.println("MD5:"+DigestUtils.md5Hex("WANGQIUYUN"));
	}
	public void testmd5_1() throws Exception {
		String path="F:\\Baidudownload\\commons-codec-1.10-bin.zip";
		getfilemd5(new File(path));
	}
	@SuppressWarnings("unused")
	public void testconf() {
		Properties properties =new Properties();
		Resource resource = new ClassPathResource("conf/conf.properties");
		try {
			properties =PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = properties.getProperty("path_upload");
	}

}
