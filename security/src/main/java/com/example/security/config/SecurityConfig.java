package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    // - Spring Security는 기본적으로 모든 페이지를 막고 시작한다.
    // - Spring Security는 DelegatingFilterProxy라는 필터를 만들어서 메인 필터체인에 끼워넣고, 그 아래에 다시 SecurityFilterChain 그룹을 등록한다.
    // - 이 필터체인은 반드시 한 개 이상이고, url 패턴에 따라 적용되는 필터체인을 다르게 할 수 있다. 본래의 메인 필터를 반드시 통과해야만 서블릿에 들어갈 수 있는
    // 단점을 보완하기 위해서 필터체인 proxy를 두었다고 할 수 있다.
    // - web resource의 경우 패턴을 따르더라도 필터를 무시하고 통과시켜주기도 한다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()

                ).formLogin(Customizer.withDefaults());
        return http.build();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser(User.builder()
//                        .username("user2")
//                        .password(passwordEncoder().encode("2222"))
//                        .roles("USER"))
//                .withUser(User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("3333"))
//                        .roles("ADMIN"));
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 두 개의 사용자 설정
        UserDetails user2 = User.builder()
                .username("user2")
                .password(passwordEncoder().encode("2222"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("3333"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user2, admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}