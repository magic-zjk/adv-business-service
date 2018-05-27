/**  
 * @Title:  AESUtil.java
 * @Package com.imo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author quchuanyuan
 * @date  2015年9月24日 下午2:52:21
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.imopan.adv.platform.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author 屈传远 说明:java支持128位加密 也就是密钥是16字节 如果要支持256字节的 需要下载jar替换jre的安全类
 * 
 * 对照可参考:http://www.seacha.com/tools/aes.php
 * 
 */
public class AESUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
	// 加密
	public static String Encrypt(String sSrc, String sKey) {
		byte[] encrypted = null;
		try {
			if (sKey == null) {
				logger.info("Key为空null");
				return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				logger.info("Key长度不是16位");
				return null;
			}
			byte[] raw = sKey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
			// IvParameterSpec iv = new
			// IvParameterSpec("12345678abcdefgh".getBytes());//
			// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			encrypted = cipher.doFinal(sSrc.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return Base64.encodeBase64String(encrypted);// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
	}

	// 解密
	public static String Decrypt(String sSrc, String sKey) {
		try {
			// 判断Key是否正确
			if (sKey == null) {
				logger.info("Key为空null");
				return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				logger.info("Key长度不是16位");
				return null;
			}
			byte[] raw = sKey.getBytes("UTF-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			// IvParameterSpec iv = new
			// IvParameterSpec("0102030405060708".getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = Base64.decodeBase64(sSrc);// 先用base64解密
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);
				return originalString;
			} catch (Exception e) {
				logger.info(e.toString());
				return null;
			}
		} catch (Exception ex) {
			logger.info(ex.toString());
			return null;
		}
	}

}
