package com.example.demo5.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@Validated // GET방식에는 반드시 선언해주어야 유효성 검사를 시작한다
public class UserController {

	// GET 방식일 때 파라미터 앞에 어떤 유효성 검사를 할 지 당연히 지정해주어야 한다

	// http://localhost:8080/user?name=성희&age=10
	// GET 방식일 때 Valid 처리
	@GetMapping("/user")

	public User user(@Size(min = 2) @RequestParam String name, @NotNull @Min(1) @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}

	// GET 유효성 검사 직접 만들어보기
	@GetMapping("/user1")
	public User user1(@NotNull @RequestParam String name, @Email @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		return user;
	}

	@GetMapping("/user2")
	// object mapper 통해서 파싱처리 하고싶다면  
	public User user2(@Validated User user) {
		return user;
	}
}
