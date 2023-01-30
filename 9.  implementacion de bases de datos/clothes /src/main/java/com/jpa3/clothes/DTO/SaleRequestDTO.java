package com.jpa3.clothes.DTO;

import com.jpa3.clothes.Entity.SalePOC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequestDTO {
    private Integer code;
    private LocalDate date;
    private Double total;
    private String payment_method;
    private Integer[] clothes;
}
