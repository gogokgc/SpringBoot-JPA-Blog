package com.kgc.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@RequiredArgsConstructor
@Data // Lombok 이용 @Getter 와 @Setter 를 동시에
//@AllArgsConstructor // Lombok 이용 전 파라미터가 있는 생성자 작성
@NoArgsConstructor // 기본 생성자
@Builder
public class Member {

	private int id;
	private String username;
	private String password;
	private String email;
	
//	@Builder // lombok 이용 객체생성시 파라미터 선택 가능한 생성자 생성가능
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}
