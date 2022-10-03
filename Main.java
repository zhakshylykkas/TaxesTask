package Lab3_practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        TaxCriteria taxCriteria = new TaxCriteria();
        System.out.println(taxCriteria);

        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.incomeByMonthReader();
        taxCalculator.splitArray();
        taxCalculator.calculateTaxesForYear();
    }

}
