package com.project.Project.bean;

import java.math.BigInteger;
import java.util.Objects;

public class BookBean {
	private int id;
	private String name;
	private BigInteger phone;
	private String email;
	private String  date;
	private String time;
	private String address;
	
	
	public BookBean(int id, String name, BigInteger phone, String email, String date, String time, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.time = time;
		this.address = address;
	}
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, date, email, id, name, phone, time);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookBean other = (BookBean) obj;
		return Objects.equals(address, other.address) && Objects.equals(date, other.date)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && Objects.equals(time, other.time);
	}
	@Override
	public String toString() {
		return "BookBean [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", date=" + date
				+ ", time=" + time + ", address=" + address + "]";
	}
	
}
