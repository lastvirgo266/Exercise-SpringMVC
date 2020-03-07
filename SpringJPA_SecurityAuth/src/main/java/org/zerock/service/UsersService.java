package org.zerock.service;

import java.util.List;

import org.zerock.model.UsersEntity;

public interface UsersService {
	
	//Read
	public UsersEntity getUser(String userName);
	public List<UsersEntity> getAllUsers();
	
	//Create
	public void createUser(UsersEntity usersEntity);
	
	//Update
	public void updateUser(UsersEntity usersEntity);
	
	//Delete
	public void deleteUser(String userName);
	
}
