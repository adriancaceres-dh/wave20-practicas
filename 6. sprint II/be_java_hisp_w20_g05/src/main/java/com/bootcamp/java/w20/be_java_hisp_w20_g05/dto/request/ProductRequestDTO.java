package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {
    @NotNull(message = "La Id no puede estar vacia.")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    @JsonProperty("user_id")
    private int id;

    @NotBlank(message = "El campo no puede estar vacio.")
    @Pattern(regexp = "^[a-zA-Z0-9_\\s]*$", message = "El campo product-name no puede tener caracteres especiales.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @JsonProperty("user_name")
    private String name;

    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "El campo type no puede tener caracteres especiales.")
    private String type;

    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "El campo brand no puede tener caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "El campo color no puede tener caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9_\\s]*$", message = "El campo no puede tener caracteres especiales.")
    private String notes;
}
