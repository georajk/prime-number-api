package com.rbs.primenumber.service;

import com.rbs.primenumber.exception.PrimeNumberException;
import com.rbs.primenumber.json.PrimeNumberJson;
import com.rbs.primenumber.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        for (int i = 1; i <= maxNumber; i++) {
            if (isPrimeNumber(i))
                primeNumbers.add(i);
        }
        return primeNumbers;
    }

    /**
     * Verify that n is a number
     * @param n verify the number
     * @return
     */
    public boolean isPrimeNumber(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        else if (n % 2 == 0)
            return false;
        else {
            int mid = (int) Math.sqrt(n);
            for (int i = 2; i <= mid; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

}
