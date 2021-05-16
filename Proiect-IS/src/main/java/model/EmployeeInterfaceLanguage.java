package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class EmployeeInterfaceLanguage implements  ChangeInterface{

    private Button viewF,search,filter,viewS, saveR,  add, update, delete, logOut;
    private ComboBox<String> comboF, comboS;
    private TextField newName, newColor, newPrice,newAvail, newQuant;
    private Locale locale;
    private ResourceBundle resourceBundle;

    public EmployeeInterfaceLanguage(Button viewF, Button search, Button filter, Button viewS, Button saveR, Button add, Button update, Button delete, Button logOut, ComboBox<String> comboF,ComboBox<String> comboS,TextField newName,TextField newColor,TextField newPrice,TextField newAvail,TextField newQuant){
        this.viewF=viewF;
        this.search=search;
        this.filter=filter;
        this.viewS=viewS;
        this.saveR=saveR;
        this.add=add;
        this.update=update;
        this.delete=delete;
        this.logOut=logOut;
        this.comboF=comboF;
        this.comboS=comboS;
        this.newName=newName;this.newColor=newColor;this.newPrice=newPrice;this.newAvail=newAvail;this.newQuant=newQuant;
    }

    public EmployeeInterfaceLanguage() {
    }

    public void setViewF(Button viewF) {
        this.viewF = viewF;
    }

    public void setSearch(Button search) {
        this.search = search;
    }

    public void setFilter(Button filter) {
        this.filter = filter;
    }

    public void setViewS(Button viewS) {
        this.viewS = viewS;
    }

    public void setSaveR(Button saveR) {
        this.saveR = saveR;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public void setLogOut(Button logOut) {
        this.logOut = logOut;
    }

    public void setComboF(ComboBox<String> comboF) {
        this.comboF = comboF;
    }

    public void setComboS(ComboBox<String> comboS) {
        this.comboS = comboS;
    }

    public void setNewName(TextField newName) {
        this.newName = newName;
    }

    public void setNewColor(TextField newColor) {
        this.newColor = newColor;
    }

    public void setNewPrice(TextField newPrice) {
        this.newPrice = newPrice;
    }

    public void setNewAvail(TextField newAvail) {
        this.newAvail = newAvail;
    }

    public void setNewQuant(TextField newQuant) {
        this.newQuant = newQuant;
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

    @Override
    public void changeToRo() {
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

    @Override
    public void changeToTr() {
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
}
