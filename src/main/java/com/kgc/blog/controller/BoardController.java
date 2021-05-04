package com.kgc.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kgc.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	

	// 컨트롤러에서 어떻게 세션을 찾는가? @AuthenticationPrincipal PrincipalDetail principal 세션에 접근하여 데이터를 얻어올수있다
	@GetMapping({"", "/"})
	public String index() { 
		
		return "index";
	}
	
	//USER 권한필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
}
