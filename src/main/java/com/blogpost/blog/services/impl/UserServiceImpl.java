package com.blogpost.blog.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.blogpost.blog.config.JwtHelper;
import com.blogpost.blog.entities.JwtResponse;
import com.blogpost.blog.entities.Loginmaster;
import com.blogpost.blog.entities.ResponseModel;
import com.blogpost.blog.exceptions.ResourceNotFoundException;
import com.blogpost.blog.payloads.ApiResponse;
import com.blogpost.blog.repositories.UserRepo;
import com.blogpost.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

//	@Autowired
//	ModelMapper modelMapper;
//	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtHelper helper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<?> createUser(@RequestBody Loginmaster userDto) {
		Optional<Loginmaster> existingUser = this.userRepo.findByUsername(userDto.getUsername());

		if (existingUser.isPresent()) {
			// User already exists
			String message = "User already exists with username: " + existingUser.get().getUsername();
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(message, false));
		} else {
			if (userDto.getRoleType().equals("Admin")) {
				userDto.setEngineerCategory("NA");
				userDto.setScope("NA");
				userDto.setGroupName("NA");
			} else if (userDto.getRoleType().equals("User")) {
				userDto.setGroupName("NA");
				userDto.setEngineerCategory("NA");
				userDto.setScope("NA");

			} else {
			}
			userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

			this.userRepo.save(userDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User created successfully", true));
		}
	}

	@Override
	public ResponseEntity<ApiResponse> updateUSer(Loginmaster loginmaster) {

		Loginmaster user = this.userRepo.findByUsername(loginmaster.getUsername())
				.orElseThrow(() -> new ResourceNotFoundException("User", " Name : ", loginmaster.getUsername()));

		user.setFullname(loginmaster.getFullname());
		user.setEmail(loginmaster.getEmail());
		user.setBranch(loginmaster.getBranch());
		user.setDepartment(loginmaster.getDepartment());
		user.setLocation(loginmaster.getLocation());
		user.setDesignation(loginmaster.getDesignation());
		user.setPhone(loginmaster.getPhone());
		user.setCompany(loginmaster.getCompany());
		user.setEngineerCategory(loginmaster.getEngineerCategory());
		user.setGroupName(loginmaster.getGroupName());
		user.setSubDepartment(loginmaster.getSubDepartment());
		user.setRoleType(loginmaster.getRoleType());
		if (user.getRoleType().equals("Admin")) {
			user.setEngineerCategory("NA");
			user.setScope("NA");
			user.setGroupName("NA");
		} else if (user.getRoleType().equals("User")) {
			user.setGroupName("NA");
			user.setEngineerCategory("NA");
			user.setScope("NA");

		}
		Loginmaster save = this.userRepo.save(user);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User Updated Successfully", true));

	}

//
	@Override
	public Loginmaster getUserById(String username) {
		Loginmaster user = this.userRepo.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Name :", username));

		return user;
	}

//
	@Override
	public List<Loginmaster> getAllUsers() {
		List<Loginmaster> listOfUser = this.userRepo.findAll();

		return listOfUser;
	}

	@Override
	public void deleteUser(String userInteger) {
		Loginmaster orElseThrow = this.userRepo.findByUsername(userInteger)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Name ", userInteger));
		this.userRepo.deleteById(orElseThrow.getSrNo());
	}

	@Override
	public ResponseEntity<?> loginUser(String userInteger, String password) {

		Optional<Loginmaster> findByUsernameAndPassword = this.userRepo.findByUsernameAndPassword(userInteger,
				password);
		if (findByUsernameAndPassword.isPresent()) {
//		 		findByUsernameAndPassword.get().
			return new ResponseEntity<>(findByUsernameAndPassword.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponse("User Name or Password dose not exist", false),
					HttpStatus.UNAUTHORIZED);
		}

	}

	@Override
	public ResponseEntity<ResponseModel<JwtResponse>> login(String username, String password) {
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			String token = this.helper.generateToken(userDetails);
			// Cast to LoginModel to access the role information
			Loginmaster loginModel = (Loginmaster) userDetails;
			String roleType = loginModel.getRoleType();
			String userId = loginModel.getUsername();
			JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).jwtToken(token)
					.username(userDetails.getUsername()).roleType(roleType).userId(userId)
					.branch(loginModel.getBranch()).company(loginModel.getCompany())
					.groupName(loginModel.getGroupName()) // Set group name
					.branch(loginModel.getBranch()) // Set branch
					.department(loginModel.getDepartment()) // Set department
					.scope(loginModel.getScope()) // Set scope
					.engineer(loginModel.getEngineerCategory()) // Set engineer
					.build();
			ResponseModel<JwtResponse> successResponse = new ResponseModel<>(HttpStatus.OK.value(), null, jwtResponse);
			return new ResponseEntity<>(successResponse, HttpStatus.OK);

		} catch (BadCredentialsException e) {
			ResponseModel<JwtResponse> errorResponse = new ResponseModel<>(HttpStatus.UNAUTHORIZED.value(),
					"Invalid Username or Password", null);
			return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
		}
	}

}
