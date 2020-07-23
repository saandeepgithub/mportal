package com.portal.mongo.repo;

import com.portal.mongo.domain.Groceries;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceriesRepository extends MongoRepository<Groceries,String> {
}
