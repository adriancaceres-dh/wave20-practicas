import com.bootcamp.Cliente;
import com.bootcamp.ClientesManager;
import com.bootcamp.Factura;
import com.bootcamp.Producto;

public class Main {
    public static void main(String[] args) {
        ClientesManager clientesManager = new ClientesManager();

        Producto cocaCola = new Producto("CO-1", "Coca Cola", 2, 220);
        Producto pepsiCola = new Producto("PE-1", "Pepsi 2L", 3, 195);
        Producto fanta = new Producto("FA-1", "Fanta 2L", 5, 332);

        Factura factura1 = new Factura();
        factura1.addProducto(cocaCola);
        factura1.addProducto(pepsiCola);

        Factura factura2 = new Factura();
        factura2.addProducto(fanta);

        Factura factura3 = new Factura();
        factura3.addProducto(pepsiCola);
        factura3.addProducto(fanta);

        Cliente cliente1 = new Cliente("Esteban", "Demarchi", "38.405.111");
        cliente1.addFactura(factura1);
        Cliente cliente2 = new Cliente("Jose", "Lopez", "38.405.115");
        cliente2.addFactura(factura2);
        Cliente cliente3 = new Cliente("Hector", "Blanco", "12.111.222");
        cliente3.addFactura(factura3);

        clientesManager.addClient(cliente1);
        clientesManager.addClient(cliente2);
        clientesManager.addClient(cliente3);
        clientesManager.displayAll();
        clientesManager.removeClient("38.405.115");
        clientesManager.displayAll();

        clientesManager.displayClient("38.405.111");
        clientesManager.displayClient("66.66.66");
    }
}