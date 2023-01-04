import java.util.ArrayList;
import java.util.List;

public class RepositorioFactura {

    List<Factura> facturas;

    RepositorioCliente repositorioCliente;

    public RepositorioFactura(RepositorioCliente repositorioCliente) {
        this.facturas = new ArrayList<>();
        this.repositorioCliente = repositorioCliente;
    }

    public List<Factura> findAll(){
        return facturas;
    }

    public void save(Factura factura){
        if(repositorioCliente.findByDni(factura.getCliente().getDni()) != null){
            facturas.add(factura);
        }else{
            System.out.println("El cliente no existe aún, debe registrarlo antes de poder realizar la factura");
        }
    }

}
