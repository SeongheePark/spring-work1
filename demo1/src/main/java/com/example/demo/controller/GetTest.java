package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

@RestController
@RequestMapping("/api")
public class GetTest {

	// http://localhost:8080/api/hello
	@GetMapping("/hello2")
	public String getHello() {
		return "say hello";
	}

	@GetMapping("/queryParams")
	public String queryParam(@RequestParam String name) {
		System.out.println(name);
		return name;
	}
	
	// http://localhost:8080/api/queryParam33?name=성희&age=29&groupId=com.seonghee
	@GetMapping("/queryParam33")
	public String queryParam33(@RequestParam Map<String, String> data) {
		StringBuilder sbuil = new StringBuilder();

		// entrySet: map의 key,value값 꺼내기
		// foreach : 반복
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sbuil.append(entry.getKey() + "=" + entry.getValue());
		});
		System.out.println("data: " + data.toString());
		return "파싱 map 방식의 이해: " + sbuil.toString();
	}
	
	@GetMapping("/queryParam44")
	// http://localhost:8080/api/queryParam44?name=홍길동&age=10&email=bb@gmail.com
	public String queryParam44(UserRequest userDto) {
		System.out.println("dto 방식 동작 처리");
		System.out.println(userDto.getName());
		System.out.println(userDto.getAge());
		System.out.println(userDto.getEmail());
		
		return userDto.toString();
	}
	
	// pathVariable 방식
	// http://localhost:8080/api/path-variable/홍길동
	@GetMapping("/path-variable1/{userName}")
	public String pathVariable1(@PathVariable String userName) {
		System.out.println(userName);
		return userName;
	}
	
	@GetMapping("/path-variable/{name}")
	public String pathVariable2(@PathVariable(name="name") String name3) {
		String name = "나!";
		return name3;
	}

}
