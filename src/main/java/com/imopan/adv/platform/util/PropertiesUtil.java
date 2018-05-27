package com.imopan.adv.platform.util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil{
    
    //配置文件的路径
    private static String configPath = null;
    
    /**
     * 配置文件对象
     */
    private static Properties props = null;
    
//    public PropertiesUtil() throws IOException{
//        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("weight.properties");
//        props = new Properties();
//        props.load(in);
//        //关闭资源
//        in.close();
//    }
    
    static {
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("conf/conf.properties");
        props = new Properties();
        try {
            props.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 根据key值读取配置的值
     * @param key key值
     * @return key 键对应的值 
     * @throws IOException 
     */
    public static String readValue(String key){
        return  props.getProperty(key);
    }
    /**
     * 根据key值读取配置的值
     * @param key key值
     * @return key 键对应的值 
     * @throws IOException 
     */
    public static String readValue(String key,String defaultValue){
        return  props.getProperty(key,defaultValue);
    }
    
    /**
     * 读取properties的全部信息
     * @throws FileNotFoundException 配置文件没有找到
     * @throws IOException 关闭资源文件，或者加载配置文件错误
     * 
     */
    @SuppressWarnings("rawtypes")
    public static Map<String,Double> readAllProperties() throws FileNotFoundException,IOException  {
        //保存所有的键值
        Map<String,Double> map=new HashMap<String,Double>();
        Enumeration en = props.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            Double Property = Double.valueOf(props.getProperty(key));
            map.put(key, Property);
        }
        return map;
    }

    /**
     * 设置某个key的值,并保存至文件。
     * @param key key值
     * @return key 键对应的值 
     * @throws IOException 
     */
    public static void setValue(String key,String value) throws IOException {
        Properties prop = new Properties();
        InputStream fis = new FileInputStream(configPath);
        // 从输入流中读取属性列表（键和元素对）
        prop.load(fis);
        // 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
        // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream fos = new FileOutputStream(configPath);
        prop.setProperty(key, value);
        // 以适合使用 load 方法加载到 Properties 表中的格式，
        // 将此 Properties 表中的属性列表（键和元素对）写入输出流
        prop.store(fos,"last update");
        //关闭文件
        fis.close();
        fos.close();
    }
	public static String getproperties_classpath(String configpath_classpath,String propertykey) {
		Properties properties =new Properties();
		Resource resource = new ClassPathResource(configpath_classpath);
		try {
			properties =PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = properties.getProperty(propertykey);
		System.out.println("获取资源文件");
		System.out.println("getproperties_classpath  "+propertykey+"="+property);
		return property;
	}
	public static String getproperties_Filesystem(String configpath_Filesystem,String propertykey) {
		Properties properties =new Properties();
		Resource resource = new FileSystemResource(configpath_Filesystem);
		try {
			properties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = properties.getProperty(propertykey);
		System.out.println("getproperties_Filesystem  "+propertykey+"="+property);
		return property;
	}
    public static void main(String[] args) {
        try {
            System.out.println(PropertiesUtil.readAllProperties());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
