package com.newsapp.userservice.Test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.newsapp.userservice.controller.UserController;
import com.newsapp.userservice.entity.User;
import com.newsapp.userservice.exception.UserNotFoundException;
import com.newsapp.userservice.service.UserService;

 class UserControllerTest {
	 
		 @InjectMocks
		    private UserController userController;
		 
		    @Mock
		    private UserService userService;
		 
		    @BeforeEach
		    void setUp() {
		        MockitoAnnotations.openMocks(this);
		    }
		 
		    @Test
		    void saveUser_NewUser_SuccessfullySaved() {
		        User newUser = new User(9898989899L, "komal", "Data", "komal@example.com","password");
		        when(userService.saveUser(any(User.class))).thenReturn(newUser);
		        ResponseEntity<User> responseEntity = userController.saveUser(newUser);
		 
		        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		        assertEquals(newUser, responseEntity.getBody());
		        verify(userService, times(1)).saveUser(any(User.class));
		    }
		    
		    @Test
		     void findUserByUseremailTest_UserFound() {
		      
		        String userEmail = "test@example.com";
		        User expectedUser = new User(); 
		        when(userService.findByUseremail(userEmail)).thenReturn(expectedUser);
		    
		        ResponseEntity<User> response = userController.findUserByUseremail(userEmail);		        
		        assertEquals(HttpStatus.OK, response.getStatusCode());
		        assertEquals(expectedUser, response.getBody());
		        verify(userService, times(1)).findByUseremail(userEmail);
		    }
		}
