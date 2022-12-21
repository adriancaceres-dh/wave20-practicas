package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> mapaPrendas;
    private Integer contador;
    public GuardaRopa() {
        this.contador = 0;
        this.mapaPrendas = new HashMap<>();
    }
    public Map<Integer, List<Prenda>> getMapaPrendas() {
        return mapaPrendas;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        mapaPrendas.put(contador,listaPrendas);
        return contador++;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> mp: mapaPrendas.entrySet()
             ) {
            System.out.println(mp.getKey());
            mp.getValue().stream().forEach(System.out::println);
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        try{
            List<Prenda> prendasBuscadas = mapaPrendas.get(numero);
            System.out.println(prendasBuscadas.toString());
            return prendasBuscadas;
        }catch (Exception e){
            System.out.println("Prendas no encontradas");
            return null;
        }
    }
}
