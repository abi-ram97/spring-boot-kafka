package com.techboss.kafka.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.techboss.kafka.model.User;

@Service
public class ProducerService {
	
	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public void sendMessage(User user) {
		String key = UUID.randomUUID().toString();
		
		ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send("user-in", key, user);
		future.addCallback(new ListenableFutureCallback<SendResult<String, User>>(){

			@Override
			public void onSuccess(SendResult<String, User> result) {
				logger.info("Sent message[{}] with offset [{}] to partition [{}]", user,
						result.getRecordMetadata().offset(),
						result.getRecordMetadata().partition());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Unable to send message [{}] due to {}", user, ex.getMessage());
			}
		});
	}
}
