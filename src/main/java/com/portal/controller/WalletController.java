package com.portal.controller;

import com.portal.response.GenericResponse;
import com.portal.service.WalletService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@AllArgsConstructor
public class WalletController {

    private WalletService walletService;

    @GetMapping("/get/amount/{walletName}")
    public ResponseEntity<GenericResponse> getCurrentWalletAmount(@PathVariable("walletName") String walletName) {
        int walletAmount = walletService.getWalletAmount(walletName);
        return new ResponseEntity<>(new GenericResponse("OK", walletAmount), HttpStatus.OK);
    }

    @PutMapping("/add/{amount}/{walletName}")
    public ResponseEntity<GenericResponse> getWalletAmount(@PathVariable("walletName") String walletName, @PathVariable("amount") float amount) {
        walletService.addMoneyWallet(amount,walletName);
        return new ResponseEntity<>(new GenericResponse("OK", "money added"), HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<GenericResponse> addWallets() {
        walletService.addWallets();
        return new ResponseEntity<>(new GenericResponse("OK", "added"), HttpStatus.OK);
    }

}
