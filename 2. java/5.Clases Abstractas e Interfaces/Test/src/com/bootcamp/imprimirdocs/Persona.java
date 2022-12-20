package com.bootcamp.imprimirdocs;

import java.util.List;

public class Persona {
    String name;
    int age;
    List<String> skills;

    public Persona(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }


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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
