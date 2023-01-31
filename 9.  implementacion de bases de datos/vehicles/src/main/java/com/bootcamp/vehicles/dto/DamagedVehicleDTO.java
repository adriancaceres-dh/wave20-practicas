package com.bootcamp.vehicles.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class DamagedVehicleDTO extends VehicleDTO {

    List<AccidentDTO> accidents;
}
