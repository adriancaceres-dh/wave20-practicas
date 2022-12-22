package com.bootcamp.savetheropaSA.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> mapaGuardaRopa;

    public GuardaRopa() {
        this.mapaGuardaRopa = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        Integer id = -1;
        for(Map.Entry <Integer, List<Prenda>> map : this.mapaGuardaRopa.entrySet()){
            if(map.getKey()>id){
                id=map.getKey();
            }
        }
        id++;
        mapaGuardaRopa.put(id,listaDePrenda);
        return id;
    }


    public void mostrarPrendas(){
        mapaGuardaRopa.entrySet()
                .stream()
                .forEach(s->System.out.println(s.getKey()+" "+s.getValue()));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return mapaGuardaRopa.entrySet().stream()
                .filter(s->s.getKey()==numero)
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);
    }


}
