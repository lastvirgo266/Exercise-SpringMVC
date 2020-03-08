package org.zerock.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.zerock.model.AuthoritiesEntity;
import org.zerock.model.UsersEntity;

@Repository
public interface AuthoritiesRepository extends JpaRepository<AuthoritiesEntity, String> {
	
	//Read
	List<AuthoritiesEntity> findByuserName(String userName);
	
	AuthoritiesEntity findByUserNameAndAuthority(String userName, String authority);
	
	
	//delete
	void deleteByUserName(String userName);
	
	void deleteByUserNameAndAuthority(String userName, String authority);
	
	
}
