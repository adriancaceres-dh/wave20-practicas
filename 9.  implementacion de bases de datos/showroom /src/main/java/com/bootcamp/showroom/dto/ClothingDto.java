package com.bootcamp.showroom.dto;

import lombok.*;
import org.springframework.lang.Nullable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClothingDto {
    @Nullable
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double price;
}
