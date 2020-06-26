package com.portal.mongo.repo;

import com.portal.mongo.domain.Emi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmiRepository extends MongoRepository<Emi, String> {
}
