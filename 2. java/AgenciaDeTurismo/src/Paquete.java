import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paquete {

    Map<Cliente,List<Producto>> paquete;

    public Paquete(){
        paquete = new HashMap<>();
    }

    public Map<Cliente, List<Producto>> getPaquete() {
        return paquete;
    }

   public void agregarClienteProds(Cliente c , List<Producto> p){
        paquete.put(c,p);
   }
}
