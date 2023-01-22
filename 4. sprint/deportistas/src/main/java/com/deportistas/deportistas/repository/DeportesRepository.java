package com.deportistas.deportistas.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.deportistas.deportistas.dto.response.BuscaDeporteResponseDto;
import com.deportistas.deportistas.dto.response.ListaDeportesResponseDto;
import com.deportistas.deportistas.models.Deportista;

@Repository
public class DeportesRepository {
    private List<Deportista> deportes = new ArrayList<>();

    public void aniadirDeporte() {
        Deportista d1 = new Deportista();
        d1.setNombre("Hookey");
        d1.setNivel(0);
        Deportista d2 = new Deportista();
        d2.setNombre("Fútbol");
        d2.setNivel(1);
        deportes.add(d1);
        deportes.add(d2);
    }

    public List<Deportista> listarDeportes() {
        aniadirDeporte(); // esto lo hacemos ya que no tenemos datos reales de una bd.
        return deportes;
    }

    public Deportista buscaDeporte(String deporteABuscar) {
        deportes = new ArrayList<>();
        aniadirDeporte();
        return deportes.stream().filter(d -> d.getNombre().contentEquals(deporteABuscar)).findFirst().orElse(null);
    }
}
