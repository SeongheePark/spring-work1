package com.example.greensBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

	@GetMapping({ "/", "main" })
	public String mainPage() {
		return "mainPage";
	}
}
