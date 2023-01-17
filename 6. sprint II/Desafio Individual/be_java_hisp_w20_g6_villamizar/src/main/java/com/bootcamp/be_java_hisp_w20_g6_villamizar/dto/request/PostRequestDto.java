package com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class PostRequestDto {
    @NotNull(message = "El  id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer user_id;
    @NotBlank(message = "La fecha no puede estar vacía.")
    private String date;
    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;
    @Valid
    private ProductRequestDto product;
    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    private boolean has_promo;
    private Double discount;
}
