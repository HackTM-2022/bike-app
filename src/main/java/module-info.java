module codes.razvan.hacktm.bikeapp.bikeapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires static lombok;
    requires java.desktop;
    requires unirest.java;
    requires json.simple;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.pi4j;
    requires commons.httpclient;
    requires httpclient;

    opens codes.razvan.hacktm.bikeapp.bikeapp to javafx.fxml;
    exports codes.razvan.hacktm.bikeapp.bikeapp;
    exports codes.razvan.hacktm.bikeapp.bikeapp.responses;
    exports codes.razvan.hacktm.bikeapp.bikeapp.request;
    opens codes.razvan.hacktm.bikeapp.bikeapp.responses to javafx.fxml;
}