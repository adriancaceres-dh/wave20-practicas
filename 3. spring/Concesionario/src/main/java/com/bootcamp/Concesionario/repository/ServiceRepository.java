package com.bootcamp.Concesionario.repository;

import com.bootcamp.Concesionario.models.Service;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceRepository {

    List<Service> listaServicios;

    public ServiceRepository() {
        listaServicios = new ArrayList<>();
        listaServicios.add(new Service("2003-05-20","5000","Cambio de filtro"));
        listaServicios.add(new Service("2008-02-20","10000","Cambio de aceite"));
        listaServicios.add(new Service("2001-09-11","40000","Cambio de frenos"));
        listaServicios.add(new Service("2010-10-10","20000","Cambio de pintura"));
        listaServicios.add(new Service("2000-02-06","20200","Cambio de tapizado"));
        listaServicios.add(new Service("1999-06-02","1000","Cambio de farolas"));

    }

    public List<Service> getListaServicios(){
        return listaServicios;
    }
}
