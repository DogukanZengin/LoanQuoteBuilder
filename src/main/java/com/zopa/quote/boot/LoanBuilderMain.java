package com.zopa.quote.boot;

import com.zopa.quote.builder.QuoteBuilder;
import com.zopa.quote.helper.LenderMapper;
import com.zopa.quote.model.Lender;
import com.zopa.quote.model.Quote;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public class LoanBuilderMain {

    private static final Integer UPPER_LIMIT = 15000;
    private static final Integer LOWER_LIMIT = 1000;
    private static final Integer MULTITUDE = 100;
    private static final Integer LOAN_LENGTH = 36;
    private static DecimalFormat DF = new DecimalFormat("#.####");

    public static void main(String[] args) throws IllegalArgumentException, IOException {
        if(args.length < 2){
            throw new IllegalArgumentException("Please provide both market data and loan amount!");
        }

        String marketDataPath = args[0];
        Integer loanAmount = Integer.valueOf(args[1]);
        loanAmountValidator(loanAmount);

        List<Lender> lenders = LenderMapper.map(marketDataPath);

        Optional<Quote> optionalQuote = QuoteBuilder.build(lenders,loanAmount,LOAN_LENGTH);

        if(optionalQuote.isPresent()){
            DF.setRoundingMode(RoundingMode.CEILING);
            Quote quote = optionalQuote.get();
            System.out.println("Requested amount: " + quote.getAmount());
            System.out.println("Rate: " + DF.format(quote.getRate()) + "%");
            System.out.println("Monthly repayment: " + DF.format(quote.getMonthlyPayment()));
            System.out.println("Total repayment: " + DF.format(quote.getTotalPayment()));
        }else{
            System.out.println("We are sorry, we are not able to provide a quote at this time");
        }
    }

    private static void loanAmountValidator(Integer loanAmount){

        if(loanAmount < LOWER_LIMIT || loanAmount > UPPER_LIMIT){
            throw new IllegalArgumentException("Loan amount must between 1000 and 15000 !");
        }

        if(loanAmount % MULTITUDE != 0){
            throw new IllegalArgumentException("Loan amount must be multitude of 100 !");
        }
    }
}
