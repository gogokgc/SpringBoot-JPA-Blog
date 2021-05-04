package com.kgc.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgc.blog.config.auth.PrincipalDetail;
import com.kgc.blog.dto.ResponseDto;
import com.kgc.blog.model.Board;
import com.kgc.blog.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) { 
		
		boardService.write(board, principal.getUser());
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 

	}
	


}






//// 기본적인 로그인 기능 구현방법
//@PostMapping("/api/user/login")
//public ResponseDto<Integer> login(@RequestBody User user,HttpSession session){
//	
//	System.out.println("UserApiController : Calling login method sucessfully");
//	
//	User principal = userService.login(user); // principal(접근주체)
//	
//	if(principal != null) {
//		session.setAttribute("principal", principal);
//	}
//	
//	return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//}