package com.example.DTO.Repository;

import com.example.DTO.Models.Person;
import com.example.DTO.Models.Symptom;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonRepository {
    private List<Person> people;

    public PersonRepository() {
        this.people = new ArrayList<>();
        people.add(new Person(1, "Roberto", "Pettinato", 61, new int[]{1, 2}));
        people.add(new Person(2, "Lautaro", "Walsh", 27, new int[]{1, 3}));
        people.add(new Person(3, "Amanda", "Sanpedro", 90, new int[]{2, 3}));
        people.add(new Person(4, "Julian", "Alvarez", 22, new int[]{3, 1}));

    }
}
