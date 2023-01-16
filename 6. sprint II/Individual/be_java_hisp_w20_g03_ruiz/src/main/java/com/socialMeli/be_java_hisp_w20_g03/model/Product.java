package com.socialMeli.be_java_hisp_w20_g03.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
