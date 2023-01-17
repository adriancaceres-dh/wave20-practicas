package com.bootcamp.be_java_hisp_w20_g7.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ExceptionDTO {

    String name;
    String message;
}
