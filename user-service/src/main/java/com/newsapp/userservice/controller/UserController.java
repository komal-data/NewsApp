package com.newsapp.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsapp.userservice.entity.User;
import com.newsapp.userservice.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1.0/user")
public class UserController {
	 
	@Autowired
	private UserService userService;
	
	
	//add user
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
	 return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);

}
 
	@GetMapping("/get")
	public ResponseEntity<User> findUserByUseremail(String useremail){
	
		return new ResponseEntity<>(userService.findByUseremail(useremail),HttpStatus.OK);
	}

	
}
