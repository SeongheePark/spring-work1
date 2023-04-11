package com.example.demo5.dto;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestUser {
	private String name;
	private Integer age;
	@Email(message = "이메일 형식...틀렸다...!")
	private String email;
	private String phoneNumber;
}
