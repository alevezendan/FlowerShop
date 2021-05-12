package service;


import entity.FlowerShop;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Users;
import repository.UserRepo;

import java.util.List;
//import lombok.Data;


public class UserService{

   private Users users;
   private UserRepo userRepo;
   private FlowerShopService flowerShopService;
   public UserService(){
       this.userRepo=new UserRepo();
       this.users=new Users();
       flowerShopService=new FlowerShopService();
   }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void initCombo(ComboBox<String> combo){
        ObservableList<String> list= FXCollections.observableArrayList();

        list.add("The Flower Studio");
        list.add("Blossom House");
        list.add("Rose and Co");
        list.add("All shops");
        combo.setItems(list);
    }
    public User getU(String n){
        for(User u: users.getUsers()){
            if(u.getUsername().equals(n)){
                return u;
            }
        }
        return null;
    }

    public void  populateUserTable(TableColumn name,TableColumn role,TableColumn username,TableColumn id){
        //name = new TableColumn<User,String>("Name");
        name.setMinWidth(90);
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        //role = new TableColumn("Role");
        role.setMinWidth(60);
        role.setCellValueFactory(
                new PropertyValueFactory<>("role"));


        //flowersTable.setItems((ObservableList<Flower>) fShop.getFlowers());
        // username= new TableColumn("Username");
        username.setCellValueFactory(new PropertyValueFactory<>("username"));

        // id= new TableColumn("Flower shop id");
        id.setMinWidth(80);
        id.setCellValueFactory(
                new PropertyValueFactory<>("id"));
    }


    public void showUsers(ComboBox<String> combo){
       if(combo.getValue().equals("All Users")){

       }
    }
    public void showAllUsers(ObservableList<User> dataU){
        dataU.removeAll();
        for(User u:users.getUsers()){
            dataU.add(u);
        }
    }

    public List<User> getAllUsers(){
        return userRepo.showAllUsers();
    }

    public void showSpecificUser(FlowerShop f, ObservableList<User> dataU){
        dataU.removeAll();
        for(User u:f.getUsers()){
            dataU.add(u);
        }
    }
    public void showUsers(TableView<User> usersTable, String value, ObservableList<User> dataU, FlowerShop f, TableColumn name, TableColumn role, TableColumn username, TableColumn id){
        usersTable.getItems().clear();
        usersTable.getColumns().clear();
        populateUserTable(name,role,username,id);
        // FlowerShop f;
        if(value.equals("All shops")) {
            //allUsers();

            showAllUsers(dataU);
        }
        else{

            f=flowerShopService.getFlowerShopByName(value);
            //specificUsers(f);
            showSpecificUser(f,dataU);

        }
        usersTable.getColumns().removeAll();
        usersTable.setItems(dataU);
        usersTable.getColumns().addAll(name,role,username,id);
        //flowersTable.setVisible(false);
        usersTable.setVisible(true);
    }
}
