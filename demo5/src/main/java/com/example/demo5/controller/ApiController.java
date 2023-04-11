package com.example.demo5.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// http://localhost:8080/api/user
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user) {
		// springboot request 시, 기본 데이터 파싱 전략 : key=value 구조
		// dto 방식을 사용 : 알아서 mapping 해줌 (object mapper 동작해서 자동 파싱 처리)
		// 유효성 검사 - 예전 방식
		if (user.getAge() < 1 || user.getAge() > 100) {
			// 잘못된 입력값을 확인
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		// 서비스 만들어서 ㅡㅡ> DAO로 보냄 ㅡㅡ> DB Insert 처리
		// DB 갔다가 다시 사용자에게 돌아와 응답처리 해줘야함
		System.out.println(user);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/user1")
	public ResponseEntity<User> post(@RequestBody User user) {
		if (user.getName() == null || user.getEmail() == null || user.getPhoneNumber() == null
				|| user.getAge() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		System.out.println(user);
		return ResponseEntity.ok(user);
	}

	// builder 패턴으로 User 객체 만들어보기
	User user2 = User.builder().name("홍길동").age(20).build(); // 마지막에 build() 반드시 호출

	// 두번째
	// AOP 기반인 Validation 라이브러리 활용하기
	// 1. GET 방식일 때 사용방법과 POST 방식일 때 사용방법이 약간 다르다 (HTTP 바디가 있냐없냐)
	// 반드시 Valid 선언을 해주어야한다.
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user) {
		// 관점 지향 패러다임 추가
		// AOP 기반 valid 라이브러리를 활용하면 공통적으로 들어가야하는 부분에 코드를 분리시킬 수 있다
		return ResponseEntity.ok(user);
	}

	// 직접 예외클래스 컨트롤 1단계
	// 와일드카드 ? 어떤 타입으로 return할지 모를때.. ? 사용가능
	// 상황에 따라 다른 결과값을 도출해야할 때 와일드카드 사용 !
	@PostMapping("/user3")
	public ResponseEntity<?> user3(@Valid @RequestBody User user, BindingResult bindingResult) {
		// bindingResult 클래스를 배워보자
		// bindingResult가 @Valid에 대한 결과 값을 가지고있다.
		if (bindingResult.hasErrors()) {
			// 에러 발생
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("에러발생");
		}

		// 정상 처리
		return ResponseEntity.ok(user);
	}

	// 직접 예외클래스 컨트롤 2단계
	@PostMapping("/user33")
	public ResponseEntity<?> user33(@Valid @RequestBody User user, BindingResult bindingResult) {
		// bindingResult 클래스를 배워보자
		// bindingResult가 @Valid에 대한 결과 값을 가지고있다.
		if (bindingResult.hasErrors()) {
			// 에러 발생
			// 어떤 필드에서 에러 발생했는지 ? , 메세지를 만들어 내용 반환 처리

			StringBuilder sb = new StringBuilder();

			bindingResult.getAllErrors().forEach(error -> {
				System.out.println(error.getCode());
				System.out.println(error.getDefaultMessage());
				System.out.println(error.getArguments().length);
				System.out.println(error.getArguments()[0]);
				System.out.println(error.getArguments()[1]);
				System.out.println(error.getObjectName());

				sb.append("field: " + error.getCode());
				sb.append("\n");
				sb.append("message: " + error.getDefaultMessage());
				sb.append("\n");
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}

		// 정상 처리
		return ResponseEntity.ok(user);
	}
}
