package com.mercadolibre.starwars.dto;


import java.util.Objects;

public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;


  public CharacterDTO(String name, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, String species, Integer height, Integer mass) {
    this.name = name;
    this.hair_color = hair_color;
    this.skin_color = skin_color;
    this.eye_color = eye_color;
    this.birth_year = birth_year;
    this.gender = gender;
    this.homeworld = homeworld;
    this.species = species;
    this.height = height;
    this.mass = mass;
  }

  public CharacterDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHair_color() {
    return hair_color;
  }

  public void setHair_color(String hair_color) {
    this.hair_color = hair_color;
  }

  public String getSkin_color() {
    return skin_color;
  }

  public void setSkin_color(String skin_color) {
    this.skin_color = skin_color;
  }

  public String getEye_color() {
    return eye_color;
  }

  public void setEye_color(String eye_color) {
    this.eye_color = eye_color;
  }

  public String getBirth_year() {
    return birth_year;
  }

  public void setBirth_year(String birth_year) {
    this.birth_year = birth_year;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getMass() {
    return mass;
  }

  public void setMass(Integer mass) {
    this.mass = mass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CharacterDTO)) return false;
    CharacterDTO that = (CharacterDTO) o;
    return getName().equals(that.getName()) && getHair_color().equals(that.getHair_color()) && getSkin_color().equals(that.getSkin_color()) && getEye_color().equals(that.getEye_color()) && getBirth_year().equals(that.getBirth_year()) && getGender().equals(that.getGender()) && getHomeworld().equals(that.getHomeworld()) && getSpecies().equals(that.getSpecies()) && getHeight().equals(that.getHeight()) && getMass().equals(that.getMass());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getHair_color(), getSkin_color(), getEye_color(), getBirth_year(), getGender(), getHomeworld(), getSpecies(), getHeight(), getMass());
  }

  @Override
  public String toString() {
    return "CharacterDTO{" +
            "name='" + name + '\'' +
            ", hair_color='" + hair_color + '\'' +
            ", skin_color='" + skin_color + '\'' +
            ", eye_color='" + eye_color + '\'' +
            ", birth_year='" + birth_year + '\'' +
            ", gender='" + gender + '\'' +
            ", homeworld='" + homeworld + '\'' +
            ", species='" + species + '\'' +
            ", height=" + height +
            ", mass=" + mass +
            '}';
  }
}
