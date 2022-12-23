package com.dto.deportistas.service;

import com.dto.deportistas.model.PersonaModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonaService {
    private List<PersonaModel> listaPersonas;
    public PersonaService() {
        PersonaModel victor = new PersonaModel("Victor", "Lopez", 23);
        PersonaModel amanda = new PersonaModel("Amanda", "Rodriguez", 35);
        PersonaModel maria = new PersonaModel("Maria", "Rojas", 18);
        PersonaModel pedro = new PersonaModel("Pedro", "Torres", 30);

        listaPersonas = new ArrayList<>(Arrays.asList(victor, amanda, pedro, maria));

    }

    public List<PersonaModel> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<PersonaModel> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    @Override
    public String toString() {
        StringBuilder stringListaPersonas = new StringBuilder();
        listaPersonas.forEach(persona -> stringListaPersonas.append(persona.toString()).append(", ").append('\n'));
        return  "listaPersonas: {" + '\n' +
                stringListaPersonas + '\n' +
                '}';
    }

}
