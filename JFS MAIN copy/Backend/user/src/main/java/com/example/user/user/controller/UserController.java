package com.example.user.user.controller;

import java.util.List;
import java.util.Objects;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.user.entity.MovieDetails;
import com.example.user.user.entity.User;
import com.example.user.user.repository.UserRepo;
import com.example.user.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins ="*")
public class UserController {

	

	
//	@PostMapping("/save")
//	public Long save(@RequestBody User details) {
//		service.saveDetails(details);
//		return details.userid;
//	}
	
//	@PostMapping("/get/login")
//	public ResponseEntity<?> getLoginDetails(@RequestBody User user){
//		return new ResponseEntity<>(service.LoginDetails(user),HttpStatus.OK);
//	}
//	public ResponseEntity<List<User>> getLaptopsByFirstNameAndPassword(@RequestParam String FirstName, 
//			@RequestParam String Password) {
//	return new ResponseEntity<List<User>>(service.listByFirstNameAndPassword(FirstName,Password), HttpStatus.OK);
//}
//	@PostMapping("/userlogin")
//	public String login(@RequestBody User user) {
//		
//		User authUser=service.login(user.getFirstname(),user.getPassword());
//		if(authUser!=null) {
//			return "success";
//		}else {
//			return "Try Again";
//		}
//	}
//	@PostMapping(value="/userlogin")
//	public ResponseEntity<String> userLogin(@RequestParam(value = "userid") Long userid,@RequestParam(value = "password") String password,HttpSession session) {
//
//		User u=repo.findById(userid).orElse(null);
//
//        //Long Session=u.getUserid();
//
//		System.out.println(u);
//			if(service.validateLogin(userid,password).equals("success")) {
//
//			return ResponseEntity.status(200).body("successful");
//
//		}
//
//		else if(service.validateLogin(userid,password).equals("Invalid")) {
//
//			return ResponseEntity.status(200).body("Failed");
//		}
//
//		return ResponseEntity.status(200).body("");
//
//	}	
	
	@Autowired
	UserRepo ur;
	
	@Autowired
	UserService userService;
	
	public Long userSession=0L;
	
	@GetMapping("ShowallUser")
	public Iterable<User> showAllDetails(){
		Iterable<User> logindetails=ur.findAll();
		return logindetails;
	}
	
	@PostMapping("Save")
	public String userRegistration(@RequestBody User u) {
		
		User logindetails=userService.addingUser(u);
		
		return "Successfull";
		
	}

	@PostMapping("/userLogin")
	public ResponseEntity<String> userLogin(@RequestParam("loginID") Long loginID,@RequestParam("password") String password) {
		
		
		System.out.print(loginID);
		User u=ur.findById(loginID).orElse(null);
		userSession=u.getLoginID();
		System.out.println(u);
		if(userService.validateLogin(loginID,password).equals("success")) {	
			return ResponseEntity.status(200).body("success");	
		}
		else if(userService.validateLogin(loginID,password).equals("Invalid")) {
			return ResponseEntity.status(200).body("Failed");
		
		}
		return ResponseEntity.status(200).body("Please Check The crediantials");
	}
}
	
