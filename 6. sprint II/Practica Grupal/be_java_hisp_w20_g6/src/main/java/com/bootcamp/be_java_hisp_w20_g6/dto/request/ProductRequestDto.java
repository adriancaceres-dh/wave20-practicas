package com.bootcamp.be_java_hisp_w20_g6.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer product_id;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="(\\w|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ|\\s)*", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    private String product_name;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="(\\w|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ|\\s)*", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    private String type;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="(\\w|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ|\\s)*", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    private String brand;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="(\\w|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ|\\s)*", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    private String color;
    @Pattern(regexp="(\\w|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ|\\s)*", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    private String notes;
}
