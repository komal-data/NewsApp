package com.newsapp.newsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler(NoArticlesFoundException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleCustomValidationException(NoArticlesFoundException ex) {
    	ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
