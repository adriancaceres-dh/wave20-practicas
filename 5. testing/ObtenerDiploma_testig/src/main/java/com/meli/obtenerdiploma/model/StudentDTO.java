package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    Long id;

    @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<@Valid SubjectDTO> subjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO)) return false;
        StudentDTO that = (StudentDTO) o;
        return getId().equals(that.getId()) && getStudentName().equals(that.getStudentName()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getAverageScore(), that.getAverageScore()) && getSubjects().equals(that.getSubjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentName(), getMessage(), getAverageScore(), getSubjects());
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", message='" + message + '\'' +
                ", averageScore=" + averageScore +
                ", subjects=" + subjects +
                '}';
    }
}
