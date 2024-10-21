package com.blogpost.blog.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.blogpost.blog.entities.JwtResponse;
import com.blogpost.blog.entities.Loginmaster;
import com.blogpost.blog.entities.ResponseModel;
import com.blogpost.blog.payloads.ApiResponse;



public interface UserService {

	ResponseEntity<?> createUser(Loginmaster userDto);

	ResponseEntity<ApiResponse> updateUSer(Loginmaster userDto);

	Loginmaster getUserById(String userId);

//
	List<Loginmaster> getAllUsers();

//
	void deleteUser(String userId);

	ResponseEntity<?> loginUser(String userId, String password);

	ResponseEntity<ResponseModel<JwtResponse>> login(String userId, String password);

}
