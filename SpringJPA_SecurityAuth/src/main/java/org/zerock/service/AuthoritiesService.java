package org.zerock.service;

import java.util.List;

import org.zerock.model.AuthoritiesEntity;

public interface AuthoritiesService {
	
	//Read
	public List<AuthoritiesEntity> getAuthorities(String userName);
	public List<AuthoritiesEntity> getAllUsers();
	
	//Create
	public void saveUser(AuthoritiesEntity authoritiesEntity);
	
	//Update
	public void updateAuthority(AuthoritiesEntity authoritiesEntity);
	
	//Delete
	public void deleteAuthority(String userName, String authority);
	
}
