import java.util.*;

public class Guardarropas {
    private Map<Integer, List<Prenda>> mapaRopa;
    private int contador;

    public Guardarropas() {
        this.mapaRopa = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        mapaRopa.put(contador, listaDePrendas);
        contador++;
        return contador;
    }

    public void mostrarRopa(){
        System.out.println(mapaRopa);
    }
    public List<Prenda> devolverPrendas(Integer numero) throws Exception {

        List<Prenda> listaDevuelta = mapaRopa.get(numero);
        if(listaDevuelta == null){
            throw new Exception("No existen dichas prendas");
        }
        return listaDevuelta;
    }
}
