package com.portal.service;

import com.portal.mongo.domain.CashBack;
import com.portal.mongo.domain.dto.LastModifiedDto;
import com.portal.mongo.repo.CashBackRepository;
import com.portal.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CashbackService {

    @Autowired
    private CashBackRepository cashBackRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addCashBack(float cashBack) {
        Query query = new Query(Criteria.where("cashBackId").is(IdGenerator.cashBackId()));
        Update update = new Update().inc("cashBackAmount", cashBack);
        mongoTemplate.updateFirst(query, update, CashBack.class);
    }

    public void removeCashBack(float cashBack) {
        Query query = new Query(Criteria.where("cashBackId").is(IdGenerator.cashBackId()));
        Update update = new Update().inc("cashBackAmount", (int) cashBack * (-1));
        mongoTemplate.updateFirst(query, update, CashBack.class);
    }

    public void addCashBackRecord() {
        Query query = new Query(Criteria.where("activeStatus").is("Y"));
        CashBack activeCashBack = mongoTemplate.findOne(query, CashBack.class);
        CashBack cashBack = new CashBack();
        cashBack.setCashBackId(IdGenerator.cashBackId());
        cashBack.setActiveStatus("Y");
        LastModifiedDto lastModifiedDto = new LastModifiedDto();
        lastModifiedDto.setLastModifiedDate(new Date(System.currentTimeMillis()));
        cashBack.setLastModifiedDto(lastModifiedDto);
        if (activeCashBack != null) {
            cashBack.setCashBackAmount(activeCashBack.getCashBackAmount());
        } else {
            cashBack.setCashBackAmount(0);
        }
        deActivateCashBackRecord();
        cashBackRepository.insert(cashBack);
    }

    public void deActivateCashBackRecord() {
        Query query = new Query(Criteria.where("activeStatus").is("Y"));
        Update update = new Update().push("activeStatus", "N");
        mongoTemplate.updateFirst(query, update, CashBack.class);
    }
}
