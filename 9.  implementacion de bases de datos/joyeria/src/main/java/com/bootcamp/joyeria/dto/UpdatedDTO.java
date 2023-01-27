package com.bootcamp.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatedDTO {

    private Integer nroIdentificatorio;

    private JewelDTO jewelDTO;
}
