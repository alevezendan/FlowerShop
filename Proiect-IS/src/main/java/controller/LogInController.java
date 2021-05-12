package controller;

import service.LogInService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController<VLogin> implements Initializable {

    private LogInService logInService;
    @FXML
    EmployeeController emplContr;
    @FXML
    AdminController adminContr;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorLabel;
    @FXML
    private TextField username;

    @FXML
    private Button login;
    public void showErrorDialog(String error){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Error");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(error);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }


    @FXML
    void loginOnAction(ActionEvent event) {

        String usern=username.getText();
        String pass=password.getText();
        String s=logInService.logIn(usern,pass);
        //String s="Admin";
        switch(s){
            case "Administrator":System.out.println("Admin");
                errorLabel.setText("User:"+usern);
                initNewPresenter(adminContr,"src\\main\\java\\view\\admin.fxml","Admin:"+usern);
                break;
            case "Employee" :System.out.println("Employee");
                errorLabel.setText("User:"+usern);
                initNewPresenter(emplContr,"src\\main\\java\\View\\employee.fxml","Employee:"+usern);
                break;
            default:showErrorDialog("Error!");

        }

        // FlowerShop f=flowsP.getFlowerShop(usern);
        // String sid=Integer.toString(f.getId());
        // System.out.println(sid);
           /* if(!userP.validUser(usern,pass)) {
                System.out.println("Invalid user");
                if(usern==""){
                    errorLabel.setText("Missing username!");
                }
                if(pass==""){
                    errorLabel.setText("Missing password!");
                }
                if(usern=="" & pass==""){
                    errorLabel.setText("Invalid operation!");
                }
                if (!userP.existentUser(usern)) {
                    // showErrorDialog("User not found!");
                    errorLabel.setText("User not found!");
                } else {
                    errorLabel.setText("Invalid password!");
                }
            }else{
                System.out.println("Valid user!");
                if (userP.isEmployee(usern)) {
                    System.out.println("Employee");
                    flowP.readXMLFile();
                    errorLabel.setText("User:"+usern);
                    //initNewPresenter(emplPres,"src\\main\\java\\View\\employee.fxml","Employee:"+usern);
                    User u=userP.getU(usern);
                    FlowerShop f=flowsP.getFlowerShop(u.getId());
                    initNewPresenter(emplContr,"src\\main\\java\\View\\"+u.getId()+".fxml",usern);
                    // System.out.println("de ce nu merge");
                } else {
                    if (userP.isAdmin(usern)) {
                        System.out.println("Admin");
                        errorLabel.setText("User:"+usern);
                        initNewPresenter(adminContr,"src\\main\\java\\View\\admin.fxml","Admin:"+usern);
                    }
                }

            }*/

    }


    @FXML
    void passwordOnAction(ActionEvent event) {

    }

    @FXML
    void userNameOnAction(ActionEvent event) {

    }

    public void initNewPresenter(Controller c,String path,String title){
        try{
            FXMLLoader loader=new FXMLLoader();

            FileInputStream fxmlStream = null;
            fxmlStream = new FileInputStream(path);

            Parent parent=loader.load(fxmlStream);

            c=loader.getController();
            Stage stage =new Stage();
            System.out.println("1111");

            stage.setTitle(title);
            Scene s=new Scene(parent);
            //s.getStylesheets().add(pathCss);
            stage.setScene(s);
            stage.show();
            c.init(this);

        } catch(IOException e){
            System.out.println("eferg");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInService=new LogInService();
    }
}
