package com.bootcamp.be_java_hisp_w20_g4.dto.request;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO {

    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Integer user_id;

    @NotNull(message = "La fecha no puede estar vacía")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductRequestDTO product;

    @NotNull(message = "El campo categoria no puede estar vacío")
    private Integer category;

    @NotNull(message = "El campo precio no puede estar vacío")
    @DecimalMax(value = "10000000", message = "El precio maximo por producto es de 10.000.000")
    private double price;
}
