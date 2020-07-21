package com.portal.mongo.domain;

import com.portal.mongo.domain.dto.LastModifiedDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cashback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashBack {

    @Id
    @Field("CASHBACK_ID")
    private String cashBackId;

    @Field("CASHBACK_AMOUNT")
    private int cashBackAmount;

    @Field("ACTIVE_STATUS")
    private String activeStatus;

    @Field("LAST_MODIFIED")
    private LastModifiedDto lastModifiedDto;
}
