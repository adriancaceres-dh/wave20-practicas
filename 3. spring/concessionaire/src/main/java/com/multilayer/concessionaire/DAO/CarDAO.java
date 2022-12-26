package com.multilayer.concessionaire.DAO;

import com.multilayer.concessionaire.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CarDAO {
    @Autowired
    ObjectMapper objectMapper;
    public List<CarModel> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:CarMockData.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TypeReference<List<CarModel>> typeRef = new TypeReference<>() {};
        List<CarModel> cars = null;
        try {
            cars = objectMapper.readValue(file, typeRef);
            System.out.println(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
