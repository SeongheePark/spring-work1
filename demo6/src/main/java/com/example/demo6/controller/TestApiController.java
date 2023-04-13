package com.example.demo6.controller;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.dto.User;
@RestController
@RequestMapping("/apiTest")
@Validated
public class TestApiController {
	
	@GetMapping("/user")
	public User get(@RequestParam String name, @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}
	
	@PostMapping("/user")
	public User post(@Valid @RequestBody User user ) {
		System.out.println(user.toString());
		return user;
	}
	
	@GetMapping("/user2")
	public User get2(@Validated User reqUser) {
		return reqUser;
	}
	
	
}
