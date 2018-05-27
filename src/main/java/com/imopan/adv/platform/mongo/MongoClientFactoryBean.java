package com.imopan.adv.platform.mongo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoClientFactoryBean implements FactoryBean<MongoClient>,
		InitializingBean, DisposableBean {
	
	private Logger log = LoggerFactory.getLogger(MongoClientFactoryBean.class);

	private MongoClient mongoClient;
	
	
	// mongodb://user1:pwd1@host1/?authSource=db1
	private String uri;
	
	
	private String host;
	private int port;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
 

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public MongoClient getObject() throws Exception {
		return mongoClient;
	}

	@Override
	public Class<?> getObjectType() {
		return MongoClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// MongoClientOptions options = MongoClientOptions.builder().build();
//		ServerAddress adress = new ServerAddress(host,port);
//		MongoCredential credential = MongoCredential.createCredential(username,
//                database,
//                password.toCharArray());
//		List<MongoCredential> credList = new ArrayList<>();
//		credList.add(credential);
//		this.mongoClient = new MongoClient(adress,credList);
		if(uri!=null){
			MongoClientURI mongoUri = new MongoClientURI(uri);
			this.mongoClient =  new MongoClient(mongoUri);
			log.info("init mongodb client use uri : " + uri);
			return ;
		}
		this.mongoClient = new MongoClient(host,port);
		
	}

	@Override
	public void destroy() throws Exception {
		mongoClient.close();
	}

}
