package com.rk.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.rk.enity.OrderHistory;


@Service
public class OrderHistoryService {

	private MongoTemplate mongoTemplate;
	
	public OrderHistoryService(MongoTemplate mongoTemplate) {
		// TODO Auto-generated constructor stub
		this.mongoTemplate=mongoTemplate;
	}
	
	public List<OrderHistory> getAllOrderHistory(){
		 return mongoTemplate.findAll(OrderHistory.class);
	 }
	
	 public OrderHistory addOrderHistory(OrderHistory OrderHistory) {		 
		 return mongoTemplate.save(OrderHistory);
	 }
	 public String deleteOrderHistoryById(String orderId) {	
		 Query query = new Query(Criteria.where("orderId").is(orderId));
		 return  (mongoTemplate.remove(query, OrderHistory.class).getDeletedCount()==1) ? "Done":"Not Done";
	 }
	 
	 public List<OrderHistory> getOrderHistoryByDate( String fromdate, String todate) {
		 LocalDateTime start = LocalDateTime.parse(fromdate);
	        LocalDateTime end = LocalDateTime.parse(todate);
		 
		 Query query = new Query();
	        query.addCriteria(Criteria.where("orderDate").gte(start).lte(end));
	        return mongoTemplate.find(query, OrderHistory.class);
	 }
	 
	 
	
}
