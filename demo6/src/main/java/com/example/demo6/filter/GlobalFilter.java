package com.example.demo6.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// 인터페이스 구현
@Slf4j
@Component // IoC대상 - 싱글톤
public class GlobalFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1단계
//		log.error(">> 요청(request)에 대한 앞단 처리 <<");
//		chain.doFilter(request, response);
//		log.error("<< 응답(response)에 대한 마지막 처리 >>");

		// 2단계 로깅처리 : 요청 URI 콘솔창에 먼저 확인
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httptResponse = (HttpServletResponse) response;

		log.error("요청 URI : {}", httpRequest.getRequestURI());
		chain.doFilter(httpRequest, httptResponse);
		log.error("응답 상태 : {}", httptResponse.getStatus());

	}

}
