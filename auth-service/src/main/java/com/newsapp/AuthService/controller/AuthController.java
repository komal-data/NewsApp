package com.newsapp.AuthService.controller;

import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.newsapp.AuthService.config.JwtGenerator;
import com.newsapp.AuthService.exception.UserNotFoundException;
import com.newsapp.AuthService.model.UserInfo;
import com.newsapp.AuthService.service.UserService;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1.0")
public class AuthController {


private final UserService userservice;

public AuthController(UserService userservice, JwtGenerator jwtGenerator) {
	this.userservice = userservice;
	
}


@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody UserInfo userinfo) throws UserNotFoundException {
	if (userinfo.getUseremail() == null || userinfo.getPassword() == null) {
		throw new UserNotFoundException("email and password are null");
	}
	UserInfo result = userservice.login(userinfo.getUseremail(), userinfo.getPassword());
	if (result == null) {
		return new ResponseEntity("Invalid user", HttpStatus.UNAUTHORIZED);
		
	} else {
		Map<String, String> mytoken = new JwtGenerator().generateToken(result);
		return new ResponseEntity<Map>(mytoken, HttpStatus.OK);
	}
}

@GetMapping("/getUserByToken")
public ResponseEntity<?> getUserByToken(@RequestHeader("Authorization") String token){
	String email=new JwtGenerator().getUserIdByToken(token);
	Map<String, String> responseData = new HashMap<>();
	responseData.put("email", email);
	return ResponseEntity.ok().body(responseData);
}

}