package com.blogpost.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
//@Service
public class LoginServiceImpl {
//implements LoginService {
//
//	@Autowired
//	private LoginRepository loginRepository;
// 
//	@Autowired
//	private AuthenticationManager manager;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	private JwtHelper helper;
//
//	@Override
//	public ResponseEntity<ResponseModel<JwtResponse>> login(LoginModel login) {
//		try {
//			manager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
//
//			UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
//			String token = this.helper.generateToken(userDetails);
//
//			// Cast to LoginModel to access the role information
//			LoginModel loginModel = (LoginModel) userDetails;
//			String roleType = loginModel.getRole().getRoleName();
//			int userId = loginModel.getUserId();
//
//			JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).username(userDetails.getUsername())
//					.roleType(roleType).userId(userId).build();
//
//			ResponseModel<JwtResponse> successResponse = new ResponseModel<>(HttpStatus.OK.value(), null, jwtResponse);
//			return new ResponseEntity<>(successResponse, HttpStatus.OK);
//
//		} catch (BadCredentialsException e) {
//			ResponseModel<JwtResponse> errorResponse = new ResponseModel<>(HttpStatus.UNAUTHORIZED.value(),
//					"Invalid Username or Password", null);
//			return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
//		}
//	}

}
