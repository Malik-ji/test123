package com.blogpost.blog.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.entities.JwtResponse;
import com.blogpost.blog.entities.Loginmaster;
import com.blogpost.blog.entities.ResponseModel;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> createUser(@RequestBody Loginmaster userDto, HttpSession session) {
		ResponseEntity<?> createUser = this.userService.createUser(userDto);

//			  System.out.println("ADDDDDDDDDDDDD"+session.getAttribute("username"));

		return new ResponseEntity<>(createUser, HttpStatus.CREATED);

	}

	@PatchMapping("/updateUser/")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody Loginmaster userDto) {
		ResponseEntity<ApiResponse> updateUSer = this.userService.updateUSer(userDto);
		return updateUSer;

	}

	@GetMapping("/getUserByUsername/{username}")
	public ResponseEntity<Loginmaster> getUserById(@PathVariable("username") String id) {

		return ResponseEntity.ok(this.userService.getUserById(id));
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Loginmaster>> getAllUsers() {
		List<Loginmaster> allUsers = this.userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}

//		
	@DeleteMapping("/deleteUserByUsername/{username}")
	public ResponseEntity<Loginmaster> deleteUserById(@PathVariable("username") String id) {
		this.userService.deleteUser(id);
		return new ResponseEntity(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

	}

	
//	@PostMapping("/login")
//	public ResponseEntity<com.blogpost.blog.entities.ResponseModel<JwtResponse>> login(@RequestBody Loginmaster login) {
//		try {
////			ResponseEntity<ResponseModel<JwtResponse>> responseEntity = userService.login(login);
//
////			return responseEntity;
//		} catch (Exception e) {
//			// Handle other exceptions or log them if necessary
//			ResponseModel<JwtResponse> errorResponse = new ResponseModel<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
//					"Internal Server Error", null);
//			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
//	
//	@PostMapping("/loginUser")
//	public ResponseEntity<?> loginUser(@RequestParam("username") String name, @RequestParam("password") String password,
//			HttpSession session) {
//
//		ResponseEntity<?> loginUser = this.userService.loginUser(name, password);
//		if (loginUser.getStatusCode().equals(HttpStatus.OK)) {
//
//			Loginmaster body = (Loginmaster) loginUser.getBody();
//			session.setAttribute("username", body.getUsername());
//			session.setAttribute("roleType", body.getRoleType());
//			session.setAttribute("company", body.getCompany());
//			
//			 List<String> asList = Arrays.asList( body.getGroupName()) ;
//			  session.setAttribute("groupName", asList);
//			 // Example list
////			session.setAttribute("groupName", groupNames);
//			System.out.println("AAAAAAAAAAAAAAAAAAAAA  :: "+session.getAttribute("roleType"));
//			
//		}
//		
//		return loginUser;
//
//	}
	@PostMapping("/logoutUser")
	public ResponseEntity<?> logoutUser(HttpSession session) {
	    session.invalidate();
	    return new ResponseEntity<>(new ApiResponse("Logged out successfully", true), HttpStatus.OK);
	}
}
