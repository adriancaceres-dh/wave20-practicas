package com.bootcamp.be_java_hisp_w20_g7.dto.request;

import com.bootcamp.be_java_hisp_w20_g7.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCreateDto {

    @NotNull(message = "El id no puede estar vació")
    @Min(value = 0, message = "El id debe ser mayor a cero")
    private Integer userId;
    @NotNull(message = "La fecha no puede estar vaciá")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "Producto no puede estar vació")
    @Valid
    private ProductDto product;

    @NotNull(message = "El campo no puede estar vació")
    @Min(value = 0, message = "La categoria debe ser mayor a cero")
    private Integer category;

    @NotNull(message = "El campo no puede estar vació")
    @Max(value = 10000000, message = "El precio maximo por producto es de 10.000.000")
    @Min(value = 1, message = "El precio minimo por producto es de 1")
    private Double price;

}
