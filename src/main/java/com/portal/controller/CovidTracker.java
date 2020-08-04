package com.portal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.response.GenericResponse;
import com.portal.response.covid.Covid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/covid")
@Profile("prod")
public class CovidTracker {

    @Value("${covid.url}")
    private String covidUrl;

    private RestTemplate covidRestTemplate;

    @GetMapping("/count")
    public ResponseEntity<GenericResponse> getCovidCount() throws JsonProcessingException {
        covidRestTemplate= new RestTemplate();
        String covidJson=covidRestTemplate.getForEntity(covidUrl, String.class).getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        Covid covid=objectMapper.readValue(covidJson,Covid.class);
        System.out.println(covid);
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK.name(),covid),HttpStatus.OK);
    }
}
