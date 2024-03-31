package com.example.football_data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Standings {
    private String stage;
    private String type;
    private String group;
    private List<Table> tables;
}

