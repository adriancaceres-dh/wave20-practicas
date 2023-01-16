package com.bootcamp.be_java_hisp_w20_g4.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDTO {

    private String name;
    private String description;

}
