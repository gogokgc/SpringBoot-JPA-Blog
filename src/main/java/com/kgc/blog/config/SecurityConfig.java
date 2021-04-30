package com.kgc.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

@Configuration // 빈등록 (IoC 관리)
@EnableWebSecurity // (시큐리티 필터 추가) = 시큐리티가 모든 리퀘스트 요청을 가로챈다 (필터링을 위해)
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests() // 허가 요청
				.antMatchers("/auth/**") // "/auth/ 이후에오는 페이지는
				.permitAll() // 전부 허용
				.anyRequest() // 그 외의 페이지는
				.authenticated() // 인증필요
			.and()
				.formLogin() // 인증을 위한 로그인
				.loginPage("/auth/loginForm"); // 로그인 페이지 설정
	}
}
