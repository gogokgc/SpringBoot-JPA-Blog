package com.kgc.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgc.blog.model.Board;


public interface BoardRepository extends JpaRepository<Board, Integer>{

	
}