package com.portal.mongo.domain;

import com.portal.mongo.domain.dto.LastModifiedDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Document(collection = "bills")
public class Bill {

    @Id
    @Field("BILL_ID")
    private String billId;

    @Field("BILL_NAME")
    private String billName;

    @Field("BILL_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date billDate;

    @Field("BILL_AMOUNT")
    @Min(value = 0)
    private float billAmount;

    @Field("BILL_PAYMENT_MODE")
    private String billPaymentMode;

    @Field("CASHBACK_ID")
    private String cashBackId;

    @Field("LAST_MODIFIED")
    private LastModifiedDto lastModifiedDto;

}
