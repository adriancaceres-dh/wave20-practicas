package com.dto.covid.service;

import com.dto.covid.model.PersonM;
import com.dto.covid.model.SymptomM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonS {
    List<PersonM> personList;

    public PersonS() {
        PersonM maria = new PersonM(1, "Maria", "Lopez", 70);
        PersonM juan = new PersonM(2, "Juan", "Chacon", 70);
        PersonM pedro = new PersonM(3, "Pedro", "Rincon", 50);
        PersonM luisa = new PersonM(4, "Luis", "Rojas", 64);

        personList = Arrays.asList(maria,juan,pedro,luisa);

    }

    public List<PersonM> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonM> personList) {
        this.personList = personList;
    }



    public PersonM findOneById(int id){
        List<PersonM> result = personList.stream().filter(item -> item.getId()==id).collect(Collectors.toList());

        try{
            return result.get(0);
        }catch(Exception e){
            return new PersonM();
        }
    }
}
