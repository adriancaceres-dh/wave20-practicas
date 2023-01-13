package com.socialmeli.be_java_hisp_w20_g8.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotNull(message = "La ID no puede estar vacia")
    @Positive(message = "La ID debe ser mayor a cero")
    private Integer product_id;
    @NotBlank(message="El campo no puede estar vacio")
    @Size(max=40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "(^[a-zA-Z0-9\\s]*$)", message = "El campo no puede poseer caracteres especiales") //([a-z0-9A-Z/s]+)
    private String product_name;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "(^[a-zA-Z0-9\\s]*$)", message = "El campo no puede poseer caracteres especiales") //([a-z0-9A-Z\\s]+)
    private String type;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "(^[a-zA-Z0-9\\s]*$)", message = "El campo no puede poseer caracteres especiales") //([a-z0-9A-Z\\s]+)
    private String brand;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "(^[a-zA-Z0-9&\\s]*$)", message = "El campo no puede poseer caracteres especiales") //([a-z0-9A-Z\\s]+)
    private String color;
    @Size(max=80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "(^[a-zA-Z0-9\\s]*$)", message = "El campo no puede poseer caracteres especiales") //([a-z0-9A-Z/s]+)
    private String notes;
}
