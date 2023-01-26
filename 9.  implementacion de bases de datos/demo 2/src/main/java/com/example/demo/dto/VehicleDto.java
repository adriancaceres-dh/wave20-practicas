package com.example.demo.dto;

import com.example.demo.model.Person;
import com.example.demo.model.Sinister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    @Nullable
    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
    private Long fabricacion;
    private Integer cantidad_ruedas;
    @Nullable
    private List<Sinister> sinisters;
    private Person person;
}
