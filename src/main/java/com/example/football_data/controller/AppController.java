package com.example.football_data.controller;

import com.example.football_data.model.Team;
import com.example.football_data.task.FootballTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private ComboBox<String> competitionComboBox;

    @FXML
    private ObservableList<Team> team;
    @FXML
    private TextField competitionInput;
    @FXML
    private ListView<Team> teamListView;

    private FootballTask footballTask;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ComboBox para seleccionar una competición

        competitionComboBox.setOnAction(event -> {
            String selectedCompetition = competitionComboBox.getValue();
            String abbreviation = getAbbreviation(selectedCompetition);
            System.out.println("Abreviatura: " + abbreviation);
        });
    }

    @FXML
    public void findTeams(ActionEvent event) {

        this.team = FXCollections.observableArrayList();
        String selectedCompetition = competitionInput.getText();
        competitionInput.clear();
        competitionInput.requestFocus();
        this.teamListView.setItems(this.team);

        footballTask = new FootballTask(selectedCompetition, this.team) {

        };
        new Thread(footballTask).start();
    }

//Selecciona la abreviatura para la request a partir del nombre de la competición
    private String getAbbreviation(String competitionName) {
        switch (competitionName) {
            case "FIFA World Cup":
                return "WC";
            case "UEFA Champions League":
                return "CL";
            case "Bundesliga":
                return "BL1";
            case "Eredivisie":
                return "DED";
            case "Campeonato Brasileiro Série A":
                return "BSA";
            case "Primera Division":
                return "PD";
            case "Ligue 1":
                return "FL1";
            case "Championship":
                return "ELC";
            case "Primeira Liga":
                return "PPL";
            case "European Championship":
                return "EC";
            case "Serie A":
                return "SA";
            case "Premier League":
                return "PL";
            case "Copa Libertadores":
                return "CLI";
            default:
                return "";
        }
    }


    public void deleteText() {

    }


}