package com.example.lasperlas.dto;

import com.example.lasperlas.utilities.Action;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionResponseDTO {
    @JsonProperty("nro_id")
    private Integer nroId;
    private Action action;
}
