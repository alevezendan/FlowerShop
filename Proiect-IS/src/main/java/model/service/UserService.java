package model.service;



import model.entity.FlowerShop;
import model.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Users;
import model.repository.UserRepo;


import java.util.List;
import java.util.Random;
//import lombok.Data;


public class UserService{

   private Users users;
   private UserRepo userRepo;
   private FlowerShopService flowerShopService;
   private FlowerShop flowerShop;
   public UserService(){
       this.userRepo=new UserRepo();
       this.users=new Users();
       flowerShopService=new FlowerShopService();
       this.flowerShop=new FlowerShop();
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
       List<User> users=userRepo.showAllUsers();
        for(User u: users){
            if(u.getUsername().equals(n)){
                System.out.println(u.getUsername()+" "+u.getRole()+" "+u.getPassword()+" "+u.getLanguage());
                return u;
            }
        }
        return null;
    }

    public void  populateUserTable(TableColumn name,TableColumn role,TableColumn username,TableColumn id){
        name.setMinWidth(90);
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        role.setMinWidth(60);
        role.setCellValueFactory(
                new PropertyValueFactory<>("role"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        id.setMinWidth(80);
        id.setCellValueFactory(
                new PropertyValueFactory<>("flowerShop"));
    }


    public void showAllUsers(ObservableList<User> dataU){
        dataU.removeAll();
        List<User> users=userRepo.showAllUsers();
        for(User u:users){
            dataU.add(u);
        }
    }

    public List<User> getAllUsers(){
        return userRepo.showAllUsers();
    }

    public void showSpecificUser(FlowerShop f, ObservableList<User> dataU){
        dataU.removeAll();
        List<User> users=userRepo.showAllUsers();
        //for(User u:f.getUsers()){
        for(User u:users){
            if(u.getFlowerShop().getName().equals(f.getName())) {
                dataU.add(u);
            }
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

           // f=flowerShopService.getFlowerShopByName(value);
            //specificUsers(f);
            showSpecificUser(f,dataU);

        }
        usersTable.getColumns().removeAll();
        usersTable.setItems(dataU);
        usersTable.getColumns().addAll(name,role,username,id);
        //flowersTable.setVisible(false);
        usersTable.setVisible(true);
    }

    public void deleteUser(User u,TableView<User> usersTable,ObservableList<User> dataU,FlowerShop f,TableColumn name, TableColumn role, TableColumn username, TableColumn id){
           try {
               //userRepo.deleteUser(u);
               userRepo.deleteUser(u.getUsername());

           }catch(Exception e){
               e.printStackTrace();
           }
        System.out.println(f.getName()+" din user model.service");
        f.deleteUser(u);
            usersTable.getItems().clear();
            usersTable.getColumns().clear();
            populateUserTable(name,role,username,id);
            try {

                List<User> us = userRepo.showAllUsers();
                dataU.removeAll();
                for(User x:us){
                    if(x.getFlowerShop().getName().equals(f.getName())){
                        dataU.add(x);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
        }

        usersTable.getColumns().removeAll();
        usersTable.setItems(dataU);
        usersTable.getColumns().addAll(name,role,username,id);
        //flowersTable.setVisible(false);
        usersTable.setVisible(true);
    }

    public void updateUser(TableView<User>usersTable, User user, ObservableList<User> dataU, TextField newName, TextField newUsername,TextField newRole){
        if (!newName.getText().equals("")) {
            user.setName(newName.getText());
            userRepo.updateName(user,newName.getText());
        }
        if (!newRole.getText().equals("")) {
            user.setRole(newRole.getText());
            userRepo.updateRole(user,newRole.getText());
        }
        if (!newUsername.getText().equals("")) {
            user.setUsername(newUsername.getText());
            userRepo.updateUsername(user,newUsername.getText());
        }
        usersTable.getItems().clear();
        List<User> users=userRepo.showAllUsers();
        for(User x:users){
            if(x.getFlowerShop().getName().equals(user.getFlowerShop().getName())){
                dataU.add(x);
            }
        }

        usersTable.setItems(dataU);
        newName.clear();newUsername.clear();newRole.clear();
    }

    public void addUser(FlowerShop f,TableView<User>usersTable,  ObservableList<User> dataU, TextField newName, TextField newUsername,TextField newRole){
        Random r = new Random();
        int low = 10;
        int high = 1000;
        int id = r.nextInt(high-low) + low;
        //usersTable.getItems().clear();
       User user=new User(id,newName.getText(),newRole.getText(),newUsername.getText(),f);
       f.getUsers().add(user);
       userRepo.insertNewUser(user);
       dataU.add(user);
       usersTable.setItems(dataU);
       newName.clear();
       newRole.clear();
       newUsername.clear();
    }

    public void updateLanguage(User user,String setLanguage) {
       userRepo.updateLanguage(user,setLanguage);
    }
}
