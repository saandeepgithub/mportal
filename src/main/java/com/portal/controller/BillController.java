package com.portal.controller;

import com.portal.response.GenericResponse;
import com.portal.mongo.domain.Bill;
import com.portal.service.BillService;
import com.portal.util.StaticData;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/bills")
@AllArgsConstructor
public class BillController {

    private BillService billService;

    @PutMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> addBill(@RequestBody Bill bill) {
        Bill savedBill = billService.addBill(bill);
        if (savedBill != null) {
            return new ResponseEntity<>(new GenericResponse(HttpStatus.OK.name(), savedBill.getBillId()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new GenericResponse(HttpStatus.NOT_FOUND.name(), "failed to add bill"), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> saveBill(@RequestBody Bill bill) {
        Bill savedBill = billService.saveBill(bill);
        if (savedBill != null) {
            return new ResponseEntity<>(new GenericResponse(HttpStatus.OK.name(), savedBill.getBillId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new GenericResponse(HttpStatus.NOT_FOUND.name(), "failed to update bill"), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/get/{billId}")
    public ResponseEntity<GenericResponse> viewBill(@PathVariable("billId") String billId) {
        Optional<Bill> viewBill = billService.viewBill(billId);
        if (viewBill.isPresent()) {
            return new ResponseEntity<>(new GenericResponse(HttpStatus.FOUND.name(), viewBill.get()), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(new GenericResponse(HttpStatus.NOT_FOUND.name(), "No Bill Present with billId " + billId), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/allowed")
    public ResponseEntity<GenericResponse> allowedBills() {
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK.name(), StaticData.billMap.keySet()), HttpStatus.OK);
    }

    @GetMapping(value = "/search/all")
    public ResponseEntity<GenericResponse> searchBillId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMM");
        String billIdPrefix = simpleDateFormat.format(new Date()).toUpperCase();
        return new ResponseEntity<>(new GenericResponse(HttpStatus.OK.name(), billService.getAllBillId(billIdPrefix)), HttpStatus.OK);
    }

    @GetMapping(value = "/search/{billId}")
    public ResponseEntity<GenericResponse> searchBill(@PathVariable("billId") String billId) {
        Optional<Bill> optionalBill = billService.getBillByBillId(billId);
        if (optionalBill.isPresent()) {
            return new ResponseEntity<>(new GenericResponse(HttpStatus.OK.name(), optionalBill.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new GenericResponse(HttpStatus.NO_CONTENT.name(), "BILL NOT FOUND"), HttpStatus.NO_CONTENT);
    }
}
