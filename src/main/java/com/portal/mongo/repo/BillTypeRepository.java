package com.portal.mongo.repo;

import com.portal.mongo.domain.BillClassification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillTypeRepository extends MongoRepository<BillClassification,String> {
}
