package com.bootcamp.clothes.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClotheDTO {

    private Integer code;

    private String name;

    private String type;

    private String brand;

    private String color;

    private Integer size;

    @JsonProperty("sales_price")
    private Double salesPrice;
}
