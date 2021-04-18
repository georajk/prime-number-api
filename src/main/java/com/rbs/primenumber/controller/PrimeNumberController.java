package com.rbs.primenumber.controller;

import com.rbs.primenumber.json.PrimeNumberJson;
import com.rbs.primenumber.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class PrimeNumberController {

    @Autowired
    PrimeNumberService primeNumberService;

    @GetMapping("/primeNumbers")
    ResponseEntity<PrimeNumberJson> getPrimeNumbers(@RequestParam(required = false) String value) throws Exception {

        return  new ResponseEntity<>(primeNumberService.getPrimeNumbers(value), HttpStatus.OK);
    }

}
