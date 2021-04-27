package com.kgc.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgc.blog.dto.ResponseDto;
import com.kgc.blog.model.User;

@RestController
public class UserApiController {

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email
		System.out.println("UserApiController : Calling save method sucessfully");
		// 실제로 DB에 insert를 하고 아래에서 return 이 되면 된다.
		return new ResponseDto<Integer>(HttpStatus.OK, 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)

	}

}
