package com.kgc.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgc.blog.dto.ResponseDto;
import com.kgc.blog.model.RoleType;
import com.kgc.blog.model.User;
import com.kgc.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	


	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) { // user 로 받는값 username, password, email
		
		System.out.println("UserApiController : Calling save method sucessfully");
		// 실제로 DB에 insert를 하고 아래에서 return 이 되면 된다.
		user.setRole(RoleType.USER);
		
		userService.joinMembership(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)

	}
	
//	// 기본적인 로그인 기능 구현방법
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user,HttpSession session){
//		
//		System.out.println("UserApiController : Calling login method sucessfully");
//		
//		User principal = userService.login(user); // principal(접근주체)
//		
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}

}
