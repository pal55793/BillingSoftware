package com.rk.Repositry;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rk.enity.User;

public interface UserRepositry extends MongoRepository<User, String> {

	@Query(value= "{}" ,fields = "{ 'id': 0 }")
	User getUserById(String Id);
	  
	List<User> findAll(); 
	
		 	  
}
   