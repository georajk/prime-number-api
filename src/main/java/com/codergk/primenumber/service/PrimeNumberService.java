package com.codergk.primenumber.service;

import com.codergk.primenumber.exception.PrimeNumberException;
import com.codergk.primenumber.json.PrimeNumberJson;
import com.codergk.primenumber.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Service
public class PrimeNumberService {

    /**
     * Service method for the rest api of prime numbers
     * @param maxNumber argument number
     * @return PrimenumberJson
     * @throws PrimeNumberException
     */
    public PrimeNumberJson getPrimeNumbers(String maxNumber) throws PrimeNumberException {
        PrimeNumberJson primeNumberJson = new PrimeNumberJson();

        if (Utils.isValidNumber(maxNumber)) {
            primeNumberJson.setMaxNumber(Integer.parseInt(maxNumber));
            primeNumberJson.setPrimeNumberList(buildPrimeNumberList(primeNumberJson.getMaxNumber()));
        }

        return primeNumberJson;
    }

    /**
     * Method to build the primenumber list from the given number in the argument
     * @param maxNumber - argument number
     * @return List of prime numbers
     */
    private ArrayList<Integer> buildPrimeNumberList(int maxNumber) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        IntStream.range(0, maxNumber)
                .filter(number -> number>= 2)
                .filter(number -> isPrimeNumber(number))
                .forEach(number -> primeNumbers.add(number));

        return primeNumbers;
    }

    /**
     * Verify that n is a number
     * @param number verify the number
     * @return
     */
    public boolean isPrimeNumber(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }

}
