import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    public int UltimaKeyGuardada = 0;
    private Map<Integer, List<Prenda>> PrendasGuardadas = new HashMap<>();

    public Map<Integer, List<Prenda>> getPrendasGuardadas() {
        return PrendasGuardadas;
    }
    public int guardarPrendas(List<Prenda> prendasAGuardar){
        UltimaKeyGuardada++;
        PrendasGuardadas.put(UltimaKeyGuardada, prendasAGuardar);
        return UltimaKeyGuardada;
    }

    public void mostrarPrendas(){
        PrendasGuardadas.entrySet().forEach(lote -> {
            System.out.println("Lote nro "+ lote.getKey());
            lote.getValue().stream().forEach(System.out::println);
            System.out.println("--------------------- ");

        });
    }
    public void consultaLote(int nroLote){
        List<Prenda> lote = PrendasGuardadas.get(nroLote);
        lote.stream().forEach(System.out::println);

    }
}
