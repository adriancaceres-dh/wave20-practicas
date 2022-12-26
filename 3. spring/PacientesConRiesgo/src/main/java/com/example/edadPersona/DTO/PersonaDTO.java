package com.example.edadPersona.DTO;

import com.example.edadPersona.entity.Persona;
import com.example.edadPersona.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO implements Serializable {
    private Long id;
    private String nombreCompleto;
    private Integer edad;
    private Set<Sintoma> sintomasRiesgo;

}
