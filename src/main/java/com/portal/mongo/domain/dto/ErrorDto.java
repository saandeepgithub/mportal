package com.portal.mongo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private String errorClassName;

    private String errorMessage;

    private String errorException;

    private LastModifiedDto lastModifiedDto;
}
