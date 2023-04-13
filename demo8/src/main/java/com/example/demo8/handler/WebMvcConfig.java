package com.example.demo8.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 1. WebMvcConfigurer 구현 처리하기
 * 2. addInterceptors 구현하기
 * */

@Configuration //1개 이상 bean으로 등록해야할 때 (WebMvcConfig, LoggingInterceptor)
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 우리가 직접 만든 인터셉터 구현클래스를 등록 처리
		registry.addInterceptor(new LoggingInterceptor());
	}
	
	// DI 사용하는 코드로 변경
	@Autowired // 자동 DI 적용
	private LoggingInterceptor loggingInterceptor;
	
//	public WebMvcConfig(LoggingInterceptor loggingInterceptor) {
//		this.loggingInterceptor = loggingInterceptor;
//	}
}
