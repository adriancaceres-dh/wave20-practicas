package com.bootcamp.showroom.dto;

import com.bootcamp.showroom.entity.Clothing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponseDto {
    private Long id;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<ClothingDto> clothingList;
}
