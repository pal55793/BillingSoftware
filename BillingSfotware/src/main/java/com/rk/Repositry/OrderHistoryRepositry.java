package com.rk.Repositry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rk.enity.OrderHistory;

public interface OrderHistoryRepositry extends MongoRepository<OrderHistory, String> {

}
