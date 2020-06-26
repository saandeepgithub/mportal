package com.portal.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "bill-type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillClassification {

    @Field("_id")
    private String billName;

    @Field("BILL_CLASSIFICATION")
    private String billType;

}
