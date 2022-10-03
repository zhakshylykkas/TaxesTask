package Lab3_practice;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Individual {

    private static String fullName;
    private static double incomeFromTheMainJob;
    private static double incomeFromTheAdditionalJob;
    private static double royalty;
    private static double propertySale;
    private static double gift;
    private static double remittance;

    private static double benefitsForChildren;
    private static double otherMaterialSupports;

    ArrayList<Double> incomes = new ArrayList<>();


    void incomesByMonthFileReader() throws IOException {
        FileReader incomesByMonthReader = new FileReader("C:\\Users\\User\\IdeaProjects\\LabWorks\\src\\Lab3_practice\\incomes by month.txt");
        Scanner scannerName = new Scanner(incomesByMonthReader);
        fullName = scannerName.nextLine();

    }

    public String getIndividualDataInMap() {
        return fullName + " : " + incomes;
    }

    public String getFullName() {
        return fullName;
    }

    public double getIncomeFromTheMainJob() {
        return incomeFromTheMainJob;
    }

    public double getIncomeFromTheAdditionalJob() {
        return incomeFromTheAdditionalJob;
    }

    public double getRoyalty() {
        return royalty;
    }

    public double getPropertySale() {
        return propertySale;
    }

    public double getGift() {
        return gift;
    }

    public double getRemittance() {
        return remittance;
    }

    public double getBenefitsForChildren() {
        return benefitsForChildren;
    }

    public double getOtherMaterialSupports() {
        return otherMaterialSupports;
    }
}
