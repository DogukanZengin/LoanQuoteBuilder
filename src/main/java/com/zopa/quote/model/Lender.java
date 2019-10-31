package com.zopa.quote.model;

public class Lender {
    private String name;
    private Integer lendAmount;
    private Double rate;

    public Lender(String name, Integer lendAmount, Double rate) {
        this.name = name;
        this.lendAmount = lendAmount;
        this.rate = rate;
    }

    public Lender() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLendAmount() {
        return lendAmount;
    }

    public void setLendAmount(Integer lendAmount) {
        this.lendAmount = lendAmount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
