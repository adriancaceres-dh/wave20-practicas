package com.bootcamp.be_java_hisp_w20_g1.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductRequestDto {
    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Integer productId;
    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[\\w ]+$", message = "El campo no puede poseer caracteres especiales.")
    private String productName;
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @NotBlank(message = "El campo no puede estar vacio")
    @Pattern(regexp = "^[\\w]+$", message = "El campo no puede poseer caracteres especiales.")
    private String type;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "^[\\w]+$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @NotBlank(message = "El campo no puede estar vacío")
    @Pattern(regexp = "^[\\w]+$", message = "El campo no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "^[\\w ]+$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
