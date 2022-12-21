import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    protected int contador;
    protected Map<Integer, List<Prenda>> ropero;

    public GuardaRopa() {
        this.contador = 0;
        this.ropero = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        ropero.put(++contador,listaDePrenda);
        System.out.println("Se ha guardado en el guardaropa nro " + contador +
                " la ropa: " + listaDePrenda.toString());
        return contador;
    }

    public void mostrarPrendas(){
        ropero.forEach((i, p) -> {
            System.out.println("En el guardaropa nro " +
                    i + " existen las siguientes prendas - " + p.toString());
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
            if(ropero.get(numero) != null) return ropero.get(numero);
            throw new Error("No hay che");


    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "contador=" + contador +
                ", ropero=" + ropero +
                '}';
    }

    public int getContador() {
        return contador;
    }

    public Map<Integer, List<Prenda>> getRopero() {
        return ropero;
    }
}
