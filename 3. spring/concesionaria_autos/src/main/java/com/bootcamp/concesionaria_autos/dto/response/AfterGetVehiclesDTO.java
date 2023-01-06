package com.bootcamp.concesionaria_autos.dto.response;

import com.bootcamp.concesionaria_autos.dto.common.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AfterGetVehiclesDTO {

    private int vehicleCount;
    private List<VehicleDTO> vehicles;
}
