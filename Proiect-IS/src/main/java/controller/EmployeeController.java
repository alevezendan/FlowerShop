package controller;

import model.Language;
import service.FlowerService;

import entity.Flower;
import entity.FlowerShop;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import service.FlowerShopService;
import service.UserService;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;


public class EmployeeController extends Controller implements Initializable {

    private ObservableList<Flower> dataF;
    private User u;
    private FlowerShop f;
    private Stage stage;
    private Language language;

    private FlowerService flowS;
    private FlowerShopService flowsS;
    // private FlowerMapper flowerMapper;
    private FlowerController flowerController;
    private UserService userService;

    @FXML
    private TextField newName;

    @FXML
    private TextField filterText;

    @FXML
    private TextField newPrice;

    @FXML
    private TextField newColor;

    @FXML
    private TextField newAvail;

    @FXML
    private TextField newQuant;

    @FXML
    private TableView<Flower> flowerTable;

    @FXML
    private TextField searchName;
    @FXML
    private ComboBox<String> comboFilter;
    @FXML
    private ComboBox<String> comboStat;
    @FXML
    private PieChart pieChart;
    @FXML
    private RadioButton pie;

    @FXML
    private Button logOut;
    @FXML
    private CheckBox csv;

    @FXML
    private CheckBox json;
    @FXML
    private Button ViewF;

    @FXML
    private Button Filter;

    @FXML
    private Button Search;

    @FXML
    private Button ViewS;

    @FXML
    private Button Add;

    @FXML
    private Button Update;

    @FXML
    private Button Delete;

    @FXML
    private Button SaveR;
    //public void init(LogInController mainGUI){
    //this.loginGUI=mainGUI;
    // }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //userService=new UserService();

        language=new Language();
        flowerController=new FlowerController();
        flowsS=new FlowerShopService();
        //stage = (Stage) logOut.getScene().getWindow();
        dataF= FXCollections.observableArrayList();
        //f=u.getFlowerShop();
        flowerTable.getSelectionModel (). setCellSelectionEnabled (true);
       // u=flowerController.getUserService().getU(stage.getTitle());
       // switchLanguage();
        initCombo();
        //init();
    }

    public void init(){
        stage = (Stage) logOut.getScene().getWindow();
      //  System.out.println(stage.getTitle()+" stage title");
        u=flowerController.getUserService().getU(stage.getTitle());

       // System.out.println(u.getUsername()+" username");
        f=u.getFlowerShop();
        System.out.println(u.getLanguage()+"din init");
       // switchLanguage(u.getLanguage());
    }

    @FXML
    void refreshOnAction(ActionEvent event) {
        init();
        switchLanguage(u.getLanguage());
    }
    public void switchLanguage(String s){
        switch(s){
            case "French":language.changeToEmployeeFrench(ViewF,Search,Filter,ViewS,SaveR,Add,Update,Delete,logOut,comboFilter,comboStat,newName,newColor,newPrice,newAvail,newQuant);
                break;
            case "Turkish":language.changeToEmployeeTurkish(ViewF,Search,Filter,ViewS,SaveR,Add,Update,Delete,logOut,comboFilter,comboStat,newName,newColor,newPrice,newAvail,newQuant);
                break;
            case "Romanian":language.changeToEmployeeRo(ViewF,Search,Filter,ViewS,SaveR,Add,Update,Delete,logOut,comboFilter,comboStat,newName,newColor,newPrice,newAvail,newQuant);
                break;

        }
    }
    public void showErrorDialog(String error){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Error");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(error);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    @FXML
    void viewOnAction(ActionEvent event) {
        init();
        System.out.println(f.getName());
        flowerController.getFlowerService().showFlowers(flowerTable,f,dataF);

    }

    @FXML
    void searchOnAction(ActionEvent event) {
        init();
        String flowerName=searchName.getText();
        flowerController.getFlowerService().searchFlowerByName(flowerTable,f,dataF,flowerName);
        // flowP.searchFlower(flowerTable,flowerName,dataF,f);

    }
    @FXML
    void addOnAction(ActionEvent event) {
        init();

       flowerController.getFlowerService().addFlower(f,flowerTable,dataF,newName,newColor,newPrice,newAvail,newQuant);

    }

    public void clear(){
        newName.clear();
        newPrice.clear();
        newColor.clear();
        newAvail.clear();
        newQuant.clear();
    }
    @FXML
    void logOutOnAction(ActionEvent event) {
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        init();
        Flower flower = flowerTable.getSelectionModel().getSelectedItem();
        try {
            flowerController.getFlowerService().deleteFlower(flower,flowerTable,dataF,f);
        }catch(Exception e){
            showErrorDialog("Please select the item that you want to delete!");
        }

    }

    @FXML
    void filterOnAction(ActionEvent event) {
        init();
        flowerController.getFlowerService().filterFlowers(filterText,comboFilter,flowerTable,f,dataF);

    }

   @FXML
    void saveReportOnAction(ActionEvent event) {
        init();
        flowerController.getFlowerService().saveReports(f,json,csv);

    }




    @FXML
    void updateOnAction(ActionEvent event) {
        init();
        dataF = flowerTable.getItems();
        Flower flower = flowerTable.getSelectionModel().getSelectedItem();
       flowerController.getFlowerService().updateFlower(flowerTable,flower,dataF,newName,newColor,newPrice,newAvail,newQuant);

    }



    @FXML
    void viewStatisticsOnAction(ActionEvent event) {
        init();
        ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
        pieChart.setVisible(true);
        flowerController.getFlowerService().viewStatistics(comboStat,f,pieChart,pieChartData,pie);
    }


    @FXML
    void comboFOnAction(ActionEvent event) {
    }
    @FXML
    void comboStatOnAction(ActionEvent event) {
    }
    public void initCombo(){
       ObservableList<String> list1=FXCollections.observableArrayList();
        list1.add("Name");
        list1.add("Price");
        list1.add("Color");
        list1.add("Availability");
        list1.add("Quantity");
       comboFilter.setItems(list1);
        ObservableList<String> list2=FXCollections.observableArrayList();
        list2.add("Price");

        list2.add("Availability");
        list2.add("Quantity");
        comboStat.setItems(list2);

    }

     @FXML
    void pieOnAction(ActionEvent event) {

     }

}
