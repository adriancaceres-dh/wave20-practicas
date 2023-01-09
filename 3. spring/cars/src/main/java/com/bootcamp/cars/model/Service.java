package com.bootcamp.cars.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Service {
    private String idService;
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
