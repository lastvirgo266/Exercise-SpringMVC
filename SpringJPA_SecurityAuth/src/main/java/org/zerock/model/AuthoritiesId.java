package org.zerock.model;

import java.io.Serializable;

public class AuthoritiesId implements Serializable {
	String userName;
	String authority;
	
	public AuthoritiesId() {}
	
	public AuthoritiesId(String userName, String authority) {
		this.userName = userName;
		this.authority = authority;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getAuthority() {
		return this.authority;
	}
}
