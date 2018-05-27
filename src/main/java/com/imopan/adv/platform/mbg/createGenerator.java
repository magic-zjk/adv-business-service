package com.imopan.adv.platform.mbg;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


/**
 * ClassName: createGenerator <br/>
 * Desc:(mbg工具-生成)
 * date: 2016年1月28日 下午3:41:55 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class createGenerator {
	
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		InputStream stream = createGenerator.class.getClassLoader().getResourceAsStream("advPlatformGenConfig2.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(stream);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
		for (String string : warnings) {
			System.out.println("-------------");
			System.out.println(string);			
		}
	}
}
