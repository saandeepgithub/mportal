package com.portal.controller;

import com.portal.mongo.domain.Wallets;
import com.portal.response.GenericResponse;
import com.portal.service.WalletService;

import com.portal.util.Payments;
import com.portal.util.StaticData;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/wallet")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class WalletController {

    private WalletService walletService;

    @GetMapping("/get/amount/{walletName}")
    public ResponseEntity<GenericResponse> getCurrentWalletAmount(@PathVariable("walletName") String walletName) {
        int walletAmount = walletService.getWalletAmount(walletName);
        return new ResponseEntity<>(new GenericResponse("OK", walletAmount), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<GenericResponse> getAllWalletsInfo() {
        List<Wallets> walletsList = walletService.getAllWalletsInfo();
        Map<String, Integer> walletMap = new TreeMap<>();
        walletsList.forEach(wallet -> {
            walletMap.put(StaticData.walletMap.get(wallet.getWalletName()), wallet.getWalletAmount());
        });
        return new ResponseEntity<>(new GenericResponse("OK", walletMap), HttpStatus.OK);
    }

    @PutMapping("/add/{amount}/{walletName}")
    public ResponseEntity<GenericResponse> getWalletAmount(@PathVariable("walletName") String walletName, @PathVariable("amount") float amount) {
        walletService.addMoneyWallet(amount, walletName);
        return new ResponseEntity<>(new GenericResponse("OK", "money added"), HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<GenericResponse> addWallets() {
        walletService.addWallets();
        return new ResponseEntity<>(new GenericResponse("OK", "added"), HttpStatus.OK);
    }

}
