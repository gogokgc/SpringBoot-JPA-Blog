package com.kgc.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgc.blog.model.Board;
import com.kgc.blog.model.BlogUser;
import com.kgc.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void write(Board board, BlogUser user) { // title, content
		
		board.setCount(0);
		
		board.setUser(user);
		
		boardRepository.save(board);
	}

	@Transactional(readOnly = true)
	public Page<Board> list(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board detail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("Cannot find Post id");
				});
	}
	
	@Transactional
	public void delete(int id) {
		boardRepository.deleteById(id);
				
	}

	@Transactional
	public void edit(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("Cannot find Post");
				}); //영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시(Service 가 종료 될때) 트랜쟉션이 종료, 이때 더티체킹 - 자동 업데이트 DB flush
		
	}
}
