package com.rk.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.enity.Costumers;
import com.rk.services.CostumerService;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
	
	@Autowired
	CostumerService costumerService;
	
	
	
	@PostMapping(path="/addCostumer", produces = "application/json")
	public ResponseEntity<Object> addCostumer(@RequestBody Costumers costumers){
		costumerService.addCostumers(costumers);
		return new ResponseEntity<Object>(costumers, HttpStatus.OK);
	}
	
	@Cacheable(value = "costumers", key = "id")
	@GetMapping(path="/getCostumerById", produces = "application/json")
	public ResponseEntity<Object> getCostumerById(@RequestParam String mobileNumber ){
		System.out.println("Api called");
		
		return new ResponseEntity<Object>(costumerService.getCostumersById(mobileNumber), HttpStatus.OK);
	}
	
	@GetMapping(path="/getCostumerByName", produces = "application/json")
	public ResponseEntity<Object> getCostumerByName(@RequestParam String name ){
		return new ResponseEntity<Object>(costumerService.getCostumersByName(name), HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllCostumer", produces = "application/json")
	public ResponseEntity<Object> getAllCostumer(){
		return new ResponseEntity<Object>(costumerService.getAllCostumers(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteCostumerById", produces = "application/json")
	public ResponseEntity<Object> deleteCostumerById(@RequestParam String  mobilenumber){
		return new ResponseEntity<Object>(costumerService.deleteCostumersById(mobilenumber), HttpStatus.OK);
	}

}
