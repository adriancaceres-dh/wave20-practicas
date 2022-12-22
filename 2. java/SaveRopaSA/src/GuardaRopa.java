import java.util.*;

public class GuardaRopa {
    public Integer indice;
    public Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.indice = 0;
        this.prendas = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        indice++;
        this.prendas.putIfAbsent(indice, listaDePrenda);
        return indice;
    }

    public void mostrarPrendas() {
        prendas
                .keySet()
                .stream()
                .forEach(indice -> imprimir(indice, this.prendas.get(indice)));
    }

    private void imprimir(Integer indice,  List<Prenda>  prendas) {
        System.out.println(
                "su código es: " + indice + " sus prendas son: " + prendas.toString()
        );
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "indice=" + indice +
                ", prendas=" + prendas +
                '}';
    }
}
