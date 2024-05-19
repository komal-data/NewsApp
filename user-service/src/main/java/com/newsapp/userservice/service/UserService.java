package com.newsapp.userservice.service;

import com.newsapp.userservice.entity.User;

  public interface UserService {
       public User saveUser(User user);
       public User findByUseremail(String useremail);
       
       
         
       
	}

	

