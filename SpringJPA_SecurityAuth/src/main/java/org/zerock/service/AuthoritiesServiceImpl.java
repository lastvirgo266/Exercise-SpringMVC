package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.DAO.AuthoritiesRepository;
import org.zerock.model.AuthoritiesEntity;


@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
	
	@Autowired
	AuthoritiesRepository authoritiesRepository;

	//Read
	@Override
	@Transactional
	public List<AuthoritiesEntity> getAuthorities(String userName){
		return authoritiesRepository.findByuserName(userName);
	}
	
	
	@Override
	@Transactional
	//Create
	public void saveAuthority(AuthoritiesEntity authoritiesEntity) {
		authoritiesRepository.save(authoritiesEntity);
	}
	
	//Update
	public void updateAuthority(AuthoritiesEntity authoritiesEntity) {
		authoritiesRepository.save(authoritiesEntity);
	}
	
	//Delete
	public void deleteAuthority(String userName, String authority) {
		authoritiesRepository.deleteByUserName(userName);
	}


}
