package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequestDTO {

    //Id_Post no viene!

    @NotNull(message = "El ID no puede estar vacio")
    @Positive(message = "El ID debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer user_id;

    @NotNull(message = "La fecha no puede estar vacia")
    @PastOrPresent(message = "La fecha no puede ser una fecha futura")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @Valid
    @NotNull(message = "El producto no puede estar vacio")
    @JsonProperty("product")
    private ProductDTO productDTO;
    @NotNull(message = "El ID de la categoria no puede estar vacio")
    private Integer category;
    @NotNull(message = "El precio no puede estar vacio")
    @DecimalMax(value = "10000000.0", message = "El precio el producto no puede superar los 10.000.000 millones")
    private Double price;

    private boolean has_promo;
    private Double discount;
}
