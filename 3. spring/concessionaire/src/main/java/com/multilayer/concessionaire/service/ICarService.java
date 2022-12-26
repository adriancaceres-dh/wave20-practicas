package com.multilayer.concessionaire.service;

import com.multilayer.concessionaire.model.CarModel;

import java.util.List;

public interface ICarService {
    public boolean addOne(CarModel newcar);
    public List<CarModel> readAll();
    public List<CarModel> readAllFilterByDate(Integer since, Integer to);
    public List<CarModel> readAllFilterByPrice(Integer since, Integer to);
    public List<CarModel> readOne(int id);

}
