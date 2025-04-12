package com.rk.services;

import java.util.List;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.rk.enity.User;

@Service
public class UserServices {
	
	private MongoTemplate mongoTemplate;
	
	 public UserServices(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	 
	 public List<User> getAllUser(){
		 return mongoTemplate.findAll(User.class);
	 }

	 public User addUser(User user) {		 
		 return mongoTemplate.save(user);
	 }
	 public String deleteUserById(String userId) {	
		 Query query = new Query(Criteria.where("_id").is(userId));
		 return  (mongoTemplate.remove(query, User.class).getDeletedCount()==1) ? "Done":"Not Done";
	 }
	 
	 public User getUSerById( String mobileNumber) {
		 Query query = new Query(Criteria.where("mobileNumber").is(mobileNumber));
		 return mongoTemplate.findOne(query, User.class);
	 }
}
