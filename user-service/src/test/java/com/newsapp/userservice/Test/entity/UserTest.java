package com.newsapp.userservice.Test.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.newsapp.userservice.entity.User;

class UserTest {

	private User userTest;
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		userTest = new User(8901566901L,"komal","data","komal@gmail.com","komaldata");
	}
	@Test
	void testSetMobileNo() {
		userTest.setMobile(8901566901L);
	}
	@Test
	void testSetFirstName() {
		userTest.setFirstname("komal");
	}
	@Test
	void testSetLastName() {
		userTest.setLastname("data");
	}
	@Test
	void testSetEmail() {
		userTest.setUseremail("komal@gmail.com");
	}
	@Test
	void testSetPasswrod() {
		userTest.setPassword("komaldata");
	}
}
