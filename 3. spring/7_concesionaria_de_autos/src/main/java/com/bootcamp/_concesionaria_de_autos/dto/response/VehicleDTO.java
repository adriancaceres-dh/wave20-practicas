package com.bootcamp._concesionaria_de_autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VehicleDTO {

    String brand,model,manufacturingData,numberOfKilometers,doors,price,currency,countOfOwners;
}
