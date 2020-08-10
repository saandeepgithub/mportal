package com.portal.controller;

import com.portal.response.covid.Covid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/covid")
@Profile("prod")
public class CovidTracker {

    @Value("${covid.url}")
    private String covidUrl;

    private RestTemplate covidRestTemplate;

    @GetMapping("/count")
    public Object getCovidCount()  {
        covidRestTemplate= new RestTemplate();
        LinkedHashMap<String,Object> covidJson=covidRestTemplate.getForEntity(covidUrl, LinkedHashMap.class).getBody();
        return covidJson;
        //return new ResponseEntity<>(new GenericResponse(HttpStatus.OK.name(),covidJson),HttpStatus.OK);
    }
}
