package com.portal.controller;

import com.portal.mongo.domain.CashBack;
import com.portal.mongo.repo.CashBackRepository;
import com.portal.response.GenericResponse;
import com.portal.service.CashbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("cashback/")
public class CashBackController {

    @Autowired
    private CashbackService cashbackService;

    @PutMapping("addrecord")
    public ResponseEntity<GenericResponse> addCashBackRecord(){
        cashbackService.addCashBackRecord();
        return new ResponseEntity<>(new GenericResponse("cashback record added", HttpStatus.OK),HttpStatus.OK);
    }
}
