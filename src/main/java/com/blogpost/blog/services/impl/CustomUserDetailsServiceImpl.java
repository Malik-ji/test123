package com.blogpost.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogpost.blog.entities.Loginmaster;
import com.blogpost.blog.repositories.UserRepo;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo loginRepository;
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	Loginmaster findByUsername = loginRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("user not found"));
		return findByUsername;
	}

}
