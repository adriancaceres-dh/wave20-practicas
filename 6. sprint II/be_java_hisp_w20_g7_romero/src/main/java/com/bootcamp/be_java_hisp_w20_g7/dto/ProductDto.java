package com.bootcamp.be_java_hisp_w20_g7.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    @NotNull(message = "La id no puede estar vaciá")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vació")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "El campo no puede poseer caracteres especiales")
    private String productName;

    @NotBlank(message = "El campo no puede estar vació")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "El campo no puede poseer caracteres especiales")
    private String type;

    @NotBlank(message = "El campo no puede estar vació")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "El campo no puede poseer caracteres especiales")
    private String brand;

    @NotBlank(message = "El campo no puede estar vació")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "El campo no puede poseer caracteres especiales")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "El campo no puede poseer caracteres especiales")
    private String notes;

}
