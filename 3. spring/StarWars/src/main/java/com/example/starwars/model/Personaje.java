package com.example.starwars.model;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Personaje {
  @NonNull
  private String name;
  @NonNull
  private int height;
  @NonNull
  private int mass;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  @NonNull
  private String gender;
  @NonNull
  private String homeworld;
  @NonNull
  private String species;
}
