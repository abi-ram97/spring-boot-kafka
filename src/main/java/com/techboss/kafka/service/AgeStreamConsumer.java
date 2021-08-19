package com.techboss.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AgeStreamConsumer {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@KafkaListener(id="ageStream-1", groupId = "my-group", 
			containerFactory = "ageKafkaListenerContainerFactory", topics = "user-out")
	public void getAgeCount(ConsumerRecord<Long, Long> myRecord) {
		logger.info("Received [{}] users with age [{}]", myRecord.value(), myRecord.key());
	}
}
