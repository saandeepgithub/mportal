package com.portal.service;

import com.portal.mongo.domain.Wallets;
import com.portal.mongo.domain.dto.LastModifiedDto;
import com.portal.mongo.repo.WalletRepository;
import com.portal.util.IdGenerator;
import com.portal.util.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WalletService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private WalletRepository walletRepository;


    public void addMoneyWallet(float walletAmount, String walletName) {
        Criteria walletIdCriteria = Criteria.where("walletId").is(IdGenerator.genWalletId(walletName));
        Criteria activeStatusCriteria = Criteria.where("walletActive").is("Y");
        Query query = new Query(walletIdCriteria.andOperator(activeStatusCriteria));
        Update update = new Update().inc("walletAmount", walletAmount);
        mongoTemplate.updateFirst(query, update, Wallets.class);
    }

    public void addCashBack(float walletAmount, String walletName) {
        Query query = new Query(Criteria.where("walletId").is(IdGenerator.genWalletId(walletName)));
        Update update = new Update().inc("walletAmount", walletAmount);
        mongoTemplate.updateFirst(query, update, Wallets.class);
    }

    public void payFromWallet(float walletAmount, String walletName) {
        Query query = new Query(Criteria.where("walletId").is(IdGenerator.genWalletId(walletName)));
        Update update = new Update().inc("walletAmount", (int) walletAmount * (-1));
        mongoTemplate.updateFirst(query, update, Wallets.class);
    }

    public void addWallets() {
        StaticData.walletMap.forEach((key, value) -> {
            String walletId = IdGenerator.genWalletId(value);
            Wallets wallets = new Wallets();
            wallets.setWalletName(key.name());
            wallets.setLastModifiedDto(new LastModifiedDto());
            wallets.setWalletId(walletId);
            wallets.setWalletActive("Y");
            wallets.setWalletAmount(getWalletAmount(key.name()));
            LastModifiedDto lastModifiedDto = new LastModifiedDto();
            lastModifiedDto.setLastModifiedDate(new Date(System.currentTimeMillis()));
            lastModifiedDto.setLastModifiedBy("admin");
            wallets.setLastModifiedDto(lastModifiedDto);
            deActivateWallet(key.name());
            walletRepository.insert(wallets);
        });
    }

    public int getWalletAmount(String walletName) {
        Optional<Wallets> wallet = walletRepository.getWalletAmount(walletName);
        if (wallet.isPresent()) {
            return wallet.get().getWalletAmount();
        }
        return 0;
    }

    private void deActivateWallet(String walletName) {
        Criteria walletNameCriteria = Criteria.where("walletName").is(walletName);
        Criteria walletActiveCriteria = Criteria.where("walletActive").is("Y");
        Query query = new Query(new Criteria().andOperator(walletNameCriteria, walletActiveCriteria));
        Update update = new Update().push("walletActive", "N");
        mongoTemplate.updateFirst(query, update, Wallets.class);
    }
}
