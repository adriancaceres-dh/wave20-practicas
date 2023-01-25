package com.example.vehiculosysiniestros.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VehicleLicensePlateResponseDto {
    @JsonProperty("license_plate")
    private String licensePlate;
}
