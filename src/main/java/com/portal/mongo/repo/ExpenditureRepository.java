package com.portal.mongo.repo;

import com.portal.mongo.domain.Expenditure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenditureRepository extends MongoRepository<Expenditure, String> {

    Optional<Expenditure> findExpenditureByActiveStatusEquals(String activeStatus);

}
