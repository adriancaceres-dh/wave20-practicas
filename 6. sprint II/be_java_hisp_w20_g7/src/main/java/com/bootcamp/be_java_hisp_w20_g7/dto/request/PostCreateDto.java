package com.bootcamp.be_java_hisp_w20_g7.dto.request;

import com.bootcamp.be_java_hisp_w20_g7.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCreateDto {

    //@NotBlank(message = "Id cannot be empty")
    @Min(value = 1,message = "Id must be greater than 0")
    private int userId;
    @NotNull(message = "Date is a mandatory filed")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "product is a mandatory field")
    @Valid
    private ProductDto product;

    @NotNull(message = "Field cannot be empty")
    @Min(value = 1, message = "category must be greather than 0")
    private int category;

    //@NotEmpty(message = "Field cannot be empty")
    @Max(value = 10000000, message = "Max price is 10000000")
    @Min(1000)
    private double price;

}
