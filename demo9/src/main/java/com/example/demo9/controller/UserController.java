package com.example.demo9.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo9.dto.User;

@Controller
public class UserController {
	// 로그인 페이지 직접 URL 요청해서 응답 받을 수 있다
	// 로그인 페이지를 controller를 통해 응답 처리 해보자
	
	@GetMapping("/login-page")
	public String login() {
		return "login.html";
	}
	
	// MIME TYPE : form
	// @RequestBody 쓰면 JSON으로 들어옴
	@PostMapping("/login-proc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, User user) {
		// 로직 : 세션 저장 후 myInfo 페이지 이동 처리
		HttpSession session = request.getSession();
		System.out.println(user);
		session.setAttribute("user", user);
		//response.sendRedirect("/mypage/myinfo");
		return "redirect:/mypage/myinfo.html";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "redirect:/mypage/cart.html";
	}
	
	// http://localhost:8080/mypage/myinfo
	@GetMapping("/mypage/myinfo")
	public String myInfo() {
		// 인증이 필요한 페이지로 만들기
		return "mypage/myinfo.html";
	}
}
