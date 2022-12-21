package SaveTheRopaS.A;

import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> prendas;
    int contador = 0;

    public GuardaRopa() {
    }

    public GuardaRopa(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(contador, listaDePrenda);
                contador ++;
        return contador -1;
    }

    public void mostrarPrendas(){
     //  prendas.forEach(v-> System.out.println());
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
    //otra alternativa para mostrar prendas
    public void mostrarPrendas2(){
        prendas.entrySet()
                .stream()
                .forEach(s->System.out.println(s.getKey()+" "+s.getValue()));
    }
    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }
}
