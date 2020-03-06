package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.zerock.DAO.AuthoritiesRepository;
import org.zerock.DAO.UsersRepository;
import org.zerock.model.UsersEntity;

@Service
public class RepositoryServiceImpl implements RepositoryService{
	
	@Autowired
	private UsersRepository userRepository;
	
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	
}
