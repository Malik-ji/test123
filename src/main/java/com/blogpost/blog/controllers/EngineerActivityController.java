package com.blogpost.blog.controllers;

import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.entities.Ticket;


@RestController
@RequestMapping("/api/engineer")
public class EngineerActivityController {
	
	@GetMapping("/getAllEngineerTicket")
	public List<Ticket> getAllEngineerTicket( HttpServletRequest httpServletRequest,HttpSession httpSession)
	{
		 String username = httpSession.getAttribute("username").toString();
		 String Company = 	httpSession.getAttribute("Company").toString();
		 String GroupName = httpSession.getAttribute("GroupName").toString();
		 
		return null;
	}
}
