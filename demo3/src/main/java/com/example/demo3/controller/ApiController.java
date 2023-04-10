package com.example.demo3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	// http://localhost:80/api/hello
	// http://localhost/api/hello (80 포트번호 생략 가능)
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	// MIME TYPE : text/plain 으로 응답 처리 해주세요
	// http://localhost/api/text
	// 응답 결과 ㅡ> 응답 : text/plain
	@GetMapping("/text")
	public String text() {
		return "text/plain";
	}

	// response를 json 형식으로 내려주기
	@PostMapping("/json")
	// /api/json
	public User json(@RequestBody User user) {
		System.out.println(user.toString());
		// 응답 Object type
		return user;
	}

	// /api/put
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user) {
		System.out.println(user.toString());
		// HTTP 메세지 코드를 200으로 직접 세팅
		// HTTP 메세지 body에 데이터를 ㅡ> user object
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	/*
	 * 백엔드 개발자 위치 클라이언트 (모바일) ㅡ> 요청 (HTTP 통신) 데이터로 반환 처리 (JSON 형식) 매번 새로운 요청마다 다른
	 * 형식으로 return 해주면 api를 계속 개발해야함.. 일괄적인 형식을 만들어서 던져주면 api 개발자가 편해짐
	 * 
	 * 자바스크립트 ajax 통신 처리
	 */

	@PutMapping("/put2")
	public ResponseEntity<String> put2(@RequestBody User user) {
		// 정상적인 값이 들어왔는지 확인, 인증된 사용자인지 확인
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		// 201 생성, 수정
		return new ResponseEntity<>(user.toString(), headers, HttpStatus.CREATED);
	}

	// ResponseEntity 활용해서 응답 내려보기
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user) {
		System.out.println(user.toString());
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
