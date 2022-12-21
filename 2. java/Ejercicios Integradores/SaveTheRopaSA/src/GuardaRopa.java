import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> casilleros;
    private int contadorPrendas;
    public GuardaRopa() {
        casilleros = new HashMap<>();
        contadorPrendas = 0;
    }


    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        contadorPrendas++;
        casilleros.put(contadorPrendas, listaDePrendas);
        return contadorPrendas;
    }

    public String mostrarPrendas(){
        StringBuilder resultado = new StringBuilder();
        for(Integer identificador : casilleros.keySet()){
            resultado.append("\n");
            resultado.append(identificador);
            resultado.append("\n");
            casilleros.get(identificador).stream().forEach(prenda -> resultado.append("-> "  + prenda.toString() + "\n"));
        }
        return resultado.toString();
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return casilleros.get(numero);
    }
}
