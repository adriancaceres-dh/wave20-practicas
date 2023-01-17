package com.bootcamp.be_java_hisp_w20_g2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    @NotNull(message = "El id no puede estar vacío.")
    // Se paso a Integer para que pueda agarrar el @ e identificarlo como null.
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacía.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy") // Verificar que funcione.
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductDTO product;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El precio debe ser mayor a cero")
    @Max(value = 10000000, message = "El precio máximo por producto es 10.000.000")
    private Double price;
}