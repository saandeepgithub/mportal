package com.portal.mongo.repo;

import com.portal.mongo.domain.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends MongoRepository<Bill,String> {

    public List<Bill> getByBillIdIsStartingWith(String billIdPrefix);

    public Optional<Bill> getAllByBillIdEquals(String billId);
}
