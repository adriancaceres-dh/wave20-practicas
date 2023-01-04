package bootcamp2;

import java.util.HashMap;
import java.util.List;


public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> casilleros;
    private int ultimaDisponible;

    public GuardaRopa() {
        this.casilleros = new HashMap<>();
    }

    public HashMap<Integer, List<Prenda>> getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(HashMap<Integer, List<Prenda>> casilleros) {
        this.casilleros = casilleros;
    }

    public int getCasillerosActuales() {
        return ultimaDisponible;
    }

    public void setCasillerosActuales(int casillerosActuales) {
        this.ultimaDisponible = casillerosActuales;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        casilleros.put(ultimaDisponible, listaDePrenda);
        ultimaDisponible += 1;
        return ultimaDisponible - 1;
    }

    public void mostrarPrendas() {
        for (int i = 0; i < ultimaDisponible; i++){
            int finalI = i;
            casilleros.get(i).forEach(prenda -> System.out.println("Prenda en casilla " + finalI + ": "+ prenda.toString()));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        if (casilleros.containsKey(numero)) return casilleros.get(numero);
        return null;
    }
}
