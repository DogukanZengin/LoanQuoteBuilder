package com.zopa.quote.builder;

import com.zopa.quote.model.Lender;
import com.zopa.quote.model.Quote;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class QuoteBuilder {

    public static Optional<Quote> build(List<Lender> lenders, Integer loanAmount, Integer length){
        return Optional.ofNullable(createQuote(loanAmount,lenders, length));
    }

    private static Quote createQuote(Integer loanAmount, List<Lender>  lenders, Integer length){

        if(lenders.stream().mapToDouble(Lender::getLendAmount).sum() < loanAmount){
            return null;
        }
        Double totalAmount = 0.0d;
        Double increment = 0.0d;
        lenders.sort(Comparator.comparing(Lender::getRate));
        for(Lender lender : lenders){

            Double amountPerLender = loanAmount < increment + lender.getLendAmount() ? lender.getLendAmount() : loanAmount - increment;
            totalAmount += amountPerLender + (amountPerLender * lender.getRate());

            if((increment += amountPerLender) >= loanAmount){
                break;
            }
        }
        Double rate = (totalAmount - loanAmount) / loanAmount;
        Double monthlyRepayment = loanAmount * (1 + rate) / length;
        return new Quote(loanAmount, rate, monthlyRepayment, totalAmount);
    }
}
