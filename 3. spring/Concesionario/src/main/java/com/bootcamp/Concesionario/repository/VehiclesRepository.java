package com.bootcamp.Concesionario.repository;

import com.bootcamp.Concesionario.models.Service;
import com.bootcamp.Concesionario.models.Vehicles;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class VehiclesRepository {

    ServiceRepository serviceRepository;

    List<Vehicles> listaVehiculos;
    List<Service> listaServiciosCar1;
    List<Service> listaServiciosCar2;
    List<Service> listaServiciosCar3;
    public VehiclesRepository(){

        serviceRepository = new ServiceRepository();
        listaVehiculos = new ArrayList<>();


        listaServiciosCar1 = serviceRepository.getListaServicios()
                .stream().filter(service -> service.getDescriptions().contains("aceite") || service.getDescriptions().contains("filtro")).collect(Collectors.toList());

        listaServiciosCar2 = serviceRepository.getListaServicios()
                .stream().filter(service -> service.getDescriptions().contains("aceite") || service.getDescriptions().contains("filtro") || service.getDescriptions()
                        .contains("frenos") || service.getDescriptions().contains("pintura")).collect(Collectors.toList());

        listaServiciosCar3 = serviceRepository.getListaServicios()
                .stream().filter(service -> service.getDescriptions().contains("aceite") || service.getDescriptions().contains("filtro")
                        || service.getDescriptions().contains("tapizado") || service.getDescriptions().contains("farolas")).collect(Collectors.toList());

        listaVehiculos.add(new Vehicles("Chevrolet","Corsa","1996-10-10","15500","4",25000,"AR", listaServiciosCar1,"2"));
        listaVehiculos.add(new Vehicles("Renault","Sandero","1998-11-05","222222","4",30000,"AR", listaServiciosCar2,"5"));
        listaVehiculos.add(new Vehicles("Mazda","Mazda 3","1999-01-01","333899","4",45000,"AR", listaServiciosCar3,"1"));

    }

    public List<Vehicles> getAllVehiculos(){
        return listaVehiculos;
    }

    public boolean addVehiculo(Vehicles vehiculo){
        listaVehiculos.add(vehiculo);
        return true;
    }
}
