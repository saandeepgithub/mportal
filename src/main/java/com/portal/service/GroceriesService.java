package com.portal.service;

import com.portal.mongo.domain.Groceries;
import com.portal.mongo.repo.GroceriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceriesService {

    @Autowired
    private GroceriesRepository groceriesRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Groceries addGroceri(Groceries groceries) {
        groceries.setPurchased("N");
        groceries.setAck("N");
        if (groceries.getQuantity() == null) {
            groceries.setQuantity("1");
        }
        return groceriesRepository.insert(groceries);
    }

    public Groceries updateGroceri(Groceries groceries) {
        groceries.setPurchased("N");
        groceries.setAck("N");
        if (groceries.getQuantity() == null) {
            groceries.setQuantity("1");
        }
        return groceriesRepository.save(groceries);
    }

    public void ackGroceri(String groceriId) {
        Query query = new Query(Criteria.where("_id").is(groceriId));
        Update update = new Update();
        update.set("ack", "Y");
        mongoTemplate.updateFirst(query, update, Groceries.class);
    }

    public void purchaseGroceri(String groceriId) {
        Query query = new Query(Criteria.where("_id").is(groceriId));
        Update update = new Update();
        update.set("purchased", "Y");
        mongoTemplate.updateFirst(query, update, Groceries.class);
    }

    public List<Groceries> getAllNewGroceries() {
        Query query = new Query(Criteria.where("ack").is("N").andOperator(Criteria.where("purchased").is("N")));
        return mongoTemplate.find(query, Groceries.class);
    }

    public List<Groceries> getAllAckedGroceries() {
        Query query = new Query(Criteria.where("ack").is("Y").andOperator(Criteria.where("purchased").is("N")));
        return mongoTemplate.find(query, Groceries.class);
    }

    public List<Groceries> getAllPurchasedGroceries() {
        Query query = new Query(Criteria.where("purchased").is("Y"));
        return mongoTemplate.find(query, Groceries.class);
    }

    public List<Groceries> getGroceries(String groceriName) {
        Query query = new Query(Criteria.where("groceriName").is(groceriName));
        return mongoTemplate.find(query, Groceries.class);
    }
}
