package com.example.user.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user.user.entity.MovieDetails;
import com.example.user.user.entity.ShowDetails;
import com.example.user.user.entity.Theaterdetails;
import com.example.user.user.repository.MovieRepo;
import com.example.user.user.repository.ShowRepo;

@Service
public class MovieService {
 
	@Autowired
	public MovieRepo repo;
	
	@Autowired
	public ShowRepo showRepo;
	
	//This is for saving the Movie details
	public void saveMovies(MovieDetails details) {
		repo.save(details);
	}
	//This is for Getting all the Movie details
	public Iterable<MovieDetails> listAll(){
		return repo.findAll();
	}
	//this is for deleting the Movies by getting the id
	public void deleteMovie(Long id) {
		MovieDetails movie=repo.findById(id).get();
		if(movie!=null) {
			repo.delete(movie);
		}
	}
	//This is for updating the Movie
	//By fetching all the details of the Movie by id
	//After checking I have set the new value which comes in details
	public MovieDetails updateMovie(Long id,MovieDetails details) {
		MovieDetails oldMovie=repo.findById(id).get();
		if(oldMovie!=null) {
			details.setMovieId(id);
			repo.save(details);
		}
		return null;
	}
	
}
