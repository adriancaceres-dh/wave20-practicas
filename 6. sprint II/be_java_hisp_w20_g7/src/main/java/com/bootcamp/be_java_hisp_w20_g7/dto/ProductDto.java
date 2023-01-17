package com.bootcamp.be_java_hisp_w20_g7.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    @NotNull(message = "productId is a mandatory field")
    @Min(value = 1, message = "Id must be greater than 0")
    private Integer productId;

    @NotBlank(message = "Product name cannot be blank")
    @Size(max = 40, message = "Product name cannot have more than 40 characters")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "product name cannot have especial characters")
    private String productName;

    @NotBlank(message = "Type cannot be blank")
    @Size(max = 15, message = "Type cannot have more than 15 characters")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "type cannot have especial characters")
    private String type;

    @NotBlank(message = "Brand cannot be blank")
    @Size(max = 25, message = "Brand cannot have more than 25 characters")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "Brand cannot have especial characters")
    private String brand;

    //probar que pueda ser nulo
    @NotBlank(message = "Color cannot be blank")
    @Size(max = 15, message = "Color cannot have more than 15 characters")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "Color cannot have especial characters")
    private String color;

    @Size(max = 80, message = "Notes cannot have more than 80 characters")
    @Pattern(regexp = "[A-Za-zñóíáéúÁÓÉÍÚ&[0-9] ]*", message = "Notes cannot have especial characters")
    private String notes;

}
