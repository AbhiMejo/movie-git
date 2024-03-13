package com.example.user.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.user.entity.MovieDetails;
import com.example.user.user.entity.User;
import com.example.user.user.repository.UserRepo;

@Service
public class UserService implements UserServiceInf  {
	
	@Autowired
	public UserRepo repo;
	
//	public void listAll(User entity) {
//		repo.save(entity);
//	}
	
//	public User LoginDetails(User user){
//		User fp=repo.findByFirstName(user);
//		if(fp.equals(user)) {
//			return user.FirstName;
//					
//		}
//	
//	}
//	public List<User> listByFirstNameAndPassword(String FirstName,String Password){
//		return repo.findByFirstNameAndPassword(FirstName,Password);
//	}
	//This is for saving the Movie details
//		public void saveDetails(User details) {
//			repo.save(details);
//		}
//		
//	public User login(String FirstName,String Password) {
//		User user=repo.findByFirstnameAndPassword(FirstName, Password);
//		return user;
//	}
//		public String validateLogin(Long userid, String password) {
//
//		     User user=repo.findById(userid).orElse(null);
//
//			if(user==null) {
//
//				return "Invalid";
//
//			}else if(user.getPassword().equals(password)) {
//
//				return "success";
//			}
//
//			return "Invalid";
//
//		}
	
	public String validateLogin(Long loginID, String password) {   
		User user=repo.findById(loginID).orElse(null);
		if(user==null) {
			return "Invalid";
		}else if(user.getPassword().equals(password)) {
			return "success";
		}
			
		return "Invalid";
				
	}
	
	public User addingUser(User u) {
		User details=repo.save(u);
		return details;
		
	}
}
