package poo.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mundial {
    List<Partido> partidos;

    public Mundial() {
        partidos = new ArrayList<>();
    }

    public Mundial(List<Partido> mundial) {
        this.partidos = mundial;
    }

    public int cantidadPartidos(){
        return partidos.size();
    }
    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }
    /*public int cantidadDeGolesTotales(){
        int cantidad = 0;
        for (Partidos partido : partidos){
            cantidad += goles
        }
        return cantidad;
    }*/


}
