package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    Joya create(Joya joya);
    Joya edit(Joya joya);
    List<Joya> getAll();
    Joya get(int id) throws Throwable;

    int delete(int id);


}
