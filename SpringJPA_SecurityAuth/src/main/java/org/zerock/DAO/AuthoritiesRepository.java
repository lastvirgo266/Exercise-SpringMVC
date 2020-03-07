package org.zerock.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.zerock.model.AuthoritiesEntity;

@Repository
public interface AuthoritiesRepository extends JpaRepository<AuthoritiesEntity, String> {
	
	
	
}
