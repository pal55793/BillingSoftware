package com.rk.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.rk.enity.Items;


@Service
public class ItemsService {
	
	
	private MongoTemplate mongoTemplate;
	
	public ItemsService(MongoTemplate mongoTemplate) {
		this.mongoTemplate=mongoTemplate;
	}

	 public List<Items> getAllItems(){
		 return mongoTemplate.findAll(Items.class);
	 }
	
	 public Items addItems(Items Items) {		 
		 return mongoTemplate.save(Items);
	 }
	 public String deleteItemsById(String ItemsId) {	
		 Query query = new Query(Criteria.where("_id").is(ItemsId));
		 return  (mongoTemplate.remove(query, Items.class).getDeletedCount()==1) ? "Done":"Not Done";
	 }
	 
	 public Items getItemsById( String itemId) {
		 Query query = new Query(Criteria.where("itemId").is(itemId));
		 return mongoTemplate.findOne(query, Items.class);
	 }
	 
	
}
