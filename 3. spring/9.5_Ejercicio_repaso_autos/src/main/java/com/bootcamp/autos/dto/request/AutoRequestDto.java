package com.bootcamp.autos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutoRequestDto {
    private String id;
    private String marca;
    private String modelo;

}
