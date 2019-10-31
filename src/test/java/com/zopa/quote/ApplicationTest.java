package com.zopa.quote;

import com.zopa.quote.boot.LoanBuilderMain;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ApplicationTest {

    @Test
    public void givenCSVFile_WhenRead_ThenContentsAsExpected(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMissingParameters_ThenThrowException() throws Exception{
        String[] args = {"1000"};
        LoanBuilderMain.main(args);
    }

    @Test(expected = FileNotFoundException.class)
    public void whenMarketDataNotFound_ThenThrowException() throws Exception{
        String[] args = {"NoFile.csv", "1000"};
        LoanBuilderMain.main(args);
    }

    @Test
    public void whenLoanAmountExceedsLendAmount_ThenDisplayNoQuote(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLowerAmount_ThenThrowException() throws Exception{
        String args[] = {"market-data.csv", "999"};
        LoanBuilderMain.main(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenUpperAmount_ThenThrowException() throws Exception{
        String args[] = {"market-data.csv", "15001"};
        LoanBuilderMain.main(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncrementValueWrong_ThenThrowException() throws Exception{
        String args[] = {"market-data.csv", "1001"};
        LoanBuilderMain.main(args);
    }

}
