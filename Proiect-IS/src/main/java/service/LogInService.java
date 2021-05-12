package service;

import entity.User;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import repository.UserRepo;

import java.util.List;

public class LogInService {

    private UserRepo userRepo;

    public void showErrorDialog(String error) {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Error");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(error);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    public String logIn(String username, String password) {

        boolean found = false;
        boolean usern = false;
        boolean pass = false;
        List<User> users = userRepo.showAllUsers();
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                usern = true;
            }
            if (u.getPassword().equals(password)) {
                pass = true;

            }
            if (usern && pass) {
                found = true;
            }

        }
        if (!found) {
            showErrorDialog("User not found");
        } else {
            User user = userRepo.logIn(username);
            if (user.getRole().equals("Administrator")) {
                return "Administrator";
            } else {
                if (user.getRole().equals("Employee")) {
                    return "Employee";
                }
            }
        }
        return "Error";
    }
}



