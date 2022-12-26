import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements ICrud<Factura>{
    List<Factura> listaFacturas = new ArrayList<>();
    @Override
    public void create(Factura item) {
        listaFacturas.add(item);
    }

    @Override
    public List<Factura> read() {
        System.out.println(listaFacturas);
        return listaFacturas;
    }

    @Override
    public Optional<Factura> find(String id) {
        System.out.println(listaFacturas.stream().filter(x -> String.valueOf(x.getCodigo()).equals(id)).findFirst());
        return listaFacturas.stream().filter(x -> String.valueOf(x.getCodigo()).equals(id)).findFirst();
    }

    @Override
    public void update(Factura item) {

    }

    @Override
    public void delete(String id) {
        listaFacturas.removeIf(x -> String.valueOf(x.getCodigo()).equals(id));
    }
}
