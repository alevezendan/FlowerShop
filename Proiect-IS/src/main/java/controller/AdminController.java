package controller;

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
            FlowerShop f = flowerShopService.getFlowerShopByName(v);
            userService.showUsers(usersTable, v, dataU, f, name, role, username, id);
            // userP.showUsers(usersTable, v, dataU, f, name, role, username, id);
        }catch(Exception e){
            showErrorDialog("Flower Shop not selected!");
        }

    }
    @FXML
    void addOnAction(ActionEvent event) {}
       /* try {
            if(!flowsP.getFC().existingShop(Integer.parseInt(vAdmin.getNewId().getText()))){
                showErrorDialog("The flower shop with id"+ Integer.parseInt(vAdmin.getNewId().getText())+ "does not exist!");
            }
            else {
                if (!vAdmin.getNewRole().getText().equals("Employee") || !vAdmin.getNewRole().getText().equals("Administrator")){
                    showErrorDialog("Incorrect role!");
                }
                else{
                    //User newU = new User(newName.getText(), newRole.getText(), newUsername.getText(), Integer.parseInt(newId.getText()));
                    //  newU.getFlowerShop().getUsers().add(newU);
                    FlowerShop f = flowsP.getFlowerShop(Integer.parseInt(vAdmin.getNewId().getText()));
                    FlowerShop f1 = flowsP.getFlowerShop(vAdmin.getCombo().getValue());
                    if (f.getId() == f1.getId()) {
                        // userP.addUser(newU, f, usersTable, dataU);
                    }
                    // f.getUsers().add(newU);
                    //userP.getUsers().addUser(newU);

                    vAdmin.getNewName().clear();
                    vAdmin.getNewId().clear();
                    vAdmin.getNewRole().clear();
                    vAdmin.getNewUsername().clear();
                }
            }
        }catch(Exception e){
            showErrorDialog("Missing attributes!");
        }*/


    @FXML
    void deleteOAction(ActionEvent event) {
        /*try {
            User u = vAdmin.getUsersTable().getSelectionModel().getSelectedItem();
            //userP.getUsers().getUsers().remove(u);
            FlowerShop f = flowsP.getFlowerShop(u.getId());
            // userP.deleteUser(u, f, usersTable);
        }catch(Exception e){
            showErrorDialog("Please select the item that you want to delete!");
        }*/

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




    /*public void updateName(){
        //Flower flower=flowerTable.getSelectionModel().getSelectedItem();
        User user=vAdmin.getUsersTable().getSelectionModel().getSelectedItem();

        //userP.updateName(dataU,user,newName.getText());
    }
    public void updateRole(){
        //Flower flower=flowerTable.getSelectionModel().getSelectedItem();
        User user=vAdmin.getUsersTable().getSelectionModel().getSelectedItem();

        // userP.updateRole(dataU,user,newRole.getText());
    }
    public void updateUsername(){
        //Flower flower=flowerTable.getSelectionModel().getSelectedItem();
        User user=vAdmin.getUsersTable().getSelectionModel().getSelectedItem();
        // userP.updateUsername(dataU,user,newUsername.getText());
    }
    public void updateShopId(){

        User user=vAdmin.getUsersTable().getSelectionModel().getSelectedItem();
        FlowerShop f=flowsP.getFlowerShop(Integer.parseInt(vAdmin.getNewId().getText()));
        // userP.updateId(dataU,user,newId.getText(),f);
    }*/
    @FXML
    void updateOnAction(ActionEvent event) {
        /*try {
            User user = vAdmin.getUsersTable().getSelectionModel().getSelectedItem();

            dataU = vAdmin.getUsersTable().getItems();
            if (!vAdmin.getNewName().getText().equals("")) {
                //updateName();
                //userP.updateName(dataU, user, newName.getText());
            }
            if (!vAdmin.getNewRole().getText().equals("")) {
                //System.out.println(newRole.getText());
                //updateRole();
                // userP.updateRole(dataU, user, newRole.getText());
            }
            if (!vAdmin.getNewUsername().getText().equals("")) {
                //updateUsername();
                //  userP.updateUsername(dataU, user, newUsername.getText());
            }
            if (!vAdmin.getNewId().getText().equals("")) {
                //updateShopId();
                FlowerShop f = flowsP.getFlowerShop(Integer.parseInt(vAdmin.getNewId().getText()));
                // userP.updateId(dataU, user, newId.getText(), f);
            }

            FlowerShop f1 = flowsP.getFlowerShop(vAdmin.getCombo().getValue());
            vAdmin.getUsersTable().getItems().clear();
            // for (User ul : userP.getUsers().getUsers()) {
            for (User ul : f1.getUsers()) {
                dataU.add(ul);
            }
            vAdmin.getUsersTable().setItems(dataU);
            vAdmin.getNewName().clear();//newPrice.clear();newColor.clear();newAvail.clear();newQuant.clear();
        }
        catch(Exception e){
            showErrorDialog("Please select the item!");
        }*/

    }




    @FXML
    void comboOnAction(ActionEvent event) {

    }
}
