package com.bootcamp.ConcesionariaAutos.Respositories;

import com.bootcamp.ConcesionariaAutos.Models.Auto;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class AutoRespository {
    List<Auto> listaAutos;

    private List<Auto> agregarAutos(){
        List<Auto> devolver = new LinkedList<>();
        devolver.add(new Auto("Hyundai","Accent",2016-06-13, 110000, 4, 1450000, "UY", List.of(), 1));
        devolver.add(new Auto("Hyundai1","Accent","2016-06-12", 110000, 4, 1450000, "UY", List.of(), 1));
        devolver.add(new Auto("Hyundai2","Accent","2016-06-11", 110000, 4, 1450000, "UY", List.of(), 1));

    }
}
