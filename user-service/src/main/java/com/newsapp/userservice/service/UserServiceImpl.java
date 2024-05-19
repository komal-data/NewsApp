package com.newsapp.userservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.newsapp.userservice.entity.User;
import com.newsapp.userservice.exception.UserAlreadyExistsException;
import com.newsapp.userservice.exception.UserNotFoundException;
import com.newsapp.userservice.kafka.KafkaConfig;
import com.newsapp.userservice.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	 private static final Logger logger =
	 LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private Gson gson;

	private UserRepo userRepo;
	private static final String TOPIC = "user-register";

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User saveUser(User user) throws UserAlreadyExistsException {
		 logger.info(" Executing Save User");
		User user1 = userRepo.findByUseremail(user.getUseremail());
		if (user1!=null) {
			throw new UserAlreadyExistsException("User Already Exists");
		} else {
			User users = userRepo.save(user);
			kafkaTemplate.send(TOPIC, gson.toJson(user));
			return users;
		}

	}


	@Override
	public User findByUseremail(String useremail) {
		 logger.info(" Executing getUser");
		return userRepo.findByUseremail(useremail);
	}

}
