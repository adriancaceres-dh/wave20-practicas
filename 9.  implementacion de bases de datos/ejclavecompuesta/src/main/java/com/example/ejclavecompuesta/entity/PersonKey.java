package com.example.ejclavecompuesta.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class PersonKey implements Serializable {
  private Integer dni;
  private Integer numTramite;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PersonKey personKey = (PersonKey) o;

    return Objects.equals(dni, personKey.dni) &&
            Objects.equals(numTramite, personKey.numTramite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dni, numTramite);
  }
}
