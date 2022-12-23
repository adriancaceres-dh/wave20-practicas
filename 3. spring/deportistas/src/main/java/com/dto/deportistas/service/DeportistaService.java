package com.dto.deportistas.service;

import com.dto.deportistas.dto.DeportistaDTO;

import java.util.Arrays;
import java.util.List;

public class DeportistaService {
    List<DeportistaDTO> listaDeportista;

    public DeportistaService() {
        DeportistaDTO nadadoraAmanda = new DeportistaDTO("Amanda", "Rodriguez", "Natación");
        DeportistaDTO futbolistaPedro = new DeportistaDTO("Pedro", "Torres", "Fútbol");
        listaDeportista = Arrays.asList(nadadoraAmanda, futbolistaPedro);
    }

    public List<DeportistaDTO> getListaDeportista() {
        return listaDeportista;
    }

    public void setListaDeportista(List<DeportistaDTO> listaDeportista) {
        this.listaDeportista = listaDeportista;
    }


    @Override
    public String toString() {
        StringBuilder stringDeportistas = new StringBuilder();
        listaDeportista.forEach(deportista -> stringDeportistas.append(deportista.toString()).append(", ").append('\n'));
        return  "listaDeportistas: {" + '\n' +
                stringDeportistas + '\n' +
                '}';
    }

}
