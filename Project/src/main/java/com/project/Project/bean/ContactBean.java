package com.project.Project.bean;

import java.math.BigInteger;
import java.util.Objects;

public class ContactBean {
	private int id;
	private String name;
	private BigInteger phone;
	private String email;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ContactBean(int id, String name, BigInteger phone, String email, String message) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.message = message;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, message, name, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactBean other = (ContactBean) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(message, other.message)
				&& Objects.equals(name, other.name) && phone == other.phone;
	}
	@Override
	public String toString() {
		return "ContactBean [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", message="
				+ message + "]";
	}
	
}
