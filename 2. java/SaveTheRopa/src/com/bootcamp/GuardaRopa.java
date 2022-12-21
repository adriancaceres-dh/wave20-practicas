package com.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    private Map<Integer, List<Prenda>> mapaRopa;

    public GuardaRopa() {
        this.contador = 0;
        this.mapaRopa = new HashMap<>();
    }

    public int guardarPrendas(List<Prenda> listaDePrendas) {
        sumarContador();
        mapaRopa.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarPrendas() {
        System.out.println(mapaRopa);
    }

    public List<Prenda> devolverPrendas(int codigo) throws Exception {
        if (mapaRopa.containsKey(codigo)) {
            return mapaRopa.get(codigo);
        }
        throw new Exception(codigo + " No existe");
    }

    private void sumarContador() {
        contador++;
    }
}
