package com.softserveinc.application.player;

import lombok.Data;
import java.util.List;

@Data
public class Player {

    private String name;
    private int age;
    private int experience;
    private List<Integer> skills;
}