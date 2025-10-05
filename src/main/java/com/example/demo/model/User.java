package com.example.demo.model;
import jakarta.persistence.*;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	public User() {}
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
