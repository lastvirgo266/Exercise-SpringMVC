package org.zerock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class UsersEntity implements Serializable {
	
	@Id
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(length = 1)
	private String enabled = "1";
	
	
	
	
	public String getUsername() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	

}
