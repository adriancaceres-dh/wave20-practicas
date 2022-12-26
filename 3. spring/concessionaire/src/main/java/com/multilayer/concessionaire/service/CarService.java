package com.multilayer.concessionaire.service;

import com.multilayer.concessionaire.DAO.CarDAO;
import com.multilayer.concessionaire.model.CarModel;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ToString
public class CarService implements ICarService  {

    @Autowired
    CarDAO cars;


    @Override
    public boolean addOne(CarModel newcar) {
        List<CarModel>  carList = cars.loadDataBase();


        return false;
    }

    @Override
    public List<CarModel> readAll() {
        return cars.loadDataBase();
    }

    @Override
    public List<CarModel> readAllFilterByDate(Integer since, Integer to) {
        List<CarModel>  carList = cars.loadDataBase();
        return carList.stream().filter(item -> item.getDate() >=since && item.getDate() <=to).collect(Collectors.toList());
    }
    @Override
    public List<CarModel> readAllFilterByPrice(Integer since, Integer to) {
        List<CarModel>  carList = cars.loadDataBase();
        return carList.stream().filter(item -> item.getPrice() >=since && item.getPrice() <=to).collect(Collectors.toList());
    }


    @Override
    public List<CarModel> readOne(int id) {
        return null;
    }
}
