package com.bootcamp.concesionaria_autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AfterPostVehicleDTO {

    private int vehicleId;
    private String message;
}
