package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetTest {
	
	// http://localhost:8080/api/hello
	@GetMapping("/hello")
	public String getHello() {
		return "say hello";
	}
	
}
