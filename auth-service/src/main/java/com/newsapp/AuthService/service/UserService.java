package com.newsapp.AuthService.service;

import com.newsapp.AuthService.model.UserInfo;

public interface UserService {


UserInfo login(String email, String password);

}
