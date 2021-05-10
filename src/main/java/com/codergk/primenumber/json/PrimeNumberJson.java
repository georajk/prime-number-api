package com.codergk.primenumber.json;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class PrimeNumberJson {

    Integer maxNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    ArrayList<Integer> primeNumberList = new ArrayList<>();

    public PrimeNumberJson() {
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public ArrayList<Integer> getPrimeNumberList() {
        return primeNumberList;
    }

    public void setPrimeNumberList(ArrayList<Integer> primeNumberList) {
        this.primeNumberList = primeNumberList;
    }
}
