package com.codergk.primenumber.utils;

import com.codergk.primenumber.exception.PrimeNumberException;

public class Utils {

    /**
     * Uility method to validate the number
     * @param value
     * @return
     * @throws PrimeNumberException
     */
    public static boolean isValidNumber(String value) throws PrimeNumberException {

        try{
            int maxNumber = Integer.parseInt(value);
            if (maxNumber < 2) {
                throw new PrimeNumberException(PrimeNumberException.PNE03);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new PrimeNumberException(PrimeNumberException.PNE02);
        } catch (PrimeNumberException primeNumberException) {
            throw new PrimeNumberException(PrimeNumberException.PNE03);
        } catch (Exception exception) {
            throw new PrimeNumberException(PrimeNumberException.PNEXX);
        }

        return true;

    }
}
