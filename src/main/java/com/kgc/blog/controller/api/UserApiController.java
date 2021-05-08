package com.kgc.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgc.blog.config.auth.PrincipalDetail;
import com.kgc.blog.dto.ResponseDto;
import com.kgc.blog.model.RoleType;
import com.kgc.blog.model.User;
import com.kgc.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { // @RequestBody 어노테이션이 있어야 JSON 데이터를 받아올수있다. // user 로 받는값 username, password, email 
		
		System.out.println("UserApiController : Calling save method sucessfully");
		// 실제로 DB에 insert를 하고 아래에서 return 이 되면 된다.
		
		user.setRole(RoleType.USER);
		
		userService.joinMembership(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)

	}
	

	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) {
		userService.modifyUserInfo(user);
		// 여기서는 트랜잭션이 종료되기 때문에 DB에 값을 변경, 하지만 세션의 User 값은 아직 변경되지 않음 직접 변경하는 세팅 필요
		
		// 세션등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
				
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