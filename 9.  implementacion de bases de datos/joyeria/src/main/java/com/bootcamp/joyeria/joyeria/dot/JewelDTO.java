package com.bootcamp.joyeria.joyeria.dot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelDTO {

    private Long IdNum;
    @JsonProperty("nombre")
    private String name;

    private String material;
    @JsonProperty("peso")
    private Double weight;
    @JsonProperty("particularidad")
    private String particularity;
    @JsonProperty("posee_piedra")
    private Boolean hasStone;
    @JsonProperty("ventaONo")
    private Boolean saleOrNo;
}
