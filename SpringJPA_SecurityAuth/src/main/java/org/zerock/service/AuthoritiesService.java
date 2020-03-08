package org.zerock.service;

import java.util.List;

import org.zerock.model.AuthoritiesEntity;

public interface AuthoritiesService {
	
	//Read
	public List<AuthoritiesEntity> getAuthorities(String userName);
	
	//Create
	public void saveAuthority(AuthoritiesEntity authoritiesEntity);
	
	//Update
	public void updateAuthority(AuthoritiesEntity authoritiesEntity);
	
	//Delete
	public void deleteAuthority(String userName, String authority);
	
}
