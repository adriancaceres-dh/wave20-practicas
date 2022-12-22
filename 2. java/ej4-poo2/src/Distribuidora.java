import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(new Perecedero("manteca",100));
        productos.add(new Perecedero("carne",2000));
        productos.add(new Perecedero("pollo",300));
        productos.add(new NoPerecedero("arroz",100));
        productos.add(new NoPerecedero("harina",200));

        productos
                .stream()
                .forEach(p -> System.out.println("el precio del producto es: " + p.calcular(5)));


    }
}
