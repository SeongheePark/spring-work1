package com.example.demo8.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 인터셉터 만들기
 * 1. HandlerInterceptor 인터페이스 구현처리
 * 2. 3가지 메서드 기억
 * */

// 어노테이션 사용안함 ! ㅡ> 사용 안하니까 @AutoWeird 쓸 때 오류가 남... 올라간 객체가 없어서!
@Component
public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("--------------");
		System.out.println("Request URI: " + request.getRequestURI());
		System.out.println("Request Method: " + request.getMethod());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
