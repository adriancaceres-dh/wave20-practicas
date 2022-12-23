package com.bootcamp;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa(){
        prendas = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        this.prendas.put(contador, listaDePrendas);
        return contador++;
    }

    public void mostrarPrendas(){
        if(!this.prendas.isEmpty()){
            for(Map.Entry<Integer, List<Prenda>> prendasGuardadas : prendas.entrySet()){
                System.out.println("Numero: " + prendasGuardadas.getKey());
                System.out.println("Prendas: ");
                prendasGuardadas.getValue().forEach(prenda -> System.out.println(prenda.toString()));
                System.out.println();
            }
        }else{
            System.out.println("No hay prendas guardadas");
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendasBuscadas = prendas.get(numero);
        if(prendasBuscadas == null){
            System.out.println("No se encontraron prendas bajo esa llave");
        }else{
            System.out.println("Devolviendo prendas: " + prendasBuscadas);
            this.prendas.remove(numero);
        }
        return prendasBuscadas;
    }
}
