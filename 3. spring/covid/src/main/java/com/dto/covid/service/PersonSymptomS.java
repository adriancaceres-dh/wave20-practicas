package com.dto.covid.service;

import com.dto.covid.model.PersonM;

import java.util.*;

public class PersonSymptomS {

    Map<Integer, int[]> personSymptomList;

    public PersonSymptomS() {
        personSymptomList = new HashMap<>();
        personSymptomList.put(1, new int[]{2, 3});
        personSymptomList.put(3, new int[]{1, 2});
        personSymptomList.put(4, new int[]{3, 4});
    }

    public Map<Integer, int[]> getPersonSymptomList() {
        return personSymptomList;
    }

    public void setPersonSymptomList(Map<Integer, int[]> personSymptomList) {
        this.personSymptomList = personSymptomList;
    }
}
