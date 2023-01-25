package com.jpa.la_perla.dto;

import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JewerlyRequestDto {

    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    @Nullable
    //Nullable porque no deberia llegar este attb en el body de la request porque solo cambia de estado
    // con la eliminacion del objeto.
    //La eliminacion se realiza a traves del endpoint correspondiente.
    private Boolean venta_o_no;



}
