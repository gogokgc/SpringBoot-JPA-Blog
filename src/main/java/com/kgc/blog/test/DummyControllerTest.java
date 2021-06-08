package com.kgc.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgc.blog.model.RoleType;
import com.kgc.blog.model.BlogUser;
import com.kgc.blog.repository.UserRepository;

//html파일이 아니라 data를 리턴해주는 controller = RestController
@RestController
public class DummyControllerTest {

	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;

	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "delete Failed the ID was not exist in DB";
		}

		return "delete complete id : " + id;
	}

	// save함수는 id를 전달하지 않으면 insert를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해요.
	// email, password
	@Transactional // 함수 종료시에 자동 commit 이 됨.
	@PutMapping("/dummy/user/{id}")
	public BlogUser updateUser(@PathVariable int id, @RequestBody BlogUser requestUser) { // @RequestBody는 클라이언트가 전송하는
																					// Json(application/json) 형태의 HTTP
																					// Body 내용을 Java Object로 변환시켜주는
																					// 역할(message Converter 의 jackson
																					// 라이브러리)을 한다.
		System.out.println("id : " + id);
		System.out.println("password : " + requestUser.getPassword());
		System.out.println("email : " + requestUser.getEmail());

		BlogUser user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Update Failed");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());

//		requestUser.setId(id);
//		userRepository.save(user);
		// 더티체킹 // @Transactional 이 종료될때 데이터의 변경을 감지하여 DB에 수정을 해준다.
		return user;
	}

	@GetMapping("/dummy/users")
	public List<BlogUser> list() {

		return userRepository.findAll();
	}

	// 한페이지당 2건에 데이터를 리턴받아 볼 예정
	@GetMapping("/dummy/user")
	public List<BlogUser> pageList(
			@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<BlogUser> pagingUser = userRepository.findAll(pageable);

		List<BlogUser> users = pagingUser.getContent(); // findAll 에서 같이 가져오는 데이터중 content 데이터만 수집한다.
		return users;
	}

	@GetMapping("/dummy/user/{id}") // {id} 주소로 파라미터를 전달 받을수 있습니다. // http://locahost:8000/blog/dummy/user/3
	public BlogUser detail(@PathVariable int id) { // id 파라미터를 받기위한 @PathVariable 어노테이션

		// user/4을 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될 것 아냐?
		// 그럼 return null 이 리턴이 되자나.. 그럼 프로그램에 문제가 있지 않겠니?
		// Optional로 너의 User객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해!!

		BlogUser user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {

				return new IllegalArgumentException("Failed to find User : " + id);

			}
		});
//	     // 람다식
//			User user = userRepository.findById(id).orElseThrow(()->{
//				return new IllegalArgumentException("해당 사용자는 없습니다.");
//			});

		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변환 ( 웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
		// 스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
		return user;
	}

	// http://localhost:8000/blog/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(BlogUser user) { // key=value (약속된 규칙)
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());

		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "Membership join complete";
	}
}
