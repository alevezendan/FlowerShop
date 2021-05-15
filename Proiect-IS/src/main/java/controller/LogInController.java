package controller;

import entity.User;
import model.Language;
import service.LogInService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import service.UserService;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController<VLogin> implements Initializable {

    private LogInService logInService;
    private UserService userService;
    private Language language;
    private  String setLanguage;
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

    @FXML
    private Button frButton;

    @FXML
    private Button turkButton;

    @FXML
    private Button roButton;

    @FXML
    private TextField usern;

    @FXML
    private TextField pass;

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
        System.out.println(usern+" "+pass+" ");
       // String s=logInService.logIn(usern,pass);
        User u=logInService.logIn(usern,pass);
        String s=u.getRole();
        u.setLanguage(setLanguage);
        userService.updateLanguage(u,setLanguage);
        System.out.println(u.getUsername()+" "+u.getRole()+" "+u.getPassword()+" "+u.getLanguage());
        //String s="Admin";
        switch(s){
            case "Administrator":System.out.println("Admin");
                errorLabel.setText("User:"+usern);

                initNewPresenter(adminContr,"src\\main\\java\\view\\admin.fxml","Admin:"+usern);
                break;
            case "Employee" :System.out.println("Employee");
                errorLabel.setText("User:"+usern);
                initNewPresenter(emplContr,"src\\main\\java\\view\\employee.fxml",usern);
                break;
            default:showErrorDialog("Error!");

        }

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

            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInService=new LogInService();
        language=new Language();
        userService=new UserService();
    }

    @FXML
    void frenchOnAction(ActionEvent event) {
        language.changeToLogInFrench(usern,pass,login);
            //logInService.changeToFrench(usern,pass,login);
        setLanguage="French";
    }
    @FXML
    void roOnAction(ActionEvent event) {
        language.changeToLogInRo(usern,pass,login);
        //logInService.changeToRo(usern,pass,login);
        setLanguage="Romanian";
    }
    @FXML
    void turkishOnAction(ActionEvent event) {
        language.changeToLogInTurkish(usern,pass,login);
       // logInService.changeToTurkish(usern,pass,login);
        setLanguage="Turkish";
    }


    @FXML
    void backOnAction(ActionEvent event) {
        language.changeToLogInDefault(usern,pass,login);

    }
}
