package com.bootcamp.ejercicio.dto.response;

import com.bootcamp.ejercicio.dto.PersonajeDto;
import com.bootcamp.ejercicio.model.Personaje;

public class PersonajeResponseDto {

    private String mensaje;
    private PersonajeDto personajeDto;

    public PersonajeResponseDto() {
    }

    public PersonajeResponseDto(String mensaje, PersonajeDto personajeDto) {
        this.mensaje = mensaje;
        this.personajeDto = personajeDto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public PersonajeDto getPersonajeDto() {
        return personajeDto;
    }

    public void setPersonajeDto(PersonajeDto personajeDto) {
        this.personajeDto = personajeDto;
    }
}
