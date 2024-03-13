package com.example.user.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.user.entity.MovieDetails;
import com.example.user.user.entity.ShowDetails;
import com.example.user.user.entity.Theaterdetails;
import com.example.user.user.repository.AdminRepo;
import com.example.user.user.repository.MovieRepo;
import com.example.user.user.repository.ShowRepo;

@Service
public class ShowService {

	@Autowired
	public ShowRepo repo;
	@Autowired
	public MovieRepo movieRepo;
	@Autowired
	public AdminRepo theaterRepo;
	
	//I am checking If the Movie id and Theater id is present or not then only show details will save
	public ShowDetails saveShow(ShowDetails details) {
		
		if(movieRepo.existsById(details.getMId())&&theaterRepo.existsById(details.getTId())) {
		return repo.save(details);
	}else {
		System.out.println("Hi");
		return null;
	}
		
}
	//This is for retriving all the data from the database
	public Iterable<ShowDetails> listAll(){
		return repo.findAll();
	}
	//This is for deleting the show
	public void deleteShow(Long id) {
		
		ShowDetails show=repo.findById(id).get();
		if(show!=null) {
			repo.delete(show);
		}
	}
	//This is for updating the Show
	//By fetching all the details of the Show by id
	//After checking I have set the new value which comes in details
	//Also checking MovieId and TheaterId is present or not
	public ShowDetails updateShow(Long id,ShowDetails details) {
		ShowDetails oldShowDetails=repo.findById(id).get();
		if(movieRepo.existsById(details.getMId())&&theaterRepo.existsById(details.getTId())&&oldShowDetails!=null) {
			details.setShowId(id);
			repo.save(details);
		}
		return null;
	}
	public List<ShowDetails> ShowByMovieId(Long id) {
		return repo.findByMId(id);
		
	}
	
}
