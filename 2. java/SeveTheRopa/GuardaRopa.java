package SeveTheRopa;

import supermercadoEconocmico.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;

    private Integer identificador;

    public GuardaRopa(Integer identificador) {
        this.identificador = identificador;
        this.prendas = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


    public void addPrendas(Integer identificadorPrendas, List<Prenda> prendas){
        this.prendas.put(identificadorPrendas,prendas);
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        Integer key = 0;
        for(Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet()){
            if(entry.getValue().equals(listaDePrenda)){
                key = (Integer) entry.getKey();
                break;
            }
        }
        return key;
    }
    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet()){
           System.out.println("Numero que identifica a la lista de prendas: " + entry.getKey());
           entry.getValue().stream().forEach(System.out::println);
           System.out.println("------------------");
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> listPrendas = new ArrayList<>();
        Map<Integer,List<Prenda>> pair = this.prendas.entrySet().stream().filter(m->m.getKey() == numero).collect(Collectors.toMap(m->m.getKey(),m->m.getValue()));
        for(Map.Entry<Integer, List<Prenda>> entry : pair.entrySet()){
           for(Prenda p: entry.getValue()){
               listPrendas.add(p);
           }
        }
        return listPrendas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                ", identificador=" + identificador +
                '}';
    }
}
