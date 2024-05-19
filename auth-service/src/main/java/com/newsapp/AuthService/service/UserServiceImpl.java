package com.newsapp.AuthService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsapp.AuthService.model.UserInfo;
import com.newsapp.AuthService.repo.UserRepo;

import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

@Autowired
private UserRepo repo;

@Override
public UserInfo login(String email, String password) {
	
	Optional<UserInfo> userinfo = repo.findByUseremailAndPassword(email, password);
	if (userinfo.isPresent())
		return userinfo.get();
	else
		return null;
}

public UserInfo registerUser(UserInfo userdata) {
	Optional<UserInfo> userinfo = repo.findById(userdata.getUseremail());
	if (userinfo.isEmpty()) {
		return repo.save(userdata);
		
	} else
		return null;
}


}
