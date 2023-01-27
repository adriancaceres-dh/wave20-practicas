package com.example.demo.dto;

import com.example.demo.model.Vehicle;
import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinisterDto {

    @Nullable
    private Integer id;
    private LocalDate fecha;
    private Double perdida_economica;
    private Integer vehiculo;
}
