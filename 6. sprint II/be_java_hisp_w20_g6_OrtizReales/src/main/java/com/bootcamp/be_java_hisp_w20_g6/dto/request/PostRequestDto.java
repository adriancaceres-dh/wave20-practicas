package com.bootcamp.be_java_hisp_w20_g6.dto.request;

import com.bootcamp.be_java_hisp_w20_g6.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostRequestDto {
    @NotNull(message = "El  id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer user_id;
    @NotBlank(message = "La fecha no puede estar vacía.")
    private String date;
    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;
    @Valid
    private ProductRequestDto product;
    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    private boolean has_promo;
    private Double discount;

    public PostRequestDto(int user_id, String date, int category, ProductRequestDto productRequestDto, double price) {
        this.user_id = user_id;
        this.date = date;
        this.category = category;
        this.product = productRequestDto;
        this.price = price;
    }
}
