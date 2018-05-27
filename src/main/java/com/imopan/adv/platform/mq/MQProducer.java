package com.imopan.adv.platform.mq;

public interface MQProducer {
	public void sendMsgToQueue(String queueKey, Object object);
}
