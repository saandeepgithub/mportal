package com.portal.controller;

import com.portal.mongo.domain.Groceries;
import com.portal.response.GenericResponse;
import com.portal.service.GroceriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groceri")
@CrossOrigin(origins = "*")
public class GroceriController {

    @Autowired
    private GroceriesService groceriesService;

    @PostMapping("/add")
    public ResponseEntity<GenericResponse> addNewGroceriItem(@RequestBody Groceries groceries) {
        Groceries savedGroceries = groceriesService.addGroceri(groceries);
        if (savedGroceries != null) {
            return new ResponseEntity<>(new GenericResponse("OK", groceries.getGroceriId()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new GenericResponse("FAILED", "FAILED"), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<GenericResponse> updateGroceriItem(@RequestBody Groceries groceries) {
        Groceries savedGroceries = groceriesService.updateGroceri(groceries);
        if (savedGroceries.getGroceriId() != null) {
            return new ResponseEntity<>(new GenericResponse("OK", "UPDATED"), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new GenericResponse("FAILED", "FAILED"), HttpStatus.OK);
    }

    @PutMapping("/ack/{id}")
    public ResponseEntity<GenericResponse> ackGroceri(@PathVariable("id") String groceriId) {
        groceriesService.ackGroceri(groceriId);
        return new ResponseEntity<>(new GenericResponse("OK", "Y"), HttpStatus.OK);
    }

    @PutMapping("/purchase/{id}")
    public ResponseEntity<GenericResponse> purchaseGroceri(@PathVariable("id") String groceriId) {
        groceriesService.purchaseGroceri(groceriId);
        return new ResponseEntity<>(new GenericResponse("OK", "Y"), HttpStatus.OK);
    }

    @GetMapping("/display/new")
    public ResponseEntity<GenericResponse> newGroceries() {
        List<Groceries> groceriList = groceriesService.getAllNewGroceries();
        return new ResponseEntity<>(new GenericResponse("OK", groceriList), HttpStatus.OK);
    }

    @GetMapping("/display/ack")
    public ResponseEntity<GenericResponse> acknowledgedGroceries() {
        List<Groceries> groceriList = groceriesService.getAllAckedGroceries();
        return new ResponseEntity<>(new GenericResponse("OK", groceriList), HttpStatus.OK);
    }

    @GetMapping("/display/purchased")
    public ResponseEntity<GenericResponse> purchasedGroceries() {
        List<Groceries> groceriList = groceriesService.getAllPurchasedGroceries();
        if (groceriList.size() > 30) {
            return new ResponseEntity<>(new GenericResponse("OK", groceriList.subList(0, 30)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new GenericResponse("OK", groceriList), HttpStatus.OK);
    }

    @GetMapping("/details/{name}")
    public ResponseEntity<GenericResponse> getGroceriInfo(@PathVariable("name") String name) {
        List<Groceries> groceriList = groceriesService.getGroceries(name);
        return new ResponseEntity<>(new GenericResponse("OK", groceriList), HttpStatus.OK);
    }
}
