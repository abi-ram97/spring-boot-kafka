package com.techboss.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopic userin() {
		return TopicBuilder.name("user-in")
				.partitions(1)
				.replicas(1)
				.build();
	}
	
	@Bean
	public NewTopic userout() {
		return TopicBuilder.name("user-out")
				.partitions(1)
				.replicas(1)
				.build();
	}
	
	@Bean
	public NewTopic myTopic() {
		return TopicBuilder.name("my-topic")
				.partitions(2)
				.replicas(1)
				.build();
	}
	
}
