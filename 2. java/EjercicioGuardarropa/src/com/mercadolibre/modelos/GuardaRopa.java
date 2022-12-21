package com.mercadolibre.modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer,List<Prenda>> prendas;
    private static int id;

    public GuardaRopa() {
        prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(++id, listaDePrenda);
        return id;
    }
    public void mostrarPrendas(){
        for (Map.Entry<Integer,List<Prenda>> prenda: prendas.entrySet()) {
            System.out.println("Prendas con identificador= " +prenda.getKey().toString());
            System.out.println("Lista de prendas= ");
            prenda.getValue().stream().forEach(p -> System.out.println(p.getMarca()+" " + p.getModelo()));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        try{
            if(this.prendas.containsKey(numero)){
                return prendas.get(numero);
            }
            return null;
        }
        catch (NullPointerException e){
            System.out.println("Error, entrada no encontrada = " + e.getMessage());
            return null;
        }
    }


}
