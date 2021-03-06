package com.portal.mongo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastModifiedDto {

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date lastModifiedDate;
}
