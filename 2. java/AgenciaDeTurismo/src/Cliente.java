import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String dni;
    String nombre;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
    public void comprarPaquete(){
        Paquete paquete = new Paquete();
        List<Producto> listaProd = new ArrayList<>();
        Reservas reserva = new Reservas(2);
        Comida comida = new Comida(4);
        listaProd.add(reserva);
        listaProd.add(comida);
        paquete.agregarClienteProds(this, listaProd);

    }

}
