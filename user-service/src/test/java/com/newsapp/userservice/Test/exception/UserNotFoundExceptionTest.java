package com.newsapp.userservice.Test.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.newsapp.userservice.exception.UserNotFoundException;

public class UserNotFoundExceptionTest {

	@Test
	void testConstructor() {
		UserNotFoundException userNotFound= new UserNotFoundException("msg");
		assertEquals("msg",userNotFound.getLocalizedMessage());
		assertEquals("msg", userNotFound.getMessage());
	}
}
