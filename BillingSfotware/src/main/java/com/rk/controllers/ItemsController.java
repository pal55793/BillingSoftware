package com.rk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.enity.Items;
import com.rk.services.ItemsService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemsController {
	
	@Autowired
	ItemsService itemsService;
	
	@PostMapping(path="/addItem", produces = "application/json")
	public ResponseEntity<Object> addItem(@RequestBody Items items){
		return new ResponseEntity<Object>(itemsService.addItems(items), HttpStatus.OK);
	}
	
	@GetMapping(path="/getItemId", produces = "application/json")
	public ResponseEntity<Object> getItemId(@RequestParam String itemId ){
		return new ResponseEntity<Object>(itemsService.getItemsById(itemId), HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllItem", produces = "application/json")
	public ResponseEntity<Object> getAllItem(){
		return new ResponseEntity<Object>(itemsService.getAllItems(), HttpStatus.OK);
	}
	public String fallbackRateLimit(Throwable t) {
	    return "Too many requests - try again later!";
	}
	@DeleteMapping(path="/deleteItemById", produces = "application/json")
	public ResponseEntity<Object> deleteItemById(@RequestParam String id){
		return new ResponseEntity<Object>(itemsService.deleteItemsById(id), HttpStatus.OK);
	}

}
