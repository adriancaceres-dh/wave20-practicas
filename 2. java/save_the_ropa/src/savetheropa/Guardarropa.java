package savetheropa;

import java.util.HashMap;
import java.util.List;

public class Guardarropa {
    private Integer currentKey;
    private HashMap<Integer, List<Prenda>> prendas;

    public Guardarropa() {
        currentKey = 0;
        prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        prendas.put(currentKey, listaDePrendas);
        return currentKey++;
    }

    public void mostrarPrendas() {
        prendas.forEach((key, value) -> {
            System.out.println("Clave " + key + ":");
            value.forEach(System.out::println);
            System.out.println("-------------------------");
        });
    }

    public List<Prenda> devolverPrendas(Integer key) {
        return prendas.get(key);
    }
}
