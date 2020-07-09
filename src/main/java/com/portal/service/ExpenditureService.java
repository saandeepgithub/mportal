package com.portal.service;

import com.portal.mongo.domain.Expenditure;
import com.portal.mongo.domain.dto.LastModifiedDto;
import com.portal.mongo.repo.ExpenditureRepository;
import com.portal.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenditureService {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addExpenditure(float amount) {
        String expId = IdGenerator.genExpId();
        Query query = new Query(Criteria.where("_id").is(expId));
        Update update = new Update().inc("expAmount", amount);
        mongoTemplate.updateFirst(query, update, Expenditure.class);
    }

    public void addExpenditureRecord() {
        String expId = IdGenerator.genExpId();
        Optional<Expenditure> expenditure = expenditureRepository.findById(expId);
        if (!expenditure.isPresent()) {
            Expenditure expenditureRecord = new Expenditure();
            expenditureRecord.setExpId(expId);
            expenditureRecord.setExpAmount(0);
            expenditureRecord.setActiveStatus("Y");
            deActivateExpenditure();
            expenditureRepository.save(expenditureRecord);
        }
    }

    public void deActivateExpenditure(){
        Optional<Expenditure> expenditure = expenditureRepository.findExpenditureByActiveStatusEquals("Y");
        if(expenditure.isPresent()){
           Query query = new Query(Criteria.where("_id").is(expenditure.get().getExpId()));
           Update update = new Update().push("activeStatus","N");
           mongoTemplate.updateFirst(query,update,Expenditure.class);
        }
    }

    public float getExpenditure(String expId){
        Optional<Expenditure> expenditure = expenditureRepository.findById(expId);
        if(expenditure.isPresent()){
            return expenditure.get().getExpAmount();
        }
        return 0;
    }

}
