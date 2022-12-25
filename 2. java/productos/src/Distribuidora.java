import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();
        Producto leche = new Perecedero("Leche Entera", 1100, 2);
        Producto arroz = new NoPerecedero("Arroz Grano Entero", 2150, "Arroz");
        Producto chocolate = new Producto("Chocolate", 1500);
        productos.add(leche);
        productos.add(arroz);
        productos.add(chocolate);

        System.out.println(leche.calcular(5));
        System.out.println(arroz.calcular(5));
        System.out.println(chocolate.calcular(5));

    }
}