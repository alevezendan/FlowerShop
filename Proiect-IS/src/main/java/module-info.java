module Proiect.IS {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires  javafx.base;
    requires  java.desktop;

    requires  javafx.fxmlEmpty;
    requires commons.collections;
    // requires
    requires java.persistence;

    exports model;
    exports start to javafx.graphics;

    opens model to javafx.graphics;
    opens controller;
}