package com.rk.Repositry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rk.enity.Costumers;

public interface CostumerRepositry extends MongoRepository<Costumers, String> {

	
}
