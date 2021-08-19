package com.techboss.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.techboss.kafka.model.User;

@Service
public class SecondConsumer {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@KafkaListener(id = "consumer-2", groupId = "group-id", topicPartitions = @TopicPartition(topic = "my-topic", partitions = "0"))
	public void getMessage(@Payload User user, @Header(KafkaHeaders.OFFSET) long offset) {
		logger.info("2:Received [{}] with offset [{}]", user, offset);
	}
}
