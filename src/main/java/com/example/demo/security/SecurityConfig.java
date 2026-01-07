package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(
	                "/",
	                "/login.html",
	                "/register.html",
	                "/dashboard.html",
	                "/css/**",
	                "/js/**",
	                "/api/login",
	                "/api/register"
	            ).permitAll()
	            .anyRequest().permitAll()   // ✅ TEMPORARY
	        );

	    return http.build();
	}

}
