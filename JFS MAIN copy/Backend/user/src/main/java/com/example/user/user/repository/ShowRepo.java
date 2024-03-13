package com.example.user.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.user.entity.ShowDetails;

@Repository
public interface ShowRepo extends CrudRepository<ShowDetails,Long> {
	public List<ShowDetails> findByMId(Long id);
	
	public List<ShowDetails> findAllByMId(Long id);
}
