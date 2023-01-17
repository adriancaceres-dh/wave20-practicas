package com.bootcamp.be_java_hisp_w20_g1.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequestDto {
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "La fecha debe seguir el formato dd-mm-yyyy.")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;
    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Integer userId;
    @NotNull(message = "Debe ingresar un producto")
    @Valid
    private ProductRequestDto product;
    @NotNull(message = "El campo no puede estar vacío")
    @Min(value = 1, message = "El campo debe ser mayor a 0")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacío")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000")
    @DecimalMin(value = "0.10", message = "El precio mínimo por producto es de 0.1")
    private Double price;


}
