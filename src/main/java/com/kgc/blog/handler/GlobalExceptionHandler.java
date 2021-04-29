package com.kgc.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.kgc.blog.dto.ResponseDto;

@ControllerAdvice // Exception 이 발생하면 이 클래스로 연결된다.
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseDto<String> handleArgumentException(Exception e) {
		
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//		return "<h1>" + e.getMessage() + "</h1>";
		
	}

}
