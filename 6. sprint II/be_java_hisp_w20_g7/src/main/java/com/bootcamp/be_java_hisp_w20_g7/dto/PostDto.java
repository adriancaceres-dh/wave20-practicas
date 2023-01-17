package com.bootcamp.be_java_hisp_w20_g7.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {

    @NotNull(message = "El id no puede estar vacio")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private int userId;

    @NotNull(message = "El id_post no puede estar vacio")
    @Min(value = 1, message = "El id_post debe ser mayor a cero")
    private int postId;
    @NotEmpty(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @NotNull(message = "El producto no puede estar vacio")
    private ProductDto product;

    @NotNull(message = "El campo no puede estar vacio")
    @Min(value = 1, message = "Categoria debe ser mayor a cero")
    private int category;

    @NotNull(message = "El campo no puede estar vació")
    @Max(value = 10000000, message = "El precio maximo por producto es de 10.000.000")
    @Min(value = 1, message = "El precio minimo por producto es de 1")
    private double price;

}
