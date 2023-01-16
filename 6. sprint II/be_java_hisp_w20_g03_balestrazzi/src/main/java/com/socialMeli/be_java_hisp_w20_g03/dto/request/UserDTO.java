package com.socialMeli.be_java_hisp_w20_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

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
    @Size(max = 15, message = "El nombre de usuario debe tener menos de 15 caracteres")
    private String userName;
}
