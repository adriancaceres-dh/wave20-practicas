package com.bootcamp.be_java_hisp_w20_g7.dto;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Min;
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

    @NotBlank(message = "userId is a mandatory field")
    @Min(value = 1, message = "Id must be greater than 0")
    private int userId;

    @NotNull(message = "userName is a mandatory field")
    @Size(max = 15, message = "Field cannot have more than 15 characters")
    @Pattern(regexp = "(([A-Z]* | [a-z]* | [ñ,ó,í,á,é,ú,Á,Ó,É,Í,Ú]*))*", message = "Name cannot hace especial characters")
    //creo que esto valida que solo sean letras ahorita lo probamos
    private String userName;

}
