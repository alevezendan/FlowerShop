package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    private Locale locale;
    private ResourceBundle resourceBundle;

    public void changeToLogInFrench(TextField usern, TextField pass, Button login) {
       // Locale locale=Locale.FRENCH;
       //ResourceBundle labels = ResourceBundle.getBundle("MyBundle_fr", locale);
        locale=Locale.FRENCH;
        resourceBundle= ResourceBundle.getBundle("MyBundle_fr", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(resourceBundle.getString("w3"));
        pass.setText(resourceBundle.getString("w2"));
        login.setText(resourceBundle.getString("w1"));
    }

    public void changeToLogInRo(TextField usern, TextField pass, Button login) {
        locale=Locale.FRENCH;
        resourceBundle= ResourceBundle.getBundle("MyBundle_ro", locale);
        //System.out.println(labels.getString("w1"));
        usern.setText(resourceBundle.getString("w3"));
        pass.setText(resourceBundle.getString("w2"));
        login.setText(resourceBundle.getString("w1"));
    }

    public void changeToLogInTurkish(TextField usern, TextField pass, Button login) {
        locale=Locale.FRENCH;
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


    public void changeToEmployeeFrench(Button viewF, Button search, Button filter, Button viewS, Button saveR, Button add, Button update, Button delete, Button logOut, ComboBox<String> comboF,ComboBox<String> comboS,TextField newName,TextField newColor,TextField newPrice,TextField newAvail,TextField newQuant) {
        locale=Locale.FRENCH;
        resourceBundle= ResourceBundle.getBundle("MyBundle_fr", locale);
        viewF.setText(resourceBundle.getString("w4"));
        search.setText(resourceBundle.getString("w5"));
        filter.setText(resourceBundle.getString("w6"));
        viewS.setText(resourceBundle.getString("w7"));
        saveR.setText(resourceBundle.getString("w8"));
        add.setText(resourceBundle.getString("w9"));
        update.setText(resourceBundle.getString("w10"));
        delete.setText(resourceBundle.getString("w11"));
        logOut.setText(resourceBundle.getString("w12"));
        newName.setText(resourceBundle.getString("w13"));
        newColor.setText(resourceBundle.getString("w14"));
        newPrice.setText(resourceBundle.getString("w15"));
        newAvail.setText(resourceBundle.getString("w16"));
        newQuant.setText(resourceBundle.getString("w17"));
        comboF.getItems().removeAll();
        ObservableList<String> list1= FXCollections.observableArrayList();
        list1.add(resourceBundle.getString("w13"));
        list1.add(resourceBundle.getString("w14"));
        list1.add(resourceBundle.getString("w15"));
        list1.add(resourceBundle.getString("w16"));
        list1.add(resourceBundle.getString("w17"));
        comboF.setItems(list1);
        comboS.getItems().removeAll();
        ObservableList<String> list2=FXCollections.observableArrayList();
        list2.add(resourceBundle.getString("w14"));
        list2.add(resourceBundle.getString("w16"));
        list2.add(resourceBundle.getString("w17"));
        comboS.setItems(list2);
    }


    public void changeToEmployeeRo(Button viewF, Button search, Button filter, Button viewS, Button saveR, Button add, Button update, Button delete, Button logOut, ComboBox<String> comboFilter, ComboBox<String> comboStat,TextField newName,TextField newColor,TextField newPrice,TextField newAvail,TextField newQuant) {
        locale=new Locale("ro","RO");
        resourceBundle= ResourceBundle.getBundle("MyBundle_ro", locale);
        viewF.setText(resourceBundle.getString("w4"));
        search.setText(resourceBundle.getString("w5"));
        filter.setText(resourceBundle.getString("w6"));
        viewS.setText(resourceBundle.getString("w7"));
        saveR.setText(resourceBundle.getString("w8"));
        add.setText(resourceBundle.getString("w9"));
        update.setText(resourceBundle.getString("w10"));
        delete.setText(resourceBundle.getString("w11"));
        logOut.setText(resourceBundle.getString("w12"));
        newName.setText(resourceBundle.getString("w13"));
        newColor.setText(resourceBundle.getString("w14"));
        newPrice.setText(resourceBundle.getString("w15"));
        newAvail.setText(resourceBundle.getString("w16"));
        newQuant.setText(resourceBundle.getString("w17"));
        comboFilter.getItems().removeAll();
        ObservableList<String> list1= FXCollections.observableArrayList();
        list1.add(resourceBundle.getString("w13"));
        list1.add(resourceBundle.getString("w14"));
        list1.add(resourceBundle.getString("w15"));
        list1.add(resourceBundle.getString("w16"));
        list1.add(resourceBundle.getString("w17"));
        comboFilter.setItems(list1);
        comboStat.getItems().removeAll();
        ObservableList<String> list2=FXCollections.observableArrayList();
        list2.add(resourceBundle.getString("w14"));
        list2.add(resourceBundle.getString("w16"));
        list2.add(resourceBundle.getString("w17"));
        comboStat.setItems(list2);

    }

    public void changeToEmployeeTurkish(Button viewF, Button search, Button filter, Button viewS, Button saveR, Button add, Button update, Button delete, Button logOut, ComboBox<String> comboFilter, ComboBox<String> comboStat,TextField newName,TextField newColor,TextField newPrice,TextField newAvail,TextField newQuant) {
        locale=new Locale("tr","TR");
        resourceBundle= ResourceBundle.getBundle("MyBundle_tr", locale);
        viewF.setText(resourceBundle.getString("w4"));
        search.setText(resourceBundle.getString("w5"));
        filter.setText(resourceBundle.getString("w6"));
        viewS.setText(resourceBundle.getString("w7"));
        saveR.setText(resourceBundle.getString("w8"));
        add.setText(resourceBundle.getString("w9"));
        update.setText(resourceBundle.getString("w10"));
        delete.setText(resourceBundle.getString("w11"));
        logOut.setText(resourceBundle.getString("w12"));
        newName.setText(resourceBundle.getString("w13"));
        newColor.setText(resourceBundle.getString("w14"));
        newPrice.setText(resourceBundle.getString("w15"));
        newAvail.setText(resourceBundle.getString("w16"));
        newQuant.setText(resourceBundle.getString("w17"));
        comboFilter.getItems().removeAll();
        ObservableList<String> list1= FXCollections.observableArrayList();
        list1.add(resourceBundle.getString("w13"));
        list1.add(resourceBundle.getString("w14"));
        list1.add(resourceBundle.getString("w15"));
        list1.add(resourceBundle.getString("w16"));
        list1.add(resourceBundle.getString("w17"));
        comboFilter.setItems(list1);
        comboStat.getItems().removeAll();
        ObservableList<String> list2=FXCollections.observableArrayList();
        list2.add(resourceBundle.getString("w14"));
        list2.add(resourceBundle.getString("w16"));
        list2.add(resourceBundle.getString("w17"));
        comboStat.setItems(list2);

    }


    public void changeToAdminFrench(Label employees, Button delete, Button view, Button update, Button logOut,  TextField newName, TextField newName1, TextField newRole, TextField newUsername) {
        locale=Locale.FRENCH;
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

    public void changeToAdminTurkish(Label employees, Button delete, Button view, Button update, Button logOut,  TextField newName, TextField newName1, TextField newRole, TextField newUsername) {
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

    public void changeToAdminRo(Label employees, Button delete, Button view, Button update, Button logOut,  TextField newName, TextField newName1, TextField newRole, TextField newUsername) {
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
