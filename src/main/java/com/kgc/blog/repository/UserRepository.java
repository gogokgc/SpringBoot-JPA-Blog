package com.kgc.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgc.blog.model.User;

//DAO  //JpaRepository 안에 select, save, delete 등의 필요함수가 내장되어있다.
//자동으로 bean등록이 된다. -> //@Repository // 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{  // JpaRepository - User 테이블 관리 , User 테이블의 PK 는 int 이다.

}
