package com.portal.controller;

import com.portal.response.GenericResponse;
import com.portal.service.CashbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashback")
@CrossOrigin(origins = "*")
public class CashBackController {

    @Autowired
    private CashbackService cashbackService;

    @PostMapping("/admin/add")
    public ResponseEntity<GenericResponse> addCashBackRecord(){
       cashbackService.addCashBackRecord();
       return new ResponseEntity<>(new GenericResponse("OK","cashback record added successfully"), HttpStatus.ACCEPTED);
    }
}
