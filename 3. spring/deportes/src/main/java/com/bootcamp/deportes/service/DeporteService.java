package com.bootcamp.deportes.service;

import com.bootcamp.deportes.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteService {
    private static List<Deporte> deporteList;

    public DeporteService(List<Deporte> deportes) {
        deporteList = deportes;
    }

    public void agDeporte (Deporte d) {
        deporteList.add(d);
    }

    public static List<Deporte> getDeporteList() {
        return deporteList;
    }
}
