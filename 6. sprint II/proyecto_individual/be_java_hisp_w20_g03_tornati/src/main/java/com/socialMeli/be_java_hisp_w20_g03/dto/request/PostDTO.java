package com.socialMeli.be_java_hisp_w20_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
    @JsonProperty("post_id")
    @NotNull(message = "El post_id no puede estar vacio")
    //@Min(value = 1, message = "El post_id debe ser mayor a 0")
    private int postId;
    @JsonProperty("user_id")
    @NotNull(message = "El id no puede estar vacio")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private int userId;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;
    @Valid
    private ProductDTO product;
    @NotNull(message = "El campo no puede estar vacío.")
    private int category;
    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private double price;

}
