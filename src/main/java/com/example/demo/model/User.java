package com.example.demo.model;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
@Entity
public class User implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String role;
	public User() {}
	
	public User(String username, String password, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.role = roles;
	}


	public User(Long id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		// Chuyển đổi chuỗi Role thành GrantedAuthority
        return List.of(new SimpleGrantedAuthority("ROLE_" + role)); 
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return role;
	}
	public void setRoles(String role) {
		this.role = role;
	}
	
}
