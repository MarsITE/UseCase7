package com.softserveinc.application.student;

import java.util.Objects;

public class Student {

    private String name;
    private int age;
    private int grade;
    private boolean exceptional;
    private boolean honorRoll;
    private boolean passed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isExceptional() {
        return exceptional;
    }

    public void setExceptional(boolean exceptional) {
        this.exceptional = exceptional;
    }

    public boolean isHonorRoll() {
        return honorRoll;
    }

    public void setHonorRoll(boolean honorRoll) {
        this.honorRoll = honorRoll;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && grade == student.grade && exceptional == student.exceptional && honorRoll == student.honorRoll && passed == student.passed && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grade, exceptional, honorRoll, passed);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", exceptional=" + exceptional +
                ", honorRoll=" + honorRoll +
                ", passed=" + passed +
                '}';
    }
}
