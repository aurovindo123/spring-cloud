package com.user.management.microservices.springclouduserlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.management.microservices.springclouduserlogin.repository.entity.UserAuth;

@Repository
public interface UserLoginRepository extends JpaRepository<UserAuth, Integer>{

	UserAuth findByUserNameAndPass(String userName, String pass);

}
