package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.List;
import java.util.Objects;

public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

  public HouseDTO() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<RoomDTO> getRooms() {
    return rooms;
  }

  public void setRooms(List<RoomDTO> rooms) {
    this.rooms = rooms;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof HouseDTO)) return false;
    HouseDTO houseDTO = (HouseDTO) o;
    return Objects.equals(getName(), houseDTO.getName()) && Objects.equals(getAddress(), houseDTO.getAddress()) && Objects.equals(getRooms(), houseDTO.getRooms());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAddress(), getRooms());
  }

  @Override
  public String toString() {
    return "HouseDTO{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", rooms=" + rooms +
            '}';
  }
}
