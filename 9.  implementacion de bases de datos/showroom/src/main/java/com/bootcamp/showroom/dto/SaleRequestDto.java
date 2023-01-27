package com.bootcamp.showroom.dto;

import com.bootcamp.showroom.entity.Clothing;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequestDto {
    private LocalDate date;
    private String paymentMethod;
    private List<Long> clothingIdList;
}
