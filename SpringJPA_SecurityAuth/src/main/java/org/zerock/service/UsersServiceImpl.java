package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.DAO.UsersRepository;
import org.zerock.model.UsersEntity;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Transactional
	public UsersEntity getUser(String userName) {
		return usersRepository.findByuserName(userName);
	}
	
	
	@Override
	@Transactional
	public List<UsersEntity> getAllUsers(){
		return usersRepository.findAll();
	}
	
	
	@Override
	@Transactional
	public void createUser(UsersEntity usersEntity) {
		log.info("Normal");
		usersRepository.save(usersEntity);
	}
	
	@Override
	@Transactional
	public void updateUser(UsersEntity usersEntity) {
		usersRepository.save(usersEntity);
	}
	
	@Override
	@Transactional
	public void deleteUser(String userName) {
		usersRepository.deleteByuserName(userName);
	}

}
