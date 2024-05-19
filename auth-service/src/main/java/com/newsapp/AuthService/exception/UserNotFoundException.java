package com.newsapp.AuthService.exception;

public class UserNotFoundException extends RuntimeException {
public UserNotFoundException(String message) {
	super(message);
}

}
