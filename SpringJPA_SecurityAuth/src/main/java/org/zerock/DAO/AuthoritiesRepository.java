package org.zerock.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import org.zerock.model.AuthoritiesEnitity;
import org.zerock.model.UsersEntity;

public interface AuthoritiesRepository extends JpaRepository<AuthoritiesEnitity, Long> {
	
	List<AuthoritiesEnitity> findByuserEntity(UsersEntity user);
	
}
