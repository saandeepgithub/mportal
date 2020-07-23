package com.portal.mongo.domain;

import com.portal.mongo.domain.dto.LastModifiedDto;
import com.portal.util.Payments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "wallets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallets {

    @Id
    @Field("WALLET_ID")
    private String walletId;

    @Field("WALLET_NAME")
    private Payments walletName;

    @Field("WALLET_AMOUNT")
    private int walletAmount;

    @Field("WALLET_ACTIVE")
    private String walletActive;

    @Field("LAST_MODIFIED")
    private LastModifiedDto lastModifiedDto;
}
