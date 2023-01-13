package com.bootcamp.be_java_hisp_w20_g7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    //@NotBlank(message = "Id cannot be empty")
    @Min(value = 1,message = "Id must be greater than 0")
    private int userId;

    @Size(max = 15, message = "Field cannot have more than 15 characters")
    @Pattern(regexp="(([A-Z]* | [a-z]* | [ñ,ó,í,á,é,ú,Á,Ó,É,Í,Ú]*))*", message = "Name cannot hace especial characters") //creo que esto valida que solo sean letras ahorita lo probamos
    private String userName;

}
