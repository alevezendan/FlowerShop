package controller;

import model.Language;
import service.FlowerService;
import service.FlowerShopService;
import service.UserService;

import entity.Flower;
import entity.FlowerShop;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController extends Controller implements  Initializable {
    private ObservableList<User> dataU;
    private ObservableList<Flower> dataF;

    private FlowerService flowerService;
    private UserService userService;
    private FlowerShopService flowerShopService;
    private User u;
    private Stage stage;
    private Language language;
    private TableColumn type,price,color,availab,quant,idF,name,role,username,id;
    @FXML
    private TableView<User> usersTable;
    @FXML
    private TableView<Flower> flowersTable;
    @FXML
    private ComboBox<String> combo;

    @FXML
    private TextField newName;
    @FXML
    private Button logOut;
    @FXML
    private TextField newRole;

    @FXML
    private TextField newId;

    @FXML
    private TextField newUsername;

    @FXML
    private Button RoseandCo;

    @FXML
    private Button BlossomHouse;

    @FXML
    private Button TheFlowerStudio;

    @FXML
    private Button update;

    @FXML
    private Button add;

    @FXML
    private Button view;

    @FXML
    private Button delete;

    @FXML
    private Label employees;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        name = new TableColumn<User,String>("Name");
        role = new TableColumn("Role");
        username = new TableColumn("Username");
        id = new TableColumn("Flower shop id");
        flowerService=new FlowerService();
        userService=new UserService();
        flowerShopService=new FlowerShopService();
        // System.out.println("sdvcsdcv");
        dataF= FXCollections.observableArrayList();
        dataU= FXCollections.observableArrayList();
        usersTable.getSelectionModel (). setCellSelectionEnabled (true);
        flowerService.initCombo(combo);
        List<FlowerShop> flowerShops=flowerShopService.getFlowerShops();
        flowerShopService.getFlowerShopChain().setFlowerShops(flowerShops);
        List<User> users=userService.getAllUsers();
        userService.getUsers().setUsers(users);

    }

    public void init(){
        stage = (Stage) logOut.getScene().getWindow();
        u=userService.getU(stage.getTitle());
    }

    @FXML
    void refreshOnAction(ActionEvent event) {
        init();
        switchLanguage(u.getLanguage());
    }
    public void switchLanguage(String s){
        switch(s){
            case "French":language.changeToAdminFrench(employees,delete,view,update,logOut,newName,newName,newRole,newUsername);
                break;
            case "Turkish":language.changeToAdminTurkish(employees,delete,view,update,logOut,newName,newName,newRole,newUsername);
                break;
            case "Romanian":language.changeToAdminRo(employees,delete,view,update,logOut,newName,newName,newRole,newUsername);
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
    void flowerStudioOnAction(ActionEvent event) {
        flowersTable.getItems().clear();
        flowersTable.getColumns().clear();
        flowersTable.setVisible(true);

        FlowerShop f=flowerShopService.getFlowerShopByName("The Flower Studio");

        usersTable.setVisible(false);
        flowerService.showFlowers(flowersTable,f,dataF);
        //userP.showFlowers(flowersTable,f,dataF);

    }

    @FXML
    void blossomHouseOnAction(ActionEvent event) {
        flowersTable.getItems().clear();
        flowersTable.getColumns().clear();
        flowersTable.setVisible(true);

        FlowerShop f=flowerShopService.getFlowerShopByName("Blossom House");
        usersTable.setVisible(false);
        flowerService.showFlowers(flowersTable,f,dataF);
    }

    @FXML
    void roseCoOnAction(ActionEvent event) {
        flowersTable.getItems().clear();
        flowersTable.getColumns().clear();
        flowersTable.setVisible(true);

        FlowerShop f=flowerShopService.getFlowerShopByName("Rose and Co");
        usersTable.setVisible(false);
        flowerService.showFlowers(flowersTable,f,dataF);

    }

    @FXML
    void logOutOnAction(ActionEvent event) {
        Stage stage = (Stage)logOut.getScene().getWindow();
        stage.close();
    }


    @FXML
    void readOnAction(ActionEvent event) {
        try {

            String v = combo.getValue();
            if(v.equals("All shops")){
                flowersTable.setVisible(false);
                userService.showUsers(usersTable, v, dataU, null, name, role, username, id);
            }else {

                FlowerShop f = flowerShopService.getFlowerShopByName(v);
                System.out.println(f.getName() + " din show flowers");
                flowersTable.setVisible(false);
                userService.showUsers(usersTable, v, dataU, f, name, role, username, id);
            }
            // userP.showUsers(usersTable, v, dataU, f, name, role, username, id);
        }catch(Exception e){
            showErrorDialog("Flower Shop not selected!");
        }

    }
    @FXML
    void addOnAction(ActionEvent event) {
        //dataU = usersTable.getItems();
        FlowerShop f=null;
        try
        {
             f = flowerShopService.getFlowerShopByName(combo.getValue());
        }catch(Exception e) {
            showErrorDialog("Please select flower shop!");
        }

        userService.addUser(f,usersTable,dataU,newName,newUsername,newRole);

    }



    @FXML
    void deleteOAction(ActionEvent event) {

            User u = usersTable.getSelectionModel().getSelectedItem();
            FlowerShop f = flowerShopService.getFlowerShopByUsername(u.getUsername());
        try {
            userService.deleteUser(u,usersTable,dataU,f,name,role,username,id);
        }catch(Exception e){
            showErrorDialog("Please select the item that you want to delete!");
        }

    }


    public void allUsers(){
        dataU.removeAll();
        //for(User u:userP.getUsers().getUsers()){
        //  dataU.add(u);
        //}
    }

    public void specificUsers(FlowerShop f){
        dataU.removeAll();
        for(User u:f.getUsers()){
            dataU.add(u);
        }
    }
    public void populateUserTable(){
        name = new TableColumn<User,String>("Name");
        name.setMinWidth(90);
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        role = new TableColumn("Role");
        role.setMinWidth(60);
        role.setCellValueFactory(
                new PropertyValueFactory<>("role"));


        //flowersTable.setItems((ObservableList<Flower>) fShop.getFlowers());
        username= new TableColumn("Username");
        username.setCellValueFactory(new PropertyValueFactory<>("username"));


        id= new TableColumn("Flower shop id");
        id.setMinWidth(80);
        id.setCellValueFactory(
                new PropertyValueFactory<>("id"));

    }


    @FXML
    void updateOnAction(ActionEvent event) {

        User u = usersTable.getSelectionModel().getSelectedItem();
        dataU = usersTable.getItems();
        userService.updateUser(usersTable,u,dataU,newName,newUsername,newRole);
    }

    @FXML
    void comboOnAction(ActionEvent event) {

    }
}
