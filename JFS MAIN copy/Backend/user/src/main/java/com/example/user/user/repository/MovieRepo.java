package com.example.user.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.user.entity.MovieDetails;

@Repository
public interface MovieRepo extends CrudRepository<MovieDetails, Long> {

	//This is for show details
	boolean existsById(Long MovieId);
}
