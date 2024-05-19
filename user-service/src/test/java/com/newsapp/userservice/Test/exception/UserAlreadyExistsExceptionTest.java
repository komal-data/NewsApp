package com.newsapp.userservice.Test.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.newsapp.userservice.exception.UserAlreadyExistsException;

public class UserAlreadyExistsExceptionTest {

	@Test
	void testConstructor() {
		UserAlreadyExistsException actualUser= new UserAlreadyExistsException("msg");
		assertEquals("msg",actualUser.getLocalizedMessage());
		assertEquals("msg", actualUser.getMessage());
	}
}
