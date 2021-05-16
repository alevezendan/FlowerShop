package model;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginInterfaceLanguage implements  ChangeInterface{

    private TextField usern;
    private TextField pass;
    private Button login;
    private Locale locale;
    private ResourceBundle resourceBundle;

    public LoginInterfaceLanguage(TextField usern,TextField pass, Button login){
        this.login=login;
        this.pass=pass;
        this.usern=usern;
    }

    public LoginInterfaceLanguage() {
    }

    public void setUsern(TextField usern) {
        this.usern = usern;
    }

    public void setPass(TextField pass) {
        this.pass = pass;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void changeToFr() {
        locale=Locale.FRENCH;
        resourceBundle= ResourceBundle.getBundle("MyBundle_fr", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(resourceBundle.getString("w3"));
        pass.setText(resourceBundle.getString("w2"));
        login.setText(resourceBundle.getString("w1"));
    }

    @Override
    public void changeToRo() {
        locale=new Locale("ro","RO");
        resourceBundle= ResourceBundle.getBundle("MyBundle_ro", locale);
        usern.setText(resourceBundle.getString("w3"));
        pass.setText(resourceBundle.getString("w2"));
        login.setText(resourceBundle.getString("w1"));
    }

    @Override
    public void changeToTr() {
        locale=new Locale("tr","TR");
        resourceBundle= ResourceBundle.getBundle("MyBundle_tr", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(resourceBundle.getString("w3"));
        pass.setText(resourceBundle.getString("w2"));
        login.setText(resourceBundle.getString("w1"));

    }

    public void changeToLogInDefault(TextField usern, TextField pass, Button login) {
        locale=Locale.getDefault();
        resourceBundle= ResourceBundle.getBundle("MyBundle", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(resourceBundle.getString("w3"));
        pass.setText(resourceBundle.getString("w2"));
        login.setText(resourceBundle.getString("w1"));
    }
}
