package com.example.user.user.controller;


import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.user.entity.Theaterdetails;
import com.example.user.user.repository.AdminRepo;
import com.example.user.user.service.TheaterService;


@RestController
@CrossOrigin(origins ="*")
public class AdminController {
	
	@Autowired
	public AdminRepo repo;
	@Autowired
	public TheaterService service;
	//Adding theater details
	@PostMapping("/Adminlogin/theaterdetails")
	public Long SaveThreater(@RequestBody Theaterdetails theaterDetails) {
		repo.save(theaterDetails);
		return theaterDetails.TheaterId;
	}
	//Getting all the theater list
	@GetMapping("/TheaterList")
	public Iterable<Theaterdetails> getAllDetails(){
		return repo.findAll();
	}
	
	//Updating the list
	@PostMapping("/update/{id}")
	public ResponseEntity<Theaterdetails> updateTheater(@PathVariable Long id,@RequestBody Theaterdetails details)
	{
		
		return new ResponseEntity<Theaterdetails>(service.updateTheater(id,details),HttpStatus.OK);
	}
	//this is for deleting a particular theater details	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteTheater(@PathVariable Long id){
		service.deleteTheater(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
//	@GetMapping("/get/theaterdetails/{id}")
//	public ResponseEntity<?> getTheaterDetails(@PathVariable Long id){
//		return new ResponseEntity<>(service.ShowById(id),HttpStatus.OK);
//	}
	
}
