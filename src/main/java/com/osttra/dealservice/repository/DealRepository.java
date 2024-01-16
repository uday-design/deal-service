package com.osttra.dealservice.repository;

import com.osttra.dealservice.entity.Deal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DealRepository extends MongoRepository<Deal, String> {
}
