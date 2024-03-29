package com.project.Project.bean;

import java.util.Objects;

public class AuthBean {
	
	private String auth_token;
	private int pkId;

	public AuthBean(String auth_token) {
		super();
		this.auth_token = auth_token;
	}

	public AuthBean(String auth_token, int pkId) {
		super();
		this.auth_token = auth_token;
		this.pkId = pkId;
	}

	public AuthBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public String getAuth_token() {
		return auth_token;
	}

	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auth_token, pkId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthBean other = (AuthBean) obj;
		return Objects.equals(auth_token, other.auth_token) && pkId == other.pkId;
	}

	@Override
	public String toString() {
		return "AuthBean [auth_token=" + auth_token + ", pkId=" + pkId + "]";
	}

	
}
