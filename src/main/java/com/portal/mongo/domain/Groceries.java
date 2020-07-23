package com.portal.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "groceries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groceries {

    @Field("_id")
    private String groceriId;

    @Field("GROCERI_NAME")
    private String groceriName;

    @Field("MONTH")
    private String month;

    @Field("QUANTITY")
    private String quantity;

    @Field("ACK")
    private String ack;

    @Field("PURCHASED")
    private String purchased;
}
