package com.portal.mongo.repo;

import com.portal.mongo.domain.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends MongoRepository<Bill,String> {
}
