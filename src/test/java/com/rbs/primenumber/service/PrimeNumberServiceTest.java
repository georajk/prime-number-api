package com.rbs.primenumber.service;

import com.rbs.primenumber.exception.PrimeNumberException;
import com.rbs.primenumber.json.PrimeNumberJson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PrimeNumberServiceTest {

    @Autowired
    PrimeNumberService primeNumberService;

    @Test
    void getPrimeNumbersValid() throws Exception {
        PrimeNumberJson primeNumberJson = primeNumberService.getPrimeNumbers("10");
        assertEquals(4, primeNumberJson.getPrimeNumberList().size());
    }

    @Test
    void getPrimeNumbersInValid() throws Exception {
        PrimeNumberException primeNumberException = assertThrows(PrimeNumberException.class,
                () -> primeNumberService.getPrimeNumbers("aaa"));
        assertEquals(PrimeNumberException.PNE02, primeNumberException.getMessage());
    }

    @Test
    void getPrimeNumbersWithNull() throws Exception {
        PrimeNumberException primeNumberException = assertThrows(PrimeNumberException.class,
                () -> primeNumberService.getPrimeNumbers(null));
        assertEquals(PrimeNumberException.PNE02, primeNumberException.getMessage());
    }

    @Test
    void getPrimeNumbersWithNegative() throws Exception {
        PrimeNumberException primeNumberException = assertThrows(PrimeNumberException.class,
                () -> primeNumberService.getPrimeNumbers("-1"));
        assertEquals(PrimeNumberException.PNE03, primeNumberException.getMessage());
    }
}
