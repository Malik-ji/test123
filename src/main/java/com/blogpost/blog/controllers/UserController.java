package com.blogpost.blog.controllers;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.entities.Loginmaster;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.payloads.UserDto;
import com.blogpost.blog.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

		@Autowired
		private UserService userService;
	
		
		@PostMapping("/")
		public ResponseEntity<?> createUser( @RequestBody Loginmaster userDto,HttpSession session)
		{
			  ResponseEntity<?> createUser = this.userService.createUser(userDto);
			
			  session.setAttribute("username", userDto.getUsername());
			  session.setAttribute("roleType", userDto.getRoleType());
			
//			  System.out.println("ADDDDDDDDDDDDD"+session.getAttribute("username"));
			  
			  return new ResponseEntity<>(createUser,HttpStatus.CREATED);
			
		}
		@PatchMapping("/updateUser/")
		public ResponseEntity<ApiResponse> updateUser( @RequestBody Loginmaster userDto)
		{
		ResponseEntity<ApiResponse> updateUSer = this.userService.updateUSer(userDto);
		return updateUSer;
			
		}
		@GetMapping("/getUserByUsername/{username}")
		public ResponseEntity<Loginmaster> getUserById( @PathVariable("username") String id)
		{
			
			return ResponseEntity.ok(this.userService.getUserById(id));
		}
	
		@GetMapping("/getAllUsers")
		public ResponseEntity<List<Loginmaster>> getAllUsers()
		{
			List<Loginmaster> allUsers = this.userService.getAllUsers();
			return ResponseEntity.ok(allUsers);
		}
//		
		@DeleteMapping("/deleteUserByUsername/{username}")
		public ResponseEntity<Loginmaster> deleteUserById( @PathVariable("username") String id)
		{
			this.userService.deleteUser(id);
			return new  ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
			
		}
		
		@PostMapping("/loginUser")
		public ResponseEntity<?>  loginUser(@RequestParam("username") String name,@RequestParam("password") String password){
			return this.userService.loginUser(name,password);
			
		}
		
}
