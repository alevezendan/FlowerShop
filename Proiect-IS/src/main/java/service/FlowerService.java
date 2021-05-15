package service;

import entity.Flower;
import entity.FlowerShop;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import repository.FlowerRepo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FlowerService {

    private FlowerRepo flowerRepo;
    public FlowerService(){
        this.flowerRepo=new FlowerRepo();
    }

    public void showErrorDialog(String error){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Error");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(error);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    public void populateFlowerTable(TableView<Flower> flowersTable){
        //usersTable.setVisible(false);
        flowersTable.setVisible(true);
        // flowP.readXMLFile();

        TableColumn type = new TableColumn<Flower,String>("Flower type");
        type.setMinWidth(100);
        type.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn  price = new TableColumn("Price");
        price.setMinWidth(80);
        price.setCellValueFactory(
                new PropertyValueFactory<>("price"));

        TableColumn color= new TableColumn("Color");
        color.setMinWidth(80);
        color.setCellValueFactory(
                new PropertyValueFactory<>("color"));

        //flowersTable.setItems((ObservableList<Flower>) fShop.getFlowers());
        TableColumn  availab= new TableColumn("Availability");
        availab.setMinWidth(100);
        availab.setCellValueFactory(new PropertyValueFactory<>("availability"));

        TableColumn quant= new TableColumn("Quantity");
        quant.setMinWidth(80);
        quant.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn idF= new TableColumn("Shop id");
        idF.setMinWidth(80);
        idF.setCellValueFactory(new PropertyValueFactory<>("flowerShop"));
        flowersTable.getColumns().addAll(type, price, color,availab,quant,idF);

    }
    public void showFlowers(TableView<Flower> flowersTable, FlowerShop flowerShop, ObservableList<Flower> dataF){
        flowersTable.getItems().clear();
        flowersTable.getColumns().clear();
        List<Flower> flowers=null;
        try {
         flowers = flowerRepo.showAllFlowers();
        }catch(Exception e){
            e.printStackTrace();
        }
        for(Flower fl:flowers){
            System.out.println(fl.toString()+"  din showFlowers");
            if(fl.getFlowerShop().getName().equals(flowerShop.getName())) {
                dataF.add(fl);
            }
        }
        populateFlowerTable(flowersTable);
        flowersTable.setItems(dataF);
        //dataF.removeAll();
    }

    public void initCombo(ComboBox<String> combo){
        ObservableList<String> list= FXCollections.observableArrayList();
        list.add("The Flower Studio");
        list.add("Blossom House");
        list.add("Rose and Co");
        list.add("All shops");
        combo.setItems(list);

    }

    public void searchFlowerByName(TableView<Flower> flowersTable, FlowerShop f, ObservableList<Flower> dataF, String flowerName) {
        flowersTable.getItems().clear();
        flowersTable.getColumns().clear();
        List<Flower> flowers=null;
        try {
            flowers = flowerRepo.searchByName(flowerName);
        }catch(Exception e){
            e.printStackTrace();
        }
        for(Flower fl:flowers){
            if(fl.getFlowerShop().getName().equals(f.getName())) {

                dataF.add(fl);
            }

        }
        populateFlowerTable(flowersTable);
        flowersTable.setItems(dataF);

    }

    public void filterFlowers(TextField filterText, ComboBox<String> combo,TableView<Flower> flowersTable, FlowerShop f, ObservableList<Flower> dataF){
       String val="";
       String text="";
        flowersTable.getItems().clear();
        flowersTable.getColumns().clear();
       List<Flower> flowers=null;
        try{
            val=combo.getValue();
            try{
                text=filterText.getText();
                switch(val){
                    case "Name":flowers=flowerRepo.filterByName(text);
                        break;
                    case "Color":flowers=flowerRepo.filterByColor(text);
                        break;
                    case "Price":flowers=flowerRepo.filterByPrice(Double.parseDouble(text));
                        break;
                    case "Availability":flowers=flowerRepo.filterByAvailability(text);
                        break;
                    case "Quantity":flowers=flowerRepo.filterByQuantity(Double.parseDouble(text));
                        break;
                }
                for(Flower fl:flowers){
                    if(fl.getFlowerShop().getName().equals(f.getName())) {

                        dataF.add(fl);
                    }

                }
                populateFlowerTable(flowersTable);
                flowersTable.setItems(dataF);

            }catch(Exception e){
                showErrorDialog("Please introduce filter value!");
            }
        }catch(Exception e){
            showErrorDialog("Please select the criterion!");
        }


    }

    public void viewStatistics(ComboBox<String> comboStat, FlowerShop f, PieChart pieChart, ObservableList<PieChart.Data> pieChartData,RadioButton pie) {

        if(pie.isSelected()){
            switch(comboStat.getValue()){
                case "Price": statPrice(f,pieChart,pieChartData);
                    break;
                case "Quantity": statQuant(f,pieChart,pieChartData);
                    break;
                case "Availability": statAvail(f,pieChart,pieChartData);
                    break;
            }
        }
    }

    public void statAvail(FlowerShop f,PieChart pieChart,  ObservableList<PieChart.Data> pieChartData){
        for(Flower fl:f.getFlowers()){
            double s;
            if(fl.getAvailability().equals("Yes")){
                s=1;
            }
            else{
                s=0;
            }
            pieChartData.add(new PieChart.Data(fl.getName(),s));
        }
        pieChart.setData(pieChartData);
    }

    public void statPrice(FlowerShop f,PieChart pieChart,  ObservableList<PieChart.Data> pieChartData){
        for(Flower fl:f.getFlowers()){

            pieChartData.add(new PieChart.Data(fl.getName(),fl.getPrice()));
        }
        pieChart.setData(pieChartData);
    }

    public void statQuant(FlowerShop f,PieChart pieChart,  ObservableList<PieChart.Data> pieChartData){
        for(Flower fl:f.getFlowers()){

            pieChartData.add(new PieChart.Data(fl.getName(),fl.getQuantity()));
        }
        pieChart.setData(pieChartData);
    }

    public void saveReports(FlowerShop f, CheckBox json, CheckBox csv) {
        if(json.isSelected()){
            saveJSONReports(f);
        }
        if(csv.isSelected()){
            saveCSVReports(f);
        }
    }

    public void saveCSVReports(FlowerShop f){
        ArrayList<List<String>> rows = new ArrayList<List<String>>();
        for(Flower fl:f.getFlowers()) {
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

    public void saveJSONReports(FlowerShop f){
        JSONArray flowerList = new JSONArray();
        for(Flower fl:f.getFlowers()){
            JSONObject jf=new JSONObject();
            jf.put("Flower type",fl.getName());
            jf.put("Price",fl.getPrice());
            jf.put("Color",fl.getColor());
            jf.put("Flower shop id",fl.getFlowerShop().getId());
            jf.put("Availability",fl.getAvailability());
            jf.put("Quantity",fl.getQuantity());
            JSONObject obj=new JSONObject();
            obj.put("Flowers",jf);
            flowerList.add(obj);

        }
        try {
            try (FileWriter file = new FileWriter("flowers.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(flowerList.toJSONString());
                file.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateFlower(TableView<Flower>flowersTable, Flower flower, ObservableList<Flower> dataF, TextField newName, TextField newColor, TextField newPrice,TextField newAvail,TextField newQuant){
        if (!newName.getText().equals("")) {
            flower.setName(newName.getText());
            flowerRepo.updateName(flower,newName.getText());
        }
        if (!newColor.getText().equals("")) {
            flower.setColor(newColor.getText());
            flowerRepo.updateColor(flower,newColor.getText());
        }
        if (!newPrice.getText().equals("")) {
            flower.setPrice(Double.parseDouble(newPrice.getText()));
            flowerRepo.updatePrice(flower,Double.parseDouble(newPrice.getText()));
        }
        if (!newAvail.getText().equals("")) {
            flower.setAvailability(newAvail.getText());
            flowerRepo.updateAvailability(flower,newAvail.getText());
        }

        if (!newQuant.getText().equals("")) {
            flower.setQuantity(Double.parseDouble(newQuant.getText()));
            flowerRepo.updateQuantity(flower,Double.parseDouble(newQuant.getText()));
        }
        flowersTable.getItems().clear();
        List<Flower> flowers=flowerRepo.showAllFlowers();
        for(Flower x:flowers){
            if(x.getFlowerShop().getName().equals(flower.getFlowerShop().getName())){
                dataF.add(x);
            }
        }

        flowersTable.setItems(dataF);
        newName.clear();newColor.clear();newPrice.clear();newAvail.clear();newQuant.clear();
    }

    public void deleteFlower(Flower flower, TableView<Flower> flowerTable, ObservableList<Flower> dataF, FlowerShop f) {

        try {
            //userRepo.deleteUser(u);
            flowerRepo.deleteFlower(flower,flower.getId());

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(f.getName()+" din user service");
        f.deleteFlower(flower);

        flowerTable.getItems().clear();
        flowerTable.getColumns().clear();
        populateFlowerTable(flowerTable);
        //populateUserTable(name,role,username,id);
        try {

            List<Flower> fs = flowerRepo.showAllFlowers();
            dataF.removeAll();
            for(Flower x:fs){

                if(x.getFlowerShop().getName().equals(f.getName())){
                    System.out.println(x.toString());
                    dataF.add(x);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        flowerTable.getColumns().removeAll();
        flowerTable.setItems(dataF);
       // populateFlowerTable(flowerTable);
        //flowerTable.getColumns().addAll(name,role,username,id);
        //flowersTable.setVisible(false);
        flowerTable.setVisible(true);
    }

    public void addFlower(FlowerShop f, TableView<Flower> flowerTable, ObservableList<Flower> dataF, TextField newName, TextField newColor, TextField newPrice, TextField newAvail, TextField newQuant) {
        Random r = new Random();
        int low = 4;
        int high = 1000;
        int id = r.nextInt(high-low) + low;
        //usersTable.getItems().clear();
        Flower flower=new Flower(id,newName.getText(),newColor.getText(),Double.parseDouble(newPrice.getText()),newAvail.getText(),Double.parseDouble(newQuant.getText()),f);
        f.getFlowers().add(flower);
        flowerRepo.insertFlower(flower);
        dataF.add(flower);
        flowerTable.setItems(dataF);

    }
}
