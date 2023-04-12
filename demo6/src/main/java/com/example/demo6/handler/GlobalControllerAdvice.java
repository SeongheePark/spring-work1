package com.example.demo6.handler;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo6.dto.CustomError;

@RestControllerAdvice // IoC의 대상이 된다
// @ControllerAdvice 페이지 리턴 오류시 작동
public class GlobalControllerAdvice {
	// 모든 예외를 여기서 처리하고 싶다
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println("=================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	// 특정 예외를 잡아서 다르게 응답처리 하고싶다
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		// 디버깅
		// 어떤 필드가 잘못되었는지, 에러메세지 띄우기

		ArrayList<CustomError> errorList = new ArrayList<>();
		e.getAllErrors().forEach(error -> {
			String field = error.getCode();
			String message = error.getDefaultMessage();
			CustomError customError = new CustomError();
			customError.setField(field);
			customError.setMessage(message);

			errorList.add(customError);
		});
		System.out.println("잘못된 값입니다 ~!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {
		System.out.println("JSON 형식이 아니에요..!!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(value = BindException.class)
	public ResponseEntity<?> bindException1(BindException e) {
		System.out.println("GET방식 으로 값을 던질 때 잘못 보냈어요!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
