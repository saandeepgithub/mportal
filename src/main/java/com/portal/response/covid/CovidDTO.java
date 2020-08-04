package com.portal.response.covid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CovidDTO {

    private CovidResponse delta;
    private CovidResponse total;
}
