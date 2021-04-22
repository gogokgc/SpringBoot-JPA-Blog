package com.kgc.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 Mysql에 테이블이 생성된다 
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 오라클-시퀸스 MySql - auto_increment
	
	@Column(nullable = false,length = 30) // nullable = false : not null
	private String username; //아이디
	
	@Column(nullable = false,length = 100) // 123456 => 해쉬 (비밀번호 암호화)
	private String password;
	
	@Column(nullable = false,length = 30)
	private String email;
	
	@ColumnDefault("'user'") // 문자라는걸 알려주기 위해 홑따옴표가 들어가야 한다
	private String role; // Enum 을 사용하는게 좋다 // admin, user, manager...
	
	// 내가 직접 시간을 넣으려면 Timestamp.valueOf(LocalDateTime.now())
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;

}