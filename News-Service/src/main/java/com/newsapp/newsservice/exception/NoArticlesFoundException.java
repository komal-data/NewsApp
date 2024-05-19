package com.newsapp.newsservice.exception;

public class NoArticlesFoundException extends Throwable {
	private static final long serialVersionUID = 1L;

	public NoArticlesFoundException(String noArticlesFound) {
		super(noArticlesFound);
	}
}
