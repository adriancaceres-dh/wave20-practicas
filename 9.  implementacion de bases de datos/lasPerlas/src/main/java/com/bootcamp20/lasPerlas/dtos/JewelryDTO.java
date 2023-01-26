package com.bootcamp20.lasPerlas.dtos;

import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JewelryDTO {

    //Here validations

    @NotNull(message = "El nombre no puede estar vacio")
    private String name;

    @NotNull(message = "El material no puede estar vacio")
    @NotBlank(message = "El material no puede estar en blanco")
    private String material;

    @NotNull(message = "El peso no puede estar vacio")
    private Double weight;

    @NotNull(message = "La particularidad no puede estar vacio")
    private String specificity;

    @NotNull(message = "El pesee piedra no puede estar vacio")
    private boolean owns_stone;

    @NotNull(message = "El ventaONos no puede estar vacio")
    private boolean saleONo;
}
