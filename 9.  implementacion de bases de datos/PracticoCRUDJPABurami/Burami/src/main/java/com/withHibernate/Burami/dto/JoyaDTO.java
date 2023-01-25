package com.withHibernate.Burami.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {
    private Long idJoya;
    private String nombre;
    private String material;
    private Integer peso;
    private String Particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
