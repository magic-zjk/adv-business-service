package com.imopan.adv.platform.util;



import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imopan.adv.platform.common.ImopanConstants;

public class HttpRequest {
	private static Logger logger = LoggerFactory.getLogger(HttpRequest.class);
	
    /**
     * 向指定URL发送GET方法的请求(适用于Http请求)
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param)throws Exception {
    	logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendGet--url|"+url);
    	logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendGet--param|"+param);
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection)connection;
            // 设置通用的请求属性
            httpConnection.setRequestProperty("accept", "*/*");
            //httpConnection.setRequestProperty("connection", "Keep-Alive");
            httpConnection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
            // 建立实际的连接
            httpConnection.connect();
            int code = httpConnection.getResponseCode();
            //大于400抛异常
            if(code >= 400){
            	if(code == 503){
                	throw new Exception("此AppStore Id不存在！");
                }
            	throw new Exception("请求AppStore异常！请检查AppStore Id 或稍后重试！");
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
            		httpConnection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	logger.error(ImopanConstants.LOGGER_PREFIX_ERROR+"HttpRequest.sendGet--请求出现异常！|"+e.getMessage());
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendGet--result|"+result);
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
    	logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendPost--url|"+url);
    	logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendPost--param|"+param);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	logger.error(ImopanConstants.LOGGER_PREFIX_ERROR+"HttpRequest.sendPost--请求出现异常！|"+e.getMessage());
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"HttpRequest.sendPost--result|"+result);
        return result;
    }    
    
    /**
     * 根据url下载app icon并保存本地
     * 此方法只适用在从apple服务器取icon
     * @param url
     * @return 本地文件路径
     * @version liangbing
     */
    public static String downloadAppIconByUrl(String urlStr)throws Exception{
    	URL url;
    	InputStream inputStream = null;
    	ByteArrayOutputStream outputStream = null;
    	FileOutputStream fops = null;
    	String rootPath = PropertiesUtil.readValue("path_upload");
    	//此处根据url获取图片类型
    	String fileType = urlStr.substring(urlStr.lastIndexOf("."),urlStr.length());
    	String fileMD5 = null;
    	String filePath = null;
    	String retPath = null;
		try {
			url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	        conn.setRequestMethod("GET");  
	        conn.setConnectTimeout(5 * 1000);  
	        inputStream = conn.getInputStream();//通过输入流获取图片数据
	        outputStream = new ByteArrayOutputStream(); 
	        byte[] buffer = new byte[1024*40];//图片大小约30k
	        int len = 0;  
	        while( (len=inputStream.read(buffer)) != -1 ){  
	        	outputStream.write(buffer, 0, len);  
	        }
	        fileMD5 = FileMD5Util.getFileMD5Bybytes(outputStream.toByteArray());
	        String year_month = DateUtil.getNowTimeStr("yyyyMM");
	        File folder = new File(rootPath + "/" + "icons"+ "/" +year_month);///Users/liangbing/program/upload/icons/yyyyMM/MD5.jpg 
	        if(!folder.exists()){
	        	folder.mkdirs();
	        }
	        retPath = "/" + "icons" + "/" +year_month +"/"+ fileMD5 + fileType;
	        filePath = rootPath + retPath;
	        File file = new File(filePath);
	        fops = new FileOutputStream(file);
            fops.write(outputStream.toByteArray());
            fops.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("icon存入本地磁盘异常！");
		}finally{
			try {
				if(inputStream != null){
					inputStream.close();
				}
				if(outputStream != null){
					outputStream.close();
				}
				if(fops != null){
					fops.close();  
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
    	return retPath;
    }
    
    public static void main(String[] args) {
    	//String url = "http://is4.mzstatic.com/image/thumb/Purple18/v4/f4/f0/28/f4f02872-8710-0261-5062-423361175656/source/60x60bb.jpg";
	}
}