package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.DAO.UsersRepository;
import org.zerock.model.AuthoritiesEnitity;
import org.zerock.model.UsersEntity;
import org.zerock.service.RepositoryService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class ExampleController {
	
	@Autowired
	RepositoryService resRepositoryService;
	
	@Autowired
	UsersRepository userRepository;
	
	@GetMapping("/usersave")
	public String seveUser(UsersEntity usersEntity) {
		usersEntity.setUserName("abc");
		usersEntity.setPassword("sdfs");
		
		log.info(usersEntity.getUsername());
		
		userRepository.save(usersEntity);
		
		return usersEntity.getUsername();
	}

}
