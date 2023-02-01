package com.mercadolibre.bootcamp_demo_java_app.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDTO
{


    private Double ratio;
    @JsonProperty("mercado_pago_ratio")
    private Double mercado_pago_ratio;



}
