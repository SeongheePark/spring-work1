package com.example.demo5.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.TestUser;

@RestController
@RequestMapping("/api2")
public class TestApiController {

	@PostMapping("/user")
	public ResponseEntity<TestUser> user(@Valid @RequestBody TestUser testUser) {
		return ResponseEntity.ok(testUser);
	}

	@PostMapping("/user1")
	public ResponseEntity<?> user1(@Valid @RequestBody TestUser testUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("에러발생");
		}
		return ResponseEntity.ok(testUser);
	}

	@PostMapping("/user2")
	public ResponseEntity<?> user2(@Valid @RequestBody TestUser testUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				sb.append("field: " + error.getCode());
				sb.append("message: " + error.getDefaultMessage());
				sb.append("argument: " + error.getArguments());
				sb.append("object: " + error.getObjectName());
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		return ResponseEntity.ok(testUser);
	}
}
