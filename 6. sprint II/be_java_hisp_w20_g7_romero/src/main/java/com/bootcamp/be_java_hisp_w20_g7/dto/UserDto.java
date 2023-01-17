package com.bootcamp.be_java_hisp_w20_g7.dto;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    @NotBlank(message = "El id no puede estar vacio")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private int userId;

    @NotNull(message = "Nombre de usuario no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "(([A-Z]* | [a-z]* | [ñ,ó,í,á,é,ú,Á,Ó,É,Í,Ú]*))*", message = "Nombre de usuario no puede poseer caracteres especiales")
    private String userName;

}
