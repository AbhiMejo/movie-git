package com.example.user.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.user.user.entity.Theaterdetails;

public interface AdminRepo extends CrudRepository<Theaterdetails, Long>  {

	//This is for show details
	boolean existsById(Long TheaterId);
}
