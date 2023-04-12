package com.example.demo7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 페이지 리턴할거라서
public class UserController {
	
	//http://localhost:8080/user
	@GetMapping({"/", "user"})
	public String userPage() {
		// yml 파일 설정
		// prefix : /WEB-INF/view
		// subfix : .jsp
		
		// viewResolver가 동작해서 페이지를 리턴
		return "user";
	}
}
