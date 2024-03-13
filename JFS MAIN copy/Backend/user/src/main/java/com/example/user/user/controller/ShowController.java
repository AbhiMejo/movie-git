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

import com.example.user.user.entity.ShowDetails;
import com.example.user.user.service.ShowService;

@RestController
@CrossOrigin(origins = "*")
public class ShowController {
	
	@Autowired
	public ShowService service;
	
	@PostMapping("/saveshow")
	public ResponseEntity<ShowDetails> saveAndUpdate(@RequestBody ShowDetails details) {
	
		return new ResponseEntity<ShowDetails>(service.saveShow(details),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get/show")
	public ResponseEntity<?> getAllShow(){
		return new ResponseEntity<>(service.listAll(),HttpStatus.OK);
	}
	
	@PostMapping("/updateshow/{id}")
	public ResponseEntity<ShowDetails> updateShow(@PathVariable Long id,@RequestBody ShowDetails details){
		return new ResponseEntity<ShowDetails>(service.updateShow(id, details),HttpStatus.OK);
	}
	@GetMapping("/deleteshow/{id}")
	public ResponseEntity<String> deleteShow(@PathVariable Long id){
		service.deleteShow(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	//This is for getting the Movie id and fetch the showdetails
	@GetMapping("/get/showdetails/{id}")
	public ResponseEntity<List<ShowDetails>> getShowDetails(@PathVariable Long id){
		return new ResponseEntity<List<ShowDetails>>(service.ShowByMovieId(id),HttpStatus.OK);
	}
}
