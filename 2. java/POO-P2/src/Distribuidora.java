import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    //Creo los productos:
    Producto producto1 = new NoPerecedero("Harina", 80, "Alimento");
    Producto producto2 = new NoPerecedero("Arroz", 60, "Alimento");
    Producto producto3 = new Perecedero("Carne", 100, 5);
    Producto producto4 = new Perecedero("Huevos", 20, 3);

    List<Producto> listaProductos = new ArrayList<>();

    //Agrego los productos
    public void agregarProductos(){
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
    }

    public void imprimirTotal(){
        double total = 0;
        for (Producto producto : listaProductos) {
            total+= producto.calcular(5);
        }
        System.out.println("El valor total es: " + total + "$");
    }
}
