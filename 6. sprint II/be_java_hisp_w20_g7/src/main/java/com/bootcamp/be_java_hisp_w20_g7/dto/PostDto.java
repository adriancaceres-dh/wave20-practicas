package com.bootcamp.be_java_hisp_w20_g7.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {

    @NotNull(message = "userId is a mandatory field")
    @Min(value = 1, message = "Id must be greater than 0")
    private int userId;

    //@NotBlank(message = "Id cannot be empty")
    @NotNull(message = "postId is a mandatory field")
    @Min(value = 1, message = "Id must be greater than 0")
    private int postId;
    @NotEmpty(message = "Date cannot be empty")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @NotNull(message = "userId is a mandatory field")
    private ProductDto product;

    @NotNull(message = "Field cannot be empty")
    @Min(value = 1, message = "category must be greather than 0")
    private int category;

    //@NotEmpty(message = "Field cannot be empty")
    @Max(value = 10000000, message = "Max price is 10000000")
    @Min(1000)
    private double price;

}
