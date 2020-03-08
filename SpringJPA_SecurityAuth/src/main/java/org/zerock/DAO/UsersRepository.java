package org.zerock.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.zerock.model.AuthoritiesEntity;
import org.zerock.model.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> { //���� ���׸��� ��ƼƼ, �׸��� ID�� Ÿ������ �־�����Ѵ�

	UsersEntity findByuserName(String userName);
	void deleteByuserName(String userName);

}