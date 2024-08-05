package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "Hello, World!";
    }

    @RequestMapping("/auth")
    public Authentication auth() {
        // SecurityContextHolder.getContext().getAuthentication()은 Spring Security에서 사용자 인증 정보를 가져오는 방법이다.
        // 이 코드는 현재 실행 중인 애플리케이션에서 인증된 사용자의 정보를 얻기 위해 사용된다.

        // SecurityContextHolder: 이 클래스는 Spring Security의 보안 컨텍스트를 보관하는데 사용된다. 보안컨텍스트는 현재 스레드에 대한 보안 관련 정보를 저장한다.
        // getContext(): SecurityContextHolder에서 보안 컨텍스르를 반환하는데 이 컨텍스트는 현재 스레드에 대한 보안 정보(인증 정보 등)를 포함한다.
        // getAuthentication(): 보안 컨텍스트에서 Authentication 객체를 반환한다. 이 객체는 현재 사용자의 인증 상태와 인증된 사용자에 대한 정보를 담고 있다.
        // Authentication 객체에는 사용자의 권한(roles), 사용자 이름, 인증 방법 등이 포함된다.
        return SecurityContextHolder.getContext().getAuthentication();
    }

    // 개인정보에 대한 리소스 시뮬레이션
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping("/admin")
    public SecurityMessage admin() {
        return SecurityMessage.builder().auth(SecurityContextHolder.getContext().getAuthentication()).message("USER 정보").build();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @RequestMapping("/user")
    public SecurityMessage user() {
        return SecurityMessage.builder().auth(SecurityContextHolder.getContext().getAuthentication()).message("관리자 정보").build();
    }

}
