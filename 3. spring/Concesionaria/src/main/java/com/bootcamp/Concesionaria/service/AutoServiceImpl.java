package com.bootcamp.Concesionaria.service;

import com.bootcamp.Concesionaria.model.Automovil;
import com.bootcamp.Concesionaria.repository.AutomovilRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoServiceImpl implements IAutoService{
    @Autowired
    AutomovilRepositoryImpl automovilRepository;
    @Override
    public List<Automovil> obtenerListaAutos() {

        return automovilRepository.listaAutos();
    }

    @Override
    public Automovil obtenerAutoPorId(String id) {

        return automovilRepository.listaAutos().stream().filter(x->x.getId() == Integer.parseInt(id)).findFirst().get();
    }

    @Override
    public List<Automovil> obtenerPorFecha(String since, String to) {



        String[] fecha = since.split("-");
        GregorianCalendar fechaSince = new GregorianCalendar(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1])
                ,Integer.parseInt(fecha[2]));
        String[] fecha2 = to.split("-");
        GregorianCalendar fechaTo = new GregorianCalendar(Integer.parseInt(fecha2[0]),Integer.parseInt(fecha2[1])
                ,Integer.parseInt(fecha2[2]));

        Date d = fechaSince.getTime();
        Date d2 = fechaTo.getTime();



       return automovilRepository.listaAutos().stream()
                .filter(x->x.getManufacturingDate().compareTo(d)>0 )
                .filter(y->y.getManufacturingDate().compareTo(d2)<0).collect(Collectors.toList());


    }

    @Override
    public List<Automovil> obtenerPorPrice(String since, String to) {

        double priceSince = Integer.parseInt(since);
        double priceTo = Integer.parseInt(to);

       return automovilRepository.listaAutos().stream().filter(x->x.getPrice()>priceSince)
               .filter(x->x.getPrice()<priceTo).collect(Collectors.toList());

    }

    @Override
    public String guardarAuto(Automovil automovil) {
        int numberId = automovilRepository.listaAutos().size();
        automovil.setId(numberId+1);
        automovilRepository.listaAutos().add(automovil);

        return "Automovil agregado";
    }
}
