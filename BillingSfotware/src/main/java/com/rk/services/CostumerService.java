package com.rk.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.rk.enity.Costumers;

@Service
public class CostumerService {
	
	private MongoTemplate mongoTemplate;
	
	public CostumerService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
 
		 public List<Costumers> getAllCostumers(){
			 return mongoTemplate.findAll(Costumers.class);
		 }
		
		 public Costumers addCostumers(Costumers Costumers) {		 
			 return mongoTemplate.save(Costumers);
		 }
		 public String deleteCostumersById(String CostumersId) {	
			 Query query = new Query(Criteria.where("mobilenumber").is(CostumersId));
			 return  (mongoTemplate.remove(query, Costumers.class).getDeletedCount()==1) ? "Done":"Not Done";
		 }
		 
		 public Costumers getCostumersById( String mobileNumber) {
			 Query query = new Query(Criteria.where("mobilenumber").is(mobileNumber));
			 return mongoTemplate.findOne(query, Costumers.class);
		 }
		 public Costumers getCostumersByName( String name) {
			 Query query = new Query(Criteria.where("name").is(name));
			 return mongoTemplate.findOne(query, Costumers.class);
		 }	

}
