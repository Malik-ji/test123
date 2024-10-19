package com.blogpost.blog.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.blogpost.blog.entities.ResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.velox.edr.model.ResponseModel;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	private final ObjectMapper objectMapper = new ObjectMapper();
  
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		ResponseModel<Object> responseModel = new ResponseModel<>(HttpServletResponse.SC_UNAUTHORIZED,
				"Access Denied !! " + authException.getMessage(), null);

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		response.getWriter().write(objectMapper.writeValueAsString(responseModel));
		
	}
}