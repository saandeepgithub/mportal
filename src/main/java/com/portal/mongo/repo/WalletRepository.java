package com.portal.mongo.repo;

import com.portal.mongo.domain.Wallets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends MongoRepository<Wallets, String> {

    @Query("{'walletActive':'Y','walletName':?0}")
    public Optional<Wallets> getWalletAmount(String walletName);
}
