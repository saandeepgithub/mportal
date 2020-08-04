package com.portal.response.covid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidResponse {

    private String confirmed;
    private String deceased;
    private String recovered;
}
