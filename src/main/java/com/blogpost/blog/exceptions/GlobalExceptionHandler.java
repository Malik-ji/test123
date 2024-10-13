package com.blogpost.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogpost.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resooucreNotFoundExcpetionHandler(ResourceNotFoundException ex)
	{
		String message = ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlerMethodArgsNotVAlidException(MethodArgumentNotValidException ex){
		Map<String,String> error=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((eror)
				->{
				String field = ((FieldError)eror).getField();
				String defaultMessage = eror.getDefaultMessage();
				error.put(field, defaultMessage);
				});	
	return	new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
	}
	  @ExceptionHandler(InvalidCredentialsException.class)
	    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException ex) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
	    }

}
