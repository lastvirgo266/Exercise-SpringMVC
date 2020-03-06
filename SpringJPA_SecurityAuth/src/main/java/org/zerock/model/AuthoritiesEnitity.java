package org.zerock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="authorities", uniqueConstraints= {
		@UniqueConstraint(
		columnNames= {"userName", "authority"})
})
public class AuthoritiesEnitity implements Serializable {
	
	@Id
	private String userName;
	
	@ManyToOne
	@MapsId
	@JoinColumn(name="userName", referencedColumnName = "userName")
	private UsersEntity userEntity;

	@Column(nullable = false)
	private String authority;
	
	
	public String getAuthority() {
		return this.authority;
	}
	
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
