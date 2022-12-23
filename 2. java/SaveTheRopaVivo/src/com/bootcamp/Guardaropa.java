package com.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Guardaropa {
    private Map<Integer, List<Prenda>> mapaRopa;
    private int contador;

    public Guardaropa() {
        mapaRopa = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        mapaRopa.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarRopa() {
        System.out.println(mapaRopa);
    }

    public List<Prenda> devolverPrendas(Integer numero) throws Exception {
        List<Prenda> listaDevuelta = mapaRopa.get(numero);
        if (Objects.isNull(listaDevuelta)) {
            throw new Exception("No existe ese ID");
        }
        return listaDevuelta;
    }

}
