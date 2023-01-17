package com.bootcamp.be_java_hisp_w20_g2.dto;

import com.bootcamp.be_java_hisp_w20_g2.utils.constants.RegexConstants;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO {
    @NotNull(message = "El id_post no puede estar vacío.") // Se paso a Integer para que pueda agarrar el @ e identificarlo como null.
    @Positive(message = "El id_post debe ser mayor a cero.")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40,message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = RegexConstants.NO_SPECIAL_CHARACTERS,message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = RegexConstants.NO_SPECIAL_CHARACTERS,message = "El campo no puede poseer caracteres especiales.") // Especificar en el Readme que caracteres se evaluan.
    private String type;
    private String brand;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 15,message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = RegexConstants.NO_SPECIAL_CHARACTERS,message = "El campo no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80,message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = RegexConstants.NO_SPECIAL_CHARACTERS,message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
