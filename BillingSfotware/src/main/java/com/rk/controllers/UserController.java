package com.rk.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.enity.User;
import com.rk.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServices userServices;
	 
	

	@PostMapping(path="/addUser", produces = "application/json")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		userServices.addUser(user);
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
	
	@PostMapping(path="/getUserById", produces = "application/json")
	public ResponseEntity<Object> getUserById(@RequestParam String mobileNumber){
		return new ResponseEntity<Object>(userServices.getUSerById(mobileNumber), HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllUser", produces = "application/json")
	public ResponseEntity<Object> getAllUser(){		
		return new ResponseEntity<Object>(userServices.getAllUser(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteUserById", produces = "application/json")
	public ResponseEntity<Object> deleteUserById(@RequestParam String userid){
		return new ResponseEntity<Object>(userServices.deleteUserById(userid), HttpStatus.OK);
	}
}
