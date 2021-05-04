package com.kgc.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kgc.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; 

	// 컨트롤러에서 어떻게 세션을 찾는가? @AuthenticationPrincipal PrincipalDetail principal 세션에 접근하여 데이터를 얻어올수있다
	@GetMapping({"", "/"})
	public String index(Model model) { 
		model.addAttribute("boards", boardService.list());
		return "index"; //ViewResolver 작동 - model 의 정보도 같이 가지고간다.
	}
	
	//USER 권한필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
}
