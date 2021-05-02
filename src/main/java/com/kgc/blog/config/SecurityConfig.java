package com.kgc.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kgc.blog.config.auth.PrincipalDetailService;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

@Configuration // 빈등록 (IoC 관리)
@EnableWebSecurity // (시큐리티 필터 추가) = 시큐리티가 모든 리퀘스트 요청을 가로챈다 (필터링을 위해)
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		
		return new BCryptPasswordEncoder();
	}

	// 시큐리티가 대신 로그인 해줄때 password 를 가로채는데 해당 password 가 뭘로 해쉬가 되어 회원가입이 되엇는지 알아야 같은 해쉬로 암호화 해서 DB에 있는 해쉬랑 비교할수있음
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // csrf 토큰 비활성화 (테스트시 걸어주는게 좋음)
			.authorizeRequests() // 허가 요청
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**") // "/auth/ 이후에오는 페이지는
				.permitAll() // 전부 허용
				.anyRequest() // 그 외의 페이지는
				.authenticated() // 인증필요
			.and()
				.formLogin() // 인증을 위한 로그인
				.loginPage("/auth/loginForm") // 로그인 페이지 설정
				.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당주소로 요청이 오는 로그인을 가로채서 대신 로그인
				.defaultSuccessUrl("/"); // 로그인이 완료되면 이동할 디폴트 웹페이지 설정
		
	}
}
