package com.example.football_data.task;

import com.example.football_data.model.Team;
import com.example.football_data.service.FootballService;
import io.reactivex.Observable;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.util.function.Consumer;

public class FootballTask extends Task<Void> {

    private final String selectedCompetition;
    private final ObservableList<Team> teamList;

    public FootballTask(String selectedCompetition, ObservableList<Team> teamList) {
        this.selectedCompetition = selectedCompetition;
        this.teamList = teamList;
    }

    @Override
    protected Void call() throws Exception {

        FootballService footballService = new FootballService();

        Observable<Team> teamObservable = footballService.getStandings(selectedCompetition);

        // Manejar cualquier error aquí
        teamObservable.subscribe(team -> {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> teamList.add(team));
        }, Throwable::printStackTrace);


        return null;
    }
}
