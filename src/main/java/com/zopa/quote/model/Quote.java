package com.zopa.quote.model;

import java.math.BigDecimal;

public class Quote {

    private Integer amount;
    private Double rate;
    private Double monthlyPayment;
    private Double totalPayment;

    public Quote(Integer amount, Double rate, Double monthlyPayment, Double totalPayment) {
        this.amount = amount;
        this.rate = rate;
        this.monthlyPayment = monthlyPayment;
        this.totalPayment = totalPayment;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
