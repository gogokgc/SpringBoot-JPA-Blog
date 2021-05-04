package com.kgc.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgc.blog.model.Board;
import com.kgc.blog.model.User;
import com.kgc.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void write(Board board, User user) { // title, content
		
		board.setCount(0);
		
		board.setUser(user);
		
		boardRepository.save(board);
	}

}
