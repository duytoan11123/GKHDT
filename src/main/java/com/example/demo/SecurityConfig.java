package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
    public PasswordEncoder passwordEncoder() {
        // Sử dụng BCrypt để mã hóa mật khẩu
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Phân quyền (Authorization)
            .authorizeHttpRequests(authorize -> authorize     // Cho phép truy cập /public không cần đăng nhập
                .requestMatchers("/api/categories/admin").hasRole("ADMIN")     // Chỉ ADMIN mới được truy cập /admin
                .anyRequest().permitAll()                  // Mọi request khác đều phải được xác thực (đăng nhập)
            )
            // 2. Xác thực (Authentication)
            .formLogin(form -> form
            	    .usernameParameter("username")       // Thay đổi tên tham số username
            	    .passwordParameter("matkhau")     // Thay đổi tên tham số password
            	    .loginPage("/loginPage")
            	    .permitAll()
            	)// Kích hoạt Form Login mặc định của Spring Security
            .httpBasic(basic -> basic.init(http)) // Cho phép cả HTTP Basic Auth
            .csrf(csrf -> csrf.disable()); // Tắt CSRF (Thường làm khi dev API)

        return http.build();
    }
}	
