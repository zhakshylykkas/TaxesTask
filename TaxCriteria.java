package Lab3_practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaxCriteria {

    ArrayList<Double> allTaxesInArrayList = new ArrayList<>();

    private double taxFromTheIncomeFromTheMainJob;
    private double taxFromTheIncomeFromTheAdditionalJob;
    private double taxFromTheRoyalty;
    private double taxFromThePropertySale;
    private double taxFromTheGift;
    private double taxFromTheRemittance;
    private double taxFromTheBenefitsForChildren;
    private double taxFromTheOtherMaterialSupports;

    public TaxCriteria() throws IOException{
        taxCriteriaFileReader();
    }

    public ArrayList<Double> getAllTaxesInArrayList() {
        return allTaxesInArrayList;
    }

    public double getTaxFromTheIncomeFromTheMainJob() {
        return taxFromTheIncomeFromTheMainJob;
    }

    public double getTaxFromTheIncomeFromTheAdditionalJob() {
        return taxFromTheIncomeFromTheAdditionalJob;
    }

    public double getTaxFromTheRoyalty() {
        return taxFromTheRoyalty;
    }

    public double getTaxFromThePropertySale() {
        return taxFromThePropertySale;
    }

    public double getTaxFromTheGift() {
        return taxFromTheGift;
    }

    public double getTaxFromTheRemittance() {
        return taxFromTheRemittance;
    }

    public double getTaxFromTheBenefitsForChildren() {
        return taxFromTheBenefitsForChildren;
    }

    public double getTaxFromTheOtherMaterialSupports() {
        return taxFromTheOtherMaterialSupports;
    }


    ArrayList<Double> taxes2 = new ArrayList<>();
    public void taxCriteriaFileReader() throws IOException {

        allTaxesInArrayList.add(taxFromTheIncomeFromTheMainJob);
        allTaxesInArrayList.add(taxFromTheIncomeFromTheAdditionalJob);
        allTaxesInArrayList.add(taxFromTheRoyalty);
        allTaxesInArrayList.add(taxFromThePropertySale);
        allTaxesInArrayList.add(taxFromTheGift);
        allTaxesInArrayList.add(taxFromTheRemittance);
        allTaxesInArrayList.add(taxFromTheBenefitsForChildren);
        allTaxesInArrayList.add(taxFromTheOtherMaterialSupports);

//        allTaxesInArray = new double[allTaxesInArrayList.size()];
//        for (int i = 0; i < allTaxesInArray.length; i++) {
//            allTaxesInArray[i] = allTaxesInArrayList.get(i);
//        }

        String taxCriteriaFilePath = "C:\\Users\\User\\IdeaProjects\\LabWorks\\src\\Lab3_practice\\Tax Criteria";

        FileReader taxCriteriaReader = new FileReader(taxCriteriaFilePath);
        Scanner sn = new Scanner(taxCriteriaReader);

        String line;
        while (sn.hasNextLine()) {
            line = sn.next();
            String[] taxEl = line.split(" {2}");

            for (int i=0; i< taxEl.length; i++){
                taxes2.add(Double.valueOf(taxEl[i]));
            }


            if (sn.hasNext()){
                line = sn.nextLine();
            }
        }

        taxCriteriaReader.close();

        for (int i = 0; i < allTaxesInArrayList.size(); i++) {
            allTaxesInArrayList.set(i, taxes2.get(i));
        }
    }

    @Override
    public String toString() {

        return "Налог с основного места работы:  " + allTaxesInArrayList.get(0) + "\n" +
                "Налог с дополнительного места работы:  " + allTaxesInArrayList.get(1) + "\n" +
                "Налог с авторского вознаграждения:  " + allTaxesInArrayList.get(2) + "\n" +
                "Налог с продажи имущества:  " + allTaxesInArrayList.get(3) + "\n" +
                "Налог с подарка:  " + allTaxesInArrayList.get(4) + "\n" +
                "Налог с перевода из-за границы:  " + allTaxesInArrayList.get(5) + "\n" +
                "Налог с льготы на детей:  " + allTaxesInArrayList.get(6) + "\n" +
                "Налог с материальной помощи:  " + allTaxesInArrayList.get(7) + "\n";
    }
}
