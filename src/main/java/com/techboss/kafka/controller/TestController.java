package com.techboss.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techboss.kafka.model.User;
import com.techboss.kafka.service.ProducerService;

@RestController
@RequestMapping("/user")
public class TestController {
	
	@Autowired
	private ProducerService producer;
	
	@PostMapping
	public boolean postMessage(@RequestBody User user){
		producer.sendMessage(user);
		return true;
	}
}
