package com.multilayer.concessionaire.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class CarModel {
    int id;
    String make;
    String model;
    int mileage;
    int price;
    int date;
}
