package com.example.demo10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo10.dto.User;

@Controller
public class UserController {
	@GetMapping("/loginPage")
	public String loginPage() {
		return "login.html"; // 내부에서 이동
	}
	
	@PostMapping("/login-proc")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, User user) {
		//세션 저장 후 myInfo 페이지 이동
		HttpSession session = request.getSession();
		session.setAttribute("principal", session);
		return "redirect:/auth/infoPage";
	} 
	
	// 인증된 사람만 들어오게 막기
	@GetMapping("/auth/infoPage")
	public String infoPage(HttpServletRequest request) {
		//테스트
		
		
//		HttpSession session = request.getSession();
//		Object principal = session.getAttribute("principal");
//		if(principal == null) {
//			return "redirect:/loginPage";
//		}
		System.out.println("여기 코드 실행하려면 로그인 되야함");
		// 위치에서 상대 경로로 찾을지, 절대 경로로 찾을지 결정
		return "/info.html";
		// return "redirect:/auth/info";
	}
}
