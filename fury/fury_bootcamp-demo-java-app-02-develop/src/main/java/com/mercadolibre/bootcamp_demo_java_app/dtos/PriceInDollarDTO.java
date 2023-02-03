package com.mercadolibre.bootcamp_demo_java_app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceInDollarDTO {
    private String item_id;
    private Double price_usd;
}
