module com.example.football_data {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires retrofit2;
    requires rxjava;
    requires okhttp3;
    requires okhttp3.logging;
    requires retrofit2.converter.gson;
    requires retrofit2.adapter.rxjava2;
    requires gson;
    requires lombok;

    opens com.example.football_data to javafx.fxml;
    exports com.example.football_data;
    exports com.example.football_data.controller;
    opens com.example.football_data.controller to javafx.fxml;
}