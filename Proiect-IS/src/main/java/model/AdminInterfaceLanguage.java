package model;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class AdminInterfaceLanguage implements  ChangeInterface{

    private Label employees;
    private Button delete, view, update,  logOut;
    private TextField newName,newRole,  newUsername;
    private Locale locale;
    private ResourceBundle resourceBundle;

    public AdminInterfaceLanguage(Label employees, Button delete, Button view, Button update, Button logOut,  TextField newName, TextField newRole, TextField newUsername){
        this.employees=employees;
        this.delete=delete;
        this.view=view;
        this.update=update;
        this.logOut=logOut;
        this.newName=newName;
        this.newRole=newRole;
        this.newUsername=newUsername;
    }

    public AdminInterfaceLanguage() {
    }

    public void setEmployees(Label employees) {
        this.employees = employees;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public void setView(Button view) {
        this.view = view;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public void setLogOut(Button logOut) {
        this.logOut = logOut;
    }

    public void setNewName(TextField newName) {
        this.newName = newName;
    }

    public void setNewRole(TextField newRole) {
        this.newRole = newRole;
    }

    public void setNewUsername(TextField newUsername) {
        this.newUsername = newUsername;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void changeToFr() {
        locale= Locale.FRENCH;
        resourceBundle= ResourceBundle.getBundle("MyBundle_fr", locale);
        employees.setText(resourceBundle.getString("w18"));
        delete.setText(resourceBundle.getString("w11"));
        view.setText(resourceBundle.getString("w19"));
        update.setText(resourceBundle.getString("w10"));
        logOut.setText(resourceBundle.getString("w12"));
        newName.setPromptText(resourceBundle.getString("w13"));
        newRole.setPromptText(resourceBundle.getString("w20"));
        newUsername.setPromptText(resourceBundle.getString("w3"));
    }

    @Override
    public void changeToTr() {
        locale=new Locale("tr","TR");
        resourceBundle= ResourceBundle.getBundle("MyBundle_tr", locale);
        employees.setText(resourceBundle.getString("w18"));
        delete.setText(resourceBundle.getString("w11"));
        view.setText(resourceBundle.getString("w19"));
        update.setText(resourceBundle.getString("w10"));
        logOut.setText(resourceBundle.getString("w12"));
        newName.setPromptText(resourceBundle.getString("w13"));
        newRole.setPromptText(resourceBundle.getString("w20"));
        newUsername.setPromptText(resourceBundle.getString("w3"));
    }

    @Override
    public void changeToRo() {
        locale=new Locale("ro","RO");
        resourceBundle= ResourceBundle.getBundle("MyBundle_ro", locale);
        employees.setText(resourceBundle.getString("w18"));
        delete.setText(resourceBundle.getString("w11"));
        view.setText(resourceBundle.getString("w19"));
        update.setText(resourceBundle.getString("w10"));
        logOut.setText(resourceBundle.getString("w12"));
        newName.setPromptText(resourceBundle.getString("w13"));
        newRole.setPromptText(resourceBundle.getString("w20"));

    }
}
