package com.m_code.Fawry.Auth.payload.response;

import java.util.List;

public class UserInfoResponse {
	private Long id;
	private String username;
	private String email;

	private double balance;

	private List<String> roles;

	public UserInfoResponse(Long id, String username, String email,double balance, List<String> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.balance = balance;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public String getUsername() {
		return username;
	}


	public List<String> getRoles() {
		return roles;
	}
}
