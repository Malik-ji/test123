package com.blogpost.blog.controllers;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpost.blog.entities.Ticket;


@RestController
@RequestMapping("/api/engineer")
public class EngineerActivityController {
	
	
	@GetMapping("/getAllEngineerTicket")
	public List<Ticket> getAllEngineerTicket()
	{
		return null;
	}
}
