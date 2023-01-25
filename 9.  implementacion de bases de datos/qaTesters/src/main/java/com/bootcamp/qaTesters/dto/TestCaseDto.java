package com.bootcamp.qaTesters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestCaseDto {
    private  Long id;

   // @NotNull(message = "Descrition no puede estar vacío")
    private String description;
   // @NotNull(message = "Tested no puede estar vacío")
    private Boolean tested;
   // @NotNull(message = "Passed no puede estar vacío")

    private  Boolean passed;
   // @NotNull(message = "Number of tries no puede estar vacío")

    private  int numberOfTries;
  //  @NotNull(message = "Last update no puede estar vacío")

    private LocalDate lastUpdate;
}
