package com.example.ejercicio_concesionaria_de_autos.repository;

import com.example.ejercicio_concesionaria_de_autos.entity.Auto;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAutoRepository {

    List<Auto> findAll();

    void save (Auto auto);

    List<Auto> findByDate(LocalDate minDate, LocalDate maxLocalDate);

    List<Auto> findByPrice(double minPrice,double MaxPrice);

    Auto findById(long id);
}
