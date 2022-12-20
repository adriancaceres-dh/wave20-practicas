package com.bootcamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Resume implements ImpresoraInterface {
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthdate;
    private List<String> abilities;

    public Resume(String name, String lastName, String dni, LocalDate birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.birthdate = birthdate;
        this.abilities = new ArrayList<>();
    }

    public void addAbility(String ability) {
        abilities.add(ability);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    @Override
    public void print() {
        System.out.println("Resume: " + name + " " + lastName);
        System.out.println("DNI: " + dni);
        System.out.println("Birthdate " + birthdate.toString());
        System.out.println("Abilities: ");
        abilities.forEach(System.out::println);

    }
}
