package com.socialMeli.be_java_hisp_w20_g03.dto.request;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    @NotNull(message = "La id no puede estar vacía.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private int productId;
    @JsonProperty("product_name")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "[A-Za-z0-9 ]+", message="El campo no puede poseer caracteres especiales.")
    private String productName;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-Za-z0-9 ]+", message="El campo no puede poseer caracteres especiales.")
    private String type;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "[A-Za-z0-9 ]+", message="El campo no puede poseer caracteres especiales.")
    private String brand;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-Za-z0-9 ]+", message="El campo no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[A-Za-z0-9 ]+", message="El campo no puede poseer caracteres especiales.")
    private String notes;
}
