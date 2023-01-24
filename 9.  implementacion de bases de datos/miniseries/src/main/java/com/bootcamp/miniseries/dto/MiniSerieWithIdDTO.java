package com.bootcamp.miniseries.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MiniSerieWithIdDTO {
    private Long id;

    @JsonUnwrapped
    private MiniSerieDTO miniSerieDTO;

}
