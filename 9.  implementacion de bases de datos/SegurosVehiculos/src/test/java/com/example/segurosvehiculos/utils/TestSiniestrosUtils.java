package com.example.segurosvehiculos.utils;

import com.example.segurosvehiculos.model.Siniestro;
import com.example.segurosvehiculos.model.Vehiculo;
import com.example.segurosvehiculos.repository.IVehiculosRepository;

import java.time.LocalDate;

public class TestSiniestrosUtils {

  private final IVehiculosRepository vehiculosRepository;

  public TestSiniestrosUtils(IVehiculosRepository vehiculosRepository) {
    this.vehiculosRepository = vehiculosRepository;
  }

  public static Siniestro getTestSiniestro(Vehiculo vehiculo) {
    return Siniestro.builder()
      .id(1)
      .fecha(LocalDate.of(2021, 1, 1))
      .perdidaTotal(8000)
      .vehiculo(vehiculo)
      .build();

  }

  public static Siniestro getTestExpensiveSiniestro(Vehiculo vehiculo) {
    return Siniestro.builder()
      .id(2)
      .fecha(LocalDate.now())
      .perdidaTotal(12000)
      .vehiculo(vehiculo)
      .build();
  }


}
