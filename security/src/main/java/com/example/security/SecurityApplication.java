package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	// 인증(Authentication)
	// 사이트에 접근하는 사람이 누구인지 시스템이 알아야 한다. 익명사용자(Anonymous user)를 허용하는 경우도 있지만,
	// 특정 리소스에 접근하거나 개인화된 사용성을 보장 받기 위해서는 반드시 로그인하는 과정이 필요하다.
	// 로그인은 보통 username / password를 입력하고 로그인하는 경우와 sns 사이트를 통해 인증을 대리하는 경우가 있다.
	// - username, password 인증 --> session 관리, token 관리(sessionless)
	// - SNS 로그인(소셜 로그인): 인증 위임

	// 권한(Authorization)
	// 사용자가 누구인지 알았다면 사이트 관리자 혹은 시스템은 로그인한 사용자가 어떤 일을 할 수 있는지 권한을 설정한다.
	// 권한은 특정 페이지에 접근하거나 특정 리소스에 접근할 수 있는 권한여부를 판단하는데 사용된다. 개발자는 권한이 있는 사용자에게만 페이지나 리소스 접근을 허용하도록 코딩해야 하는데
	// 이런 코드를 쉽게 작성할 수 있도록 프레임워크를 제공하는 것이 스프링 시큐리티 프레임워크(Spring Security Framework)이다.

	// 메모리 사용자 인증
	// 간단히 특정된 소스를 위한 서비스나 테스트를 위해 사용하는 용도로 사용한다. 스프링 시큐리티를 테스트 하기 위한 용도로 사용한다.
	// - 기본 사용자 로그인
	// - application.yaml에 설정하고 로그인하기
	// - UserDetailService를 이용하기
	// - WebSecurityConfigurerAdpapter를 사용하기 --> Spring Security 5.7부터는 사용버이 달라져 공식문서를 확인해보아야함.
}
