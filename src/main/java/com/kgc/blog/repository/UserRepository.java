package com.kgc.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgc.blog.model.User;

//DAO  //JpaRepository 안에 select, save, delete 등의 필요함수가 내장되어있다.
//자동으로 bean등록이 된다. -> //@Repository // 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{  // JpaRepository - User 테이블 관리 , User 테이블의 PK 는 int 이다.

	// SELECT * FROM user WHERE username = ?1;
		Optional<User> findByUsername(String username);
}




//JPA Naming 쿼리
	// SELECT * FROM user WHERE username = ?1 AND password = ?2;
//	User findByUsernameAndPassword(String username, String password);
	
	//위의방식 과 아래방식 으로 사용할수있다(같은결과가 나온다. sql 을 어떤식으로 전달할것인가의 방법차이)
//	@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//	User login(String username, String password);