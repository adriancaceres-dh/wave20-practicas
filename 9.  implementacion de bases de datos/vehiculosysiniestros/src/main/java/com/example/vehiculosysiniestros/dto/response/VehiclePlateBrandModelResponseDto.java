package com.example.vehiculosysiniestros.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiclePlateBrandModelResponseDto {
    @JsonProperty("license_plate")
    private String licensePlate;
    private String brand;
    private String model;
}
