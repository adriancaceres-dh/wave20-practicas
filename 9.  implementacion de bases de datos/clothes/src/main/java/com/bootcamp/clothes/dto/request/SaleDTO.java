package com.bootcamp.clothes.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleDTO {

    private Integer number;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private Double total;

    @JsonProperty("means_payment")
    private String meansPayment;

    @JsonProperty("customer_id")
    private Integer idCustomer;

    @JsonProperty("clothes")
    private List<ClotheSaleListDTO> clotheSales;
}
