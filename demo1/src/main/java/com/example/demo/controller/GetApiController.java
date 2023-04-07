package com.example.demo.controller;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

//@Controller <-- 화면 응답(HTML,JSP)
@RestController // 요청과 응답을 할 수 있는 객체로 변환 (JSON방식)
@RequestMapping("/api")
public class GetApiController {
	// 주소 설계 - GET 방식
	// http://localhost:8080/api/hello
	@GetMapping("/hello")
	public String getHello() {
		return "say hello";
	}

	// 쿼리 파람 방식으로 데이터를 파싱해서 처리하자
	// http://localhost:8080/api/queryParam1?name=성희
	@GetMapping("/queryParam1")
	public String queryParam(@RequestParam String name) {
		System.out.println("name: " + name);
		return "name : " + name;
	}

	// http://localhost:8080/api/queryParam2?name=성희&age=10
	// http://localhost:8080/api/queryParam2?name=성희
	@GetMapping("/queryParam2")
	public String queryParam2(@RequestParam String name, @RequestParam(required = false, defaultValue = "0") int age) {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		return "name, age : " + name + age;
	}

	// http://localhost:8080/api/queryParam3?name=성희&age=10&groupId=com.tenco
	@GetMapping("/queryParam3")
	public String queryParam3(@RequestParam Map<String, String> data) {
		StringBuilder sb = new StringBuilder();

		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		System.out.println("data: " + data.toString());
		return "파싱 map 방식의 이해: " + sb.toString();
	}

	// Map 활용 (직접 만들어 보기)
	@GetMapping("/queryParam")
	// http://localhost:8080/api/queryParam?메뉴=아메리카노&가격=5000&지점=서면&사이즈=벤티
	public String queryParam(@RequestParam Map<String, String> data) {
		StringBuilder sb = new StringBuilder();

		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		});

		return data + "";
	}

	// 주소 : GET방식
	// http://localhost:8080/api/queryParam4?name=성희&age=10&email=a@naver.com
	@GetMapping("/queryParam4")
	// MessageConverter 동작해서 자동으로 파싱 처리
	// @RequestParam 붙이지 말아야 한다.
	// Dto 속성값이 없으면 파싱을 하지 않는다.
	public String queryParam4(UserRequest userDto) {
		System.out.println("Dto 방식 동작 처리");
		System.out.println(userDto.getName());
		System.out.println(userDto.getAge());
		System.out.println(userDto.getEmail());
		return userDto.toString();
	}

	// pathVariable 방식
	// http://localhost:8080/api/path-variable/10
	@GetMapping("/path-variable/{userId}")
	public String pathVariable(@PathVariable int userId) {
		System.out.println("userId: " + userId);
		return "userId: " + userId;
	}

	// 변수명을 똑같이 사용하지 못할 때 옵션값 지정해보기
	@GetMapping("/path-variable2/{name}")
	public String pathVariable2(@PathVariable(name = "name") String mName) {
		String name = "내부에서 name 변수명이 있지요";
		return "name " + mName;
	}

	// GET 방식
	// http://localhost:8080/api/users/3/orders/10
	@GetMapping("/users/{userId}/orders/{orderId}")
	public String getOrder(@PathVariable int userId, @PathVariable int orderId) {

		return "userId:" + userId + ", orderId: " + orderId;
	}
	
	// http://localhost:8080/api/name/성희
	@GetMapping("/name/{userName}")
	public UserRequest getUser(UserRequest dto) {
		UserRequest userRequest = new UserRequest();
		userRequest.setName(dto.getName());
		return userRequest;
	}
}
