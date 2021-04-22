package com.kgc.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m1 = Member.builder().username("kgc").password("123").email("kgc@gmail.com").build();
		System.out.println(TAG + "getter : " + m1.getId());
		m1.setId(5000);
		System.out.println(TAG + "setter : " + m1.getId());
		
		System.out.println(TAG + "getter : " + m1.getUsername());
		m1.setUsername("kgc2");
		System.out.println(TAG + "setter : " + m1.getUsername());
		return "Lombok test Complete";
		
	}

	// 인터넷 브라우저 요청은 무조건 get 요청밖에 할수없다.
	@GetMapping("/http/get")
	public String getTest(Member m) { //MessageConverter (스프링부트)
		return "get Request " + "id = " + m.getId() + ", username = " + m.getUsername() + ", password = " + m.getPassword() + ", email = " + m.getEmail();
	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //MessageConverter (스프링부트)
		return "post Request " + "id = " + m.getId() + ", username = " + m.getUsername() + ", password = " + m.getPassword() + ", email = " + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put Request " + "id = " + m.getId() + ", username = " + m.getUsername() + ", password = " + m.getPassword() + ", email = " + m.getEmail();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete Request";
	}
	
}
