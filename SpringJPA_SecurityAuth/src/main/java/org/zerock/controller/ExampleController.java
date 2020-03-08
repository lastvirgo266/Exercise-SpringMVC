package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.model.AuthoritiesEntity;
import org.zerock.model.UsersEntity;
import org.zerock.service.AuthoritiesService;
import org.zerock.service.UsersService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class ExampleController {
	
	@Autowired
	UsersService userService;
	
	@Autowired
	AuthoritiesService authService;
	
	@GetMapping("/userget")
	public void getUser(String userName) {
		UsersEntity entity = new UsersEntity();
		entity = userService.getUser("AAA");
		log.info(entity.getUsername());
		
	}
	
	
	@GetMapping("/usersave")
	public String seveUser(UsersEntity usersEntity) {
		usersEntity.setUserName("abc2we");
		usersEntity.setPassword("sdfswew");
		
		log.info(usersEntity.getUsername());
		
		userService.createUser(usersEntity);
		
		return usersEntity.getUsername();
	}
	
	@GetMapping("/userupdate")
	public String updateUser(UsersEntity usersEntity) {
		usersEntity.setUserName("AAA");
		usersEntity.setPassword("AAA");
		
		log.info(usersEntity.getUsername());
		
		userService.updateUser(usersEntity);
		
		return usersEntity.getUsername();
	}
	
	@GetMapping("/userdelete")
	public void deleteUser(String userName) {
		userName = "AAA";
		
		log.info(userName);
		
		userService.deleteUser(userName);
		
	}
	
	
	@GetMapping("/authsave")
	public void seveAuthority() {
		UsersEntity user = new UsersEntity();
		user.setUserName("BBB");
		user.setPassword("AAA");
		
		AuthoritiesEntity authEntity = new AuthoritiesEntity();
		authEntity.setUserName(user);
		authEntity.setAuthority("user");
		
		log.info(authEntity.getUserName());
		
		authService.saveAuthority(authEntity);
		
	}

}
