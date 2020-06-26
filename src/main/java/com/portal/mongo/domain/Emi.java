package com.portal.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Document(collection = "emi")
public class Emi {

    @Id
    @Field("EMI_ID")
    private String emiId;

    @Field("EMI_NAME")
    private String emiName;

    @Field("EMI_AMOUNT")
    @Min(value = 0)
    private float expAmount;

    @Field("EMI_ACK")
    private boolean emiAck;

    @Field("LAST_MODIFIED_DATE")
    private LastModifiedDate lastModifiedDate;
}
