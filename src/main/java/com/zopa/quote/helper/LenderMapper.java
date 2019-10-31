package com.zopa.quote.helper;

import com.zopa.quote.model.Lender;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class LenderMapper {

    private static String[] HEADERS = {"Lender","Rate","Available"};
    public static List<Lender> map(String filePath) throws IOException {

        List<Lender> lenderList = new ArrayList<>();
        Reader in = new FileReader(filePath);

        Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.withHeader(HEADERS).withFirstRecordAsHeader().parse(in);
        for(CSVRecord record : csvRecords){
            Lender lender = new Lender();
            lender.setName(record.get("Lender"));
            lender.setLendAmount(Integer.valueOf(record.get("Available")));
            lender.setRate(Double.valueOf(record.get("Rate")));
            lenderList.add(lender);
        }
        return lenderList;
    }
}
