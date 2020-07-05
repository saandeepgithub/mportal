package com.portal.mongo.repo;

import com.portal.mongo.domain.CashBack;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CashBackRepository extends MongoRepository<CashBack, String> {

}
