package model.service;


import model.entity.User;
import javafx.scene.control.*;
import model.repository.UserRepo;


import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class LogInService {

    private UserRepo userRepo;
    public LogInService(){
        this.userRepo=new UserRepo();
    }

    public void showErrorDialog(String error) {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Error");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(error);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

   // public String logIn(String username, String password) {
   public User logIn(String username, String password) {

        boolean found = false;
        boolean usern = false;
        boolean pass = false;
        User foundUser=null;
        List<User> users = userRepo.showAllUsers();
        for (User u : users) {
            System.out.println(u.getUsername()+" "+u.getRole()+" "+u.getPassword());
            if (u.getUsername().equals(username)) {
                usern = true;
            }
            if (u.getPassword().equals(password)) {
                pass = true;

            }
            if (usern && pass) {
                found = true;
                 foundUser=u;
                break;
            }

        }
        if (found) {
            return foundUser;
            //showErrorDialog("User not found");

            /*List<User> user = userRepo.logIn(username);
           // User u=user.get(0);
            if (foundUser.getRole().equals("Administrator")) {
                return "Administrator";
            } else {
                if (foundUser.getRole().equals("Employee")) {
                    return "Employee";
                }
            }*/
        }
        //return "Error";
       return null;
    }

    public void changeToFrench(TextField usern, TextField pass, Button login) {
        Locale locale=Locale.FRENCH;
        ResourceBundle labels = ResourceBundle.getBundle("MyBundle_fr", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(labels.getString("w3"));
        pass.setText(labels.getString("w2"));
        login.setText(labels.getString("w1"));
    }

    public void changeToRo(TextField usern, TextField pass, Button login) {
        Locale locale=Locale.FRENCH;
        ResourceBundle labels = ResourceBundle.getBundle("MyBundle_ro", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(labels.getString("w3"));
        pass.setText(labels.getString("w2"));
        login.setText(labels.getString("w1"));
    }

    public void changeToTurkish(TextField usern, TextField pass, Button login) {
        Locale locale=Locale.FRENCH;
        ResourceBundle labels = ResourceBundle.getBundle("MyBundle_tr", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(labels.getString("w3"));
        pass.setText(labels.getString("w2"));
        login.setText(labels.getString("w1"));
    }
}



