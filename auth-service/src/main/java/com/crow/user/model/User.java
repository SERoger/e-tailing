package com.crow.user.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="t_users")
public class User {
	@Id
	private UUID id;
	@Column(length = 45, nullable = false)
	private String fullName;
	@Column(length = 15, nullable = false, unique = true)
	private String userName;
	@Column(length = 20, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private ERole role;
	@Enumerated(EnumType.STRING)
	private EAccess access;

	public User() {
	}

	public User(UUID id, String fullName, String userName, String password, ERole role, EAccess access) {
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.access = access;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public EAccess getAccess() {
		return access;
	}

	public void setAccess(EAccess access) {
		this.access = access;
	}
}
