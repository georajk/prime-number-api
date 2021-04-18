package com.rbs.primenumber.exception;

public class PrimeNumberException extends Exception {

    public final static String PNE01= "PNE:01 Enter a valid max value";
    public final static String PNE02= "PNE:02 Enter a valid number value";
    public final static String PNE03= "PNE:03 Enter a valid number value 2 or above";

    public final static String PNEXX= "PNE:XX Unknown Error";

    public PrimeNumberException() {
    }

    public PrimeNumberException(String message) {
        super(message);
    }

    public PrimeNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrimeNumberException(Throwable cause) {
        super(cause);
    }

    public PrimeNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
