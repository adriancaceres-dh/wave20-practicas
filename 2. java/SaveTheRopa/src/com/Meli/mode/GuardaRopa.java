package com.Meli.mode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    Map<Integer, List<Prenda>> prendas;


    public  GuardaRopa(){
        prendas = new HashMap<>();
    }



    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int id = prendas.size();
        prendas.put(id, listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("id: "+entry.getKey() + ":" + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                '}';
    }
}
