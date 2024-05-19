package com.newsapp.userservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.protocol.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

import com.newsapp.userservice.entity.User;

@Configuration
@EnableKafka
public class KafkaConfig {
	

	
	private KafkaTemplate<String, String> kafkaTemplate;
	@Bean
	public NewTopic topic() {
		return TopicBuilder
				.name("user-register")
				.build();
		
	}

//	  public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
//	  this.kafkaTemplate = kafkaTemplate; } 
//	  public void topicMessage(User userData) { String
//	  userCredntial=userData.getUseremail(); String password=userData.getPassword();
//	  String sendData=userCredntial+"~"+password; 
//	  Message message=(Message) MessageBuilder.withPayload(userData).
//	  setHeader(KafkaHeaders.TOPIC,"name_json").build(); 
//	  kafkaTemplate.send("user-register",sendData);
//	  
//	  }
	 

}
