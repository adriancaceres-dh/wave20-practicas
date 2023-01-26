package com.bootcamp.clothes_relational.dto.common;

import com.bootcamp.clothes_relational.model.Garment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
public class SaleDTO {

    private Long number;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Double total;
    @JsonProperty("payment_method")
    private String paymentMethod;
    private List<Garment> clothes;
}
