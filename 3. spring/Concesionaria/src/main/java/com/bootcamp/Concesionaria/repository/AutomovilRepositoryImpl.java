package com.bootcamp.Concesionaria.repository;

import com.bootcamp.Concesionaria.model.Automovil;
import com.bootcamp.Concesionaria.model.Service;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
@Repository
public class AutomovilRepositoryImpl implements IAutomovilRepository{

    int contador = 0;
    List<Automovil> listaAutos =new ArrayList<>();
    @Override
    public List<Automovil> listaAutos() {

        if (contador == 0) {
            Service s1 = Service.builder().date("14-09-1990").kilometers("100122").description("cambio de filtro").build();
            Service s2 = Service.builder().date("14-09-1991").kilometers("200122").description("cambio de estanque").build();
            Service s3 = Service.builder().date("14-09-1992").kilometers("60000").description("cambio rodamientos").build();

            List<Service> listaService = new ArrayList<>() {{
                add(s1);
                add(s2);
            }};
            List<Service> listaService2 = new ArrayList<>() {{
                add(s1);
                add(s2);
                add(s3);
            }};

            Automovil a1 = new Automovil(1, "suzuky", "switf", new GregorianCalendar(2010, 9, 14).getTime(), "342344",
                    "5", 7500000, "CL", listaService, "2");

            Automovil a2 = new Automovil(2, "mazda", "new 3", new GregorianCalendar(1990, 9, 14).getTime(), "34234",
                    "5", 11990000, "CL", listaService2, "1");

            listaAutos.add(a1);
            listaAutos.add(a2);

            contador++;

        }

        return listaAutos;
    }
}
