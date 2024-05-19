package com.newsapp.authorizeapp.Test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.newsapp.AuthService.model.UserInfo;
import com.newsapp.AuthService.repo.UserRepo;
import com.newsapp.AuthService.service.UserServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AuthServiceTest {
@Mock
private UserRepo userRepo;

@InjectMocks
private UserServiceImpl userService;

@BeforeEach
void setUp() {
	MockitoAnnotations.openMocks(this);
}

@Test
void testLoginSuccess() {
	String email = "kav@gmail.com";
	String password = "kav@123";
	UserInfo user = new UserInfo("kav@gmail.com", "kav@123");
	
	when(userRepo.findByUseremailAndPassword(email, password)).thenReturn(Optional.of(user));
	
	UserInfo result = userService.login(email, password);
	
	assertNotNull(result);
	assertEquals(user.getUseremail(), result.getUseremail());
	assertEquals(user.getPassword(), result.getPassword());
}

@Test
void testLoginFailure() {
	String email = "kav@gmail.com";
	String password = "kav@123";
	
	when(userRepo.findByUseremailAndPassword(email, password)).thenReturn(Optional.empty());
	
	UserInfo result = userService.login(email, password);
	
	assertNull(result);
}


	
	
}


