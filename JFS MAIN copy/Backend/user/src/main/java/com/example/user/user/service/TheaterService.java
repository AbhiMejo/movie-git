package com.example.user.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.user.entity.ShowDetails;
import com.example.user.user.entity.Theaterdetails;
import com.example.user.user.repository.AdminRepo;
import com.example.user.user.repository.ShowRepo;

@Service
public class TheaterService {
	@Autowired
	public AdminRepo repo;
	
	@Autowired
	public ShowRepo showRepo;
	
	//This is for Updating the Theater details
	public Theaterdetails updateTheater(Long id, Theaterdetails details) {
		Theaterdetails oldDetails=repo.findById(id).get();
		if(oldDetails!=null) {
			details.setTheaterId(id);
			return repo.save(details);
		}
		return null;
	}
	//this is for deleting the theater details
	public void deleteTheater(Long id) {
		Theaterdetails tDetails=repo.findById(id).get();
		if(tDetails!=null) {
			repo.delete(tDetails);
		}
	}
	//This is for displaying data by using id
//	public List<Theaterdetails> ShowById(Long id) {
//		//This is fetching the show details as well as theaterIds
//		List<ShowDetails> details=showRepo.findAllByMId(id);
//		//this is for fetching Theaterdetails from there
//		
//	}
}
