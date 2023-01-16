package com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestDTO {

    @NotNull(message = "El id del producto no puede estar vacío")
    @Min(value = 1, message = "El id del producto debe ser mayor a 0")
    private Integer product_id;

    @NotNull(message = "El nombre del producto no puede estar vacío")
    @Size(max = 40, message = "La longitud de nombre no puede superar los 40 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "El campo nombre no puede poseer caracteres especiales")
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String product_name;

    @NotNull(message = "El campo tipo no puede estar vacio")
    @NotBlank(message = "El campo tipo no puede estar vacio")
    @Size(max = 15, message = "La longitud del tipo no puede superar los 15 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "El campo tipo no puede poseer caracteres especiales")
    private String type;
    @NotNull(message = "El campo brand no puede estar vacio")
    @NotBlank(message = "El campo brand no puede estar vacio")
    @Size(max = 25, message = "La longitud del brand no puede superar los 25 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "El campo brand no puede poseer caracteres especiales")
    private String brand;

    @NotNull(message = "El campo color no puede estar vacío")
    @NotBlank(message = "El campo color no puede estar vacío")
    @Size(max = 15, message = "La longitud del color no puede superar los 15 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "El campo color no puede poseer caracteres especiales")
    private String color;

    @Size(max = 80, message = "La longitud de las notas no puede superar los 80 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "El campo notas no puede poseer caracteres especiales")
    private String notes;
}
