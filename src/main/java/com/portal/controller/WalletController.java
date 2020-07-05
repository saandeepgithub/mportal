package com.portal.controller;

import com.portal.response.GenericResponse;
import com.portal.service.WalletService;
import com.portal.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/get/amount/{walletName}")
    public ResponseEntity<GenericResponse> getCurrentWalletAmount(@PathVariable("walletName") String walletName){
        int walletAmount=walletService.getWalletAmount(walletName);
        return new ResponseEntity<>(new GenericResponse("OK",walletAmount),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<GenericResponse> addWallets(){
        walletService.addWallets();
        return new ResponseEntity<>(new GenericResponse("OK","added"),HttpStatus.OK);
    }

}
