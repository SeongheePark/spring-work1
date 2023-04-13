package com.example.demo9.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 1개 이상 등록
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// authInterceptor 동작 시킬 때 모든 페이지를 가로 채면 ㅡ> 무조건 리다이렉트
		// 명시한 요청 설계 주소에서만 동작하도록
		registry.addInterceptor(authInterceptor)
		.addPathPatterns("/mypage/**");
	}
}
