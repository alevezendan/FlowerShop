package controller;

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

    private FlowerService flowS;
    // private FlowerMapper flowerMapper;
    private FlowerController flowerController;

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
    //public void init(LogInController mainGUI){
    //this.loginGUI=mainGUI;
    // }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        u=flowerController.getUserService().getU(stage.getTitle());
        f=u.getFlowerShop();
        dataF= FXCollections.observableArrayList();
        flowerTable.getSelectionModel (). setCellSelectionEnabled (true);
        //initCombo();

    }

    public void init(){
        stage = (Stage) logOut.getScene().getWindow();
        // String ux=stage.getTitle();

        // u=userP.getU(stage.getTitle());
        // f=flowsP.getFlowerShop(u.getId());
    }
    public void showErrorDialog(String error){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Error");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(error);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }
   /* @FXML
    void addOnAction(ActionEvent event) {
        init();
        try {
            List<FlowerShop> fS=null;
            fS.add(f);
            Flower flower=new Flower(Integer.parseInt(UUID.randomUUID().toString()),vEmployee.getNewName().getText(),vEmployee.getNewColor().getText(),Double.parseDouble(vEmployee.getNewQuant().getText()),Double.parseDouble(vEmployee.getNewPrice().getText()), vEmployee.getNewAvail().getText(),fS);
            flowerController.getFlowerService().insertFlower(vEmployee.getFlowerTable(), f,flower, dataF);
            // flowP.addFlower(flowerTable, f, newColor.getText(), newName.getText(), newPrice.getText(), newAvail.getText(), newQuant.getText(), dataF);
        }catch(Exception e){
            showErrorDialog("Missing data!");
        }
        clear();

    }*/
    /*
    public void clear(){
        vEmployee.getNewName().clear();
        vEmployee.getNewPrice().clear();
        vEmployee.getNewColor().clear();
        vEmployee.getNewAvail().clear();
        vEmployee.getNewQuant().clear();
    }*/
   /* @FXML
    void logOutOnAction(ActionEvent event) {
        Stage stage = (Stage) vEmployee.getLogOut().getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        init();
        try {
            Flower flower = vEmployee.getFlowerTable().getSelectionModel().getSelectedItem();
            List<FlowerDTO> flowersDTO=flowerController.remaining(flower);
            for(FlowerDTO f:flowersDTO){
                Flower flow=FlowerMapper.dtoToEntity(f);
                dataF.add(flow);
            }
            //  flowP.deleteFlower(flower, flowerTable);
        }catch(Exception e){
            showErrorDialog("Please select the item you want to delete!");
        }
    }*/

   /* @FXML
    void filterOnAction(ActionEvent event) {
        init();
        String s="";
        try {
            s = vEmployee.getComboFilter().getSelectionModel().getSelectedItem();
        }catch(Exception e){
            showErrorDialog("Please select the criterion!");
        }

        //User user=userP.getU(u);
        // System.out.println(user.getUsername());
        // FlowerShop f=flowsP.getFlowerShop(user.getId());
        try {
            // flowP.filterr(s, flowerTable, dataF, filterText.getText(), f);
        }catch(Exception e){
            showErrorDialog("Missing filter value!");
        }

    }*/

   /* @FXML
    void saveReportOnAction(ActionEvent event) {
        init();
        FlowerShop f=flowsP.getFlowerShop("The Flower Studio");
        if(vEmployee.getJson().isSelected()) {
            //toJson();
            //flowP.saveJSONReports(f);
        }
        if(vEmployee.getCsv().isSelected()){
            //toCSV();
            //flowP.saveCSVReports(f);
        }
    }*/

   /* @FXML
    void searchOnAction(ActionEvent event) {
        init();
        String flowerName=vEmployee.getSearchName().getText();
        // flowP.searchFlower(flowerTable,flowerName,dataF,f);

    }*/


   /* @FXML
    void updateOnAction(ActionEvent event) {
        init();
        try {
            dataF = vEmployee.getFlowerTable().getItems();
            if (!vEmployee.getNewName().getText().equals("")) {

                //flowP.updateName(vEmployee.getFlowerTable().getSelectionModel().getSelectedItem(), dataF, newName.getText());
            }
            if (!vEmployee.getNewPrice().getText().equals("")) {

                // flowP.updatePrice(vEmployee.getFlowerTable().getSelectionModel().getSelectedItem(), dataF, newPrice.getText());
            }
            if (!vEmployee.getNewColor().getText().equals("")) {

                //flowP.updateColor(vEmployee.getFlowerTable().getSelectionModel().getSelectedItem(), dataF, newColor.getText());
            }
            if (!vEmployee.getNewAvail().getText().equals("")) {
                // updateAvail();
                //flowP.updateAvail(vEmployee.getFlowerTable().getSelectionModel().getSelectedItem(), dataF, newAvail.getText());
            }
            if (!vEmployee.getNewQuant().getText().equals("")) {
                //updateQuant();
                //flowP.updateQuant(vEmployee.getFlowerTable().getSelectionModel().getSelectedItem(), dataF, newQuant.getText());
            }
            vEmployee.getFlowerTable().getItems().clear();



            vEmployee.getFlowerTable().setItems(dataF);
            vEmployee.getNewName().clear();
            vEmployee.getNewPrice().clear();
            vEmployee.getNewColor().clear();
            vEmployee.getNewAvail().clear();
            vEmployee.getNewQuant().clear();
        }
        catch(Exception e){
            showErrorDialog("Item not selected!");
        }

    }*/

    /*@FXML
    void viewOnAction(ActionEvent event) {
        init();
        System.out.println(u.getUsername());
        List<FlowerDTO> allFlowers=flowerController.all();
        for(FlowerDTO f:allFlowers){
            Flower flow=FlowerMapper.dtoToEntity(f);
            dataF.add(flow);
        }
        //FlowerShop f=flowsP.getFlowerShop(u.getId());

        //flowP.view(vEmployee.getFlowerTable(),dataF,f);
    }*/

    /*@FXML
    void viewStatisticsOnAction(ActionEvent event) {
        try{
            ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();

            vEmployee.getPieChart().setVisible(true);
            if (vEmployee.getComboStat().getValue().equals("Availability")) {
                if(vEmployee.getPie().isSelected()) {
                    // flowP.statAvail(f, pieChart, pieChartData);
                }
                else{
                    showErrorDialog("Select chart!");
                }
            }
            if (vEmployee.getComboStat().getValue().equals("Price")) {
                if(vEmployee.getPie().isSelected()) {
                    // flowP.statPrice(f, pieChart, pieChartData);
                }else{
                    showErrorDialog("Select chart!");
                }
            }
            if (vEmployee.getComboStat().getValue().equals("Quantity")) {
                if (vEmployee.getPie().isSelected()) {
                    //flowP.statQuant(f, pieChart, pieChartData);
                }else{
                    showErrorDialog("Select chart!");
                }
            }
            // }

        }catch(Exception e){
            showErrorDialog("Please select the criterion!");
        }
    }
*/

   /* @FXML
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
        vEmployee.getComboFilter().setItems(list1);
        ObservableList<String> list2=FXCollections.observableArrayList();
        list2.add("Price");
        list2.add("Color");
        list2.add("Availability");
        list2.add("Quantity");
        vEmployee.getComboStat().setItems(list2);

    }*/

    // @FXML
    //void pieOnAction(ActionEvent event) {
       /* ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
       // FlowerShop f=flowsP.getFlowerShop("The Flower Studio");
        if(pie.isSelected())

        {

            pieChart.setVisible(true);
            if (comboStat.getValue().equals("Availability")) {
                flowP.statAvail(f, pieChart, pieChartData);
            }
            if (comboStat.getValue().equals("Price")) {
                flowP.statPrice(f, pieChart, pieChartData);
            }
            if (comboStat.getValue().equals("Quantity")) {
                flowP.statQuant(f, pieChart, pieChartData);
            }
        }*/
    // }

}
