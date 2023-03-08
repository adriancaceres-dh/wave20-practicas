package com.bootcamp.clothes.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClotheSaleListDTO {

    @JsonProperty("clothe_code")
    private Integer codeClothe;

    private Integer quantity;
}
