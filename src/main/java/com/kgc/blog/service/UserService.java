package com.kgc.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgc.blog.model.User;
import com.kgc.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int joinMembership(User user) {
		try {
		userRepository.save(user);
		return 1;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserService : joinMembership : " + e.getMessage());
			return -1;
		}
	}
	
}
