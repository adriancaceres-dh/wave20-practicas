package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.model.Servicio;
import com.bootcamp.concesionaria.model.Vehiculo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcesionariaRepositoryImpl implements ConcesionariaRepository{

    private List<Vehiculo> vehiculos;

    public ConcesionariaRepositoryImpl() {
        vehiculos = loadVehiculos();
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public List<Servicio> loadServicios(){
        List<Servicio> servicios = new ArrayList<>();
        LocalDate fecha = LocalDate.of(2015,12,20);
        Servicio s1 = new Servicio(fecha,40000,"Cambio de aceite");
        Servicio s2 = new Servicio(fecha,50000,"Cambio de filtro");
        Servicio s3 = new Servicio(fecha,70000,"Cambio de correas");
        servicios.add(s1);
        servicios.add(s2);
        servicios.add(s3);
        return servicios;
    }

    public List<Vehiculo> loadVehiculos(){
        List<Vehiculo> vehiculos = new ArrayList<>();
        List<Servicio> servicios = loadServicios();
        LocalDate fecha = LocalDate.parse("12/07/2010",DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Vehiculo v1 = new Vehiculo(1,"Peugeot","207",fecha,50000,5,1300000,"argentina",servicios,2);
        Vehiculo v2 = new Vehiculo(2,"Chevrolet","Astra",fecha,20000,3,1500000,"argentina",servicios,3);
        Vehiculo v3 = new Vehiculo(3,"Ford","Focus",fecha,10000,5,2000000,"argentina",servicios,2);
        Vehiculo v4 = new Vehiculo(4,"Volkswagen","Gol",fecha,6000,5,2200000,"argentina",servicios,1);
        Vehiculo v5 = new Vehiculo(5,"Renault","Sandero",fecha,25000,5,2500000,"argentina",servicios,3);
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        return vehiculos;
    }
}
