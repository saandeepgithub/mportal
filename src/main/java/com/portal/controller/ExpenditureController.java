package com.portal.controller;

import com.portal.response.GenericResponse;
import com.portal.service.ExpenditureService;
import com.portal.util.IdGenerator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenditure")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ExpenditureController {

    private ExpenditureService expenditureService;

    @GetMapping("/current")
    public ResponseEntity<GenericResponse> getExpenditure() {
        String expId = IdGenerator.genExpId();
        float expenditure = expenditureService.getExpenditure(expId);
        return new ResponseEntity<>(new GenericResponse("OK", expenditure), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getExpenditure(@PathVariable("id") String expId) {
        float expenditure = expenditureService.getExpenditure(expId);
        return new ResponseEntity<>(new GenericResponse("OK", expenditure), HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<GenericResponse> addExpenditureRecord(){
        expenditureService.addExpenditureRecord();
        return new ResponseEntity<>(new GenericResponse("OK","success"), HttpStatus.ACCEPTED);
    }
}
