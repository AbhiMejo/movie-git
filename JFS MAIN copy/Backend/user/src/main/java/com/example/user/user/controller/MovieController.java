package com.example.user.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.user.entity.MovieDetails;
//import com.example.user.user.entity.Theaterdetails;
import com.example.user.user.repository.MovieRepo;
import com.example.user.user.service.MovieService;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {

	@Autowired
	public MovieService service;
	@Autowired
	MovieRepo repo;
	
	@PostMapping("/savemovie")
	public Long saveMovie(@RequestBody MovieDetails details) {
		service.saveMovies(details);
		return details.MovieId;
	}
	
	@GetMapping("/get/movie")
	public ResponseEntity<?> getAllMovies(){
		return new ResponseEntity<>(service.listAll(),HttpStatus.OK);
	}
	
	@GetMapping("/deleteMovie/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable long id){
		service.deleteMovie(id);
		return new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
	}
	
	@PostMapping("/upadateMovie/{id}")
	public ResponseEntity<MovieDetails> updateMovie(@PathVariable Long id,@RequestBody MovieDetails details){
		return new ResponseEntity<MovieDetails>(service.updateMovie(id,details),HttpStatus.OK);
	}
	
}
