package service;

import entity.Flower;
import entity.FlowerShop;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FlowerService {


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
        availab.setCellValueFactory(new PropertyValueFactory<>("disp"));

        TableColumn quant= new TableColumn("Quantity");
        quant.setMinWidth(80);
        quant.setCellValueFactory(new PropertyValueFactory<>("quant"));

        TableColumn idF= new TableColumn("Shop id");
        idF.setMinWidth(80);
        idF.setCellValueFactory(new PropertyValueFactory<>("ids"));
        flowersTable.getColumns().addAll(type, price, color,availab,quant,idF);

    }
    public void showFlowers(TableView<Flower> flowersTable, FlowerShop flowerShop, ObservableList<Flower> dataF){
        flowersTable.getItems().clear();
        flowersTable.getColumns().clear();
        // String n=TheFlowerStudio.getText();

        //  FlowerShop f=flowsP.getFlowerShop("The Flower Studio");
        for(Flower fl:flowerShop.getFlowers()){
            dataF.add(fl);
        }
        populateFlowerTable(flowersTable);
        flowersTable.setItems(dataF);
        dataF.removeAll();
    }
}
