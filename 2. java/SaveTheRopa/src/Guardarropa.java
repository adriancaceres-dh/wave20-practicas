import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guardarropa {
    private Map<Integer, List<Prenda>> guardaRropa;
    private int contador;

    public Guardarropa() {
        guardaRropa = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> lista) {
        guardaRropa.put(++contador,lista);
        return contador;
    }

    public String mostrarPrendas() {
        return guardaRropa
                .entrySet()
                .stream()
                .map(i -> i.getKey().toString() + " - " + i.getValue().toString())
                .collect(Collectors.joining("\n"));
    }

    public List<Prenda> devolverPrendas(Integer llave) {
        return guardaRropa.get(llave);
    }

}
