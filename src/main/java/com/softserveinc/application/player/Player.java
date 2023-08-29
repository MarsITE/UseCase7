package com.softserveinc.application.player;

import java.util.List;
import java.util.Objects;

public class Player {

    public String name;
    public int age;
    public int experience;

    public List<Integer> skills;

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age && experience == player.experience && Objects.equals(name, player.name) && Objects.equals(skills, player.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, experience, skills);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", skills=" + skills +
                '}';
    }
}