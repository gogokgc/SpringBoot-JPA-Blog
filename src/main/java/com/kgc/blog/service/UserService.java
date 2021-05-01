package com.kgc.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgc.blog.model.RoleType;
import com.kgc.blog.model.User;
import com.kgc.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void joinMembership(User user) {
		String rawPassword = user.getPassword(); // 원 패스워드
		String encPassword = encoder.encode(rawPassword); // 해쉬 암호화 작업
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}

//	@Transactional(readOnly = true) //select 할때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성)
//	public User login(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}

}
