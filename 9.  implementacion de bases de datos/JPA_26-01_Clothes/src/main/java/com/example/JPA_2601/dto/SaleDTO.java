package com.example.JPA_2601.dto;

import com.example.JPA_2601.entity.Cloth;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleDTO {
    private Integer numero;

    private LocalDate fecha;

    private Double total;

    private String medioDePago;

    private List<Cloth> clothList;
}
