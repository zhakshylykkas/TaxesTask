package Lab3_practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

public class TaxCalculator {

    String[] incomeNames = {"основного места работы", "дополнительного места работы", "авторского вознаграждения",
            "продажи имущества", "подарка", "переводов из-за границы",
            "льгот на детей", "других материальных помощей"};

    ArrayList<String> incomesByMonthInArrayList = new ArrayList<>();
    public void incomeByMonthReader() throws IOException{
        FileReader incomeByMonthReader = new FileReader("C:\\Users\\User\\IdeaProjects\\LabWorks\\src\\Lab3_practice\\incomes by month.txt");
        Scanner someSn = new Scanner(incomeByMonthReader);

        String line;

        String[] incomeElByMonth = new String[8];

        while (someSn.hasNextLine()) {

            line = someSn.nextLine();

            incomeElByMonth = line.split(";");

            incomesByMonthInArrayList.add(Arrays.toString(incomeElByMonth));

        }

        if (someSn.hasNextLine()){
            line = someSn.nextLine();
        }
    }

    String[] incomesInDouble2;
    double[][] incomesInDouble;
    ArrayList<Double> doubleSplitArrayList = new ArrayList<>();
    void splitArray() throws IOException {

        ArrayList<String> splitArrayList = new ArrayList<>(incomesByMonthInArrayList);
        String[] splitArray = new String[incomesByMonthInArrayList.size()];

        ArrayList<String> doubleSplitArrayList2 = new ArrayList<>();

        int n=0;
        while (n< splitArrayList.size()){
            splitArray = splitArrayList.get(n).split(" ");

            doubleSplitArrayList = new ArrayList<>();
            int i=0, j=0;
            while (i< splitArray.length){

                try {
                    doubleSplitArrayList.add(Double.parseDouble(splitArray[i]));

                } catch (NumberFormatException e) {
                    i++;
                    continue;
                }
                i++;
            }

            doubleSplitArrayList2.add(String.valueOf(doubleSplitArrayList));

            n++;
        }


        String[] incomes2 = new String[doubleSplitArrayList2.size()];
        for (int i = 0; i < incomes2.length; i++) {
            incomes2[i] = doubleSplitArrayList2.get(i);
        }

        incomesInDouble = new double[incomes2.length][doubleSplitArrayList.size()];
        incomesInDouble2 = new String[incomesByMonthInArrayList.size()];

        for (int i = 0; i < incomesInDouble.length; i++) {
            for (int j = 0; j < doubleSplitArrayList.size(); j++) {
                incomesInDouble2 = incomes2[i].replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s ", "").split(", ");

                try {
                    incomesInDouble[i][j] = Double.parseDouble(incomesInDouble2[j]);
                } catch (Exception e){
                    continue;
                }

            }
        }
    }

    void calculateTaxesForYear() throws IOException{

        TaxCriteria taxCriteria = new TaxCriteria();
        Individual individual = new Individual();


        double incomeFromTheMainJobForYearAfterTaxes =0;

        ArrayList<Double> incomesInArray = new ArrayList<>();
        double[] incomesInDoubleArray = new double[doubleSplitArrayList.size()];

        for (int l = 0; l < incomesInDouble.length; l++) {
            for (int i = 0; i < incomesInDouble[l].length; i++) {
                incomeFromTheMainJobForYearAfterTaxes = 0;
                for (int j = 0; j < incomesInDouble.length; j++) {
                    incomeFromTheMainJobForYearAfterTaxes += incomesInDouble[j][i];
                }

                for (int t = 0; t < incomesInDoubleArray.length; t++) {
                    incomesInDoubleArray[i] = incomeFromTheMainJobForYearAfterTaxes;
                }
            }
        }

        individual.incomesByMonthFileReader();

        String incomesAfterTaxesFilePath = "C:\\Users\\User\\IdeaProjects\\LabWorks\\src\\Lab3_practice\\Incomes after taxes.txt";
        FileWriter incomesAfterTaxesWriter = new FileWriter(incomesAfterTaxesFilePath);
        incomesAfterTaxesWriter.write(individual.getFullName() + "\n\n");
        System.out.println("\n" + individual.getFullName() + "\n");

        for (int i = 0; i < incomesInDoubleArray.length; i++) {
            Formatter formatter = new Formatter();
            Formatter sout = formatter.format("Доход за год с %s до уплаты налогов: " + incomesInDoubleArray[i], incomeNames[i]);
            incomesAfterTaxesWriter.write(sout + "\n");

            System.out.println(sout);
        }

        incomesAfterTaxesWriter.write("\n");
        System.out.println("\n");

        for (int j = 0; j < incomesInDoubleArray.length; j++) {
            Formatter formatter = new Formatter();
            Formatter sout2 = formatter.format("Доход за год с %s после уплаты налогов: " + (incomesInDoubleArray[j]-(incomesInDoubleArray[j]*taxCriteria.taxes2.get(j))), incomeNames[j]);
            incomesAfterTaxesWriter.write(sout2 + "\n");

            System.out.println(sout2);
        }

        incomesAfterTaxesWriter.close();
    }
}
