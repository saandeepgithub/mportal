package com.portal.mongo.domain;

import com.portal.mongo.domain.dto.LastModifiedDto;
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
@Document(collection = "expenditure")
public class Expenditure {

    @Id
    @Field("EXPENDITURE_ID")
    private String expId;

    @Field("EXPENDITURE_AMOUNT")
    @Min(value = 0)
    private float expAmount;

    @Field("ACTIVE_STATUS")
    private String activeStatus;

    @Field("LAST_MODIFIED")
    private LastModifiedDto lastModifiedDto;
}
