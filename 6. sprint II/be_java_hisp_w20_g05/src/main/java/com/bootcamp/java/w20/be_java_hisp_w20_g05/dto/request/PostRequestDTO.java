package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDTO {

    @JsonProperty("user_id")
    @Min(value = 1, message= "El Id debe ser mayor a 0.")
    @NotNull(message = "El Id no puede estar vacio.")
    private int userId;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "La fecha no puede estar vacia.")
    private LocalDate date;

    @Valid
    private ProductRequestDTO product;
    @NotNull(message = "La categoria no puede estar vacia.")
    private int category;

    @NotNull(message = "El precio no puede estar vacio.")
    @Max(value = 10000000 , message = "El precio maximo por producto es de 10.000.000")
    @Min(value = 0)
    private double price;
}