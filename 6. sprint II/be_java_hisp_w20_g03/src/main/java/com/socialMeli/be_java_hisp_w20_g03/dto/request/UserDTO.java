package com.socialMeli.be_java_hisp_w20_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("user_id")
    @NotNull(message = "El id no puede estar vacio")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private int userId;
    @JsonProperty("user_name")
    @NotBlank(message = "El nombre de usuario no puede estar vacio")
    @Max(value = 15, message = "El nombre de usuario debe tener menos de 15 caracteres")
    private String userName;
}
