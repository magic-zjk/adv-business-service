package com.imopan.adv.platform.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imopan.adv.platform.common.ImopanConstants;

@Service
public class MQProducerImpl implements MQProducer{
	
	private static Logger logger = LoggerFactory.getLogger(MQProducerImpl.class);
	
	@Autowired(required=true)
	private AmqpTemplate template;
	
	
	@Override
	public void sendMsgToQueue(String queueKey, Object object) {
		try {
            template.convertAndSend(queueKey, object);
            logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+queueKey+"|."+object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
}
