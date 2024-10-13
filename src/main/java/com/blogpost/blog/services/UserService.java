package com.blogpost.blog.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.blogpost.blog.entities.Loginmaster;
import com.blogpost.blog.entities.User;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.payloads.UserDto;

public interface UserService {

	ResponseEntity<?> createUser(Loginmaster userDto);

	ResponseEntity<ApiResponse> updateUSer(Loginmaster userDto);

	Loginmaster getUserById(String userId);
//
	List<Loginmaster> getAllUsers();
//
	void deleteUser(String userId);
	ResponseEntity<?> loginUser(String userId,String password);
}
