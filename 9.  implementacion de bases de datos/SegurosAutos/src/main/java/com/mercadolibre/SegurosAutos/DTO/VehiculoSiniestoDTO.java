package com.mercadolibre.SegurosAutos.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.SegurosAutos.models.Siniestro;


import java.time.LocalDate;
import java.util.List;

public class VehiculoSiniestoDTO {

    private Integer id;

    private String marca;
    private String modelo;


    private List<Siniestro> siniestro;

}
