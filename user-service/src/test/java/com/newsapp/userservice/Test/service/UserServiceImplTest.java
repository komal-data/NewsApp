package com.newsapp.userservice.Test.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.newsapp.userservice.entity.User;
import com.newsapp.userservice.exception.UserAlreadyExistsException;
import com.newsapp.userservice.repository.UserRepo;
import com.newsapp.userservice.service.UserServiceImpl;

@SpringBootTest
class UserServiceImplTest {

	@Mock
	private UserRepo userRepo;
    
	@InjectMocks
	private UserServiceImpl userService;

	@BeforeEach
	public void setUp() {
		 MockitoAnnotations.openMocks(this);
	}

//	@Test
//	void saveUserTest_UserDoesNotExist() {
//		User user = new User();
//		user.setFirstname("komal");
//		user.setLastname("data");
//		user.setUseremail("komal@gmail.com");
//		user.setMobile(8901566901L);
//		user.setPassword("komaldata");
//		when(userRepo.findByUseremail(user.getUseremail())).thenReturn(null);
//		when(userRepo.save(user)).thenReturn(user);
//		        
//		try {
//	        User savedUser = userService.saveUser(user);
//	        assertNotNull(savedUser);
//	        assertEquals(user, savedUser);
//	        
//	        verify(userRepo, times(1)).findByUseremail(user.getUseremail());
//	        verify(userRepo, times(1)).save(user);
//	      
//	    } catch (UserAlreadyExistsException e) {
//	        fail("User already exists but was expected not to.");
//	    }
//	}

	@Test
	void saveUserTest_UserAlreadyExists() {
		User user = new User();
		when(userRepo.findByUseremail(user.getUseremail())).thenReturn(user);
		assertThrows(UserAlreadyExistsException.class, () -> userService.saveUser(user));
		verify(userRepo, times(1)).findByUseremail(user.getUseremail());
		verify(userRepo, never()).save(any());
	}
	
	 @Test
	    void findByUseremail_Success() {
	        // Arrange
	        String userEmail = "test@example.com";
	        User expectedUser = new User(8901566901L,"komal","data","komal@gmail.com","komaldata");
	        when(userRepo.findByUseremail(userEmail)).thenReturn(expectedUser);

	        // Act
	        User foundUser = userService.findByUseremail(userEmail);

	        // Assert
	        assertEquals(expectedUser, foundUser);
	    }
}
