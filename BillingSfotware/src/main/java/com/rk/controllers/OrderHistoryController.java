package com.rk.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

import com.rk.enity.OrderHistory;
import com.rk.services.OrderHistoryService;

@RestController
@RequestMapping("/orders")
public class OrderHistoryController {
	
	@Autowired
	OrderHistoryService orderHistoryService;
	
	
	@PostMapping(path="/addOrderHistory", produces = "application/json")
	public ResponseEntity<Object> addOrderHistory(@RequestBody OrderHistory orderHistory) throws ParseException{
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate today = LocalDate.now();
		orderHistory.setOrderDate(today.format(formatter));
		int size=orderHistoryService.getAllOrderHistory().size();
		orderHistory.setOrderId(orderHistoryService.getAllOrderHistory().get(size-1).getCostumerId().toString()+(size+1));
		orderHistoryService.addOrderHistory(orderHistory);
		return new ResponseEntity<Object>(orderHistory, HttpStatus.OK);
	}
	
	@GetMapping(path="/getOrderHistoryByDate", produces = "application/json")
	public ResponseEntity<Object> getOrderHistoryByDate(@RequestParam String todate ,@RequestParam String fromdate ){
		return new ResponseEntity<Object>(orderHistoryService.getOrderHistoryByDate(todate,fromdate), HttpStatus.OK);
	}
	
	@GetMapping(path="/getAllOrderHistory", produces = "application/json")
	public ResponseEntity<Object> getAllOrderHistory(){
		return new ResponseEntity<Object>(orderHistoryService.getAllOrderHistory(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteOrderHistoryByOrderId", produces = "application/json")
	public ResponseEntity<Object> deleteOrderHistoryByOrderId(@RequestParam String  orderId){
		return new ResponseEntity<Object>(orderHistoryService.deleteOrderHistoryById(orderId), HttpStatus.OK);
	}

}
