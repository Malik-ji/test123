package com.blogpost.blog.exceptions;

import com.blogpost.blog.payloads.ApiResponse;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message,boolean status) {
        super(message);
    }

	public InvalidCredentialsException(ApiResponse apiResponse) {
		super();
	}
}