package com.example.football_data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private int id;
    private String name;
    private String shortName;
    private String tla;
    private String crest;
}

