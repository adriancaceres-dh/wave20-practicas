package com.example.ejerciciodeportistas.repositorio;

import com.example.ejerciciodeportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositorioDeportes {

  private static RepositorioDeportes instace = null;
  private List<Deporte> deportes;

  private RepositorioDeportes() {
    deportes = new ArrayList<>();
  }

  public static RepositorioDeportes getInstance() {
    if (instace == null) {
      instace = new RepositorioDeportes();
    }
    return instace;
  }

  public void agregarDeporte(Deporte deporte) {
    deportes.add(deporte);
  }

  public List<Deporte> getDeportes() {
    return deportes;
  }

  public Deporte getDeporte(String nombre) {
    for (Deporte deporte : deportes) {
      if (deporte.getNombre().equals(nombre)) {
        return deporte;
      }
    }
    return null;
  }
}
