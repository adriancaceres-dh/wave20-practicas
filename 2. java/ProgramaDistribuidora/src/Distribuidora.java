import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto prod1 = new Perecedero("Pastel",75.0,4);
        Producto prod2 = new NoPerecedero("Arroz",55.0,"grano");
        Producto prod3 = new NoPerecedero("Lenteja",45.0,"Legumbre");
        Producto prod4 = new Perecedero("Banana",90.0,2);
        Producto prod5 = new Producto("Lavandina",110.0);
        Producto prod6 = new Producto("PH",150.0);

        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);
        productos.add(prod4);
        productos.add(prod5);
        productos.add(prod6);

        for(Producto prod : productos){
            System.out.println(prod.calcular(5));
        }
    }
}