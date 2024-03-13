package com.example.user.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.user.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	//public User findByFirstName(String user);
	//List<User> findByFirstNameAndPassword(String FirstName,String Password);
	//public User finfByFirstNameAndPassword(String FirstName, String Password);
	//User findByFirstnameAndPassword(String FirstName,String Password);
}

