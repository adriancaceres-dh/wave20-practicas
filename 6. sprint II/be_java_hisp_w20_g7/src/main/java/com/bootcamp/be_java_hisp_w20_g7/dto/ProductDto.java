package com.bootcamp.be_java_hisp_w20_g7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

   // @NotBlank(message = "Id cannot be empty")
    @Min(value = 1,message = "Id must be greater than 0")
    private int productId;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 40, message = "Field cannot have more than 40 characters")
    @Pattern(regexp="[A-Za-zñóíáéúÁÓÉÍÚ ]*", message = "productName cannot have especial characters")
    private String productName;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 15, message = "Type cannot have more than 15 characters")
    @Pattern(regexp="[A-Za-zñóíáéúÁÓÉÍÚ ]*", message = "type cannot have especial characters")
    private String type;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 25, message = "Brand cannot have more than 25 characters")
    @Pattern(regexp="[A-Za-zñóíáéúÁÓÉÍÚ ]*", message = "brand cannot have especial characters")
    private String brand;

    //probar que pueda ser nulo
    @Size(max = 15, message = "Color cannot have more than 15 characters")
    @Pattern(regexp="[A-Za-zñóíáéúÁÓÉÍÚ ]*", message = "color cannot have especial characters")
    private String color;

    @Size(max = 80, message = "Notes cannot have more than 80 characters")
    @Pattern(regexp="[A-Za-zñóíáéúÁÓÉÍÚ ]*", message = "Notes cannot have especial characters")
    private String notes;

}
