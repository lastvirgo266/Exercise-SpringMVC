package org.zerock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.extern.log4j.Log4j;

@Log4j
@Entity
@IdClass(AuthoritiesId.class)
@Table(name="authorities")
public class AuthoritiesEntity implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "userName")
	private UsersEntity userName;
	
	@Id
	@Column(nullable = false)
	private String authority;
	
	public AuthoritiesEntity() {}
	
	public AuthoritiesEntity(UsersEntity userName, String authority) {
		this.userName = userName;
		this.authority = authority;
	}
	
	
//	public UsersEntity getUserEntity() {
//		return this.userName;
//	}
//	
//	public void setUserEntity(UsersEntity userEntity) {
//		this.userName = userEntity;
//	}
//	
	
	public UsersEntity getUserName() {
		return userName;
	}
	
	public void setUserName(UsersEntity userName) {
		this.userName = userName;
	}
	
	
	public String getAuthority() {
		return this.authority;
	}
	
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
