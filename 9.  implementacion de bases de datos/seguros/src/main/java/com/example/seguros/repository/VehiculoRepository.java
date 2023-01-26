package com.example.seguros.repository;

import com.example.seguros.dto.templates.TemplateMarcaYPatente;
import com.example.seguros.dto.templates.TemplateMatriculaMarcaYModelo;
import com.example.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {

    @Query("SELECT v.patente FROM Vehiculo v")
    public List<String> getAllPatentes();

    @Query("SELECT new com.example.seguros.dto.templates.TemplateMarcaYPatente(v.patente,v.marca) FROM Vehiculo v ORDER BY v.fechaFabricacion")
    public List<TemplateMarcaYPatente> getAllPatentesAndMarca();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT v FROM Vehiculo v WHERE v.cantRuedas > 4 AND year(v.fechaFabricacion) = year(sysdate())")
    public List<Vehiculo> getVehiculoByCantRuedas();




}
