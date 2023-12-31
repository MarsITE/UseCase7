package com.softserveinc.application.student;

import lombok.Data;

@Data
public class Student {

    private String name;
    private int age;
    private int grade;
    private boolean exceptional;
    private boolean honorRoll;
    private boolean passed;
}
