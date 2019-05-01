package com.user.management.microservices.springclouduserregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.management.microservices.springclouduserregistration.bean.User;

@Repository
public interface UserRegistrationDAO extends JpaRepository<User, Integer>{

}
