package com.project.Project.bean;

import java.util.Objects;

public class RegisterBean {
	private int id;
	private String username;
	private String email;
	private String password;
	private String confirm_password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RegisterBean(int id, String username, String email, String password, String confirm_password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(confirm_password, email, id, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterBean other = (RegisterBean) obj;
		return Objects.equals(confirm_password, other.confirm_password) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "RegisterBean [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirm_password=" + confirm_password + "]";
	}
	
}
