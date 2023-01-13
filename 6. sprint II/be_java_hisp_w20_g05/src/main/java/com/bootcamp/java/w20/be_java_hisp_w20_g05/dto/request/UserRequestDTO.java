package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @Min(value = 1, message= "El Id debe ser mayor a 0.")
    @NotNull(message = "El Id no puede estar vacio.")
    private int id;
}
