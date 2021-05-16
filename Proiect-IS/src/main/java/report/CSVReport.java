package report;



import entity.Flower;
import entity.FlowerShop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReport extends Report {
    @Override
    public void generateReport(FlowerShop flowerShop) {
        ArrayList<List<String>> rows = new ArrayList<List<String>>();
        for(Flower fl:flowerShop.getFlowers()) {
            rows.add(  Arrays.asList(fl.getName(),Double.toString(fl.getPrice()),fl.getColor(),fl.getAvailability(),Double.toString(fl.getQuantity())));
        }
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter("new.csv");
            csvWriter.append("Flower type");
            csvWriter.append(" ");
            csvWriter.append("Price");
            csvWriter.append(" ");
            csvWriter.append("Color");
            csvWriter.append(" ");
            csvWriter.append("Availability");
            csvWriter.append(" ");
            csvWriter.append("Quantity");
            csvWriter.append("\n");
            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");

            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
