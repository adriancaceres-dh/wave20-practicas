package com.example.seguros.repository;

import com.example.seguros.dto.templates.TemplateMatriculaMarcaYModelo;
import com.example.seguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SiniestroRepository extends JpaRepository<Siniestro,Integer> {

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT new com.example.seguros.dto.templates.TemplateMatriculaMarcaYModelo(s.vehiculo.patente, s.vehiculo.marca,s.vehiculo.model) FROM Siniestro s WHERE s.perdidaEconomica > 10000")
    public List<TemplateMatriculaMarcaYModelo> getVehiculoBySiniestro();
}
