package com.newsapp.AuthService.config;

import com.google.gson.Gson;
import com.newsapp.AuthService.model.UserInfo;
import com.newsapp.AuthService.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@EnableKafka
public class KafkaConfigConsumer {

@Autowired
Gson gson;

@Autowired
UserServiceImpl authUserService;

@KafkaListener(topics = "user-register", groupId = "news")
public void consume(String users) {
	System.out.println("received message=" + users);
	UserInfo userdata = gson.fromJson(users, UserInfo.class);
	UserInfo result = authUserService.registerUser(userdata);
	System.out.println("User Data: "+result);
	System.out.println("Stored data in User Copy" + userdata.toString());
	
	
}
	
}
