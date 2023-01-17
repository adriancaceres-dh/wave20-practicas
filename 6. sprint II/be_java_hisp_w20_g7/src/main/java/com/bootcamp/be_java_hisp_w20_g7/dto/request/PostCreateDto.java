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

    @NotNull(message = "User id is a mandatory field")
    @Min(value = 0, message = "User id must be greater than 0")
    private Integer userId;
    @NotNull(message = "Date is a mandatory filed")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "Product is a mandatory field")
    @Valid
    private ProductDto product;

    @NotNull(message = "Category is a mandatory field")
    @Min(value = 0, message = "Category must be greather than 0")
    private Integer category;

    @NotNull(message = "Price is a mandatory field")
    @Max(value = 10000000, message = "Max price is 10000000")
    @Min(value = 1000, message = "Price must be greater than o equals to 1000")
    private Double price;

}
