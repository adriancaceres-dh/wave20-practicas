package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre de la materia no puede superar los 30 caracteres.")
    String name;

    @NotNull(message = "La nota de la materia no puede estar vacía.")
    @DecimalMax(value = "10.0", message = "La nota máxima de la materia es de 10 pts.")
    @DecimalMin(value = "0.0", message = "La nota mínima de la materia es de 0 pts.")
    Double score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDTO)) return false;
        SubjectDTO that = (SubjectDTO) o;
        return getName().equals(that.getName()) && getScore().equals(that.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScore());
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
