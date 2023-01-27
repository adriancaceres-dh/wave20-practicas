package com.example.segurosvehiculos.utils;

import com.example.segurosvehiculos.model.Vehiculo;

import java.time.Year;

public class TestVehicleUtils {
  public static Vehiculo getTestVehicle() {
    return Vehiculo.builder()
      .id(1)
      .marca("Ford")
      .modelo("Fiesta")
      .anio(Year.of(2010))
      .patente("1234ABC")
      .cantRuedas(4)
      .build();
  }

  public static Vehiculo getTestVehicleManufacturedYhisYear() {
    return Vehiculo.builder()
      .id(2)
      .marca("Ford")
      .modelo("Fiesta")
      .anio(Year.now())
      .patente("1234ABC")
      .cantRuedas(4)
      .build();
  }
}
