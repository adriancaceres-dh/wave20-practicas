import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        int CANTIDAD_PRODUCTOS = 5;

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecederos("carne",150,3));
        productos.add(new Perecederos("pescado", 700,1));
        productos.add(new NoPereceredos("arroz", 70, "grano"));

        for(Producto producto:productos){
            System.out.println(producto.nombre + " - cantidad: "+ CANTIDAD_PRODUCTOS + " - total: "+ producto.calcular(CANTIDAD_PRODUCTOS));
        }
    }
}
