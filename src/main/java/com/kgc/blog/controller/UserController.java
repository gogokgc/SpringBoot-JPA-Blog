package com.kgc.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	// 인증이 안된 사용자들이 출입할수있는 경로를 /auth 로만 허용
	// 그냥 주소가 / 이면 index.jsp 허용
	// static 이하에 잇는 /js/**, /css/**, /image/** 허용
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
}
