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

	// ====================================================================================================

	// 로그인 하기
	// - 스프링 프레임워크에서 로그인을 한다는 것은 authenticated가 true인 Authentication 객체를 SecurituContext에 갖고 있는 상태를 말한다.
	//   단, Authentication이 AnonymousAuthenticationToken만 아니면 된다.
	// - 로그인 == Authentication(authenticated = true) only if Authentication != AnonymousAuthenticationToken

	// Authentication(인증)의 기본 구조
	// - 필터들 중에 일부 필터는 인증 정보에 관여한다. 이들 필터가 하는 일은 AuthenticationManager를 통해 Authentication을 인증하고 그 결과를 SecurityContextHolder에 넣어주는 것이다.

	// 인증 토큰(Authentication)을 제공하는 필터들
	// - UsernamePasswordAuthenticationFilter: 폼 로그인
	// - RememberMeAuthenticationFilter: remember-me 쿠키 로그인
	// - AnonymousAuthenticationFilter: 로그인하지 않았다는 것을 인증함
	// - SecurityContextPersistenceFilter: 기존 로그인을 유지함(기본적으로 session을 이용함)
	// - BearerTokenAuthenticationFilter: JWT 로그인
	// - BasicAuthenticationFilter: ajax 로그인
	// - OAuth2LoginAuthenticationFilter: 소셜 로그인
	// - OpenIDAuthenticationFilter: OpenID 로그인
}
