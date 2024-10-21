package com.blogpost.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.entities.JwtResponse;
import com.blogpost.blog.entities.ResponseModel;
import com.blogpost.blog.services.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseModel<JwtResponse>> login(@RequestParam("username") String name, @RequestParam("password") String password) {
		try {
			ResponseEntity<ResponseModel<JwtResponse>> responseEntity = userService.login(name,password);
			
			return responseEntity;
		} catch (Exception e) {
			// Handle other exceptions or log them if necessary
			ResponseModel<JwtResponse> errorResponse = new ResponseModel<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Internal Server Error", null);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
