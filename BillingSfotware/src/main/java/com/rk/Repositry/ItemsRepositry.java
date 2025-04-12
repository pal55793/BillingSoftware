package com.rk.Repositry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rk.enity.Items;

public interface ItemsRepositry extends MongoRepository<Items, String> {

}
